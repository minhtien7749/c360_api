package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.request.LimitApprovedBalRequest;


public class LimitApprovedBalQuery {
	private final  String SQL_TEMPLATE =  "SELECT cif, cif_name, segment, ostd_n_bond, undisbursed_loan_lmt, card_lmt, tf_bal, total, cob_dt ";
	
	 private LimitApprovedBalRequest request;

	    public LimitApprovedBalQuery(LimitApprovedBalRequest request) {
	        this.request = request;
	    }

	    public String returnPeriod() {
	        if (this.request.getPeriod() == null) {
	            return "mth_last_day_flag";
	        }
	        switch (this.request.getPeriod()) {
	            case "Y":
	                return "year_end_flag";
	            case "M":
	                return "mth_last_day_flag";
	            default:
	                return "clndr_qtr_end_flag";
	        }
	    }

	    private String buildBaseSQL(String flag) {
	        StringBuilder sqlBuilder = new StringBuilder(SQL_TEMPLATE);

	        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
	        boolean hasToDate = request.getCobDt() != null && !request.getCobDt().isEmpty();
	        
	     // Always select basic columns       

	        // Conditionally add crcd    
	        
	        if (this.request.getPeriod() == null  && (hasFromDate && hasToDate)) {
	            sqlBuilder.append(" FROM customer360.c360_limit_approved_bal WHERE ")
	                      .append("(cob_dt >= ? AND cob_dt <= ?) AND cif = ?   "); 
	    }  if(hasFromDate && !hasToDate) {
	            sqlBuilder.append(" FROM customer360.c360_limit_approved_bal WHERE ")
	            .append("cob_dt in (select cob_dt  from customer360.tm_dim where ")
	            .append(flag).append(" = 'Y' AND (cob_dt >= ? AND cob_dt <= CURDATE())) AND cif = ? ");
	        }
        if (this.request.getPeriod() != null && (hasFromDate && hasToDate)) {
        	sqlBuilder.append(" FROM customer360.c360_limit_approved_bal WHERE ")
            .append("(cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND cob_dt >= ? AND cob_dt <= ?) or cob_dt = ?) AND cif = ? ");
        }

	        return sqlBuilder.toString();
	    }

	    private PreparedStatement buildPreparedStatement(Connection c, String sql, List<Object> parameters) throws SQLException {
	        PreparedStatement statement = c.prepareStatement(sql);
	        for (int i = 0; i < parameters.size(); i++) {
	            statement.setObject(i + 1, parameters.get(i));
	        }
	        System.out.println("Generated SQL: " + statement.toString());
	        return statement;
	    }

	    public PreparedStatement buildQuery(Connection c, String flag) throws SQLException {
	        StringBuilder sqlBuilder = new StringBuilder(buildBaseSQL(flag));
	        List<Object> parameters = new ArrayList<>();
	        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
	        boolean hasToDate = request.getCobDt() != null && !request.getCobDt().isEmpty();
	        
	        if (this.request.getPeriod() == null && hasToDate) {

	            parameters.add(request.getFromDate());
	            parameters.add(request.getCobDt());
	            parameters.add(request.getCif());

	            }
	            if(hasFromDate && !hasToDate) {

	            parameters.add(request.getFromDate());	
	            parameters.add(request.getCif());

	            parameters.add(request.getCif());

	            }
	            if (this.request.getPeriod() != null && hasFromDate && hasToDate) {

			    
	            parameters.add(request.getFromDate());
	            parameters.add(request.getCobDt());
	            parameters.add(request.getCobDt());
	            parameters.add(request.getCif());



	            }

	        return buildPreparedStatement(c, sqlBuilder.toString(), parameters);
	    }
	    
	    public PreparedStatement SQLPrepareFinal(Connection c) throws SQLException {
	        String flag = returnPeriod();


	        return buildQuery(c, flag);
	    }
}
