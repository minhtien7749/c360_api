package query;

import dao.request.PfmGetTranCatRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PfmGetOriginalTransQuery {
        private static final String SQL_TEMPLATE = "WITH pfm_trans AS ( " +
                "    SELECT cid, acn, zprfrefno, tseq,  channel, tcmt remark, ofsname,1 split_count,  " +
                "           CONCAT(cob_dt, ' ', time) time, crcd, ofscid, cob_dt, amt, category " +
                "    FROM ipay.ipay_pfm_transaction_t_1 " +
                "    WHERE cob_dt = ? and acn = ?   %s " +
                "), " +
                "pfm_t_1 AS ( " +
                "    SELECT null pid, null parent_pid, a.cid, a.acn, a.zprfrefno, a.tseq, a.channel, a.remark, a.ofsname, " +
                "           COUNT() OVER (PARTITION BY a.cid, a.tseq) AS split_count, a.time, a.crcd, a.ofscid, a.cob_dt, " +
                "           c.in_out, c.category, c.name_vi, c.name_en, " +
                "           a.amt AS amt, 'account' AS cid_type " +
                "    FROM pfm_trans a " +
                "    LEFT JOIN ipay.ipay_pfm_category c ON  a.category = c.category " +
                "), " +
                "pfm_realtime AS ( " +
                "    SELECT distinct null pid, null parent_pid, a.acn, a.cid, c.in_out, a.hostrefno AS zprfrefno, a.tseq, a.remark, " +
                "            a.trx_amt AS amt, 'account' AS cid_type, cob_dt, " +
                "           c.category, c.name_vi, c.name_en, NULL AS channel, NULL AS ofscid, trans_time time, " +
                "           currency crcd, NULL AS ofsname, COUNT() OVER (PARTITION BY a.cid, a.tseq) split_count " +
                "    FROM ( " +
                "        SELECT DISTINCT cif_no AS acn, acct_no cid, hostrefno, trx_amt, tseq, remark, trans_time, " +
                "                       CAST(trans_time AS DATE) cob_dt, " +
                "                       CASE WHEN trans_type = 1 THEN 'Cat_In_Other' ELSE 'Cat_Out_Other' END AS category, currency " +
                "        FROM ipay.pfm_sms_notify_hist " +
                "        WHERE CAST(trans_time AS DATE) between    DATE_ADD(CURDATE(), -1) and CURDATE()  and CAST(trans_time AS DATE) = ? AND currency = 'VND' AND cif_no = ?   %s " +
                "    ) a " +
                "    LEFT JOIN ipay.ipay_pfm_category c ON  a.category = c.category " +
                ") " +
                "    SELECT * " +
                "    FROM ( " +
                "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, split_count, time, crcd, ofscid, cob_dt, " +
                "               in_out, category, name_vi, name_en, amt, cid_type,  pid,  parent_pid " +
                "        FROM pfm_realtime " +
                "        UNION ALL " +
                "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, split_count, time, crcd, ofscid, cob_dt, " +
                "               in_out, category, name_vi, name_en, amt, cid_type, pid, parent_pid " +
                "        FROM pfm_t_1 " +
                "    ) x ";
        PfmGetTranCatRequest request;

        public PfmGetOriginalTransQuery(PfmGetTranCatRequest request) {
            this.request = request;
        }
        public PreparedStatement returnSql(Connection c) throws SQLException{
            PreparedStatement statement = null;
            String finalSql = null;
            if (request.gettSeq().isEmpty() ) {
                finalSql = String.format(SQL_TEMPLATE, " and zprfrefno = ? " , " and hostrefno = ? ");
            } else {
                finalSql = String.format(SQL_TEMPLATE," and tseq = ? ", " and tseq = ? ");
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
