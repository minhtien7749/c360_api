package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.PfmFinanceRequest;

public class PredictedTransactionQuery {
    private static String query = "SELECT * FROM ipay.ipay_pfm_recommendation where acn = ? and cob_dt = (select max(cob_dt) from ipay.ETL_PROCESS_LOG where job_name = 'ipay_pfm_recommendation') ";

    private PfmFinanceRequest request;

    public PredictedTransactionQuery(PfmFinanceRequest request) {
        this.request = request;
    }

    public PreparedStatement returnSql(Connection c) throws SQLException {
        PreparedStatement sql = c.prepareStatement(query);
        sql.setString(1,request.getCustomerId());
        return sql;
    }
}