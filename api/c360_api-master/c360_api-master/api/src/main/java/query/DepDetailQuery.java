package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.DepDetailRequest;

public class DepDetailQuery {
	private final  String SQL_TEMPLATE = "select acn,cid,crcd,grp,irn,odt,mdt,trm,type,dly_ldgr_bal_amt_in_lc,dly_ldgr_bal_amt_in_tc"
			+ ",mtd_avg_ldgr_bal_amt_in_lc,"
			+ "qtd_avg_ldgr_bal_amt_in_lc ,"
			+ "ytd_avg_ldgr_bal_amt_in_lc,"
			+ "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = ? and acn = ? ";

	private final  String SQL_TEMPLATE_GRP = "select acn,cid,crcd,grp,irn,odt,mdt,trm,type,dly_ldgr_bal_amt_in_lc,dly_ldgr_bal_amt_in_tc"
			+ ",mtd_avg_ldgr_bal_amt_in_lc,"
			+ "qtd_avg_ldgr_bal_amt_in_lc ,"
			+ "ytd_avg_ldgr_bal_amt_in_lc,"
			+ "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = ? and acn = ? and grp = ?";
	private DepDetailRequest request;

    public DepDetailQuery(DepDetailRequest request) {
        this.request = request;
    }
        
    public PreparedStatement returnSql(Connection connection) throws SQLException {
        String grp = request.getGrp();
        String sql;
        PreparedStatement statement;
        int parameterIndex = 1;

        if (grp != null) {
            if ("CASA".equalsIgnoreCase(grp)) {
                sql = "select acn,cid,crcd,grp,irn,odt,mdt,trm,type,dly_ldgr_bal_amt_in_lc,dly_ldgr_bal_amt_in_tc"
                        + ",mtd_avg_ldgr_bal_amt_in_lc,"
                        + "qtd_avg_ldgr_bal_amt_in_lc ,"
                        + "ytd_avg_ldgr_bal_amt_in_lc,"
                        + "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = ? and acn = ? and grp IN (?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(parameterIndex++, request.getCob_dt());
                statement.setString(parameterIndex++, request.getCif());
                statement.setString(parameterIndex++, "DDA");
                statement.setString(parameterIndex++, "SAV");
            } else if ("FD".equalsIgnoreCase(grp)) {
                sql = SQL_TEMPLATE_GRP; // same as before
                statement = connection.prepareStatement(sql);
                statement.setString(parameterIndex++, request.getCob_dt());
                statement.setString(parameterIndex++, request.getCif());
                statement.setString(parameterIndex++, "CD");
            } else {
                sql = SQL_TEMPLATE_GRP;
                statement = connection.prepareStatement(sql);
                statement.setString(parameterIndex++, request.getCob_dt());
                statement.setString(parameterIndex++, request.getCif());
                statement.setString(parameterIndex++, grp);
            }
        } else {
            sql = SQL_TEMPLATE;
            statement = connection.prepareStatement(sql);
            statement.setString(parameterIndex++, request.getCob_dt());
            statement.setString(parameterIndex++, request.getCif());
        }

        System.out.println("Generated SQL: " + sql);
        return statement;
    }
}
