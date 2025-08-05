package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.request.LonStatisticRequest;

public class LonStatisticQuery {
	private final  String SQL_TEMPLATE =  "select cus_cif_nbr,\r\n"
    		+ "sum(cast(dly_st_ln_bal_amt as decimal(19,2))) as dly_st_ln_bal_amt,\r\n"
    		+ "sum( cast(mtd_st_ln_avg_bal_amt as decimal(19,2))) as mtd_st_ln_avg_bal_amt  ,\r\n"
    		+ "sum( cast(qtd_st_ln_avg_bal_amt as decimal(19,2))) as qtd_st_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_st_ln_avg_bal_amt as decimal(19,2))) as ytd_st_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(dly_mt_ln_bal_amt as decimal(19,2))) as dly_mt_ln_bal_amt,\r\n"
    		+ "sum( cast(mtd_mt_ln_avg_bal_amt as decimal(19,2))) as mtd_mt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(qtd_mt_ln_avg_bal_amt as decimal(19,2))) as qtd_mt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_mt_ln_avg_bal_amt as decimal(19,2))) as ytd_mt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(dly_lt_ln_bal_amt as decimal(19,2))) as dly_lt_ln_bal_amt,\r\n"
    		+ "sum( cast(mtd_lt_ln_avg_bal_amt as decimal(19,2))) as mtd_lt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(qtd_lt_ln_avg_bal_amt as decimal(19,2))) as qtd_lt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_lt_ln_avg_bal_amt as decimal(19,2))) as ytd_lt_ln_avg_bal_amt,\r\n"
    		+ "sum( cast(dly_traiphieu_avg_bal_amt as decimal(19,2))) as dly_traiphieu_avg_bal_amt,\r\n"
    		+ "sum( cast(mtd_traiphieu_avg_bal_amt as decimal(19,2))) as mtd_traiphieu_avg_bal_amt,\r\n"
    		+ "sum( cast(qtd_traiphieu_avg_bal_amt as decimal(19,2))) as qtd_traiphieu_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_traiphieu_avg_bal_amt as decimal(19,2))) as ytd_traiphieu_avg_bal_amt,\r\n"
    		+ "sum( cast(dly_loan_bal_amt as decimal(19,2))) as dly_loan_bal_amt,\r\n"
    		+ "sum( cast(mtd_loan_avg_bal_amt as decimal(19,2))) as mtd_loan_avg_bal_amt,\r\n"
    		+ "sum( cast(qtd_loan_avg_bal_amt as decimal(19,2))) as qtd_loan_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_loan_avg_bal_amt as decimal(19,2))) as ytd_loan_avg_bal_amt,\r\n"
    		+ "sum( cast(ytd_prncpl_chrg_off_shrtrm_amt as decimal(19,2))) as ytd_prncpl_chrg_off_shrtrm_amt,\r\n"
    		+ "sum( cast(ytd_prncpl_chrg_off_mttrm_amt as decimal(19,2))) as ytd_prncpl_chrg_off_mttrm_amt,\r\n"
    		+ "sum( cast(ytd_prncpl_chrg_off_lngtrm_amt as decimal(19,2))) as ytd_prncpl_chrg_off_lngtrm_amt,\r\n"
    		+ "sum( cast(ytd_intrst_chrg_off_shrtrm_amt as decimal(19,2))) as ytd_intrst_chrg_off_shrtrm_amt,\r\n"
    		+ "sum( cast(ytd_intrst_chrg_off_mttrm_amt as decimal(19,2))) as ytd_intrst_chrg_off_mttrm_amt,\r\n"
    		+ "sum( cast(ytd_intrst_chrg_off_lngtrm_amt as decimal(19,2))) as ytd_intrst_chrg_off_lngtrm_amt,\r\n"
    		+ "sum( cast(ytd_ltchrg_chrg_off_shrtrm_amt as decimal(19,2))) as ytd_ltchrg_chrg_off_shrtrm_amt,\r\n"
    		+ "sum( cast(ytd_ltchrg_chrg_off_mttrm_amt as decimal(19,2))) as ytd_ltchrg_chrg_off_mttrm_amt,\r\n"
    		+ "sum( cast(ytd_ltchrg_chrg_off_lngtrm_amt as decimal(19,2))) as ytd_ltchrg_chrg_off_lngtrm_amt,\r\n"
    		+ "sum( cast(ytd_prncpl_chrg_off_bond_amt as decimal(19,2))) as ytd_prncpl_chrg_off_bond_amt,\r\n"
    		+ "sum( cast(ytd_intrst_chrg_off_bond_amt as decimal(19,2))) as ytd_intrst_chrg_off_bond_amt,\r\n"
    		+ "sum( cast(ytd_ltchrg_chrg_off_bond_amt as decimal(19,2))) as ytd_ltchrg_chrg_off_bond_amt,\r\n"
    		+ "sum( cast(dly_nii_st_ln_amt_in_lc as decimal(19,2))) as dly_nii_st_ln_amt_in_lc,\r\n"
    		+ "sum( cast(mtd_nii_st_ln_amt_in_lc as decimal(19,2))) as mtd_nii_st_ln_amt_in_lc,\r\n"
    		+ "sum( cast(qtd_nii_st_ln_amt_in_lc as decimal(19,2))) as qtd_nii_st_ln_amt_in_lc,\r\n"
    		+ "sum( cast(ytd_nii_st_ln_amt_in_lc as decimal(19,2))) as ytd_nii_st_ln_amt_in_lc,\r\n"
    		+ "sum( cast(dly_nii_mt_ln_amt_in_lc as decimal(19,2))) as dly_nii_mt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(mtd_nii_mt_ln_amt_in_lc as decimal(19,2))) as mtd_nii_mt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(qtd_nii_mt_ln_amt_in_lc as decimal(19,2))) as qtd_nii_mt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(ytd_nii_mt_ln_amt_in_lc as decimal(19,2))) as ytd_nii_mt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(dly_nii_lt_ln_amt_in_lc as decimal(19,2))) as dly_nii_lt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(mtd_nii_lt_ln_amt_in_lc as decimal(19,2))) as mtd_nii_lt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(qtd_nii_lt_ln_amt_in_lc as decimal(19,2))) as qtd_nii_lt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(ytd_nii_lt_ln_amt_in_lc as decimal(19,2))) as ytd_nii_lt_ln_amt_in_lc,\r\n"
    		+ "sum( cast(dly_nii_traiphieu_amt as decimal(19,2))) as dly_nii_traiphieu_amt,\r\n"
    		+ "sum( cast(mtd_nii_traiphieu_amt as decimal(19,2))) as mtd_nii_traiphieu_amt,\r\n"
    		+ "sum( cast(qtd_nii_traiphieu_amt as decimal(19,2))) as qtd_nii_traiphieu_amt,\r\n"
    		+ "sum( cast(ytd_nii_traiphieu_amt as decimal(19,2))) as ytd_nii_traiphieu_amt,\r\n"
    		+ "sum(cast(ytd_overdue_cnt as decimal(19,2))) as ytd_overdue_cnt,";
	
	 private LonStatisticRequest request;

	    public LonStatisticQuery(LonStatisticRequest request) {
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
	        boolean hasToDate = request.getToDate() != null && !request.getToDate().isEmpty();
	        boolean hasBranch = request.getBranch() != null;
	        
	     // Always select basic columns   
	        sqlBuilder.append("cob_dt");      
	        // Conditionally add branch
	        if (hasBranch) {         
	        	sqlBuilder.append(", brnch_cd AS branch,");     }     
	        // Conditionally add crcd    
	        
	        if ((this.request.getPeriod() == null) && (hasFromDate && hasToDate)) {
	            sqlBuilder.append(" FROM customer360.c360_lon_statistic WHERE ")
	                      .append("(cob_dt >= ? AND cob_dt <= ?) "); 
	    }  if(hasFromDate && !hasToDate) {
	            sqlBuilder.append(" FROM customer360.c360_lon_statistic WHERE ")
	            .append("cob_dt in (select cob_dt  from customer360.tm_dim where ")
	            .append(flag).append(" = 'Y' AND (cob_dt >= ? AND cob_dt <= CURDATE())) ");
	        }
        if (returnPeriod()!= null && hasFromDate && hasToDate) {
        	sqlBuilder.append(" FROM customer360.c360_lon_statistic WHERE ")
            .append("(cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND cob_dt >= ? AND cob_dt <= ?) or cob_dt = ?) ");
        }

	        sqlBuilder.append("AND cus_cif_nbr = ? ");

	        return sqlBuilder.toString();
	    }

	    private String buildGroupBy(boolean hasBranch) {
	        List<String> groupByColumns = new ArrayList<>();
	        
	        groupByColumns.add("cus_cif_nbr");  // Always group by cus_cif_nbr
	        groupByColumns.add(" cob_dt"); // Always group by cob_dt

	        if (hasBranch) {
	            groupByColumns.add("branch"); // Group by branch if it exists
	        }

	        return " GROUP BY " + String.join(", ", groupByColumns);
	    }
	    private PreparedStatement buildPreparedStatement(Connection c, String sql, List<Object> parameters) throws SQLException {
	        PreparedStatement statement = c.prepareStatement(sql);
	        for (int i = 0; i < parameters.size(); i++) {
	            statement.setObject(i + 1, parameters.get(i));
	        }
	        System.out.println("Generated SQL: " + statement.toString());
	        return statement;
	    }

	    public PreparedStatement buildQuery(Connection c, String flag, boolean hasBranch) throws SQLException {
	        StringBuilder sqlBuilder = new StringBuilder(buildBaseSQL(flag));
	        List<Object> parameters = new ArrayList<>();
	        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
	        boolean hasToDate = request.getToDate() != null && !request.getToDate().isEmpty();
	        
	        if (this.request.getPeriod() == null && hasToDate) {
	            parameters.add(request.getFromDate());
	            parameters.add(request.getToDate());
	            parameters.add(request.getCif());
	            }
	            if(hasFromDate && !hasToDate) {
	            parameters.add(request.getFromDate());
	            parameters.add(request.getCif());
	            }
	            if (this.request.getPeriod() != null && hasFromDate && hasToDate) {
	            parameters.add(request.getFromDate());
	            parameters.add(request.getToDate());
	            parameters.add(request.getToDate());
	            parameters.add(request.getCif());
	            }
	        if (hasBranch) {
	            sqlBuilder.append("AND branch = ? ");
	            parameters.add(request.getBranch());
	        }

	        sqlBuilder.append(buildGroupBy(hasBranch));


	        return buildPreparedStatement(c, sqlBuilder.toString(), parameters);
	    }


	    
	    public PreparedStatement SQLPrepareFinal(Connection c) throws SQLException {
	        String flag = returnPeriod();
	        boolean hasBranch = request.getBranch() != null;


	        return buildQuery(c, flag, hasBranch);
	    }

}
