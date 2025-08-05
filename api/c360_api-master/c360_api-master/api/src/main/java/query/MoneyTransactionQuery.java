package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.MoneyTransactionRequest;

public class MoneyTransactionQuery {
	private final  String SQL_TEMPLATE = "select * from customer360.c360_money_transaction_statistic";

    private MoneyTransactionRequest request;

    public MoneyTransactionQuery(MoneyTransactionRequest request) {
        this.request = request;
    }
    public PreparedStatement returnSql(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE);
        System.out.println("sc");
        int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        statement.setString(parameterIndex ++, request.ofsCid());
        statement.setString(parameterIndex ++, request.getAcn());
        System.out.println("sc");
        return statement;
    }


public PreparedStatement acn_only(String cifName, String flag, Connection c, boolean hasGroupBy){
    String sql_filling = "where cob_dt >= ? and cob_dt <= ? and acn = ? order by mtd_total_amount_transaction_lc limit 5";
    String groupby = " ";
    if (hasGroupBy){
        sql_filling += groupby;
        sql_filling = String.format(sql_filling, cifName, flag, cifName);
    } else {
        sql_filling = String.format(sql_filling, cifName, flag);
    }
    String sql_final = String.format(this.SQL_TEMPLATE, sql_filling);
    PreparedStatement statement = null;
    try {
        System.out.println("sc");
        statement = c.prepareStatement(sql_final);
        int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        statement.setString(parameterIndex ++, request.ofsCid());
        statement.setString(parameterIndex ++, request.getAcn());
        System.out.println(statement.toString());

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return statement;
}

public PreparedStatement acn_cid_only(String cifName, String flag, Connection c, boolean hasGroupBy){
    String sql_filling = "where cob_dt >= ? and cob_dt <= ? and acn = ? and cid = ? order by mtd_total_amount_transaction_lc limit 5";
    String groupby = " ";
    if (hasGroupBy){
        sql_filling += groupby;
        sql_filling = String.format(sql_filling, cifName, flag, cifName);
    } else {
        sql_filling = String.format(sql_filling, cifName, flag);
    }
    String sql_final = String.format(this.SQL_TEMPLATE, sql_filling);
    PreparedStatement statement = null;
    try {
        System.out.println("sc");
        statement = c.prepareStatement(sql_final);
        int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        statement.setString(parameterIndex ++, request.ofsCid());
        statement.setString(parameterIndex ++, request.getAcn());
        System.out.println(statement.toString());

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return statement;
}

public PreparedStatement acn_cid_limit_only(String cifName, String flag, Connection c, boolean hasGroupBy){
    String sql_filling = "where cob_dt >= ? and cob_dt <= ? and acn = ? and cid = ? order by mtd_total_amount_transaction_lc limit ?";
    String sql_final = String.format(this.SQL_TEMPLATE, sql_filling);
    PreparedStatement statement = null;
    try {
        System.out.println("sc");
        statement = c.prepareStatement(sql_final);
        int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        statement.setString(parameterIndex ++, request.ofsCid());
        statement.setString(parameterIndex ++, request.getAcn());
        statement.setString(parameterIndex ++, request.getLimit());

        System.out.println(statement.toString());

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return statement;
}


public PreparedStatement trx_typ(String cifName, String flag, Connection c, boolean hasGroupBy){
    String sql_filling = "where cob_dt >= ? and cob_dt <= ? order by mtd_total_amount_transaction_lc limit 5";
    String sql_final = String.format(this.SQL_TEMPLATE, sql_filling);
    PreparedStatement statement = null;
    try {
        System.out.println("sc");
        statement = c.prepareStatement(sql_final);
        int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getFromDate());
        statement.setString(parameterIndex ++, request.getToDate());
        statement.setString(parameterIndex ++, request.ofsCid());
        statement.setString(parameterIndex ++, request.getAcn());
        System.out.println(statement.toString());

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return statement;

}




}