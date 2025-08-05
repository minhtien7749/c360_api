package query;

import payload.request.AccountStatementRequest;
import payload.request.CusProfileRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountStatementQuery {
	String SQL_TEMPLATE = "" +
            "SELECT *, CEILING(record_num/?) as num_page FROM (" +
            "SELECT *, row_number() over (partition by acn order by cast(tseq as int) desc) as rank_\n" +
            ", COUNT() OVER (PARTITION BY acn) AS record_num " +
            "FROM customer360.ai_pdtd_corp_transaction_classified\n" +
            "WHERE cob_dt >= ? AND cob_dt <= ? \n" +
            "AND acn = ? ) t " +
            "WHERE CEILING(rank_/?) = ? \n" ;
    AccountStatementRequest request;

    public AccountStatementQuery(AccountStatementRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        String customerId = request.getCustomerId();
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        String fromDate = request.getFromDate();
        String endDate = request.getEndDate();
        PreparedStatement statement = c.prepareStatement(SQL_TEMPLATE);
        statement.setInt(1, pageSize);
        statement.setString(2,fromDate);
        statement.setString(3, endDate);
        statement.setString(4,customerId);
        statement.setInt(5, pageSize);
        statement.setInt(6, pageNum);
        return statement;
    }

}