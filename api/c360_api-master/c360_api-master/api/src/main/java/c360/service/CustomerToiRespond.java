package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import c360.database.*;
import c360.model.*;
import c360.service.*;
public class CustomerToiRespond {
    public static ArrayList<CustomerToi> getRespond(InputRequestCorporate request) {
        ArrayList<CustomerToi> CustomerTois = new ArrayList<>();
        String sql ="select \n" +
                "cus_cif_nbr as cif_no,\n" +
                "--branch,\n" +
                "sum(mtd_svrc_fee_amt) mtd_svrc_fee_amt,\n" +
                "sum(qtd_svrc_fee_amt  ) qtd_svrc_fee_amt,\n" +
                "sum(ytd_svrc_fee_amt ) ytd_svrc_fee_amt,\n" +
                "sum(mtd_kdnt_incm_amt ) mtd_kdnt_incm_amt,\n" +
                "sum(qtd_kdnt_incm_amt ) qtd_kdnt_incm_amt,\n" +
                "sum(ytd_kdnt_incm_amt ) ytd_kdnt_incm_amt,\n" +
                "sum(mtd_toi_amt ) mtd_toi_amt,\n" +
                "sum(qtd_toi_amt ) qtd_toi_amt,\n" +
                "sum(ytd_toi_amt) ytd_toi_amt,\n" +
                "sum(ytd_tttm_noii_amt) ytd_tttm_noii_amt,\n" +
                "sum(ytd_fund_trnsfer_noii_amt ) ytd_fund_trnsfer_noii_amt,\n" +
                "sum(mtd_roa_amt ) mtd_roa_amt,\n" +
                "sum(six_m_roa_amt ) six_m_roa_amt,\n" +
                "    (SUM(nvl(ytd_toi_amt,0)) / SUM(ytd_loan_avg_amt)) * 365 /\r\n"
                + "    (DATEDIFF(cob_dt, DATE_SUB(cob_dt, INTERVAL DAYOFYEAR(cob_dt) - 1 DAY)) + 1) AS ytd_roa_amt,\n" +
                "sum(mtd_tsslnl_amt ) mtd_tsslnl_amt,\n" +
                "(SUM(nvl(ytd_toi_amt,0)) - SUM(nvl(ytd_ln_nii_alco_amt_in_lc,0))) / SUM(ytd_loan_avg_amt) * 365 /\r\n"
                + "    (DATEDIFF(cob_dt, DATE_SUB(cob_dt, INTERVAL DAYOFYEAR(cob_dt) - 1 DAY)) + 1) AS ytd_tsslnl_amt,\n" +
                "sum(mtd_tssl_amt ) mtd_tssl_amt,\n" +
                "sum(ytd_tssl_amt) ytd_tssl_amt ,\n" +
                "sum(ytd_loan_nim_amt ) ytd_loan_nim_amt,\n" +
                "sum(ytd_depst_nim_amt ) ytd_depst_nim_amt,\n" +
                "sum(qtd_loan_nii_amt ) qtd_loan_nii_amt,\n" +
                "sum(qtd_depst_nii_amt ) qtd_depst_nii_amt,\n" +
                "sum(mtd_loan_avg_amt ) mtd_loan_avg_amt,\n" +
                "cob_dt\n" +
                "from customer360.c360_cus_toi_amt_fact %s";
        String sqlBranch = "select \n" +
                "cus_cif_nbr as cif_no,\n" +
                "branch,\n" +
                "sum(mtd_svrc_fee_amt) mtd_svrc_fee_amt,\n" +
                "sum(qtd_svrc_fee_amt  ) qtd_svrc_fee_amt,\n" +
                "sum(ytd_svrc_fee_amt ) ytd_svrc_fee_amt,\n" +
                "sum(mtd_kdnt_incm_amt ) mtd_kdnt_incm_amt,\n" +
                "sum(qtd_kdnt_incm_amt ) qtd_kdnt_incm_amt,\n" +
                "sum(ytd_kdnt_incm_amt ) ytd_kdnt_incm_amt,\n" +
                "sum(mtd_toi_amt ) mtd_toi_amt,\n" +
                "sum(qtd_toi_amt ) qtd_toi_amt,\n" +
                "sum(ytd_toi_amt) ytd_toi_amt,\n" +
                "sum(ytd_tttm_noii_amt) ytd_tttm_noii_amt,\n" +
                "sum(ytd_fund_trnsfer_noii_amt ) ytd_fund_trnsfer_noii_amt,\n" +
                "sum(mtd_roa_amt ) mtd_roa_amt,\n" +
                "sum(six_m_roa_amt ) six_m_roa_amt,\n" +
                " sum(ytd_roa_amt) AS ytd_roa_amt,\n" +
                "sum(mtd_tsslnl_amt) mtd_tsslnl_amt,\n" +
                "sum(ytd_tssl_amt) AS ytd_tssl_amt,\n" +
                "sum(mtd_tssl_amt ) mtd_tssl_amt,\n" +
                "sum(ytd_tsslnl_amt) ytd_tsslnl_amt,\n" +
                "sum(ytd_loan_nim_amt ) ytd_loan_nim_amt,\n" +
                "sum(ytd_depst_nim_amt ) ytd_depst_nim_amt,\n" +
                "sum(qtd_loan_nii_amt ) qtd_loan_nii_amt,\n" +
                "sum(qtd_depst_nii_amt ) qtd_depst_nii_amt,\n" +
                "sum(mtd_loan_avg_amt ) mtd_loan_avg_amt,\n" +
                
                "cob_dt\n" +
                "from customer360.c360_cus_toi_amt_fact %s";
        String cifName = "cus_cif_nbr";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_cus_toi_amt_fact");
            Connection c = jdbc.getConnection();
            boolean hasGroupBy = true;
            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
            ResultSet rc = stm.executeQuery();
            while (rc.next()){
                String cus_cif_nbr = rc.getString("cif_no");
                BigDecimal mtd_svrc_fee_amt = rc.getBigDecimal("mtd_svrc_fee_amt");
                BigDecimal qtd_svrc_fee_amt = rc.getBigDecimal("qtd_svrc_fee_amt");
                BigDecimal ytd_svrc_fee_amt = rc.getBigDecimal("ytd_svrc_fee_amt");
                BigDecimal mtd_kdnt_incm_amt = rc.getBigDecimal("mtd_kdnt_incm_amt");
                BigDecimal qtd_kdnt_incm_amt = rc.getBigDecimal("qtd_kdnt_incm_amt");
                BigDecimal ytd_kdnt_incm_amt = rc.getBigDecimal("ytd_kdnt_incm_amt");
                BigDecimal mtd_toi_amt = rc.getBigDecimal("mtd_toi_amt");
                BigDecimal qtd_toi_amt = rc.getBigDecimal("qtd_toi_amt");
                BigDecimal ytd_toi_amt = rc.getBigDecimal("ytd_toi_amt");
                BigDecimal ytd_tttm_noii_amt = rc.getBigDecimal("ytd_tttm_noii_amt");
                BigDecimal ytd_fund_trnsfer_noii_amt = rc.getBigDecimal("ytd_fund_trnsfer_noii_amt");
                BigDecimal mtd_roa_amt = rc.getBigDecimal("mtd_roa_amt");
                BigDecimal six_m_roa_amt = rc.getBigDecimal("six_m_roa_amt");
                BigDecimal ytd_roa_amt = rc.getBigDecimal("ytd_roa_amt");
                BigDecimal mtd_tsslnl_amt = rc.getBigDecimal("mtd_tsslnl_amt");
                BigDecimal ytd_tsslnl_amt = rc.getBigDecimal("ytd_tsslnl_amt");
                BigDecimal mtd_tssl_amt = rc.getBigDecimal("mtd_tssl_amt");
                BigDecimal ytd_tssl_amt = rc.getBigDecimal("ytd_tssl_amt");
                BigDecimal ytd_loan_nim_amt = rc.getBigDecimal("ytd_loan_nim_amt");
                BigDecimal ytd_depst_nim_amt = rc.getBigDecimal("ytd_depst_nim_amt");
                BigDecimal qtd_loan_nii_amt = rc.getBigDecimal("qtd_loan_nii_amt");
                BigDecimal qtd_depst_nii_amt = rc.getBigDecimal("qtd_depst_nii_amt");
                BigDecimal mtd_loan_avg_amt = rc.getBigDecimal("mtd_loan_avg_amt");
                String cob_dt = rc.getString("cob_dt");
                if (request.getBranch() != null){
                    String branch  = rc.getString("branch");
                    CustomerTois.add(new CustomerToi(cus_cif_nbr,branch,mtd_svrc_fee_amt,qtd_svrc_fee_amt,ytd_svrc_fee_amt,mtd_kdnt_incm_amt,qtd_kdnt_incm_amt,
                            ytd_kdnt_incm_amt,mtd_toi_amt,qtd_toi_amt,ytd_toi_amt,ytd_tttm_noii_amt,ytd_fund_trnsfer_noii_amt,mtd_roa_amt,
                            six_m_roa_amt,ytd_roa_amt,mtd_tsslnl_amt,ytd_tsslnl_amt,mtd_tssl_amt,ytd_tssl_amt,ytd_loan_nim_amt,
                            ytd_depst_nim_amt,qtd_loan_nii_amt,qtd_depst_nii_amt,mtd_loan_avg_amt,cob_dt));
                }
                else {
                    CustomerTois.add(new CustomerToi(cus_cif_nbr,null,mtd_svrc_fee_amt,qtd_svrc_fee_amt,ytd_svrc_fee_amt,mtd_kdnt_incm_amt,qtd_kdnt_incm_amt,
                            ytd_kdnt_incm_amt,mtd_toi_amt,qtd_toi_amt,ytd_toi_amt,ytd_tttm_noii_amt,ytd_fund_trnsfer_noii_amt,mtd_roa_amt,
                            six_m_roa_amt,ytd_roa_amt,mtd_tsslnl_amt,ytd_tsslnl_amt,mtd_tssl_amt,ytd_tssl_amt,ytd_loan_nim_amt,
                            ytd_depst_nim_amt,qtd_loan_nii_amt,qtd_depst_nii_amt,mtd_loan_avg_amt,cob_dt));
                }
            }
            c.close();
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        for (CustomerToi cus : CustomerTois){
            System.out.println(cus.toString());
        }

        return CustomerTois;
    }
}