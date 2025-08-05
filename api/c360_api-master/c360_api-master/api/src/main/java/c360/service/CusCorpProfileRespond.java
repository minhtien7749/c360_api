package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.model.*;
import c360.database.*;
import c360.service.*;

public class CusCorpProfileRespond {
    public static ArrayList<CustomerCorpProfile> getRespond(InputRequestCorporate request) {
        ArrayList<CustomerCorpProfile> custCorpProfile = new ArrayList<>();
        String sql = "select * from customer360.c360_corporate_cus_profile_dly %s";
        String sqlBranch = "select * from customer360.c360_corporate_cus_profile_dly %s";
        String cifName = "cif_no";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_corporate_cus_profile_dly");
            Connection c = jdbc.getConnection();
            boolean hasGroupBy = false;
            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                String cif_no = rc.getString("cif_no");
                String cus_crea_dt = rc.getString("cus_crea_dt");
                int bank_age = rc.getInt("bank_age");
                String cus_incp_dt = rc.getString("cus_incp_dt");
                int cus_age = rc.getInt("cus_age");
                String bus_regist_dt = rc.getString("bus_regist_dt");
                String pstate_cd = rc.getString("pstate_cd");
                String pstate_nm = rc.getString("pstate_nm");
                String pcountry_cd = rc.getString("pcountry_cd");
                String pcountry_nm = rc.getString("pcountry_nm");
                String mstate_cd = rc.getString("mstate_cd");
                String mstate_nm = rc.getString("mstate_nm");
                String mcountry_cd = rc.getString("mcountry_cd");
                String mcountry_nm = rc.getString("mcountry_nm");
                String segment_cd = rc.getString("segment_cd");
                String segment_nm = rc.getString("segment_nm");
                String brnch_cd = rc.getString("brnch_cd");
                String brnch_nm = rc.getString("brnch_nm");
                String pri_brnch_cd = rc.getString("pri_brnch_cd");
                String pri_brnch_nm = rc.getString("pri_brnch_nm");
                String brnch_region = rc.getString("brnch_region");
                String brnch_state = rc.getString("brnch_state");
                String loan_grp = rc.getString("loan_grp");
                String cic_grp = rc.getString("cic_grp");
                String status_cd = rc.getString("status_cd");
                String status_nm = rc.getString("status_nm");
                String cus_subt_cd = rc.getString("cus_subt_cd");
                String cus_subt_nm = rc.getString("cus_subt_nm");
                String legal_dsgnt_grp_cd = rc.getString("legal_dsgnt_grp_cd");
                String legal_dsgnt_grp_nm = rc.getString("legal_dsgnt_grp_nm");
                String legal_form_cd = rc.getString("legal_form_cd");
                String legal_form_nm = rc.getString("legal_form_nm");
                String num_employees = rc.getString("num_employees");
                String residency_cd = rc.getString("residency_cd");
                String residency_nm = rc.getString("residency_nm");
                String residency_ctry_cd = rc.getString("residency_ctry_cd");
                String residency_ctry_nm = rc.getString("residency_ctry_nm");
                String industry_grp_cd = rc.getString("industry_grp_cd");
                String industry_grp_nm = rc.getString("industry_grp_nm");
                String industry_cd = rc.getString("industry_cd");
                String industry_nm = rc.getString("industry_nm");
                String total_assets = rc.getString("total_assets");
                String tax_id = rc.getString("tax_id");
                String ind_blacklist = rc.getString("ind_blacklist");
                String charter_capital = rc.getString("charter_capital");
                String net_revenue = rc.getString("net_revenue");
                String ind_efast = rc.getString("ind_efast");
                String efast_package_id = rc.getString("efast_package_id");
                String efast_rfdue = rc.getString("efast_rfdue");
                String tot_lmt = rc.getString("tot_lmt");
                String lmt_exp_dt = rc.getString("lmt_exp_dt");
                String crd_class = rc.getString("crd_class");
                String pd_class = rc.getString("pd_class");
                String grading_period = rc.getString("grading_period");
                BigDecimal rank_score = rc.getBigDecimal("rank_score");
                String rating_authority = rc.getString("rating_authority");
                BigDecimal year_t_fin_loan_bal_amt = rc.getBigDecimal("year_t_fin_loan_bal_amt");
                BigDecimal year_t_fin_tdepst_bal_amt = rc.getBigDecimal("year_t_fin_tdepst_bal_amt");
                BigDecimal year_t_fin_rvne_amt = rc.getBigDecimal("year_t_fin_rvne_amt");
                BigDecimal year_t_fin_net_rvne_amt = rc.getBigDecimal("year_t_fin_net_rvne_amt");
                BigDecimal year_t_fin_prfit_bf_tax = rc.getBigDecimal("year_t_fin_prfit_bf_tax");
                BigDecimal year_t_fin_prfit_af_tax = rc.getBigDecimal("year_t_fin_prfit_af_tax");
                BigDecimal year_t_1_fin_loan_bal_amt = rc.getBigDecimal("year_t_1_fin_loan_bal_amt");
                BigDecimal year_t_1_fin_tdepst_bal_amt = rc.getBigDecimal("year_t_1_fin_tdepst_bal_amt");
                BigDecimal year_t_1_fin_rvne_amt = rc.getBigDecimal("year_t_1_fin_rvne_amt");
                BigDecimal year_t_1_fin_net_rvne_amt = rc.getBigDecimal("year_t_1_fin_net_rvne_amt");
                BigDecimal year_t_1_fin_prfit_bf_tax = rc.getBigDecimal("year_t_1_fin_prfit_bf_tax");
                BigDecimal year_t_1_fin_prfit_af_tax = rc.getBigDecimal("year_t_1_fin_prfit_af_tax");
                BigDecimal year_t_2_fin_loan_bal_amt = rc.getBigDecimal("year_t_2_fin_loan_bal_amt");
                BigDecimal year_t_2_fin_tdepst_bal_amt = rc.getBigDecimal("year_t_2_fin_tdepst_bal_amt");
                BigDecimal year_t_2_fin_rvne_amt = rc.getBigDecimal("year_t_2_fin_rvne_amt");
                BigDecimal year_t_2_fin_net_rvne_amt = rc.getBigDecimal("year_t_2_fin_net_rvne_amt");
                BigDecimal year_t_2_fin_prfit_bf_tax = rc.getBigDecimal("year_t_2_fin_prfit_bf_tax");
                BigDecimal year_t_2_fin_prfit_af_tax = rc.getBigDecimal("year_t_2_fin_prfit_af_tax");
                BigDecimal year_t_3_fin_loan_bal_amt = rc.getBigDecimal("year_t_3_fin_loan_bal_amt");
                BigDecimal year_t_3_fin_tdepst_bal_amt = rc.getBigDecimal("year_t_3_fin_tdepst_bal_amt");
                BigDecimal year_t_3_fin_rvne_amt = rc.getBigDecimal("year_t_3_fin_rvne_amt");
                BigDecimal year_t_3_fin_net_rvne_amt = rc.getBigDecimal("year_t_3_fin_net_rvne_amt");
                BigDecimal year_t_3_fin_prfit_bf_tax = rc.getBigDecimal("year_t_3_fin_prfit_bf_tax");
                BigDecimal year_t_3_fin_prfit_af_tax = rc.getBigDecimal("year_t_3_fin_prfit_af_tax");
                String final_ews_alert = rc.getString("final_ews_alert");
                String vic_alert = rc.getString("vic_alert");
                String cob_dt = rc.getString("cob_dt");
                String aml_cust_segments = rc.getString("aml_cust_segments");
                String aml_risk_level = rc.getString("aml_risk_level");
                custCorpProfile.add(new CustomerCorpProfile(cif_no, cus_crea_dt, bank_age, cus_incp_dt, cus_age, bus_regist_dt, pstate_cd, pstate_nm, pcountry_cd, pcountry_nm,
                        mstate_cd, mstate_nm, mcountry_cd, mcountry_nm, segment_cd, segment_nm, brnch_cd, brnch_nm, pri_brnch_cd, pri_brnch_nm, brnch_region, brnch_state,
                        loan_grp, cic_grp, status_cd, status_nm, cus_subt_cd, cus_subt_nm, legal_dsgnt_grp_cd, legal_dsgnt_grp_nm, legal_form_cd, legal_form_nm, num_employees,
                        residency_cd, residency_nm, residency_ctry_cd, residency_ctry_nm, industry_grp_cd, industry_grp_nm, industry_cd, industry_nm, total_assets, tax_id,
                        ind_blacklist, charter_capital, net_revenue, ind_efast, efast_package_id, efast_rfdue, tot_lmt, lmt_exp_dt, crd_class, pd_class,
                        grading_period, rank_score, rating_authority, year_t_fin_loan_bal_amt, year_t_fin_tdepst_bal_amt, year_t_fin_rvne_amt, year_t_fin_net_rvne_amt,
                        year_t_fin_prfit_bf_tax, year_t_fin_prfit_af_tax, year_t_1_fin_loan_bal_amt, year_t_1_fin_tdepst_bal_amt, year_t_1_fin_rvne_amt,
                        year_t_1_fin_net_rvne_amt, year_t_1_fin_prfit_bf_tax, year_t_1_fin_prfit_af_tax, year_t_2_fin_loan_bal_amt, year_t_2_fin_tdepst_bal_amt,
                        year_t_2_fin_rvne_amt, year_t_2_fin_net_rvne_amt, year_t_2_fin_prfit_bf_tax, year_t_2_fin_prfit_af_tax, year_t_3_fin_loan_bal_amt,
                        year_t_3_fin_tdepst_bal_amt, year_t_3_fin_rvne_amt, year_t_3_fin_net_rvne_amt, year_t_3_fin_prfit_bf_tax, year_t_3_fin_prfit_af_tax,
                        final_ews_alert, vic_alert, cob_dt, aml_cust_segments, aml_risk_level));

            }
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        for (CustomerCorpProfile cus : custCorpProfile){
            System.out.println(cus.toString());
        }
        return custCorpProfile;
    }

    public static void main(String[] args) {
        InputRequestCorporate request = new InputRequestCorporate("1","1","1","300069577","2022-01-01",null,null,null);
        ArrayList<CustomerCorpProfile> a = getRespond(request);
    }

}