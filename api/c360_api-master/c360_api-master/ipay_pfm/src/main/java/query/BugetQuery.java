package query;
import dao.request.BudgetRequest;
import database.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BugetQuery {
    private static final String SQL_TEMPLATE =
            "WITH pfm_trans AS ( " +
                    "    SELECT acn, cid, tseq, zprfrefno,category, amt, cob_dt " +
                    "    FROM ipay.ipay_pfm_transaction_t_1 \n" +
                    "    WHERE cob_dt >= ? AND cob_dt <= ? AND acn = ? \n" +
                    "), " +
                    "update_category AS ( \n" +
                    "    SELECT * \n" +
                    "    FROM ( \n" +
                    "        SELECT customer_number, channel, hostrefno, account_number, tseq, category_id, \n" +
                    "               CAST(amount AS DOUBLE) amount, mapping_id, \n" +
                    "               RANK() OVER (PARTITION BY mapping_id ORDER BY version DESC) AS rank_1, version \n" +
                    "        FROM ipay.ib_pfm_transaction_category_realtime \n" +
                    "        WHERE customer_number = ? and execution_date >= ? and execution_date <= ? \n" +
                    "    ) x " +
                    "    WHERE rank_1 = 1 and category_id = ? " +
                    "), " +
                    "pfm_t_1 AS ( \n" +
                    "    SELECT a.acn, a.cid, c.in_out, c.category, c.name_vi, c.name_en, \n" +
                    "           COALESCE(b.amount, a.amt) AS amt, 'account' AS cid_type, a.cob_dt " +
                    "    FROM pfm_trans a \n" +
                    "    LEFT JOIN update_category b ON (CONCAT('H_', cid, '_', a.zprfrefno) = b.mapping_id OR \n" +
                    "                                      CONCAT('T_', cid, '_', a.tseq) = b.mapping_id) \n" +
                    "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
                    "    WHERE c.category = ?), \n" +
                    "pfm_realtime AS ( \n" +
                    "    SELECT a.acn, a.cid, c.in_out, c.category, c.name_vi, c.name_en, " +
                    "           COALESCE(b.amount, a.trx_amt) AS amt, 'account' AS cid_type,   cob_dt \n" +
                    "    FROM ( " +
                    "        SELECT DISTINCT cif_no AS acn, acct_no AS cid, hostrefno, trx_amt, tseq, \n" +
                    "               CASE WHEN trans_type = 1 THEN 'Cat_In_Other' ELSE 'Cat_Out_Other' END AS category, cast(trans_time as date) as cob_dt \n" +
                    "        FROM ipay.pfm_sms_notify_hist \n" +
                    "        WHERE CAST(trans_time AS DATE) between    DATE_ADD(CURDATE(), -1) and CURDATE()\n" +
                    "          AND currency = 'VND' AND cif_no = ? \n" +
                    "    ) a " +
                    "    LEFT JOIN update_category b ON CONCAT('H_', cid, '_', a.hostrefno) = b.mapping_id OR " +
                    "                                   CONCAT('T_', cid, '_', a.tseq) = b.mapping_id " +
                    "    LEFT JOIN ipay.ipay_pfm_category c ON COALESCE(b.category_id, a.category) = c.category \n" +
                    ") " +
                    "SELECT acn, category, SUM(CAST(amt AS DOUBLE)) AS amount %s                                                                                   \n" +
                    "FROM ( " +
                    "    (SELECT acn, category, amt, cob_dt FROM pfm_t_1) \n" +
                    "    UNION ALL " +
                    "    (SELECT acn,category,amt,cob_dt FROM pfm_realtime) \n" +
                    "    UNION ALL \n" +
                    "    (SELECT acn, category, SUM(amt) AS amt, cob_dt \n" +
                    "     FROM ipay.ipay_pfm_card_t_1 \n" +
                    "     WHERE acn = ? and cardid is  null AND cob_dt >= ? AND cob_dt <= ? and category = ? \n" +
                    "     GROUP BY acn, category , cob_dt) union all \n " +
                    "    (SELECT acn, category, SUM(amt) AS amt, cob_dt \n" +
                    "     FROM ipay.ipay_pfm_card_t_1 \n" +
                    "     WHERE acn = ? and cardid is not null AND cob_dt >= ? AND cob_dt <= ? and category = ? \n" +
                    "     GROUP BY acn, category, cob_dt) \n " +
                    "    UNION ALL " +
                    "( SELECT acn, category, SUM(CAST(amount AS DECIMAL(18,6))) AS amt, cob_dt    \n" +
                    "FROM (\n" +
                    "SELECT  account_number cid, customer_number acn, \n" +
                    "         cast(cob_dt as datetime) time, 'VND' crcd, NULL ofscid, cob_dt, \n" +
                    "        b.in_out, b.category, b.name_vi, b.name_en, amount , 'other' cid_type, row_number() over (partition by mapping_id order by version desc) as rank_\n" +
                    "FROM ipay.ipay_virtual_transaction a\n" +
                    "LEFT JOIN ipay.ipay_pfm_category b ON b.category = a.category_id \n" +
                    "WHERE  customer_number = ? AND CAST(cob_dt AS DATE) >= ? AND CAST(cob_dt AS DATE) <= ?  and category = ?  ) a \n" +
                    "WHERE rank_ = 1  \n" +
                    "GROUP BY acn, category, cob_dt ) \n" +
                    ") x " +
                    "WHERE  acn = ? AND cob_dt >= ? AND cob_dt <= ? and category = ? \n" +
                    "GROUP BY acn, category %s;";

    private BudgetRequest request;

    public BugetQuery(BudgetRequest request) {
        this.request = request;
    }
    private String generatePlaceholders(int count) {
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < count; i++) {
            placeholders.append("?");
            if (i < count - 1) {
                placeholders.append(", ");
            }
        }
        return placeholders.toString();
    }

    public String getPeriod() {
        if (request.getPeriodType() == null) return "";

        switch (request.getPeriodType()) {
            case "M":
                return ", CONCAT(CAST(YEAR(cob_dt) AS CHAR(4)), '-', LPAD(CAST(MONTH(cob_dt) AS CHAR(2)), 2, '0'))";
            case "W":
                return ", CONCAT(CAST(YEAR(cob_dt) AS CHAR(4)), '-', LPAD(CAST(WEEK(cob_dt) AS CHAR(2)), 2, '0'))";
            case "D":
                return ", cob_dt";
            default:
                return "";
        }
    }

    public PreparedStatement returnSql(Connection connection) throws SQLException {
        String period  = getPeriod();
        String cobDt = "";
        if (request.getPeriodType() != null) {
        	cobDt = " cob_dt";
        }
        String finalSql = String.format(SQL_TEMPLATE, period + cobDt, period);
        PreparedStatement statement = connection.prepareStatement(finalSql);

        int paramIndex = 1;
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCategory());
        statement.setString(paramIndex++, request.getCategory());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo()); //
        statement.setString(paramIndex++, request.getCategory());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCategory());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCategory());
        // Final parameters
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCategory());

        System.out.println(statement.toString());
        return statement;
    }
}
