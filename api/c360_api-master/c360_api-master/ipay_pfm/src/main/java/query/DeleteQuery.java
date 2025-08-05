package query;

import dao.request.DeleteRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
    private static final String SQL_TEMPLATE = "delete from ipay_virtual_transaction where pid = ? and cob_dt = ?";
    DeleteRequest request;

    public DeleteQuery(DeleteRequest request) {
        this.request = request;
    }
    public PreparedStatement returnSql(Connection c) throws SQLException {
        PreparedStatement statement = null;
        String finalSql = SQL_TEMPLATE;
        try {
            statement = c.prepareStatement(finalSql);
            int paramIndex = 1;
            statement.setString(1, request.getPid());
            statement.setString(2, request.getExecutionDate());

        } catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        System.out.println(statement.toString());
        return statement;
    }
}
