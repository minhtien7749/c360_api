package c360.service;
 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import c360.database.JdbcUtil;
import c360.model.InputRequestCorporate;
import c360.model.LonStatistic;

public class LonStatisticResponse {
	 public static ArrayList<LonStatistic> getRespond(InputRequestCorporate request) {
	        ArrayList<LonStatistic> LonStatistics = new ArrayList<>();
	        String sqlBranch = "select cus_cif_nbr,\r\n"
	        		+ "branch,"
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
	        		+ "sum( cast(qtd_lt_ln_avg_bal_amt as decimal(19,2))) as qtd_lt_ln_avg_bal_amt,\r\n"
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
	        		+ "sum(cast(ytd_overdue_cnt as decimal(19,2))) as ytd_overdue_cnt,"
	        		+ "cob_dt" +
	        					" from customer360.c360_lon_statistic %s";
	        String sql = "select cus_cif_nbr,\r\n"
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
	        		+ "sum( cast(qtd_lt_ln_avg_bal_amt as decimal(19,2))) as qtd_lt_ln_avg_bal_amt,\r\n"
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
	        		+ "sum(cast(ytd_overdue_cnt as decimal(19,2))) as ytd_overdue_cnt,"
	        		+ "cob_dt" +
	        					" from customer360.c360_lon_statistic %s";
	        String cifName = "cus_cif_nbr";
	        try {
	            JdbcUtil jdbc = new JdbcUtil();
	            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_lon_statistic");
	            Connection c = jdbc.getConnection();
	            boolean hasGroupBy = true;
	            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
	            ResultSet rc = stm.executeQuery();
	            while (rc.next()){
	            	String cus_cif_nbr = rc.getString("cus_cif_nbr");
	            	BigDecimal dly_st_ln_bal_amt = rc.getBigDecimal("dly_st_ln_bal_amt");
	            	BigDecimal mtd_st_ln_avg_bal_amt = rc.getBigDecimal("mtd_st_ln_avg_bal_amt");
	            	BigDecimal qtd_st_ln_avg_bal_amt = rc.getBigDecimal("qtd_st_ln_avg_bal_amt");
	            	BigDecimal ytd_st_ln_avg_bal_amt = rc.getBigDecimal("ytd_st_ln_avg_bal_amt");
	            	BigDecimal dly_mt_ln_bal_amt = rc.getBigDecimal("dly_mt_ln_bal_amt");
	            	BigDecimal mtd_mt_ln_avg_bal_amt = rc.getBigDecimal("mtd_mt_ln_avg_bal_amt");
	            	BigDecimal qtd_mt_ln_avg_bal_amt = rc.getBigDecimal("qtd_mt_ln_avg_bal_amt");
	            	BigDecimal ytd_mt_ln_avg_bal_amt = rc.getBigDecimal("ytd_mt_ln_avg_bal_amt");
	            	BigDecimal dly_lt_ln_bal_amt = rc.getBigDecimal("dly_lt_ln_bal_amt");
	            	BigDecimal mtd_lt_ln_avg_bal_amt = rc.getBigDecimal("mtd_lt_ln_avg_bal_amt");
	            	BigDecimal qtd_lt_ln_avg_bal_amt = rc.getBigDecimal("qtd_lt_ln_avg_bal_amt");
	            	BigDecimal ytd_lt_ln_avg_bal_amt = rc.getBigDecimal("ytd_lt_ln_avg_bal_amt");
	            	BigDecimal dly_traiphieu_avg_bal_amt = rc.getBigDecimal("dly_traiphieu_avg_bal_amt");
	            	BigDecimal mtd_traiphieu_avg_bal_amt = rc.getBigDecimal("mtd_traiphieu_avg_bal_amt");
	            	BigDecimal qtd_traiphieu_avg_bal_amt = rc.getBigDecimal("qtd_traiphieu_avg_bal_amt");
	            	BigDecimal ytd_traiphieu_avg_bal_amt = rc.getBigDecimal("ytd_traiphieu_avg_bal_amt");
	            	BigDecimal dly_loan_bal_amt = rc.getBigDecimal("dly_loan_bal_amt");
	            	BigDecimal mtd_loan_avg_bal_amt = rc.getBigDecimal("mtd_loan_avg_bal_amt");
	            	BigDecimal qtd_loan_avg_bal_amt = rc.getBigDecimal("qtd_loan_avg_bal_amt");
	            	BigDecimal ytd_loan_avg_bal_amt = rc.getBigDecimal("ytd_loan_avg_bal_amt");
	            	BigDecimal ytd_prncpl_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_shrtrm_amt");
	            	BigDecimal ytd_prncpl_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_mttrm_amt");
	            	BigDecimal ytd_prncpl_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_lngtrm_amt");
	            	BigDecimal ytd_intrst_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_shrtrm_amt");
	            	BigDecimal ytd_intrst_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_mttrm_amt");
	            	BigDecimal ytd_intrst_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_lngtrm_amt");
	            	BigDecimal ytd_ltchrg_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_shrtrm_amt");
	            	BigDecimal ytd_ltchrg_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_mttrm_amt");
	            	BigDecimal ytd_ltchrg_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_lngtrm_amt");
	            	BigDecimal ytd_prncpl_chrg_off_bond_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_bond_amt");
	            	BigDecimal ytd_intrst_chrg_off_bond_amt = rc.getBigDecimal("ytd_intrst_chrg_off_bond_amt");
	            	BigDecimal ytd_ltchrg_chrg_off_bond_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_bond_amt");
	            	BigDecimal dly_nii_st_ln_amt_in_lc = rc.getBigDecimal("dly_nii_st_ln_amt_in_lc");
	            	BigDecimal mtd_nii_st_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_st_ln_amt_in_lc");
	            	BigDecimal qtd_nii_st_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_st_ln_amt_in_lc");
	            	BigDecimal ytd_nii_st_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_st_ln_amt_in_lc");
	            	BigDecimal dly_nii_mt_ln_amt_in_lc = rc.getBigDecimal("dly_nii_mt_ln_amt_in_lc");
	            	BigDecimal mtd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_mt_ln_amt_in_lc");
	            	BigDecimal qtd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_mt_ln_amt_in_lc");
	            	BigDecimal ytd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_mt_ln_amt_in_lc");
	            	BigDecimal dly_nii_lt_ln_amt_in_lc = rc.getBigDecimal("dly_nii_lt_ln_amt_in_lc");
	            	BigDecimal mtd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_lt_ln_amt_in_lc");
	            	BigDecimal qtd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_lt_ln_amt_in_lc");
	            	BigDecimal ytd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_lt_ln_amt_in_lc");
	            	BigDecimal dly_nii_traiphieu_amt = rc.getBigDecimal("dly_nii_traiphieu_amt");
	            	BigDecimal mtd_nii_traiphieu_amt = rc.getBigDecimal("mtd_nii_traiphieu_amt");
	            	BigDecimal qtd_nii_traiphieu_amt = rc.getBigDecimal("qtd_nii_traiphieu_amt");
	            	BigDecimal ytd_nii_traiphieu_amt = rc.getBigDecimal("ytd_nii_traiphieu_amt");
	            	BigDecimal ytd_overdue_cnt = rc.getBigDecimal("ytd_overdue_cnt");
	            	String cob_dt = rc.getString("cob_dt");
	                if (request.getBranch() != null){
	                    String branch  = rc.getString("branch");
	                    System.out.println("Success");
	                    LonStatistics.add(new LonStatistic(cus_cif_nbr,branch,dly_st_ln_bal_amt,mtd_st_ln_avg_bal_amt,qtd_st_ln_avg_bal_amt,ytd_st_ln_avg_bal_amt,dly_mt_ln_bal_amt,mtd_mt_ln_avg_bal_amt,qtd_mt_ln_avg_bal_amt,ytd_mt_ln_avg_bal_amt,dly_lt_ln_bal_amt,mtd_lt_ln_avg_bal_amt,qtd_lt_ln_avg_bal_amt,ytd_lt_ln_avg_bal_amt,dly_traiphieu_avg_bal_amt,mtd_traiphieu_avg_bal_amt,qtd_traiphieu_avg_bal_amt,ytd_traiphieu_avg_bal_amt,dly_loan_bal_amt,mtd_loan_avg_bal_amt,qtd_loan_avg_bal_amt,ytd_loan_avg_bal_amt,ytd_prncpl_chrg_off_shrtrm_amt,ytd_prncpl_chrg_off_mttrm_amt,ytd_prncpl_chrg_off_lngtrm_amt,ytd_intrst_chrg_off_shrtrm_amt,ytd_intrst_chrg_off_mttrm_amt,ytd_intrst_chrg_off_lngtrm_amt,ytd_ltchrg_chrg_off_shrtrm_amt,ytd_ltchrg_chrg_off_mttrm_amt,ytd_ltchrg_chrg_off_lngtrm_amt,ytd_prncpl_chrg_off_bond_amt,ytd_intrst_chrg_off_bond_amt,ytd_ltchrg_chrg_off_bond_amt,dly_nii_st_ln_amt_in_lc,mtd_nii_st_ln_amt_in_lc,qtd_nii_st_ln_amt_in_lc,ytd_nii_st_ln_amt_in_lc,dly_nii_mt_ln_amt_in_lc,mtd_nii_mt_ln_amt_in_lc,qtd_nii_mt_ln_amt_in_lc,ytd_nii_mt_ln_amt_in_lc,dly_nii_lt_ln_amt_in_lc,mtd_nii_lt_ln_amt_in_lc,qtd_nii_lt_ln_amt_in_lc,ytd_nii_lt_ln_amt_in_lc,dly_nii_traiphieu_amt,mtd_nii_traiphieu_amt,qtd_nii_traiphieu_amt,ytd_nii_traiphieu_amt,ytd_overdue_cnt,cob_dt));
	                }
	                else {
	                	LonStatistics.add(new LonStatistic(cus_cif_nbr,null,dly_st_ln_bal_amt,mtd_st_ln_avg_bal_amt,qtd_st_ln_avg_bal_amt,ytd_st_ln_avg_bal_amt,dly_mt_ln_bal_amt,mtd_mt_ln_avg_bal_amt,qtd_mt_ln_avg_bal_amt,ytd_mt_ln_avg_bal_amt,dly_lt_ln_bal_amt,mtd_lt_ln_avg_bal_amt,qtd_lt_ln_avg_bal_amt,ytd_lt_ln_avg_bal_amt,dly_traiphieu_avg_bal_amt,mtd_traiphieu_avg_bal_amt,qtd_traiphieu_avg_bal_amt,ytd_traiphieu_avg_bal_amt,dly_loan_bal_amt,mtd_loan_avg_bal_amt,qtd_loan_avg_bal_amt,ytd_loan_avg_bal_amt,ytd_prncpl_chrg_off_shrtrm_amt,ytd_prncpl_chrg_off_mttrm_amt,ytd_prncpl_chrg_off_lngtrm_amt,ytd_intrst_chrg_off_shrtrm_amt,ytd_intrst_chrg_off_mttrm_amt,ytd_intrst_chrg_off_lngtrm_amt,ytd_ltchrg_chrg_off_shrtrm_amt,ytd_ltchrg_chrg_off_mttrm_amt,ytd_ltchrg_chrg_off_lngtrm_amt,ytd_prncpl_chrg_off_bond_amt,ytd_intrst_chrg_off_bond_amt,ytd_ltchrg_chrg_off_bond_amt,dly_nii_st_ln_amt_in_lc,mtd_nii_st_ln_amt_in_lc,qtd_nii_st_ln_amt_in_lc,ytd_nii_st_ln_amt_in_lc,dly_nii_mt_ln_amt_in_lc,mtd_nii_mt_ln_amt_in_lc,qtd_nii_mt_ln_amt_in_lc,ytd_nii_mt_ln_amt_in_lc,dly_nii_lt_ln_amt_in_lc,mtd_nii_lt_ln_amt_in_lc,qtd_nii_lt_ln_amt_in_lc,ytd_nii_lt_ln_amt_in_lc,dly_nii_traiphieu_amt,mtd_nii_traiphieu_amt,qtd_nii_traiphieu_amt,ytd_nii_traiphieu_amt,ytd_overdue_cnt,cob_dt));
	                }
	            }
	            c.close();
	        }
	        catch (SQLException e){
	            System.out.println(e.getErrorCode());
	        }
	        for (LonStatistic cus : LonStatistics){
	            System.out.println(cus.toString());
	        }

	        return LonStatistics;
	    }
}
