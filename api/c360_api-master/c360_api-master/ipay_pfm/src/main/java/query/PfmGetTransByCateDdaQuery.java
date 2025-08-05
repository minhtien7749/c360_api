package query;

import dao.request.PfmGetTransRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PfmGetTransByCateDdaQuery {
    private static final String SQL_TEMPLATE =
            "WITH pfm_trans AS ( " +
                    "    SELECT zprfrefno,  channel, tcmt remark, ofsname, 1 split_count, cid, acn, \n" +
                    "           CONCAT(cob_dt, ' ', time) time, tseq, crcd, ofscid, cob_dt, amt, category \n" +
                    "    FROM ipay.ipay_pfm_transaction_t_1 \n" +
                    "    WHERE cob_dt >= ? AND cob_dt <= ? AND acn = ? \n" +
                    "), \n" +
                    "update_category AS ( \n" +
                    "    SELECT * \n" +
                    "    FROM ( \n" +
                    "        SELECT customer_number, channel, hostrefno, account_number, pid, parent_pid, tseq, category_id, \n" +
                    "               CAST(amount AS DOUBLE) amount, mapping_id, \n" +
                    "               RANK() OVER (PARTITION BY mapping_id ORDER BY version DESC) AS rank_1, version \n" +
                    "        FROM ipay.ib_pfm_transaction_category_realtime \n" +
                    "        WHERE customer_number = ? and execution_date >= ? and execution_date <= ? \n" +
                    "    ) x \n" +
                    "    WHERE rank_1 = 1 \n" +
                    "), " +
                    "pfm_t_1 AS ( " +
                    "    SELECT b.pid, b.parent_pid, a.cid, a.acn, a.zprfrefno, a.tseq, a.channel, a.remark, a.ofsname, \n" +
                    "           COUNT() OVER (PARTITION BY a.cid, a.tseq) AS split_count, a.time, a.crcd, a.ofscid, a.cob_dt, \n" +
                    "           c.in_out, c.category, c.name_vi, c.name_en, \n" +
                    "           COALESCE(b.amount, a.amt) AS amt, 'account' AS cid_type \n" +
                    "    FROM pfm_trans a " +
                    "    LEFT JOIN update_category b ON (CONCAT('H_', cid, '_', a.zprfrefno) = b.mapping_id OR \n" +
                    "                                      CONCAT('T_', cid, '_', a.tseq) = b.mapping_id) \n" +
                    "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
                    "), " +
                    "pfm_realtime AS ( \n" +
                    "    SELECT pid, parent_pid, a.acn, a.cid, c.in_out, a.hostrefno AS zprfrefno, a.tseq, a.remark, \n" +
                    "           COALESCE(b.amount, a.trx_amt) AS amt, 'account' AS cid_type, cob_dt, \n" +
                    "           c.category, c.name_vi, c.name_en, NULL AS channel, NULL AS ofscid, trans_time time, \n" +
                    "           currency crcd, NULL AS ofsname, COUNT() OVER (PARTITION BY a.cid, a.tseq) split_count \n" +
                    "    FROM ( " +
                    "        SELECT DISTINCT cif_no AS acn, acct_no cid, hostrefno, trx_amt, tseq, remark, trans_time, \n" +
                    "                       CAST(trans_time AS DATE) cob_dt, \n" +
                    "                       CASE WHEN trans_type = 1 THEN 'Cat_In_Other' ELSE 'Cat_Out_Other' END AS category, currency \n" +
                    "        FROM ipay.pfm_sms_notify_hist \n" +
                    "        WHERE CAST(trans_time AS DATE) between    DATE_ADD(CURDATE(), -1) and CURDATE() AND currency = 'VND' AND cif_no = ? \n" +
                    "    ) a " +
                    "    LEFT JOIN update_category b ON CONCAT('H_', cid, '_', a.hostrefno) = b.mapping_id OR \n" +
                    "                                   CONCAT('T_', cid, '_', a.tseq) = b.mapping_id \n" +
                    "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
                    ") " +
                    "SELECT *, CEILING(record_num / ?) AS num_page \n" +
                    "FROM ( " +
                    "    SELECT *, ROW_NUMBER() OVER (ORDER BY cob_dt DESC, time DESC) AS rank_, \n" +
                    "           COUNT() OVER (PARTITION BY acn) AS record_num \n" +
                    "    FROM ( " +
                    "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, split_count, time, crcd, ofscid, cob_dt, \n" +
                    "               in_out, category, name_vi, name_en, amt, cid_type, pid, parent_pid \n" +
                    "        FROM pfm_realtime \n" +
                    "        UNION ALL \n" +
                    "        SELECT cid, acn, zprfrefno, tseq, channel, remark, ofsname, split_count, time, crcd, ofscid, cob_dt, \n" +
                    "               in_out, category, name_vi, name_en, amt, cid_type, pid, parent_pid \n" +
                    "        FROM pfm_t_1 \n" +
                    "        UNION ALL \n" +
                    "(SELECT cid,acn,zprfrefno,tseq,channel,remark,ofsname,split_count,time,crcd,ofscid,cob_dt,in_out,category,name_vi,name_en,amt,cid_type,pid,parent_pid\n" +
                    "FROM (\n" +
                    "SELECT  account_number cid, customer_number acn, hostrefno zprfrefno, tseq, channel, remark, \n" +
                    "        NULL ofsname, 1 split_count, cast(cob_dt as datetime) time, 'VND' crcd, NULL ofscid, cob_dt, \n" +
                    "        b.in_out, b.category, b.name_vi, b.name_en, amount amt, 'other' cid_type, pid, parent_pid, row_number() over (partition by mapping_id order by version desc) as rank_, version\n" +
                    "FROM ipay.ipay_virtual_transaction a\n" +
                    "LEFT JOIN ipay.ipay_pfm_category b ON b.category = a.category_id \n" +
                    "WHERE customer_number = ? AND cob_dt >= ? AND cob_dt <= ?    ) a \n" +
                    "where rank_ = 1) " +
                    "    ) x " +
                    "    WHERE %s %s cob_dt >= ? AND cob_dt <= ? " +
                    ") a WHERE CEILING(rank_ / ?) = ?;";

    private PfmGetTransRequest request;

    public PfmGetTransByCateDdaQuery(PfmGetTransRequest request) {
        this.request = request;
    }

    private String generatePlaceholderString(List<String> items) {
        if (items.isEmpty()) {
            return "";
        }
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            placeholders.append("?");
            if (i < items.size() - 1) {
                placeholders.append(", ");
            }
        }
        return placeholders.toString();
    }

    public String updateCidSql() {
        String placeholderString = generatePlaceholderString(request.getAccountList());
        if (placeholderString.isEmpty()) {
        	return placeholderString;
        }
        return "cid IN (" + placeholderString + ") AND ";
    }

    public String updateCategoryId() {
        String placeholderString = generatePlaceholderString(request.getCategoryList());
        if (placeholderString.isEmpty()) {
        	return placeholderString;
        }
        return "category IN (" + placeholderString + ") AND ";
    }

    public PreparedStatement returnSql(Connection connection) throws SQLException {
        String listStringCid = updateCidSql();
        String listCategory = updateCategoryId();
        String finalSql = String.format(SQL_TEMPLATE, listStringCid, listCategory);
        PreparedStatement statement = connection.prepareStatement(finalSql);

        int paramIndex = 1;
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setInt(paramIndex++, request.getPageSize());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());

        // Set account IDs
        for (String accountId : request.getAccountList()) {
            statement.setString(paramIndex++, accountId);
        }

        // Set category IDs
        for (String categoryId : request.getCategoryList()) {
            statement.setString(paramIndex++, categoryId);
        }

        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setInt(paramIndex++, request.getPageSize());
        statement.setInt(paramIndex++, request.getPageNum());

        System.out.println(statement.toString());
        return statement;
    }
}