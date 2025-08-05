package query;

import dao.request.PfmStatisticOverviewRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PfmStatisticOverviewQuery {
    private static final String SQL_TEMPLATE =
            "WITH pfm_trans AS ( " +
                    "    SELECT cob_dt, acn, in_out, SUM(amt) AS amount \n" +
                    "    FROM ipay.ipay_pfm_transaction_t_1 " +
                    "    WHERE cob_dt >= ? AND cob_dt <= ? AND acn = ? \n" +
                    "    GROUP BY cob_dt, acn, in_out \n" +
                    "), " +
                    "pfm_realtime AS ( " +
                    "    SELECT acn, in_out, CAST(trans_time AS DATE) cob_dt, SUM(trx_amt) AS amount \n" +
                    "    FROM ( " +
                    "        SELECT distinct cif_no AS acn, acct_no AS cid, hostrefno, trx_amt, tseq, " +
                    "               CASE WHEN trans_type = 1 THEN 'income' ELSE 'expense' END AS in_out, trans_time \n" +
                    "        FROM ipay.pfm_sms_notify_hist " +
                    "        WHERE CAST(trans_time AS DATE) between    DATE_ADD(CURDATE(), -1) and CURDATE()\n" +
                    "          AND currency = 'VND' AND cif_no = ? " +
                    "    ) a " +
                    "    GROUP BY acn, in_out, CAST(trans_time AS DATE) " +
                    ") " +
                    "SELECT acn, in_out, SUM(amount) AS amount %s \n" +
                    "FROM ( " +
                    "    (SELECT acn, in_out, amount, cob_dt FROM pfm_trans) \n" +
                    "    UNION ALL " +
                    "    (SELECT acn, in_out, amount, cob_dt FROM pfm_realtime) \n" +
                    "    UNION ALL " +
                    "    (SELECT acn, in_out, SUM(amt) AS amount, cob_dt \n" +
                    "     FROM ipay.ipay_pfm_card_t_1 " +
                    "     WHERE cob_dt >= ? AND cob_dt <= ? AND acn = ? \n" +
                    "     GROUP BY acn, in_out, cob_dt) \n" +
                    "    UNION ALL " +
                    "(SELECT acn, in_out,SUM(CAST(amount AS DECIMAL(18,6))) AS amt, cob_dt    \n" +
                    "FROM (\n" +
                    "SELECT  account_number cid, customer_number acn, \n" +
                    "         cast(cob_dt as datetime) time, 'VND' crcd, NULL ofscid, cob_dt, \n" +
                    "        b.in_out, b.category, b.name_vi, b.name_en, amount , 'other' cid_type, row_number() over (partition by mapping_id order by version desc) as rank_\n" +
                    "FROM ipay.ipay_virtual_transaction a\n" +
                    "LEFT JOIN ipay.ipay_pfm_category b ON b.category = a.category_id \n" +
                    "WHERE  customer_number = ? AND CAST(cob_dt AS DATE) >= ? AND CAST(cob_dt AS DATE) <= ?   ) a \n" +
                    "WHERE rank_ = 1  \n" +
                    "GROUP BY acn,in_out, cob_dt ) \n"  +
                    ") a " +
                    "WHERE cob_dt >= ? AND cob_dt <= ? \n" +
                    "GROUP BY acn, in_out %s;";

    private PfmStatisticOverviewRequest request;

    public PfmStatisticOverviewQuery(PfmStatisticOverviewRequest request) {
        this.request = request;
    }

    public String getPeriod() {
        if (request.getPeriodType() == null) return "";

        switch (request.getPeriodType()) {
        	case "Y" :
        		return ", CAST(YEAR(cob_dt) AS CHAR(4)) ";
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
        String periodClause = getPeriod();
        String formattedSql = null;
        if (periodClause.isEmpty()) {
        	formattedSql = String.format(SQL_TEMPLATE, periodClause, periodClause);
        } else {
        	formattedSql = String.format(SQL_TEMPLATE, periodClause+ " cob_dt ", periodClause );
        }
        
        PreparedStatement statement = connection.prepareStatement(formattedSql);
        int paramIndex = 1;

        // Set parameters
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getCustomerId());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());

        System.out.println(statement.toString());
        return statement;
    }
}
