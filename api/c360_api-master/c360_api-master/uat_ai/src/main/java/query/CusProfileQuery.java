package query;

import database.JdbcUtils;
import payload.request.CusProfileRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CusProfileQuery {

    String SQL_TEMPLATE = "SELECT * \n"
    		+ " FROM datalake.customerc360_output.ai_pdtd_cus_dtls \n"
    		+ " WHERE cob_dt = '2025-06-19' /*t-1*/ \n"
    		+ " AND cif = ? /*cif*/";
    CusProfileRequest request;

    public CusProfileQuery(CusProfileRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        String customerId = request.getCustomerId();
        PreparedStatement statement = c.prepareStatement(SQL_TEMPLATE);
        statement.setString(1,customerId);
        return statement;
    }
}