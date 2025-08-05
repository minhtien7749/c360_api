package c360.model;

import java.math.BigDecimal;

public class CustomerStatistic {
    private String cif_no;
    private String branch;
    private BigDecimal dly_shrtrm_ln_avg_bal_amt;
    private BigDecimal mtd_shrtrm_ln_avg_bal_amt;
    private BigDecimal qtd_shrtrm_ln_avg_bal_amt;
    private BigDecimal ytd_shrtrm_ln_avg_bal_amt;
    private BigDecimal dly_lngtrm_ln_avg_bal_amt;
    private BigDecimal mtd_lngtrm_ln_avg_bal_amt;
    private BigDecimal qtd_lngtrm_ln_avg_bal_amt;
    private BigDecimal ytd_lngtrm_ln_avg_bal_amt;
    private BigDecimal dly_bond_ln_avg_bal_amt;
    private BigDecimal mtd_bond_ln_avg_bal_amt;
    private BigDecimal qtd_bond_ln_avg_bal_amt;
    private BigDecimal ytd_bond_ln_avg_bal_amt;
    private BigDecimal dly_loan_bal_amt;
    private BigDecimal mtd_loan_avg_bal_amt;
    private BigDecimal qtd_loan_avg_bal_amt;
    private BigDecimal ytd_loan_avg_bal_amt;
    private BigDecimal dly_depst_bal_amt;
    private BigDecimal mtd_depst_avg_bal_amt;
    private BigDecimal qtd_depst_avg_bal_amt;
    private BigDecimal ytd_depst_avg_bal_amt;
    private BigDecimal dly_tdepst_bal_amt;
    private BigDecimal mtd_tdepst_avg_bal_amt;
    private BigDecimal qtd_tdepst_avg_bal_amt;
    private BigDecimal ytd_tdepst_avg_bal_amt;
    private BigDecimal dly_casa_bal_amt;
    private BigDecimal mtd_casa_avg_bal_amt;
    private BigDecimal qtd_casa_avg_bal_amt;
    private BigDecimal ytd_casa_avg_bal_amt;
    private Double loan_clsfy;
    private BigDecimal ytd_fx_sale_amt;
    private BigDecimal ytd_fx_buy_amt;
    private BigDecimal prncpl_chrg_off_shrtrm_amt;
    private BigDecimal prncpl_chrg_off_lngtrm_amt;
    private BigDecimal intrst_chrg_off_shrtrm_amt;
    private BigDecimal intrst_chrg_off_lngtrm_amt;
    private BigDecimal ytd_prncpl_chrg_off_shrtrm_amt;
    private BigDecimal ytd_prncpl_chrg_off_lngtrm_amt;
    private BigDecimal ytd_prncpl_chrg_off_bond_amt;
    private BigDecimal ytd_prncpl_chrg_off_amt;
    private BigDecimal ytd_intrst_chrg_off_shrtrm_amt;
    private BigDecimal ytd_intrst_chrg_off_lngtrm_amt;
    private BigDecimal ytd_intrst_chrg_off_bond_amt;
    private BigDecimal ytd_intrst_chrg_off_amt;
    private String cob_dt;
    
    public CustomerStatistic(){
        super();
    };

    public CustomerStatistic(String cif_no, String branch, BigDecimal dly_shrtrm_ln_avg_bal_amt, BigDecimal mtd_shrtrm_ln_avg_bal_amt, BigDecimal qtd_shrtrm_ln_avg_bal_amt,
                             BigDecimal ytd_shrtrm_ln_avg_bal_amt, BigDecimal dly_lngtrm_ln_avg_bal_amt, BigDecimal mtd_lngtrm_ln_avg_bal_amt, BigDecimal qtd_lngtrm_ln_avg_bal_amt,
                             BigDecimal ytd_lngtrm_ln_avg_bal_amt, BigDecimal dly_bond_ln_avg_bal_amt, BigDecimal mtd_bond_ln_avg_bal_amt, BigDecimal qtd_bond_ln_avg_bal_amt,
                             BigDecimal ytd_bond_ln_avg_bal_amt, BigDecimal dly_loan_bal_amt, BigDecimal mtd_loan_avg_bal_amt, BigDecimal qtd_loan_avg_bal_amt,
                             BigDecimal ytd_loan_avg_bal_amt, BigDecimal dly_depst_bal_amt, BigDecimal mtd_depst_avg_bal_amt, BigDecimal qtd_depst_avg_bal_amt,
                             BigDecimal ytd_depst_avg_bal_amt, BigDecimal dly_tdepst_bal_amt, BigDecimal mtd_tdepst_avg_bal_amt, BigDecimal qtd_tdepst_avg_bal_amt,
                             BigDecimal ytd_tdepst_avg_bal_amt, BigDecimal dly_casa_bal_amt, BigDecimal mtd_casa_avg_bal_amt, BigDecimal qtd_casa_avg_bal_amt,
                             BigDecimal ytd_casa_avg_bal_amt, Double loan_clsfy, BigDecimal ytd_fx_sale_amt, BigDecimal ytd_fx_buy_amt,
                             BigDecimal prncpl_chrg_off_shrtrm_amt, BigDecimal prncpl_chrg_off_lngtrm_amt, BigDecimal intrst_chrg_off_shrtrm_amt,
                             BigDecimal intrst_chrg_off_lngtrm_amt, BigDecimal ytd_prncpl_chrg_off_shrtrm_amt, BigDecimal ytd_prncpl_chrg_off_lngtrm_amt,
                             BigDecimal ytd_prncpl_chrg_off_bond_amt, BigDecimal ytd_prncpl_chrg_off_amt, BigDecimal ytd_intrst_chrg_off_shrtrm_amt,
                             BigDecimal ytd_intrst_chrg_off_lngtrm_amt, BigDecimal ytd_intrst_chrg_off_bond_amt, BigDecimal ytd_intrst_chrg_off_amt, String cob_dt) {
        this.cif_no = cif_no;
        this.branch = branch;
        this.dly_shrtrm_ln_avg_bal_amt = dly_shrtrm_ln_avg_bal_amt;
        this.mtd_shrtrm_ln_avg_bal_amt = mtd_shrtrm_ln_avg_bal_amt;
        this.qtd_shrtrm_ln_avg_bal_amt = qtd_shrtrm_ln_avg_bal_amt;
        this.ytd_shrtrm_ln_avg_bal_amt = ytd_shrtrm_ln_avg_bal_amt;
        this.dly_lngtrm_ln_avg_bal_amt = dly_lngtrm_ln_avg_bal_amt;
        this.mtd_lngtrm_ln_avg_bal_amt = mtd_lngtrm_ln_avg_bal_amt;
        this.qtd_lngtrm_ln_avg_bal_amt = qtd_lngtrm_ln_avg_bal_amt;
        this.ytd_lngtrm_ln_avg_bal_amt = ytd_lngtrm_ln_avg_bal_amt;
        this.dly_bond_ln_avg_bal_amt = dly_bond_ln_avg_bal_amt;
        this.mtd_bond_ln_avg_bal_amt = mtd_bond_ln_avg_bal_amt;
        this.qtd_bond_ln_avg_bal_amt = qtd_bond_ln_avg_bal_amt;
        this.ytd_bond_ln_avg_bal_amt = ytd_bond_ln_avg_bal_amt;
        this.dly_loan_bal_amt = dly_loan_bal_amt;
        this.mtd_loan_avg_bal_amt = mtd_loan_avg_bal_amt;
        this.qtd_loan_avg_bal_amt = qtd_loan_avg_bal_amt;
        this.ytd_loan_avg_bal_amt = ytd_loan_avg_bal_amt;
        this.dly_depst_bal_amt = dly_depst_bal_amt;
        this.mtd_depst_avg_bal_amt = mtd_depst_avg_bal_amt;
        this.qtd_depst_avg_bal_amt = qtd_depst_avg_bal_amt;
        this.ytd_depst_avg_bal_amt = ytd_depst_avg_bal_amt;
        this.dly_tdepst_bal_amt = dly_tdepst_bal_amt;
        this.mtd_tdepst_avg_bal_amt = mtd_tdepst_avg_bal_amt;
        this.qtd_tdepst_avg_bal_amt = qtd_tdepst_avg_bal_amt;
        this.ytd_tdepst_avg_bal_amt = ytd_tdepst_avg_bal_amt;
        this.dly_casa_bal_amt = dly_casa_bal_amt;
        this.mtd_casa_avg_bal_amt = mtd_casa_avg_bal_amt;
        this.qtd_casa_avg_bal_amt = qtd_casa_avg_bal_amt;
        this.ytd_casa_avg_bal_amt = ytd_casa_avg_bal_amt;
        this.loan_clsfy = loan_clsfy;
        this.ytd_fx_sale_amt = ytd_fx_sale_amt;
        this.ytd_fx_buy_amt = ytd_fx_buy_amt;
        this.prncpl_chrg_off_shrtrm_amt = prncpl_chrg_off_shrtrm_amt;
        this.prncpl_chrg_off_lngtrm_amt = prncpl_chrg_off_lngtrm_amt;
        this.intrst_chrg_off_shrtrm_amt = intrst_chrg_off_shrtrm_amt;
        this.intrst_chrg_off_lngtrm_amt = intrst_chrg_off_lngtrm_amt;
        this.ytd_prncpl_chrg_off_shrtrm_amt = ytd_prncpl_chrg_off_shrtrm_amt;
        this.ytd_prncpl_chrg_off_lngtrm_amt = ytd_prncpl_chrg_off_lngtrm_amt;
        this.ytd_prncpl_chrg_off_bond_amt = ytd_prncpl_chrg_off_bond_amt;
        this.ytd_prncpl_chrg_off_amt = ytd_prncpl_chrg_off_amt;
        this.ytd_intrst_chrg_off_shrtrm_amt = ytd_intrst_chrg_off_shrtrm_amt;
        this.ytd_intrst_chrg_off_lngtrm_amt = ytd_intrst_chrg_off_lngtrm_amt;
        this.ytd_intrst_chrg_off_bond_amt = ytd_intrst_chrg_off_bond_amt;
        this.ytd_intrst_chrg_off_amt = ytd_intrst_chrg_off_amt;
        this.cob_dt = cob_dt;
    }

    @Override
    public String toString() {
        return "CustomerStatistic{" +
                "cif_no='" + cif_no + '\'' +
                ", branch='" + branch + '\'' +
                ", dly_shrtrm_ln_avg_bal_amt=" + dly_shrtrm_ln_avg_bal_amt +
                ", mtd_shrtrm_ln_avg_bal_amt=" + mtd_shrtrm_ln_avg_bal_amt +
                ", qtd_shrtrm_ln_avg_bal_amt=" + qtd_shrtrm_ln_avg_bal_amt +
                ", ytd_shrtrm_ln_avg_bal_amt=" + ytd_shrtrm_ln_avg_bal_amt +
                ", dly_lngtrm_ln_avg_bal_amt=" + dly_lngtrm_ln_avg_bal_amt +
                ", mtd_lngtrm_ln_avg_bal_amt=" + mtd_lngtrm_ln_avg_bal_amt +
                ", qtd_lngtrm_ln_avg_bal_amt=" + qtd_lngtrm_ln_avg_bal_amt +
                ", ytd_lngtrm_ln_avg_bal_amt=" + ytd_lngtrm_ln_avg_bal_amt +
                ", dly_bond_ln_avg_bal_amt=" + dly_bond_ln_avg_bal_amt +
                ", mtd_bond_ln_avg_bal_amt=" + mtd_bond_ln_avg_bal_amt +
                ", qtd_bond_ln_avg_bal_amt=" + qtd_bond_ln_avg_bal_amt +
                ", ytd_bond_ln_avg_bal_amt=" + ytd_bond_ln_avg_bal_amt +
                ", dly_loan_bal_amt=" + dly_loan_bal_amt +
                ", mtd_loan_avg_bal_amt=" + mtd_loan_avg_bal_amt +
                ", qtd_loan_avg_bal_amt=" + qtd_loan_avg_bal_amt +
                ", ytd_loan_avg_bal_amt=" + ytd_loan_avg_bal_amt +
                ", dly_depst_bal_amt=" + dly_depst_bal_amt +
                ", mtd_depst_avg_bal_amt=" + mtd_depst_avg_bal_amt +
                ", qtd_depst_avg_bal_amt=" + qtd_depst_avg_bal_amt +
                ", ytd_depst_avg_bal_amt=" + ytd_depst_avg_bal_amt +
                ", dly_tdepst_bal_amt=" + dly_tdepst_bal_amt +
                ", mtd_tdepst_avg_bal_amt=" + mtd_tdepst_avg_bal_amt +
                ", qtd_tdepst_avg_bal_amt=" + qtd_tdepst_avg_bal_amt +
                ", ytd_tdepst_avg_bal_amt=" + ytd_tdepst_avg_bal_amt +
                ", dly_casa_bal_amt=" + dly_casa_bal_amt +
                ", mtd_casa_avg_bal_amt=" + mtd_casa_avg_bal_amt +
                ", qtd_casa_avg_bal_amt=" + qtd_casa_avg_bal_amt +
                ", ytd_casa_avg_bal_amt=" + ytd_casa_avg_bal_amt +
                ", loan_clsfy=" + loan_clsfy +
                ", ytd_fx_sale_amt=" + ytd_fx_sale_amt +
                ", ytd_fx_buy_amt=" + ytd_fx_buy_amt +
                ", prncpl_chrg_off_shrtrm_amt=" + prncpl_chrg_off_shrtrm_amt +
                ", prncpl_chrg_off_lngtrm_amt=" + prncpl_chrg_off_lngtrm_amt +
                ", intrst_chrg_off_shrtrm_amt=" + intrst_chrg_off_shrtrm_amt +
                ", intrst_chrg_off_lngtrm_amt=" + intrst_chrg_off_lngtrm_amt +
                ", ytd_prncpl_chrg_off_shrtrm_amt=" + ytd_prncpl_chrg_off_shrtrm_amt +
                ", ytd_prncpl_chrg_off_lngtrm_amt=" + ytd_prncpl_chrg_off_lngtrm_amt +
                ", ytd_prncpl_chrg_off_bond_amt=" + ytd_prncpl_chrg_off_bond_amt +
                ", ytd_prncpl_chrg_off_amt=" + ytd_prncpl_chrg_off_amt +
                ", ytd_intrst_chrg_off_shrtrm_amt=" + ytd_intrst_chrg_off_shrtrm_amt +
                ", ytd_intrst_chrg_off_lngtrm_amt=" + ytd_intrst_chrg_off_lngtrm_amt +
                ", ytd_intrst_chrg_off_bond_amt=" + ytd_intrst_chrg_off_bond_amt +
                ", ytd_intrst_chrg_off_amt=" + ytd_intrst_chrg_off_amt +
                ", cob_dt='" + cob_dt + '\'' +
                '}';
    }
    
    public String getCif_no() {
        return cif_no;
    }

    public void setCif_no(String cif_no) {
        this.cif_no = cif_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getDly_shrtrm_ln_avg_bal_amt() {
        return dly_shrtrm_ln_avg_bal_amt;
    }

    public void setDly_shrtrm_ln_avg_bal_amt(BigDecimal dly_shrtrm_ln_avg_bal_amt) {
        this.dly_shrtrm_ln_avg_bal_amt = dly_shrtrm_ln_avg_bal_amt;
    }

    public BigDecimal getMtd_shrtrm_ln_avg_bal_amt() {
        return mtd_shrtrm_ln_avg_bal_amt;
    }

    public void setMtd_shrtrm_ln_avg_bal_amt(BigDecimal mtd_shrtrm_ln_avg_bal_amt) {
        this.mtd_shrtrm_ln_avg_bal_amt = mtd_shrtrm_ln_avg_bal_amt;
    }

    public BigDecimal getQtd_shrtrm_ln_avg_bal_amt() {
        return qtd_shrtrm_ln_avg_bal_amt;
    }

    public void setQtd_shrtrm_ln_avg_bal_amt(BigDecimal qtd_shrtrm_ln_avg_bal_amt) {
        this.qtd_shrtrm_ln_avg_bal_amt = qtd_shrtrm_ln_avg_bal_amt;
    }

    public BigDecimal getYtd_shrtrm_ln_avg_bal_amt() {
        return ytd_shrtrm_ln_avg_bal_amt;
    }

    public void setYtd_shrtrm_ln_avg_bal_amt(BigDecimal ytd_shrtrm_ln_avg_bal_amt) {
        this.ytd_shrtrm_ln_avg_bal_amt = ytd_shrtrm_ln_avg_bal_amt;
    }

    public BigDecimal getDly_lngtrm_ln_avg_bal_amt() {
        return dly_lngtrm_ln_avg_bal_amt;
    }

    public void setDly_lngtrm_ln_avg_bal_amt(BigDecimal dly_lngtrm_ln_avg_bal_amt) {
        this.dly_lngtrm_ln_avg_bal_amt = dly_lngtrm_ln_avg_bal_amt;
    }

    public BigDecimal getMtd_lngtrm_ln_avg_bal_amt() {
        return mtd_lngtrm_ln_avg_bal_amt;
    }

    public void setMtd_lngtrm_ln_avg_bal_amt(BigDecimal mtd_lngtrm_ln_avg_bal_amt) {
        this.mtd_lngtrm_ln_avg_bal_amt = mtd_lngtrm_ln_avg_bal_amt;
    }

    public BigDecimal getQtd_lngtrm_ln_avg_bal_amt() {
        return qtd_lngtrm_ln_avg_bal_amt;
    }

    public void setQtd_lngtrm_ln_avg_bal_amt(BigDecimal qtd_lngtrm_ln_avg_bal_amt) {
        this.qtd_lngtrm_ln_avg_bal_amt = qtd_lngtrm_ln_avg_bal_amt;
    }

    public BigDecimal getYtd_lngtrm_ln_avg_bal_amt() {
        return ytd_lngtrm_ln_avg_bal_amt;
    }

    public void setYtd_lngtrm_ln_avg_bal_amt(BigDecimal ytd_lngtrm_ln_avg_bal_amt) {
        this.ytd_lngtrm_ln_avg_bal_amt = ytd_lngtrm_ln_avg_bal_amt;
    }

    public BigDecimal getDly_bond_ln_avg_bal_amt() {
        return dly_bond_ln_avg_bal_amt;
    }

    public void setDly_bond_ln_avg_bal_amt(BigDecimal dly_bond_ln_avg_bal_amt) {
        this.dly_bond_ln_avg_bal_amt = dly_bond_ln_avg_bal_amt;
    }

    public BigDecimal getMtd_bond_ln_avg_bal_amt() {
        return mtd_bond_ln_avg_bal_amt;
    }

    public void setMtd_bond_ln_avg_bal_amt(BigDecimal mtd_bond_ln_avg_bal_amt) {
        this.mtd_bond_ln_avg_bal_amt = mtd_bond_ln_avg_bal_amt;
    }

    public BigDecimal getQtd_bond_ln_avg_bal_amt() {
        return qtd_bond_ln_avg_bal_amt;
    }

    public void setQtd_bond_ln_avg_bal_amt(BigDecimal qtd_bond_ln_avg_bal_amt) {
        this.qtd_bond_ln_avg_bal_amt = qtd_bond_ln_avg_bal_amt;
    }

    public BigDecimal getYtd_bond_ln_avg_bal_amt() {
        return ytd_bond_ln_avg_bal_amt;
    }

    public void setYtd_bond_ln_avg_bal_amt(BigDecimal ytd_bond_ln_avg_bal_amt) {
        this.ytd_bond_ln_avg_bal_amt = ytd_bond_ln_avg_bal_amt;
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

    public BigDecimal getDly_depst_bal_amt() {
        return dly_depst_bal_amt;
    }

    public void setDly_depst_bal_amt(BigDecimal dly_depst_bal_amt) {
        this.dly_depst_bal_amt = dly_depst_bal_amt;
    }

    public BigDecimal getMtd_depst_avg_bal_amt() {
        return mtd_depst_avg_bal_amt;
    }

    public void setMtd_depst_avg_bal_amt(BigDecimal mtd_depst_avg_bal_amt) {
        this.mtd_depst_avg_bal_amt = mtd_depst_avg_bal_amt;
    }

    public BigDecimal getQtd_depst_avg_bal_amt() {
        return qtd_depst_avg_bal_amt;
    }

    public void setQtd_depst_avg_bal_amt(BigDecimal qtd_depst_avg_bal_amt) {
        this.qtd_depst_avg_bal_amt = qtd_depst_avg_bal_amt;
    }

    public BigDecimal getYtd_depst_avg_bal_amt() {
        return ytd_depst_avg_bal_amt;
    }

    public void setYtd_depst_avg_bal_amt(BigDecimal ytd_depst_avg_bal_amt) {
        this.ytd_depst_avg_bal_amt = ytd_depst_avg_bal_amt;
    }

    public BigDecimal getDly_tdepst_bal_amt() {
        return dly_tdepst_bal_amt;
    }

    public void setDly_tdepst_bal_amt(BigDecimal dly_tdepst_bal_amt) {
        this.dly_tdepst_bal_amt = dly_tdepst_bal_amt;
    }

    public BigDecimal getMtd_tdepst_avg_bal_amt() {
        return mtd_tdepst_avg_bal_amt;
    }

    public void setMtd_tdepst_avg_bal_amt(BigDecimal mtd_tdepst_avg_bal_amt) {
        this.mtd_tdepst_avg_bal_amt = mtd_tdepst_avg_bal_amt;
    }

    public BigDecimal getQtd_tdepst_avg_bal_amt() {
        return qtd_tdepst_avg_bal_amt;
    }

    public void setQtd_tdepst_avg_bal_amt(BigDecimal qtd_tdepst_avg_bal_amt) {
        this.qtd_tdepst_avg_bal_amt = qtd_tdepst_avg_bal_amt;
    }

    public BigDecimal getYtd_tdepst_avg_bal_amt() {
        return ytd_tdepst_avg_bal_amt;
    }

    public void setYtd_tdepst_avg_bal_amt(BigDecimal ytd_tdepst_avg_bal_amt) {
        this.ytd_tdepst_avg_bal_amt = ytd_tdepst_avg_bal_amt;
    }

    public BigDecimal getDly_casa_bal_amt() {
        return dly_casa_bal_amt;
    }

    public void setDly_casa_bal_amt(BigDecimal dly_casa_bal_amt) {
        this.dly_casa_bal_amt = dly_casa_bal_amt;
    }

    public BigDecimal getMtd_casa_avg_bal_amt() {
        return mtd_casa_avg_bal_amt;
    }

    public void setMtd_casa_avg_bal_amt(BigDecimal mtd_casa_avg_bal_amt) {
        this.mtd_casa_avg_bal_amt = mtd_casa_avg_bal_amt;
    }

    public BigDecimal getQtd_casa_avg_bal_amt() {
        return qtd_casa_avg_bal_amt;
    }

    public void setQtd_casa_avg_bal_amt(BigDecimal qtd_casa_avg_bal_amt) {
        this.qtd_casa_avg_bal_amt = qtd_casa_avg_bal_amt;
    }

    public BigDecimal getYtd_casa_avg_bal_amt() {
        return ytd_casa_avg_bal_amt;
    }

    public void setYtd_casa_avg_bal_amt(BigDecimal ytd_casa_avg_bal_amt) {
        this.ytd_casa_avg_bal_amt = ytd_casa_avg_bal_amt;
    }

    public Double getLoan_clsfy() {
        return loan_clsfy;
    }

    public void setLoan_clsfy(Double loan_clsfy) {
        this.loan_clsfy = loan_clsfy;
    }

    public BigDecimal getYtd_fx_sale_amt() {
        return ytd_fx_sale_amt;
    }

    public void setYtd_fx_sale_amt(BigDecimal ytd_fx_sale_amt) {
        this.ytd_fx_sale_amt = ytd_fx_sale_amt;
    }

    public BigDecimal getYtd_fx_buy_amt() {
        return ytd_fx_buy_amt;
    }

    public void setYtd_fx_buy_amt(BigDecimal ytd_fx_buy_amt) {
        this.ytd_fx_buy_amt = ytd_fx_buy_amt;
    }

    public BigDecimal getPrncpl_chrg_off_shrtrm_amt() {
        return prncpl_chrg_off_shrtrm_amt;
    }

    public void setPrncpl_chrg_off_shrtrm_amt(BigDecimal prncpl_chrg_off_shrtrm_amt) {
        this.prncpl_chrg_off_shrtrm_amt = prncpl_chrg_off_shrtrm_amt;
    }

    public BigDecimal getPrncpl_chrg_off_lngtrm_amt() {
        return prncpl_chrg_off_lngtrm_amt;
    }

    public void setPrncpl_chrg_off_lngtrm_amt(BigDecimal prncpl_chrg_off_lngtrm_amt) {
        this.prncpl_chrg_off_lngtrm_amt = prncpl_chrg_off_lngtrm_amt;
    }

    public BigDecimal getIntrst_chrg_off_shrtrm_amt() {
        return intrst_chrg_off_shrtrm_amt;
    }

    public void setIntrst_chrg_off_shrtrm_amt(BigDecimal intrst_chrg_off_shrtrm_amt) {
        this.intrst_chrg_off_shrtrm_amt = intrst_chrg_off_shrtrm_amt;
    }

    public BigDecimal getIntrst_chrg_off_lngtrm_amt() {
        return intrst_chrg_off_lngtrm_amt;
    }

    public void setIntrst_chrg_off_lngtrm_amt(BigDecimal intrst_chrg_off_lngtrm_amt) {
        this.intrst_chrg_off_lngtrm_amt = intrst_chrg_off_lngtrm_amt;
    }

    public BigDecimal getYtd_prncpl_chrg_off_shrtrm_amt() {
        return ytd_prncpl_chrg_off_shrtrm_amt;
    }

    public void setYtd_prncpl_chrg_off_shrtrm_amt(BigDecimal ytd_prncpl_chrg_off_shrtrm_amt) {
        this.ytd_prncpl_chrg_off_shrtrm_amt = ytd_prncpl_chrg_off_shrtrm_amt;
    }

    public BigDecimal getYtd_prncpl_chrg_off_lngtrm_amt() {
        return ytd_prncpl_chrg_off_lngtrm_amt;
    }

    public void setYtd_prncpl_chrg_off_lngtrm_amt(BigDecimal ytd_prncpl_chrg_off_lngtrm_amt) {
        this.ytd_prncpl_chrg_off_lngtrm_amt = ytd_prncpl_chrg_off_lngtrm_amt;
    }

    public BigDecimal getYtd_prncpl_chrg_off_bond_amt() {
        return ytd_prncpl_chrg_off_bond_amt;
    }

    public void setYtd_prncpl_chrg_off_bond_amt(BigDecimal ytd_prncpl_chrg_off_bond_amt) {
        this.ytd_prncpl_chrg_off_bond_amt = ytd_prncpl_chrg_off_bond_amt;
    }

    public BigDecimal getYtd_prncpl_chrg_off_amt() {
        return ytd_prncpl_chrg_off_amt;
    }

    public void setYtd_prncpl_chrg_off_amt(BigDecimal ytd_prncpl_chrg_off_amt) {
        this.ytd_prncpl_chrg_off_amt = ytd_prncpl_chrg_off_amt;
    }

    public BigDecimal getYtd_intrst_chrg_off_shrtrm_amt() {
        return ytd_intrst_chrg_off_shrtrm_amt;
    }

    public void setYtd_intrst_chrg_off_shrtrm_amt(BigDecimal ytd_intrst_chrg_off_shrtrm_amt) {
        this.ytd_intrst_chrg_off_shrtrm_amt = ytd_intrst_chrg_off_shrtrm_amt;
    }

    public BigDecimal getYtd_intrst_chrg_off_lngtrm_amt() {
        return ytd_intrst_chrg_off_lngtrm_amt;
    }

    public void setYtd_intrst_chrg_off_lngtrm_amt(BigDecimal ytd_intrst_chrg_off_lngtrm_amt) {
        this.ytd_intrst_chrg_off_lngtrm_amt = ytd_intrst_chrg_off_lngtrm_amt;
    }

    public BigDecimal getYtd_intrst_chrg_off_bond_amt() {
        return ytd_intrst_chrg_off_bond_amt;
    }

    public void setYtd_intrst_chrg_off_bond_amt(BigDecimal ytd_intrst_chrg_off_bond_amt) {
        this.ytd_intrst_chrg_off_bond_amt = ytd_intrst_chrg_off_bond_amt;
    }

    public BigDecimal getYtd_intrst_chrg_off_amt() {
        return ytd_intrst_chrg_off_amt;
    }

    public void setYtd_intrst_chrg_off_amt(BigDecimal ytd_intrst_chrg_off_amt) {
        this.ytd_intrst_chrg_off_amt = ytd_intrst_chrg_off_amt;
    }

    public String getCob_dt() {
        return cob_dt;
    }

    public void setCob_dt(String cob_dt) {
        this.cob_dt = cob_dt;
    }
	
}
