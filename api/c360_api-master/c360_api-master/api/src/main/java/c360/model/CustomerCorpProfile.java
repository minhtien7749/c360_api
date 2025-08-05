 package c360.model;
 
 import java.math.BigDecimal;
 import java.math.BigInteger;

 public class CustomerCorpProfile {
	 private String cif_no;
	    private String cus_crea_dt;
	    private Integer bank_age;
	    private String cus_incp_dt;
	    private Integer cus_age;
	    private String bus_regist_dt;
	    private String pstate_cd;
	    private String pstate_nm;
	    private String pcountry_cd;
	    private String pcountry_nm;
	    private String mstate_cd;
	    private String mstate_nm;
	    private String mcountry_cd;
	    private String mcountry_nm;
	    private String segment_cd;
	    private String segment_nm;
	    private String brnch_cd;
	    private String brnch_nm;
	    private String pri_brnch_cd;
	    private String pri_brnch_nm;
	    private String brnch_region;
	    private String brnch_state;
	    private String loan_grp;
	    private String cic_grp;
	    private String status_cd;
	    private String status_nm;
	    private String cus_subt_cd;
	    private String cus_subt_nm;
	    private String legal_dsgnt_grp_cd;
	    private String legal_dsgnt_grp_nm;
	    private String legal_form_cd;
	    private String legal_form_nm;
	    private String num_employees;
	    private String residency_cd;
	    private String residency_nm;
	    private String residency_ctry_cd;
	    private String residency_ctry_nm;
	    private String industry_grp_cd;
	    private String industry_grp_nm;
	    private String industry_cd;
	    private String industry_nm;
	    private String total_assets;
	    private String tax_id;
	    private String ind_blacklist;
	    private String charter_capital;
	    private String net_revenue;
	    private String ind_efast;
	    private String efast_package_id;
	    private String efast_rfdue;
	    private String tot_lmt;
	    private String lmt_exp_dt;
	    private String crd_class;
	    private String pd_class;
	    private String grading_period;
	    private BigDecimal rank_score;
	    private String rating_authority;
	    private BigDecimal year_t_fin_loan_bal_amt;
	    private BigDecimal year_t_fin_tdepst_bal_amt;
	    private BigDecimal year_t_fin_rvne_amt;
	    private BigDecimal year_t_fin_net_rvne_amt;
	    private BigDecimal year_t_fin_prfit_bf_tax;
	    private BigDecimal year_t_fin_prfit_af_tax;
	    private BigDecimal year_t_1_fin_loan_bal_amt;
	    private BigDecimal year_t_1_fin_tdepst_bal_amt;
	    private BigDecimal year_t_1_fin_rvne_amt;
	    private BigDecimal year_t_1_fin_net_rvne_amt;
	    private BigDecimal year_t_1_fin_prfit_bf_tax;
	    private BigDecimal year_t_1_fin_prfit_af_tax;
	    private BigDecimal year_t_2_fin_loan_bal_amt;
	    private BigDecimal year_t_2_fin_tdepst_bal_amt;
	    private BigDecimal year_t_2_fin_rvne_amt;
	    private BigDecimal year_t_2_fin_net_rvne_amt;
	    private BigDecimal year_t_2_fin_prfit_bf_tax;
	    private BigDecimal year_t_2_fin_prfit_af_tax;
	    private BigDecimal year_t_3_fin_loan_bal_amt;
	    private BigDecimal year_t_3_fin_tdepst_bal_amt;
	    private BigDecimal year_t_3_fin_rvne_amt;
	    private BigDecimal year_t_3_fin_net_rvne_amt;
	    private BigDecimal year_t_3_fin_prfit_bf_tax;
	    private BigDecimal year_t_3_fin_prfit_af_tax;
	    private String final_ews_alert;
	    private String vic_alert;
	    private String cob_dt;
	    private String aml_cust_segments;
	    private String aml_risk_level;

	    public CustomerCorpProfile(String cif_no, String cus_crea_dt, Integer bank_age, String cus_incp_dt, Integer cus_age, String bus_regist_dt, String pstate_cd, String pstate_nm, String pcountry_cd, 
	          String pcountry_nm, String mstate_cd, String mstate_nm, String mcountry_cd, String mcountry_nm, String segment_cd, String segment_nm, 
	                               String brnch_cd, String brnch_nm, String pri_brnch_cd, String pri_brnch_nm, String brnch_region, String brnch_state, 
	                               String loan_grp, String cic_grp, String status_cd, String status_nm, String cus_subt_cd, String cus_subt_nm, 
	                               String legal_dsgnt_grp_cd, String legal_dsgnt_grp_nm, String legal_form_cd, String legal_form_nm, String num_employees, 
	                               String residency_cd, String residency_nm, String residency_ctry_cd, String residency_ctry_nm, String industry_grp_cd, 
	                               String industry_grp_nm, String industry_cd, String industry_nm, String total_assets, String tax_id, String ind_blacklist, 
	                               String charter_capital, String net_revenue, String ind_efast, String efast_package_id, String efast_rfdue, String tot_lmt, 
	                               String lmt_exp_dt, String crd_class, String pd_class, String grading_period, BigDecimal rank_score, String rating_authority, 
	                               BigDecimal year_t_fin_loan_bal_amt, BigDecimal year_t_fin_tdepst_bal_amt, BigDecimal year_t_fin_rvne_amt, 
	                               BigDecimal year_t_fin_net_rvne_amt, BigDecimal year_t_fin_prfit_bf_tax, BigDecimal year_t_fin_prfit_af_tax, 
	                               BigDecimal year_t_1_fin_loan_bal_amt, BigDecimal year_t_1_fin_tdepst_bal_amt, BigDecimal year_t_1_fin_rvne_amt, 
	                               BigDecimal year_t_1_fin_net_rvne_amt, BigDecimal year_t_1_fin_prfit_bf_tax, BigDecimal year_t_1_fin_prfit_af_tax, 
	                               BigDecimal year_t_2_fin_loan_bal_amt, BigDecimal year_t_2_fin_tdepst_bal_amt, BigDecimal year_t_2_fin_rvne_amt, 
	                               BigDecimal year_t_2_fin_net_rvne_amt, BigDecimal year_t_2_fin_prfit_bf_tax, BigDecimal year_t_2_fin_prfit_af_tax, 
	                               BigDecimal year_t_3_fin_loan_bal_amt, BigDecimal year_t_3_fin_tdepst_bal_amt, BigDecimal year_t_3_fin_rvne_amt, 
	                               BigDecimal year_t_3_fin_net_rvne_amt, BigDecimal year_t_3_fin_prfit_bf_tax, BigDecimal year_t_3_fin_prfit_af_tax, 
	                               String final_ews_alert, String vic_alert, String cob_dt, String aml_cust_segments, String aml_risk_level) {
	        this.cif_no = cif_no;
	        this.cus_crea_dt = cus_crea_dt;
	        this.bank_age = bank_age;
	        this.cus_incp_dt = cus_incp_dt;
	        this.cus_age = cus_age;
	        this.bus_regist_dt = bus_regist_dt;
	        this.pstate_cd = pstate_cd;
	        this.pstate_nm = pstate_nm;
	        this.pcountry_cd = pcountry_cd;
	        this.pcountry_nm = pcountry_nm;
	        this.mstate_cd = mstate_cd;
	        this.mstate_nm = mstate_nm;
	        this.mcountry_cd = mcountry_cd;
	        this.mcountry_nm = mcountry_nm;
	        this.segment_cd = segment_cd;
	        this.segment_nm = segment_nm;
	        this.brnch_cd = brnch_cd;
	        this.brnch_nm = brnch_nm;
	        this.pri_brnch_cd = pri_brnch_cd;
	        this.pri_brnch_nm = pri_brnch_nm;
	        this.brnch_region = brnch_region;
	        this.brnch_state = brnch_state;
	        this.loan_grp = loan_grp;
	        this.cic_grp = cic_grp;
	        this.status_cd = status_cd;
	        this.status_nm = status_nm;
	        this.cus_subt_cd = cus_subt_cd;
	        this.cus_subt_nm = cus_subt_nm;
	        this.legal_dsgnt_grp_cd = legal_dsgnt_grp_cd;
	        this.legal_dsgnt_grp_nm = legal_dsgnt_grp_nm;
	        this.legal_form_cd = legal_form_cd;
	        this.legal_form_nm = legal_form_nm;
	        this.num_employees = num_employees;
	        this.residency_cd = residency_cd;
	        this.residency_nm = residency_nm;
	        this.residency_ctry_cd = residency_ctry_cd;
	        this.residency_ctry_nm = residency_ctry_nm;
	        this.industry_grp_cd = industry_grp_cd;
	        this.industry_grp_nm = industry_grp_nm;
	        this.industry_cd = industry_cd;
	        this.industry_nm = industry_nm;
	        this.total_assets = total_assets;
	        this.tax_id = tax_id;
	        this.ind_blacklist = ind_blacklist;
	        this.charter_capital = charter_capital;
	        this.net_revenue = net_revenue;
	        this.ind_efast = ind_efast;
	        this.efast_package_id = efast_package_id;
	        this.efast_rfdue = efast_rfdue;
	        this.tot_lmt = tot_lmt;
	        this.lmt_exp_dt = lmt_exp_dt;
	        this.crd_class = crd_class;
	        this.pd_class = pd_class;
	        this.grading_period = grading_period;
	        this.rank_score = rank_score;
	        this.rating_authority = rating_authority;
	        this.year_t_fin_loan_bal_amt = year_t_fin_loan_bal_amt;
	        this.year_t_fin_tdepst_bal_amt = year_t_fin_tdepst_bal_amt;
	        this.year_t_fin_rvne_amt = year_t_fin_rvne_amt;
	        this.year_t_fin_net_rvne_amt = year_t_fin_net_rvne_amt;
	        this.year_t_fin_prfit_bf_tax = year_t_fin_prfit_bf_tax;
	        this.year_t_fin_prfit_af_tax = year_t_fin_prfit_af_tax;
	        this.year_t_1_fin_loan_bal_amt = year_t_1_fin_loan_bal_amt;
	        this.year_t_1_fin_tdepst_bal_amt = year_t_1_fin_tdepst_bal_amt;
	        this.year_t_1_fin_rvne_amt = year_t_1_fin_rvne_amt;
	        this.year_t_1_fin_net_rvne_amt = year_t_1_fin_net_rvne_amt;
	        this.year_t_1_fin_prfit_bf_tax = year_t_1_fin_prfit_bf_tax;
	        this.year_t_1_fin_prfit_af_tax = year_t_1_fin_prfit_af_tax;
	        this.year_t_2_fin_loan_bal_amt = year_t_2_fin_loan_bal_amt;
	        this.year_t_2_fin_tdepst_bal_amt = year_t_2_fin_tdepst_bal_amt;
	        this.year_t_2_fin_rvne_amt = year_t_2_fin_rvne_amt;
	        this.year_t_2_fin_net_rvne_amt = year_t_2_fin_net_rvne_amt;
	        this.year_t_2_fin_prfit_bf_tax = year_t_2_fin_prfit_bf_tax;
	        this.year_t_2_fin_prfit_af_tax = year_t_2_fin_prfit_af_tax;
	        this.year_t_3_fin_loan_bal_amt = year_t_3_fin_loan_bal_amt;
	        this.year_t_3_fin_tdepst_bal_amt = year_t_3_fin_tdepst_bal_amt;
	        this.year_t_3_fin_rvne_amt = year_t_3_fin_rvne_amt;
	        this.year_t_3_fin_net_rvne_amt = year_t_3_fin_net_rvne_amt;
	        this.year_t_3_fin_prfit_bf_tax = year_t_3_fin_prfit_bf_tax;
	        this.year_t_3_fin_prfit_af_tax = year_t_3_fin_prfit_af_tax;
	        this.final_ews_alert = final_ews_alert;
	        this.vic_alert = vic_alert;
	        this.cob_dt = cob_dt;
	        this.aml_cust_segments = aml_cust_segments;
	        this.aml_risk_level = aml_risk_level;
	    }

	    public String getCif_no() {
	        return cif_no;
	    }

	    public String getCus_crea_dt() {
	        return cus_crea_dt;
	    }

	    public Integer getBank_age() {
	        return bank_age;
	    }

	    public String getCus_incp_dt() {
	        return cus_incp_dt;
	    }

	    public Integer getCus_age() {
	        return cus_age;
	    }

	    public String getBus_regist_dt() {
	        return bus_regist_dt;
	    }

	    public String getPstate_cd() {
	        return pstate_cd;
	    }

	    public String getPstate_nm() {
	        return pstate_nm;
	    }

	    public String getPcountry_cd() {
	        return pcountry_cd;
	    }

	    public String getPcountry_nm() {
	        return pcountry_nm;
	    }

	    public String getMstate_cd() {
	        return mstate_cd;
	    }

	    public String getMstate_nm() {
	        return mstate_nm;
	    }

	    public String getMcountry_cd() {
	        return mcountry_cd;
	    }

	    public String getMcountry_nm() {
	        return mcountry_nm;
	    }

	    public String getSegment_cd() {
	        return segment_cd;
	    }

	    public String getSegment_nm() {
	        return segment_nm;
	    }

	    public String getBrnch_cd() {
	        return brnch_cd;
	    }

	    public String getBrnch_nm() {
	        return brnch_nm;
	    }

	    public String getPri_brnch_cd() {
	        return pri_brnch_cd;
	    }

	    public String getPri_brnch_nm() {
	        return pri_brnch_nm;
	    }

	    public String getBrnch_region() {
	        return brnch_region;
	    }

	    public String getBrnch_state() {
	        return brnch_state;
	    }

	    public String getLoan_grp() {
	        return loan_grp;
	    }

	    public String getCic_grp() {
	        return cic_grp;
	    }

	    public String getStatus_cd() {
	        return status_cd;
	    }

	    public String getStatus_nm() {
	        return status_nm;
	    }

	    public String getCus_subt_cd() {
	        return cus_subt_cd;
	    }

	    public String getCus_subt_nm() {
	        return cus_subt_nm;
	    }

	    public String getLegal_dsgnt_grp_cd() {
	        return legal_dsgnt_grp_cd;
	    }

	    public String getLegal_dsgnt_grp_nm() {
	        return legal_dsgnt_grp_nm;
	    }

	    public String getLegal_form_cd() {
	        return legal_form_cd;
	    }

	    public String getLegal_form_nm() {
	        return legal_form_nm;
	    }

	    public String getNum_employees() {
	        return num_employees;
	    }

	    public String getResidency_cd() {
	        return residency_cd;
	    }

	    public String getResidency_nm() {
	        return residency_nm;
	    }

	    public String getResidency_ctry_cd() {
	        return residency_ctry_cd;
	    }

	    public String getResidency_ctry_nm() {
	        return residency_ctry_nm;
	    }

	    public String getIndustry_grp_cd() {
	        return industry_grp_cd;
	    }

	    public String getIndustry_grp_nm() {
	        return industry_grp_nm;
	    }

	    public String getIndustry_cd() {
	        return industry_cd;
	    }

	    public String getIndustry_nm() {
	        return industry_nm;
	    }

	    public String getTotal_assets() {
	        return total_assets;
	    }

	    public String getTax_id() {
	        return tax_id;
	    }

	    public String getInd_blacklist() {
	        return ind_blacklist;
	    }

	    public String getCharter_capital() {
	        return charter_capital;
	    }

	    public String getNet_revenue() {
	        return net_revenue;
	    }

	    public String getInd_efast() {
	        return ind_efast;
	    }

	    public String getEfast_package_id() {
	        return efast_package_id;
	    }

	    public String getEfast_rfdue() {
	        return efast_rfdue;
	    }

	    public String getTot_lmt() {
	        return tot_lmt;
	    }

	    public String getLmt_exp_dt() {
	        return lmt_exp_dt;
	    }

	    public String getCrd_class() {
	        return crd_class;
	    }

	    public String getPd_class() {
	        return pd_class;
	    }

	    public String getGrading_period() {
	        return grading_period;
	    }

	    public BigDecimal getRank_score() {
	        return rank_score;
	    }

	    public String getRating_authority() {
	        return rating_authority;
	    }

	    public BigDecimal getYear_t_fin_loan_bal_amt() {
	        return year_t_fin_loan_bal_amt;
	    }

	    public BigDecimal getYear_t_fin_tdepst_bal_amt() {
	        return year_t_fin_tdepst_bal_amt;
	    }

	    public BigDecimal getYear_t_fin_rvne_amt() {
	        return year_t_fin_rvne_amt;
	    }

	    public BigDecimal getYear_t_fin_net_rvne_amt() {
	        return year_t_fin_net_rvne_amt;
	    }

	    public BigDecimal getYear_t_fin_prfit_bf_tax() {
	        return year_t_fin_prfit_bf_tax;
	    }

	    public BigDecimal getYear_t_fin_prfit_af_tax() {
	        return year_t_fin_prfit_af_tax;
	    }

	    public BigDecimal getYear_t_1_fin_loan_bal_amt() {
	        return year_t_1_fin_loan_bal_amt;
	    }

	    public BigDecimal getYear_t_1_fin_tdepst_bal_amt() {
	        return year_t_1_fin_tdepst_bal_amt;
	    }

	    public BigDecimal getYear_t_1_fin_rvne_amt() {
	        return year_t_1_fin_rvne_amt;
	    }

	    public BigDecimal getYear_t_1_fin_net_rvne_amt() {
	        return year_t_1_fin_net_rvne_amt;
	    }

	    public BigDecimal getYear_t_1_fin_prfit_bf_tax() {
	        return year_t_1_fin_prfit_bf_tax;
	    }

	    public BigDecimal getYear_t_1_fin_prfit_af_tax() {
	        return year_t_1_fin_prfit_af_tax;
	    }

	    public BigDecimal getYear_t_2_fin_loan_bal_amt() {
	        return year_t_2_fin_loan_bal_amt;
	    }

	    public BigDecimal getYear_t_2_fin_tdepst_bal_amt() {
	        return year_t_2_fin_tdepst_bal_amt;
	    }

	    public BigDecimal getYear_t_2_fin_rvne_amt() {
	        return year_t_2_fin_rvne_amt;
	    }

	    public BigDecimal getYear_t_2_fin_net_rvne_amt() {
	        return year_t_2_fin_net_rvne_amt;
	    }

	    public BigDecimal getYear_t_2_fin_prfit_bf_tax() {
	        return year_t_2_fin_prfit_bf_tax;
	    }

	    public BigDecimal getYear_t_2_fin_prfit_af_tax() {
	        return year_t_2_fin_prfit_af_tax;
	    }

	    public BigDecimal getYear_t_3_fin_loan_bal_amt() {
	        return year_t_3_fin_loan_bal_amt;
	    }

	    public BigDecimal getYear_t_3_fin_tdepst_bal_amt() {
	        return year_t_3_fin_tdepst_bal_amt;
	    }

	    public BigDecimal getYear_t_3_fin_rvne_amt() {
	        return year_t_3_fin_rvne_amt;
	    }

	    public BigDecimal getYear_t_3_fin_net_rvne_amt() {
	        return year_t_3_fin_net_rvne_amt;
	    }

	    public BigDecimal getYear_t_3_fin_prfit_bf_tax() {
	        return year_t_3_fin_prfit_bf_tax;
	    }

	    public BigDecimal getYear_t_3_fin_prfit_af_tax() {
	        return year_t_3_fin_prfit_af_tax;
	    }

	    public String getFinal_ews_alert() {
	        return final_ews_alert;
	    }

	    public String getVic_alert() {
	        return vic_alert;
	    }

	    public String getCob_dt() {
	        return cob_dt;
	    }

	    public String getAml_cust_segments() {
	        return aml_cust_segments;
	    }

	    public String getAml_risk_level() {
	        return aml_risk_level;
	    }
 }