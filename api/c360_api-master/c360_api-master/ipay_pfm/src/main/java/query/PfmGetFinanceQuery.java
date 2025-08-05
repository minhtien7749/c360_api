package query;

import dao.request.PfmFinanceRequest;
import database.JdbcUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;

public class PfmGetFinanceQuery {
    private static String query = "SELECT * FROM ipay.financial_health_final_grade where acn = ? and cob_dt = (select max(cob_dt) from ipay.ETL_PROCESS_LOG where job_name = 'financial_health_final_grade') ";

    private PfmFinanceRequest request;

    public PfmGetFinanceQuery(PfmFinanceRequest request) {
        this.request = request;
    }

    public PreparedStatement returnSql(Connection c) throws SQLException {
        PreparedStatement sql = c.prepareStatement(query);
        sql.setString(1,request.getCustomerId());
        return sql;
    }

    public static void main(String[] args ) throws SQLException {
        PfmFinanceRequest request  = new PfmFinanceRequest("12342","123", "123456");
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection c = jdbcUtils.getConnection();
        PfmGetFinanceQuery query = new PfmGetFinanceQuery(request);
        PreparedStatement statement = query.returnSql(c);
        System.out.print(statement.toString());
    }

}