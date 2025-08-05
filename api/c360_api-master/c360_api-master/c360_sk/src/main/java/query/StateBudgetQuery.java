package query;


import dao.request.StateBudgetRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StateBudgetQuery {
    private final  String SQL_TEMPLATE = "select * from production.state_buget where refno = ? and taxtyp = ? and cob_dt >= ? and cob_dt <= ? ";
    private StateBudgetRequest request;

    public StateBudgetQuery(StateBudgetRequest request) {
        this.request = request;
    }

    public PreparedStatement returnSql(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE);
        System.out.println("sc");
        int parameterIndex = 1;
        statement.setString(parameterIndex++, request.getRefNo());
        statement.setString(parameterIndex++, request.getTaxTyp());
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        System.out.println("sc");
        return statement;
    }
}
