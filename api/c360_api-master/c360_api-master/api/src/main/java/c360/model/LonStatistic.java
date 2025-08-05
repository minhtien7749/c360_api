package c360.model;

import java.math.BigDecimal;

public class LonStatistic {
	private String cus_cif_nbr;
	private String branch;
	private BigDecimal dly_st_ln_bal_amt;
	private BigDecimal mtd_st_ln_avg_bal_amt;
	private BigDecimal qtd_st_ln_avg_bal_amt;
	private BigDecimal ytd_st_ln_avg_bal_amt;
	private BigDecimal dly_mt_ln_bal_amt;
	private BigDecimal mtd_mt_ln_avg_bal_amt;
	private BigDecimal qtd_mt_ln_avg_bal_amt;
	private BigDecimal ytd_mt_ln_avg_bal_amt;
	private BigDecimal dly_lt_ln_bal_amt;
	private BigDecimal mtd_lt_ln_avg_bal_amt;
	private BigDecimal qtd_lt_ln_avg_bal_amt;
	private BigDecimal ytd_lt_ln_avg_bal_amt;
	private BigDecimal dly_traiphieu_avg_bal_amt;
	private BigDecimal mtd_traiphieu_avg_bal_amt;
	private BigDecimal qtd_traiphieu_avg_bal_amt;
	private BigDecimal ytd_traiphieu_avg_bal_amt;
	private BigDecimal dly_loan_bal_amt;
	private BigDecimal mtd_loan_avg_bal_amt;
	private BigDecimal qtd_loan_avg_bal_amt;
	private BigDecimal ytd_loan_avg_bal_amt;
	private BigDecimal ytd_prncpl_chrg_off_shrtrm_amt;
	private BigDecimal ytd_prncpl_chrg_off_mttrm_amt;
	private BigDecimal ytd_prncpl_chrg_off_lngtrm_amt;
	private BigDecimal ytd_intrst_chrg_off_shrtrm_amt;
	private BigDecimal ytd_intrst_chrg_off_mttrm_amt;
	private BigDecimal ytd_intrst_chrg_off_lngtrm_amt;
	private BigDecimal ytd_ltchrg_chrg_off_shrtrm_amt;
	private BigDecimal ytd_ltchrg_chrg_off_mttrm_amt;
	private BigDecimal ytd_ltchrg_chrg_off_lngtrm_amt;
	private BigDecimal ytd_prncpl_chrg_off_bond_amt;
	private BigDecimal ytd_intrst_chrg_off_bond_amt;
	private BigDecimal ytd_ltchrg_chrg_off_bond_amt;
	private BigDecimal dly_nii_st_ln_amt_in_lc;
	private BigDecimal mtd_nii_st_ln_amt_in_lc;
	private BigDecimal qtd_nii_st_ln_amt_in_lc;
	private BigDecimal ytd_nii_st_ln_amt_in_lc;
	private BigDecimal dly_nii_mt_ln_amt_in_lc;
	private BigDecimal mtd_nii_mt_ln_amt_in_lc;
	private BigDecimal qtd_nii_mt_ln_amt_in_lc;
	private BigDecimal ytd_nii_mt_ln_amt_in_lc;
	private BigDecimal dly_nii_lt_ln_amt_in_lc;
	private BigDecimal mtd_nii_lt_ln_amt_in_lc;
	private BigDecimal qtd_nii_lt_ln_amt_in_lc;
	private BigDecimal ytd_nii_lt_ln_amt_in_lc;
	private BigDecimal dly_nii_traiphieu_amt;
	private BigDecimal mtd_nii_traiphieu_amt;
	private BigDecimal qtd_nii_traiphieu_amt;
	private BigDecimal ytd_nii_traiphieu_amt;
	private BigDecimal ytd_overdue_cnt;
	private String cob_dt;
	
	
	
	
	@Override
	public String toString() {
		return "LonStatistic [cus_cif_nbr=" + cus_cif_nbr + ", branch=" + branch + ", dly_st_ln_bal_amt="
				+ dly_st_ln_bal_amt + ", mtd_st_ln_avg_bal_amt=" + mtd_st_ln_avg_bal_amt + ", qtd_st_ln_avg_bal_amt="
				+ qtd_st_ln_avg_bal_amt + ", ytd_st_ln_avg_bal_amt=" + ytd_st_ln_avg_bal_amt + ", dly_mt_ln_bal_amt="
				+ dly_mt_ln_bal_amt + ", mtd_mt_ln_avg_bal_amt=" + mtd_mt_ln_avg_bal_amt + ", qtd_mt_ln_avg_bal_amt="
				+ qtd_mt_ln_avg_bal_amt + ", ytd_mt_ln_avg_bal_amt=" + ytd_mt_ln_avg_bal_amt + ", dly_lt_ln_bal_amt="
				+ dly_lt_ln_bal_amt + ", mtd_lt_ln_avg_bal_amt=" + mtd_lt_ln_avg_bal_amt + ", qtd_lt_ln_avg_bal_amt="
				+ qtd_lt_ln_avg_bal_amt + ", ytd_lt_ln_avg_bal_amt=" + ytd_lt_ln_avg_bal_amt
				+ ", dly_traiphieu_avg_bal_amt=" + dly_traiphieu_avg_bal_amt + ", mtd_traiphieu_avg_bal_amt="
				+ mtd_traiphieu_avg_bal_amt + ", qtd_traiphieu_avg_bal_amt=" + qtd_traiphieu_avg_bal_amt
				+ ", ytd_traiphieu_avg_bal_amt=" + ytd_traiphieu_avg_bal_amt + ", dly_loan_bal_amt=" + dly_loan_bal_amt
				+ ", mtd_loan_avg_bal_amt=" + mtd_loan_avg_bal_amt + ", qtd_loan_avg_bal_amt=" + qtd_loan_avg_bal_amt
				+ ", ytd_loan_avg_bal_amt=" + ytd_loan_avg_bal_amt + ", ytd_prncpl_chrg_off_shrtrm_amt="
				+ ytd_prncpl_chrg_off_shrtrm_amt + ", ytd_prncpl_chrg_off_mttrm_amt=" + ytd_prncpl_chrg_off_mttrm_amt
				+ ", ytd_prncpl_chrg_off_lngtrm_amt=" + ytd_prncpl_chrg_off_lngtrm_amt
				+ ", ytd_intrst_chrg_off_shrtrm_amt=" + ytd_intrst_chrg_off_shrtrm_amt
				+ ", ytd_intrst_chrg_off_mttrm_amt=" + ytd_intrst_chrg_off_mttrm_amt
				+ ", ytd_intrst_chrg_off_lngtrm_amt=" + ytd_intrst_chrg_off_lngtrm_amt
				+ ", ytd_ltchrg_chrg_off_shrtrm_amt=" + ytd_ltchrg_chrg_off_shrtrm_amt
				+ ", ytd_ltchrg_chrg_off_mttrm_amt=" + ytd_ltchrg_chrg_off_mttrm_amt
				+ ", ytd_ltchrg_chrg_off_lngtrm_amt=" + ytd_ltchrg_chrg_off_lngtrm_amt
				+ ", ytd_prncpl_chrg_off_bond_amt=" + ytd_prncpl_chrg_off_bond_amt + ", ytd_intrst_chrg_off_bond_amt="
				+ ytd_intrst_chrg_off_bond_amt + ", ytd_ltchrg_chrg_off_bond_amt=" + ytd_ltchrg_chrg_off_bond_amt
				+ ", dly_nii_st_ln_amt_in_lc=" + dly_nii_st_ln_amt_in_lc + ", mtd_nii_st_ln_amt_in_lc="
				+ mtd_nii_st_ln_amt_in_lc + ", qtd_nii_st_ln_amt_in_lc=" + qtd_nii_st_ln_amt_in_lc
				+ ", ytd_nii_st_ln_amt_in_lc=" + ytd_nii_st_ln_amt_in_lc + ", dly_nii_mt_ln_amt_in_lc="
				+ dly_nii_mt_ln_amt_in_lc + ", mtd_nii_mt_ln_amt_in_lc=" + mtd_nii_mt_ln_amt_in_lc
				+ ", qtd_nii_mt_ln_amt_in_lc=" + qtd_nii_mt_ln_amt_in_lc + ", ytd_nii_mt_ln_amt_in_lc="
				+ ytd_nii_mt_ln_amt_in_lc + ", dly_nii_lt_ln_amt_in_lc=" + dly_nii_lt_ln_amt_in_lc
				+ ", mtd_nii_lt_ln_amt_in_lc=" + mtd_nii_lt_ln_amt_in_lc + ", qtd_nii_lt_ln_amt_in_lc="
				+ qtd_nii_lt_ln_amt_in_lc + ", ytd_nii_lt_ln_amt_in_lc=" + ytd_nii_lt_ln_amt_in_lc
				+ ", dly_nii_traiphieu_amt=" + dly_nii_traiphieu_amt + ", mtd_nii_traiphieu_amt="
				+ mtd_nii_traiphieu_amt + ", qtd_nii_traiphieu_amt=" + qtd_nii_traiphieu_amt
				+ ", ytd_nii_traiphieu_amt=" + ytd_nii_traiphieu_amt + ", ytd_overdue_cnt=" + ytd_overdue_cnt
				+ ", cob_dt=" + cob_dt + "]";
	}
	
	public LonStatistic(String cus_cif_nbr, String branch, BigDecimal dly_st_ln_bal_amt, BigDecimal mtd_st_ln_avg_bal_amt,
			BigDecimal qtd_st_ln_avg_bal_amt, BigDecimal ytd_st_ln_avg_bal_amt, BigDecimal dly_mt_ln_bal_amt,
			BigDecimal mtd_mt_ln_avg_bal_amt, BigDecimal qtd_mt_ln_avg_bal_amt, BigDecimal ytd_mt_ln_avg_bal_amt,
			BigDecimal dly_lt_ln_bal_amt, BigDecimal mtd_lt_ln_avg_bal_amt, BigDecimal qtd_lt_ln_avg_bal_amt,
			BigDecimal ytd_lt_ln_avg_bal_amt, BigDecimal dly_traiphieu_avg_bal_amt, BigDecimal mtd_traiphieu_avg_bal_amt,
			BigDecimal qtd_traiphieu_avg_bal_amt, BigDecimal ytd_traiphieu_avg_bal_amt, BigDecimal dly_loan_bal_amt,
			BigDecimal mtd_loan_avg_bal_amt, BigDecimal qtd_loan_avg_bal_amt, BigDecimal ytd_loan_avg_bal_amt,
			BigDecimal ytd_prncpl_chrg_off_shrtrm_amt, BigDecimal ytd_prncpl_chrg_off_mttrm_amt,
			BigDecimal ytd_prncpl_chrg_off_lngtrm_amt, BigDecimal ytd_intrst_chrg_off_shrtrm_amt,
			BigDecimal ytd_intrst_chrg_off_mttrm_amt, BigDecimal ytd_intrst_chrg_off_lngtrm_amt,
			BigDecimal ytd_ltchrg_chrg_off_shrtrm_amt, BigDecimal ytd_ltchrg_chrg_off_mttrm_amt,
			BigDecimal ytd_ltchrg_chrg_off_lngtrm_amt, BigDecimal ytd_prncpl_chrg_off_bond_amt,
			BigDecimal ytd_intrst_chrg_off_bond_amt, BigDecimal ytd_ltchrg_chrg_off_bond_amt,
			BigDecimal dly_nii_st_ln_amt_in_lc, BigDecimal mtd_nii_st_ln_amt_in_lc, BigDecimal qtd_nii_st_ln_amt_in_lc,
			BigDecimal ytd_nii_st_ln_amt_in_lc, BigDecimal dly_nii_mt_ln_amt_in_lc, BigDecimal mtd_nii_mt_ln_amt_in_lc,
			BigDecimal qtd_nii_mt_ln_amt_in_lc, BigDecimal ytd_nii_mt_ln_amt_in_lc, BigDecimal dly_nii_lt_ln_amt_in_lc,
			BigDecimal mtd_nii_lt_ln_amt_in_lc, BigDecimal qtd_nii_lt_ln_amt_in_lc, BigDecimal ytd_nii_lt_ln_amt_in_lc,
			BigDecimal dly_nii_traiphieu_amt, BigDecimal mtd_nii_traiphieu_amt, BigDecimal qtd_nii_traiphieu_amt,
			BigDecimal ytd_nii_traiphieu_amt, BigDecimal ytd_overdue_cnt, String cob_dt) {
		super();
		this.cus_cif_nbr = cus_cif_nbr;
		this.branch = branch;
		this.dly_st_ln_bal_amt = dly_st_ln_bal_amt;
		this.mtd_st_ln_avg_bal_amt = mtd_st_ln_avg_bal_amt;
		this.qtd_st_ln_avg_bal_amt = qtd_st_ln_avg_bal_amt;
		this.ytd_st_ln_avg_bal_amt = ytd_st_ln_avg_bal_amt;
		this.dly_mt_ln_bal_amt = dly_mt_ln_bal_amt;
		this.mtd_mt_ln_avg_bal_amt = mtd_mt_ln_avg_bal_amt;
		this.qtd_mt_ln_avg_bal_amt = qtd_mt_ln_avg_bal_amt;
		this.ytd_mt_ln_avg_bal_amt = ytd_mt_ln_avg_bal_amt;
		this.dly_lt_ln_bal_amt = dly_lt_ln_bal_amt;
		this.mtd_lt_ln_avg_bal_amt = mtd_lt_ln_avg_bal_amt;
		this.qtd_lt_ln_avg_bal_amt = qtd_lt_ln_avg_bal_amt;
		this.ytd_lt_ln_avg_bal_amt = ytd_lt_ln_avg_bal_amt;
		this.dly_traiphieu_avg_bal_amt = dly_traiphieu_avg_bal_amt;
		this.mtd_traiphieu_avg_bal_amt = mtd_traiphieu_avg_bal_amt;
		this.qtd_traiphieu_avg_bal_amt = qtd_traiphieu_avg_bal_amt;
		this.ytd_traiphieu_avg_bal_amt = ytd_traiphieu_avg_bal_amt;
		this.dly_loan_bal_amt = dly_loan_bal_amt;
		this.mtd_loan_avg_bal_amt = mtd_loan_avg_bal_amt;
		this.qtd_loan_avg_bal_amt = qtd_loan_avg_bal_amt;
		this.ytd_loan_avg_bal_amt = ytd_loan_avg_bal_amt;
		this.ytd_prncpl_chrg_off_shrtrm_amt = ytd_prncpl_chrg_off_shrtrm_amt;
		this.ytd_prncpl_chrg_off_mttrm_amt = ytd_prncpl_chrg_off_mttrm_amt;
		this.ytd_prncpl_chrg_off_lngtrm_amt = ytd_prncpl_chrg_off_lngtrm_amt;
		this.ytd_intrst_chrg_off_shrtrm_amt = ytd_intrst_chrg_off_shrtrm_amt;
		this.ytd_intrst_chrg_off_mttrm_amt = ytd_intrst_chrg_off_mttrm_amt;
		this.ytd_intrst_chrg_off_lngtrm_amt = ytd_intrst_chrg_off_lngtrm_amt;
		this.ytd_ltchrg_chrg_off_shrtrm_amt = ytd_ltchrg_chrg_off_shrtrm_amt;
		this.ytd_ltchrg_chrg_off_mttrm_amt = ytd_ltchrg_chrg_off_mttrm_amt;
		this.ytd_ltchrg_chrg_off_lngtrm_amt = ytd_ltchrg_chrg_off_lngtrm_amt;
		this.ytd_prncpl_chrg_off_bond_amt = ytd_prncpl_chrg_off_bond_amt;
		this.ytd_intrst_chrg_off_bond_amt = ytd_intrst_chrg_off_bond_amt;
		this.ytd_ltchrg_chrg_off_bond_amt = ytd_ltchrg_chrg_off_bond_amt;
		this.dly_nii_st_ln_amt_in_lc = dly_nii_st_ln_amt_in_lc;
		this.mtd_nii_st_ln_amt_in_lc = mtd_nii_st_ln_amt_in_lc;
		this.qtd_nii_st_ln_amt_in_lc = qtd_nii_st_ln_amt_in_lc;
		this.ytd_nii_st_ln_amt_in_lc = ytd_nii_st_ln_amt_in_lc;
		this.dly_nii_mt_ln_amt_in_lc = dly_nii_mt_ln_amt_in_lc;
		this.mtd_nii_mt_ln_amt_in_lc = mtd_nii_mt_ln_amt_in_lc;
		this.qtd_nii_mt_ln_amt_in_lc = qtd_nii_mt_ln_amt_in_lc;
		this.ytd_nii_mt_ln_amt_in_lc = ytd_nii_mt_ln_amt_in_lc;
		this.dly_nii_lt_ln_amt_in_lc = dly_nii_lt_ln_amt_in_lc;
		this.mtd_nii_lt_ln_amt_in_lc = mtd_nii_lt_ln_amt_in_lc;
		this.qtd_nii_lt_ln_amt_in_lc = qtd_nii_lt_ln_amt_in_lc;
		this.ytd_nii_lt_ln_amt_in_lc = ytd_nii_lt_ln_amt_in_lc;
		this.dly_nii_traiphieu_amt = dly_nii_traiphieu_amt;
		this.mtd_nii_traiphieu_amt = mtd_nii_traiphieu_amt;
		this.qtd_nii_traiphieu_amt = qtd_nii_traiphieu_amt;
		this.ytd_nii_traiphieu_amt = ytd_nii_traiphieu_amt;
		this.ytd_overdue_cnt = ytd_overdue_cnt;
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
	public BigDecimal getDly_st_ln_bal_amt() {
		return dly_st_ln_bal_amt;
	}
	public void setDly_st_ln_bal_amt(BigDecimal dly_st_ln_bal_amt) {
		this.dly_st_ln_bal_amt = dly_st_ln_bal_amt;
	}
	public BigDecimal getMtd_st_ln_avg_bal_amt() {
		return mtd_st_ln_avg_bal_amt;
	}
	public void setMtd_st_ln_avg_bal_amt(BigDecimal mtd_st_ln_avg_bal_amt) {
		this.mtd_st_ln_avg_bal_amt = mtd_st_ln_avg_bal_amt;
	}
	public BigDecimal getQtd_st_ln_avg_bal_amt() {
		return qtd_st_ln_avg_bal_amt;
	}
	public void setQtd_st_ln_avg_bal_amt(BigDecimal qtd_st_ln_avg_bal_amt) {
		this.qtd_st_ln_avg_bal_amt = qtd_st_ln_avg_bal_amt;
	}
	public BigDecimal getYtd_st_ln_avg_bal_amt() {
		return ytd_st_ln_avg_bal_amt;
	}
	public void setYtd_st_ln_avg_bal_amt(BigDecimal ytd_st_ln_avg_bal_amt) {
		this.ytd_st_ln_avg_bal_amt = ytd_st_ln_avg_bal_amt;
	}
	public BigDecimal getDly_mt_ln_bal_amt() {
		return dly_mt_ln_bal_amt;
	}
	public void setDly_mt_ln_bal_amt(BigDecimal dly_mt_ln_bal_amt) {
		this.dly_mt_ln_bal_amt = dly_mt_ln_bal_amt;
	}
	public BigDecimal getMtd_mt_ln_avg_bal_amt() {
		return mtd_mt_ln_avg_bal_amt;
	}
	public void setMtd_mt_ln_avg_bal_amt(BigDecimal mtd_mt_ln_avg_bal_amt) {
		this.mtd_mt_ln_avg_bal_amt = mtd_mt_ln_avg_bal_amt;
	}
	public BigDecimal getQtd_mt_ln_avg_bal_amt() {
		return qtd_mt_ln_avg_bal_amt;
	}
	public void setQtd_mt_ln_avg_bal_amt(BigDecimal qtd_mt_ln_avg_bal_amt) {
		this.qtd_mt_ln_avg_bal_amt = qtd_mt_ln_avg_bal_amt;
	}
	public BigDecimal getYtd_mt_ln_avg_bal_amt() {
		return ytd_mt_ln_avg_bal_amt;
	}
	public void setYtd_mt_ln_avg_bal_amt(BigDecimal ytd_mt_ln_avg_bal_amt) {
		this.ytd_mt_ln_avg_bal_amt = ytd_mt_ln_avg_bal_amt;
	}
	public BigDecimal getDly_lt_ln_bal_amt() {
		return dly_lt_ln_bal_amt;
	}
	public void setDly_lt_ln_bal_amt(BigDecimal dly_lt_ln_bal_amt) {
		this.dly_lt_ln_bal_amt = dly_lt_ln_bal_amt;
	}
	public BigDecimal getMtd_lt_ln_avg_bal_amt() {
		return mtd_lt_ln_avg_bal_amt;
	}
	public void setMtd_lt_ln_avg_bal_amt(BigDecimal mtd_lt_ln_avg_bal_amt) {
		this.mtd_lt_ln_avg_bal_amt = mtd_lt_ln_avg_bal_amt;
	}
	public BigDecimal getQtd_lt_ln_avg_bal_amt() {
		return qtd_lt_ln_avg_bal_amt;
	}
	public void setQtd_lt_ln_avg_bal_amt(BigDecimal qtd_lt_ln_avg_bal_amt) {
		this.qtd_lt_ln_avg_bal_amt = qtd_lt_ln_avg_bal_amt;
	}
	public BigDecimal getYtd_lt_ln_avg_bal_amt() {
		return ytd_lt_ln_avg_bal_amt;
	}
	public void setYtd_lt_ln_avg_bal_amt(BigDecimal ytd_lt_ln_avg_bal_amt) {
		this.ytd_lt_ln_avg_bal_amt = ytd_lt_ln_avg_bal_amt;
	}
	public BigDecimal getDly_traiphieu_avg_bal_amt() {
		return dly_traiphieu_avg_bal_amt;
	}
	public void setDly_traiphieu_avg_bal_amt(BigDecimal dly_traiphieu_avg_bal_amt) {
		this.dly_traiphieu_avg_bal_amt = dly_traiphieu_avg_bal_amt;
	}
	public BigDecimal getMtd_traiphieu_avg_bal_amt() {
		return mtd_traiphieu_avg_bal_amt;
	}
	public void setMtd_traiphieu_avg_bal_amt(BigDecimal mtd_traiphieu_avg_bal_amt) {
		this.mtd_traiphieu_avg_bal_amt = mtd_traiphieu_avg_bal_amt;
	}
	public BigDecimal getQtd_traiphieu_avg_bal_amt() {
		return qtd_traiphieu_avg_bal_amt;
	}
	public void setQtd_traiphieu_avg_bal_amt(BigDecimal qtd_traiphieu_avg_bal_amt) {
		this.qtd_traiphieu_avg_bal_amt = qtd_traiphieu_avg_bal_amt;
	}
	public BigDecimal getYtd_traiphieu_avg_bal_amt() {
		return ytd_traiphieu_avg_bal_amt;
	}
	public void setYtd_traiphieu_avg_bal_amt(BigDecimal ytd_traiphieu_avg_bal_amt) {
		this.ytd_traiphieu_avg_bal_amt = ytd_traiphieu_avg_bal_amt;
	}
	public BigDecimal getDly_loan_bal_amt() {
		return dly_loan_bal_amt;
	}
	public void setDly_loan_bal_amt(BigDecimal dly_loan_bal_amt) {
		this.dly_loan_bal_amt = dly_loan_bal_amt;
	}
	public BigDecimal getMtd_loan_avg_bal_amt() {
		return mtd_loan_avg_bal_amt;
	}
	public void setMtd_loan_avg_bal_amt(BigDecimal mtd_loan_avg_bal_amt) {
		this.mtd_loan_avg_bal_amt = mtd_loan_avg_bal_amt;
	}
	public BigDecimal getQtd_loan_avg_bal_amt() {
		return qtd_loan_avg_bal_amt;
	}
	public void setQtd_loan_avg_bal_amt(BigDecimal qtd_loan_avg_bal_amt) {
		this.qtd_loan_avg_bal_amt = qtd_loan_avg_bal_amt;
	}
	public BigDecimal getYtd_loan_avg_bal_amt() {
		return ytd_loan_avg_bal_amt;
	}
	public void setYtd_loan_avg_bal_amt(BigDecimal ytd_loan_avg_bal_amt) {
		this.ytd_loan_avg_bal_amt = ytd_loan_avg_bal_amt;
	}
	public BigDecimal getYtd_prncpl_chrg_off_shrtrm_amt() {
		return ytd_prncpl_chrg_off_shrtrm_amt;
	}
	public void setYtd_prncpl_chrg_off_shrtrm_amt(BigDecimal ytd_prncpl_chrg_off_shrtrm_amt) {
		this.ytd_prncpl_chrg_off_shrtrm_amt = ytd_prncpl_chrg_off_shrtrm_amt;
	}
	public BigDecimal getYtd_prncpl_chrg_off_mttrm_amt() {
		return ytd_prncpl_chrg_off_mttrm_amt;
	}
	public void setYtd_prncpl_chrg_off_mttrm_amt(BigDecimal ytd_prncpl_chrg_off_mttrm_amt) {
		this.ytd_prncpl_chrg_off_mttrm_amt = ytd_prncpl_chrg_off_mttrm_amt;
	}
	public BigDecimal getYtd_prncpl_chrg_off_lngtrm_amt() {
		return ytd_prncpl_chrg_off_lngtrm_amt;
	}
	public void setYtd_prncpl_chrg_off_lngtrm_amt(BigDecimal ytd_prncpl_chrg_off_lngtrm_amt) {
		this.ytd_prncpl_chrg_off_lngtrm_amt = ytd_prncpl_chrg_off_lngtrm_amt;
	}
	public BigDecimal getYtd_intrst_chrg_off_shrtrm_amt() {
		return ytd_intrst_chrg_off_shrtrm_amt;
	}
	public void setYtd_intrst_chrg_off_shrtrm_amt(BigDecimal ytd_intrst_chrg_off_shrtrm_amt) {
		this.ytd_intrst_chrg_off_shrtrm_amt = ytd_intrst_chrg_off_shrtrm_amt;
	}
	public BigDecimal getYtd_intrst_chrg_off_mttrm_amt() {
		return ytd_intrst_chrg_off_mttrm_amt;
	}
	public void setYtd_intrst_chrg_off_mttrm_amt(BigDecimal ytd_intrst_chrg_off_mttrm_amt) {
		this.ytd_intrst_chrg_off_mttrm_amt = ytd_intrst_chrg_off_mttrm_amt;
	}
	public BigDecimal getYtd_intrst_chrg_off_lngtrm_amt() {
		return ytd_intrst_chrg_off_lngtrm_amt;
	}
	public void setYtd_intrst_chrg_off_lngtrm_amt(BigDecimal ytd_intrst_chrg_off_lngtrm_amt) {
		this.ytd_intrst_chrg_off_lngtrm_amt = ytd_intrst_chrg_off_lngtrm_amt;
	}
	public BigDecimal getYtd_ltchrg_chrg_off_shrtrm_amt() {
		return ytd_ltchrg_chrg_off_shrtrm_amt;
	}
	public void setYtd_ltchrg_chrg_off_shrtrm_amt(BigDecimal ytd_ltchrg_chrg_off_shrtrm_amt) {
		this.ytd_ltchrg_chrg_off_shrtrm_amt = ytd_ltchrg_chrg_off_shrtrm_amt;
	}
	public BigDecimal getYtd_ltchrg_chrg_off_mttrm_amt() {
		return ytd_ltchrg_chrg_off_mttrm_amt;
	}
	public void setYtd_ltchrg_chrg_off_mttrm_amt(BigDecimal ytd_ltchrg_chrg_off_mttrm_amt) {
		this.ytd_ltchrg_chrg_off_mttrm_amt = ytd_ltchrg_chrg_off_mttrm_amt;
	}
	public BigDecimal getYtd_ltchrg_chrg_off_lngtrm_amt() {
		return ytd_ltchrg_chrg_off_lngtrm_amt;
	}
	public void setYtd_ltchrg_chrg_off_lngtrm_amt(BigDecimal ytd_ltchrg_chrg_off_lngtrm_amt) {
		this.ytd_ltchrg_chrg_off_lngtrm_amt = ytd_ltchrg_chrg_off_lngtrm_amt;
	}
	public BigDecimal getYtd_prncpl_chrg_off_bond_amt() {
		return ytd_prncpl_chrg_off_bond_amt;
	}
	public void setYtd_prncpl_chrg_off_bond_amt(BigDecimal ytd_prncpl_chrg_off_bond_amt) {
		this.ytd_prncpl_chrg_off_bond_amt = ytd_prncpl_chrg_off_bond_amt;
	}
	public BigDecimal getYtd_intrst_chrg_off_bond_amt() {
		return ytd_intrst_chrg_off_bond_amt;
	}
	public void setYtd_intrst_chrg_off_bond_amt(BigDecimal ytd_intrst_chrg_off_bond_amt) {
		this.ytd_intrst_chrg_off_bond_amt = ytd_intrst_chrg_off_bond_amt;
	}
	public BigDecimal getYtd_ltchrg_chrg_off_bond_amt() {
		return ytd_ltchrg_chrg_off_bond_amt;
	}
	public void setYtd_ltchrg_chrg_off_bond_amt(BigDecimal ytd_ltchrg_chrg_off_bond_amt) {
		this.ytd_ltchrg_chrg_off_bond_amt = ytd_ltchrg_chrg_off_bond_amt;
	}
	public BigDecimal getDly_nii_st_ln_amt_in_lc() {
		return dly_nii_st_ln_amt_in_lc;
	}
	public void setDly_nii_st_ln_amt_in_lc(BigDecimal dly_nii_st_ln_amt_in_lc) {
		this.dly_nii_st_ln_amt_in_lc = dly_nii_st_ln_amt_in_lc;
	}
	public BigDecimal getMtd_nii_st_ln_amt_in_lc() {
		return mtd_nii_st_ln_amt_in_lc;
	}
	public void setMtd_nii_st_ln_amt_in_lc(BigDecimal mtd_nii_st_ln_amt_in_lc) {
		this.mtd_nii_st_ln_amt_in_lc = mtd_nii_st_ln_amt_in_lc;
	}
	public BigDecimal getQtd_nii_st_ln_amt_in_lc() {
		return qtd_nii_st_ln_amt_in_lc;
	}
	public void setQtd_nii_st_ln_amt_in_lc(BigDecimal qtd_nii_st_ln_amt_in_lc) {
		this.qtd_nii_st_ln_amt_in_lc = qtd_nii_st_ln_amt_in_lc;
	}
	public BigDecimal getYtd_nii_st_ln_amt_in_lc() {
		return ytd_nii_st_ln_amt_in_lc;
	}
	public void setYtd_nii_st_ln_amt_in_lc(BigDecimal ytd_nii_st_ln_amt_in_lc) {
		this.ytd_nii_st_ln_amt_in_lc = ytd_nii_st_ln_amt_in_lc;
	}
	public BigDecimal getDly_nii_mt_ln_amt_in_lc() {
		return dly_nii_mt_ln_amt_in_lc;
	}
	public void setDly_nii_mt_ln_amt_in_lc(BigDecimal dly_nii_mt_ln_amt_in_lc) {
		this.dly_nii_mt_ln_amt_in_lc = dly_nii_mt_ln_amt_in_lc;
	}
	public BigDecimal getMtd_nii_mt_ln_amt_in_lc() {
		return mtd_nii_mt_ln_amt_in_lc;
	}
	public void setMtd_nii_mt_ln_amt_in_lc(BigDecimal mtd_nii_mt_ln_amt_in_lc) {
		this.mtd_nii_mt_ln_amt_in_lc = mtd_nii_mt_ln_amt_in_lc;
	}
	public BigDecimal getQtd_nii_mt_ln_amt_in_lc() {
		return qtd_nii_mt_ln_amt_in_lc;
	}
	public void setQtd_nii_mt_ln_amt_in_lc(BigDecimal qtd_nii_mt_ln_amt_in_lc) {
		this.qtd_nii_mt_ln_amt_in_lc = qtd_nii_mt_ln_amt_in_lc;
	}
	public BigDecimal getYtd_nii_mt_ln_amt_in_lc() {
		return ytd_nii_mt_ln_amt_in_lc;
	}
	public void setYtd_nii_mt_ln_amt_in_lc(BigDecimal ytd_nii_mt_ln_amt_in_lc) {
		this.ytd_nii_mt_ln_amt_in_lc = ytd_nii_mt_ln_amt_in_lc;
	}
	public BigDecimal getDly_nii_lt_ln_amt_in_lc() {
		return dly_nii_lt_ln_amt_in_lc;
	}
	public void setDly_nii_lt_ln_amt_in_lc(BigDecimal dly_nii_lt_ln_amt_in_lc) {
		this.dly_nii_lt_ln_amt_in_lc = dly_nii_lt_ln_amt_in_lc;
	}
	public BigDecimal getMtd_nii_lt_ln_amt_in_lc() {
		return mtd_nii_lt_ln_amt_in_lc;
	}
	public void setMtd_nii_lt_ln_amt_in_lc(BigDecimal mtd_nii_lt_ln_amt_in_lc) {
		this.mtd_nii_lt_ln_amt_in_lc = mtd_nii_lt_ln_amt_in_lc;
	}
	public BigDecimal getQtd_nii_lt_ln_amt_in_lc() {
		return qtd_nii_lt_ln_amt_in_lc;
	}
	public void setQtd_nii_lt_ln_amt_in_lc(BigDecimal qtd_nii_lt_ln_amt_in_lc) {
		this.qtd_nii_lt_ln_amt_in_lc = qtd_nii_lt_ln_amt_in_lc;
	}
	public BigDecimal getYtd_nii_lt_ln_amt_in_lc() {
		return ytd_nii_lt_ln_amt_in_lc;
	}
	public void setYtd_nii_lt_ln_amt_in_lc(BigDecimal ytd_nii_lt_ln_amt_in_lc) {
		this.ytd_nii_lt_ln_amt_in_lc = ytd_nii_lt_ln_amt_in_lc;
	}
	public BigDecimal getDly_nii_traiphieu_amt() {
		return dly_nii_traiphieu_amt;
	}
	public void setDly_nii_traiphieu_amt(BigDecimal dly_nii_traiphieu_amt) {
		this.dly_nii_traiphieu_amt = dly_nii_traiphieu_amt;
	}
	public BigDecimal getMtd_nii_traiphieu_amt() {
		return mtd_nii_traiphieu_amt;
	}
	public void setMtd_nii_traiphieu_amt(BigDecimal mtd_nii_traiphieu_amt) {
		this.mtd_nii_traiphieu_amt = mtd_nii_traiphieu_amt;
	}
	public BigDecimal getQtd_nii_traiphieu_amt() {
		return qtd_nii_traiphieu_amt;
	}
	public void setQtd_nii_traiphieu_amt(BigDecimal qtd_nii_traiphieu_amt) {
		this.qtd_nii_traiphieu_amt = qtd_nii_traiphieu_amt;
	}
	public BigDecimal getYtd_nii_traiphieu_amt() {
		return ytd_nii_traiphieu_amt;
	}
	public void setYtd_nii_traiphieu_amt(BigDecimal ytd_nii_traiphieu_amt) {
		this.ytd_nii_traiphieu_amt = ytd_nii_traiphieu_amt;
	}
	public BigDecimal getYtd_overdue_cnt() {
		return ytd_overdue_cnt;
	}
	public void setYtd_overdue_cnt(BigDecimal ytd_overdue_cnt) {
		this.ytd_overdue_cnt = ytd_overdue_cnt;
	}
	public String getCob_dt() {
		return cob_dt;
	}
	public void setCob_dt(String cob_dt) {
		this.cob_dt = cob_dt;
	}
	
	
	
	

}
