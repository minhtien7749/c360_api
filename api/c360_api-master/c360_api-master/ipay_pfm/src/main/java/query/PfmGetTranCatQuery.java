package query;

import dao.request.PfmGetTranCatRequest;
import database.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PfmGetTranCatQuery {
    private static final String SQL_TEMPLATE = "WITH pfm_trans AS ( " +
            "    SELECT zprfrefno,  channel, tcmt remark, ofsname,1 split_count, cid, acn, \n" +
            "           CONCAT(cob_dt, ' ', time) time, tseq, crcd, ofscid, cob_dt, amt, category \n" +
            "    FROM ipay.ipay_pfm_transaction_t_1 \n" +
            "    WHERE cob_dt = ? and acn = ?   %s \n" +
            "\n), " +
            "update_category AS ( \n" +
            "    SELECT * \n" +
            "    FROM ( \n" +
            "        SELECT customer_number, execution_date, remark, channel, hostrefno, account_number, pid, parent_pid, tseq, category_id, \n" +
            "               CAST(amount AS DOUBLE) amount, mapping_id, " +
            "               RANK() OVER (PARTITION BY mapping_id ORDER BY version DESC) AS rank_1, version \n" +
            "        FROM ipay.ib_pfm_transaction_category_realtime \n" +
            "        WHERE customer_number = ? and execution_date = ? and %s" +
            "    ) x \n" +
            "    WHERE rank_1 = 1 \n" +
            "), \n " +
            "pfm_t_1 AS ( \n" +
            "    SELECT b.pid, b.parent_pid, a.cid, a.acn, a.zprfrefno, a.tseq, a.channel, a.remark, a.ofsname, \n" +
            "           COUNT() OVER (PARTITION BY a.cid, a.tseq) AS split_count, a.time, a.crcd, a.ofscid, a.cob_dt, \n" +
            "           c.in_out, c.category, c.name_vi, c.name_en, \n" +
            "           COALESCE(b.amount, a.amt) AS amt, 'account' AS cid_type " +
            "    FROM pfm_trans a " +
            "    LEFT JOIN update_category b ON (CONCAT('H_', cid, '_', a.zprfrefno) = b.mapping_id OR \n" +
            "                                      CONCAT('T_', cid, '_', a.tseq) = b.mapping_id) \n" +
            "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
            "), " +
            "pfm_rt as (" +
            "        SELECT DISTINCT cif_no AS acn, acct_no cid, hostrefno, trx_amt, tseq, remark, trans_time, \n" +
            "                       CAST(trans_time AS DATE) cob_dt, " +
            "                       CASE WHEN trans_type = 1 THEN 'Cat_In_Other' ELSE 'Cat_Out_Other' END AS category, currency \n" +
            "        FROM ipay.pfm_sms_notify_hist \n" +
            "        WHERE CAST(trans_time AS DATE) between    DATE_ADD(CURDATE(), -1) and CURDATE() and CAST(trans_time AS DATE) = ? AND currency = 'VND' AND cif_no = ?   %s ), \n" +
            "pfm_realtime AS ( \n" +
            " SELECT distinct pid, parent_pid,  COALESCE (a.acn, customer_number) acn , COALESCE (a.cid, account_number) cid, c.in_out, \n" +
            "coalesce(a.hostrefno,b.hostrefno)  AS zprfrefno, a.tseq, coalesce(a.remark, b.remark) remark,          \n"
            + "COALESCE(b.amount, a.trx_amt) AS amt, 'account' AS cid_type, COALESCE (cob_dt,execution_date) cob_dt,  c.category, c.name_vi, c.name_en, \n" +
            " b.channel, NULL AS ofscid, coalesce(trans_time, b.execution_date) time,        \n"
            + "coalesce(currency,'VND') crcd, NULL AS ofsname  \n" +
            "    FROM pfm_rt a \n" +
            "    FULL JOIN update_category b ON CONCAT('H_', cid, '_', a.hostrefno) = b.mapping_id OR \n" +
            "                                   CONCAT('T_', cid, '_', a.tseq) = b.mapping_id " +
            "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
            ") \n" +
            "    SELECT distinct split_count, acn, cid, pid, parent_pid ,category, name_vi, name_en \n" +
            "    FROM ( \n" +
            "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, COUNT() OVER (PARTITION BY cid, tseq) split_count, time, crcd, ofscid, cob_dt, \n" +
            "               in_out, category, name_vi, name_en, amt, cid_type, pid, parent_pid \n" +
            "        FROM pfm_realtime \n" +
            "        UNION ALL \n" +
            "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, split_count, time, crcd, ofscid, cob_dt, \n" +
            "               in_out, category, name_vi, name_en, amt, cid_type, pid, parent_pid \n" +
            "        FROM pfm_t_1 " +
            "    ) x ";
    PfmGetTranCatRequest request;

    public PfmGetTranCatQuery(PfmGetTranCatRequest request) {
        this.request = request;
    }
    public PreparedStatement returnSql(Connection c) throws SQLException{
        PreparedStatement statement = null;
        String finalSql = null;
        if (request.gettSeq().isEmpty() ) {
            finalSql = String.format(SQL_TEMPLATE, " and zprfrefno = ? " , "  hostrefno = ? ", "and hostrefno = ? ");
        } else {
            finalSql = String.format(SQL_TEMPLATE," and tseq = ? ", "  tseq = ? ",  " and tseq = ? ");
        }
        try {
            statement = c.prepareStatement(finalSql);
            int paramIndex = 1;
            statement.setString(paramIndex++,request.getExecutionDate());
            statement.setString(paramIndex ++ ,request.getCustomerId());
            if (request.gettSeq().length() > 0){
                statement.setString(paramIndex ++,request.gettSeq());
            } else if (request.getHostRefNo().length() > 0) {
                statement.setString(paramIndex ++,request.getHostRefNo());
            }
            statement.setString(paramIndex++,request.getCustomerId());
            statement.setString(paramIndex++,request.getExecutionDate());
            if (request.gettSeq().length() > 0){
                statement.setString(paramIndex ++,request.gettSeq());
            } else if (request.getHostRefNo().length() > 0) {
                statement.setString(paramIndex ++,request.getHostRefNo());
            }
            statement.setString(paramIndex++,request.getExecutionDate());
            statement.setString(paramIndex ++ ,request.getCustomerId());
            if (request.gettSeq().length() > 0){
                statement.setString(paramIndex ++,request.gettSeq());
            } else if (request.getHostRefNo().length() > 0) {
                statement.setString(paramIndex ++,request.getHostRefNo());
            }

        } catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        System.out.println(statement.toString());
        return statement;
    }
}