 package c360.model;
 
 import java.math.BigDecimal;

 public class CustomerToi {
     private String cus_cif_nbr;
     private String branch;
     private BigDecimal mtd_svrc_fee_amt;
     private BigDecimal qtd_svrc_fee_amt;
     private BigDecimal ytd_svrc_fee_amt;
     private BigDecimal mtd_kdnt_incm_amt;
     private BigDecimal qtd_kdnt_incm_amt;
     private BigDecimal ytd_kdnt_incm_amt;
     private BigDecimal mtd_toi_amt;
     private BigDecimal qtd_toi_amt;
     private BigDecimal ytd_toi_amt;
     private BigDecimal ytd_tttm_noii_amt;
     private BigDecimal ytd_fund_trnsfer_noii_amt;
     private BigDecimal mtd_roa_amt;
     private BigDecimal six_m_roa_amt;
     private BigDecimal ytd_roa_amt;
     private BigDecimal mtd_tsslnl_amt;
     private BigDecimal ytd_tsslnl_amt;
     private BigDecimal mtd_tssl_amt;
     private BigDecimal ytd_tssl_amt;
     private BigDecimal ytd_loan_nim_amt;
     private BigDecimal ytd_depst_nim_amt;
     private BigDecimal qtd_loan_nii_amt;
     private BigDecimal qtd_depst_nii_amt;
     private BigDecimal mtd_loan_avg_amt;
     private String cob_dt;

     @Override
     public String toString() {
         return "CustomerToi{" +
                 "cus_cif_nbr='" + cus_cif_nbr + '\'' +
                 ", branch='" + branch + '\'' +
                 ", mtd_svrc_fee_amt=" + mtd_svrc_fee_amt +
                 ", qtd_svrc_fee_amt=" + qtd_svrc_fee_amt +
                 ", ytd_svrc_fee_amt=" + ytd_svrc_fee_amt +
                 ", mtd_kdnt_incm_amt=" + mtd_kdnt_incm_amt +
                 ", qtd_kdnt_incm_amt=" + qtd_kdnt_incm_amt +
                 ", ytd_kdnt_incm_amt=" + ytd_kdnt_incm_amt +
                 ", mtd_toi_amt=" + mtd_toi_amt +
                 ", qtd_toi_amt=" + qtd_toi_amt +
                 ", ytd_toi_amt=" + ytd_toi_amt +
                 ", ytd_tttm_noii_amt=" + ytd_tttm_noii_amt +
                 ", ytd_fund_trnsfer_noii_amt=" + ytd_fund_trnsfer_noii_amt +
                 ", mtd_roa_amt=" + mtd_roa_amt +
                 ", six_m_roa_amt=" + six_m_roa_amt +
                 ", ytd_roa_amt=" + ytd_roa_amt +
                 ", mtd_tsslnl_amt=" + mtd_tsslnl_amt +
                 ", ytd_tsslnl_amt=" + ytd_tsslnl_amt +
                 ", mtd_tssl_amt=" + mtd_tssl_amt +
                 ", ytd_tssl_amt=" + ytd_tssl_amt +
                 ", ytd_loan_nim_amt=" + ytd_loan_nim_amt +
                 ", ytd_depst_nim_amt=" + ytd_depst_nim_amt +
                 ", qtd_loan_nii_amt=" + qtd_loan_nii_amt +
                 ", qtd_depst_nii_amt=" + qtd_depst_nii_amt +
                 ", mtd_loan_avg_amt=" + mtd_loan_avg_amt + 
                 ", cob_dt='" + cob_dt + '\'' +
                 '}';
     }

     public CustomerToi(String cus_cif_nbr, String branch, BigDecimal mtd_svrc_fee_amt, BigDecimal qtd_svrc_fee_amt,
                        BigDecimal ytd_svrc_fee_amt, BigDecimal mtd_kdnt_incm_amt, BigDecimal qtd_kdnt_incm_amt,
                        BigDecimal ytd_kdnt_incm_amt, BigDecimal mtd_toi_amt, BigDecimal qtd_toi_amt, BigDecimal ytd_toi_amt,
                        BigDecimal ytd_tttm_noii_amt, BigDecimal ytd_fund_trnsfer_noii_amt, BigDecimal mtd_roa_amt,
                        BigDecimal six_m_roa_amt, BigDecimal ytd_roa_amt, BigDecimal mtd_tsslnl_amt, BigDecimal ytd_tsslnl_amt,
                        BigDecimal mtd_tssl_amt, BigDecimal ytd_tssl_amt, BigDecimal ytd_loan_nim_amt,
                        BigDecimal ytd_depst_nim_amt, BigDecimal qtd_loan_nii_amt, BigDecimal qtd_depst_nii_amt,BigDecimal mtd_loan_avg_amt, String cob_dt) {
         this.cus_cif_nbr = cus_cif_nbr;
         this.branch = branch;
         this.mtd_svrc_fee_amt = mtd_svrc_fee_amt;
         this.qtd_svrc_fee_amt = qtd_svrc_fee_amt;
         this.ytd_svrc_fee_amt = ytd_svrc_fee_amt;
         this.mtd_kdnt_incm_amt = mtd_kdnt_incm_amt;
         this.qtd_kdnt_incm_amt = qtd_kdnt_incm_amt;
         this.ytd_kdnt_incm_amt = ytd_kdnt_incm_amt;
         this.mtd_toi_amt = mtd_toi_amt;
         this.qtd_toi_amt = qtd_toi_amt;
         this.ytd_toi_amt = ytd_toi_amt;
         this.ytd_tttm_noii_amt = ytd_tttm_noii_amt;
         this.ytd_fund_trnsfer_noii_amt = ytd_fund_trnsfer_noii_amt;
         this.mtd_roa_amt = mtd_roa_amt;
         this.six_m_roa_amt = six_m_roa_amt;
         this.ytd_roa_amt = ytd_roa_amt;
         this.mtd_tsslnl_amt = mtd_tsslnl_amt;
         this.ytd_tsslnl_amt = ytd_tsslnl_amt;
         this.mtd_tssl_amt = mtd_tssl_amt;
         this.ytd_tssl_amt = ytd_tssl_amt;
         this.ytd_loan_nim_amt = ytd_loan_nim_amt;
         this.ytd_depst_nim_amt = ytd_depst_nim_amt;
         this.qtd_loan_nii_amt = qtd_loan_nii_amt;
         this.qtd_depst_nii_amt = qtd_depst_nii_amt;
         this.mtd_loan_avg_amt = mtd_loan_avg_amt;
         this.cob_dt = cob_dt;
     }

     public String getCus_cif_nbr() {
         return cus_cif_nbr;
     }

     public void setCus_cif_nbr(String cus_cif_nbr) {
         this.cus_cif_nbr = cus_cif_nbr;
     }

     public String getBranch() {
         return branch;
     }

     public void setBranch(String branch) {
         this.branch = branch;
     }

     public BigDecimal getMtd_svrc_fee_amt() {
         return mtd_svrc_fee_amt;
     }

     public void setMtd_svrc_fee_amt(BigDecimal mtd_svrc_fee_amt) {
         this.mtd_svrc_fee_amt = mtd_svrc_fee_amt;
     }

     public BigDecimal getQtd_svrc_fee_amt() {
         return qtd_svrc_fee_amt;
     }

     public void setQtd_svrc_fee_amt(BigDecimal qtd_svrc_fee_amt) {
         this.qtd_svrc_fee_amt = qtd_svrc_fee_amt;
     }

     public BigDecimal getYtd_svrc_fee_amt() {
         return ytd_svrc_fee_amt;
     }

     public void setYtd_svrc_fee_amt(BigDecimal ytd_svrc_fee_amt) {
         this.ytd_svrc_fee_amt = ytd_svrc_fee_amt;
     }

     public BigDecimal getMtd_kdnt_incm_amt() {
         return mtd_kdnt_incm_amt;
     }

     public void setMtd_kdnt_incm_amt(BigDecimal mtd_kdnt_incm_amt) {
         this.mtd_kdnt_incm_amt = mtd_kdnt_incm_amt;
     }

     public BigDecimal getQtd_kdnt_incm_amt() {
         return qtd_kdnt_incm_amt;
     }

     public void setQtd_kdnt_incm_amt(BigDecimal qtd_kdnt_incm_amt) {
         this.qtd_kdnt_incm_amt = qtd_kdnt_incm_amt;
     }

     public BigDecimal getYtd_kdnt_incm_amt() {
         return ytd_kdnt_incm_amt;
     }

     public void setYtd_kdnt_incm_amt(BigDecimal ytd_kdnt_incm_amt) {
         this.ytd_kdnt_incm_amt = ytd_kdnt_incm_amt;
     }

     public BigDecimal getMtd_toi_amt() {
         return mtd_toi_amt;
     }

     public void setMtd_toi_amt(BigDecimal mtd_toi_amt) {
         this.mtd_toi_amt = mtd_toi_amt;
     }

     public BigDecimal getQtd_toi_amt() {
         return qtd_toi_amt;
     }

     public void setQtd_toi_amt(BigDecimal qtd_toi_amt) {
         this.qtd_toi_amt = qtd_toi_amt;
     }

     public BigDecimal getYtd_toi_amt() {
         return ytd_toi_amt;
     }

     public void setYtd_toi_amt(BigDecimal ytd_toi_amt) {
         this.ytd_toi_amt = ytd_toi_amt;
     }

     public BigDecimal getYtd_tttm_noii_amt() {
         return ytd_tttm_noii_amt;
     }

     public void setYtd_tttm_noii_amt(BigDecimal ytd_tttm_noii_amt) {
         this.ytd_tttm_noii_amt = ytd_tttm_noii_amt;
     }

     public BigDecimal getYtd_fund_trnsfer_noii_amt() {
         return ytd_fund_trnsfer_noii_amt;
     }

     public void setYtd_fund_trnsfer_noii_amt(BigDecimal ytd_fund_trnsfer_noii_amt) {
         this.ytd_fund_trnsfer_noii_amt = ytd_fund_trnsfer_noii_amt;
     }

     public BigDecimal getMtd_roa_amt() {
         return mtd_roa_amt;
     }

     public void setMtd_roa_amt(BigDecimal mtd_roa_amt) {
         this.mtd_roa_amt = mtd_roa_amt;
     }

     public BigDecimal getSix_m_roa_amt() {
         return six_m_roa_amt;
     }

     public void setSix_m_roa_amt(BigDecimal six_m_roa_amt) {
         this.six_m_roa_amt = six_m_roa_amt;
     }

     public BigDecimal getYtd_roa_amt() {
         return ytd_roa_amt;
     }

     public void setYtd_roa_amt(BigDecimal ytd_roa_amt) {
         this.ytd_roa_amt = ytd_roa_amt;
     }

     public BigDecimal getMtd_tsslnl_amt() {
         return mtd_tsslnl_amt;
     }

     public void setMtd_tsslnl_amt(BigDecimal mtd_tsslnl_amt) {
         this.mtd_tsslnl_amt = mtd_tsslnl_amt;
     }

     public BigDecimal getYtd_tsslnl_amt() {
         return ytd_tsslnl_amt;
     }

     public void setYtd_tsslnl_amt(BigDecimal ytd_tsslnl_amt) {
         this.ytd_tsslnl_amt = ytd_tsslnl_amt;
     }

     public BigDecimal getMtd_tssl_amt() {
         return mtd_tssl_amt;
     }

     public void setMtd_tssl_amt(BigDecimal mtd_tssl_amt) {
         this.mtd_tssl_amt = mtd_tssl_amt;
     }

     public BigDecimal getYtd_tssl_amt() {
         return ytd_tssl_amt;
     }

     public void setYtd_tssl_amt(BigDecimal ytd_tssl_amt) {
         this.ytd_tssl_amt = ytd_tssl_amt;
     }

     public BigDecimal getYtd_loan_nim_amt() {
         return ytd_loan_nim_amt;
     }

     public void setYtd_loan_nim_amt(BigDecimal ytd_loan_nim_amt) {
         this.ytd_loan_nim_amt = ytd_loan_nim_amt;
     }

     public BigDecimal getYtd_depst_nim_amt() {
         return ytd_depst_nim_amt;
     }

     public void setYtd_depst_nim_amt(BigDecimal ytd_depst_nim_amt) {
         this.ytd_depst_nim_amt = ytd_depst_nim_amt;
     }

     public BigDecimal getQtd_loan_nii_amt() {
         return qtd_loan_nii_amt;
     }

     public void setQtd_loan_nii_amt(BigDecimal qtd_loan_nii_amt) {
         this.qtd_loan_nii_amt = qtd_loan_nii_amt;
     }

     public BigDecimal getQtd_depst_nii_amt() {
         return qtd_depst_nii_amt;
     }

     public void setQtd_depst_nii_amt(BigDecimal qtd_depst_nii_amt) {
         this.qtd_depst_nii_amt = qtd_depst_nii_amt;
     }
     	
     public BigDecimal getMtd_loan_avg_amt() {
		return mtd_loan_avg_amt;
	}

	public void setMtd_loan_avg_amt(BigDecimal mtd_loan_avg_amt) {
		this.mtd_loan_avg_amt = mtd_loan_avg_amt;
	}

	public String getCob_dt() {
         return cob_dt;
     }

     public void setCob_dt(String cob_dt) {
         this.cob_dt = cob_dt;
     }
 }