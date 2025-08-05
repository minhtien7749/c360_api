package c360.model;

import java.math.BigDecimal;

public class CustomerLosLmt {
    private String pri_brnch_cd;
    private String pri_brnch_nm;
    private String area_cd;
    private String area_dsc;
    private String cus_cif_nbr;
    private BigDecimal total_lmt;
    private BigDecimal cus_lmt_to_core;
    private BigDecimal ex_crdt_lmt;
    private BigDecimal loan_lmt;
    private BigDecimal disbur_lmt;
    private BigDecimal mid_long_lmt;
    private BigDecimal guarant_lmt;
    private BigDecimal lc_lmt;

    @Override
    public String toString() {
        return "CustomerLosLmt{" +
                "pri_brnch_cd='" + pri_brnch_cd + '\'' +
                ", pri_brnch_nm='" + pri_brnch_nm + '\'' +
                ", area_cd='" + area_cd + '\'' +
                ", area_dsc='" + area_dsc + '\'' +
                ", cus_cif_nbr='" + cus_cif_nbr + '\'' +
                ", total_lmt=" + total_lmt +
                ", cus_lmt_to_core=" + cus_lmt_to_core +
                ", ex_crdt_lmt=" + ex_crdt_lmt +
                ", loan_lmt=" + loan_lmt +
                ", disbur_lmt=" + disbur_lmt +
                ", mid_long_lmt=" + mid_long_lmt +
                ", guarant_lmt=" + guarant_lmt +
                ", lc_lmt=" + lc_lmt +
                ", factoring_lmt=" + factoring_lmt +
                ", disct_lmt=" + disct_lmt +
                ", crdt_crd_lmt=" + crdt_crd_lmt +
                ", treasury_lmt=" + treasury_lmt +
                ", crcd='" + crcd + '\'' +
                ", exp_dt='" + exp_dt + '\'' +
                ", cob_dt='" + cob_dt + '\'' +
                '}';
    }

    private BigDecimal factoring_lmt;
    private BigDecimal disct_lmt;
    private BigDecimal crdt_crd_lmt;
    private BigDecimal treasury_lmt;
    private String crcd;
    private String exp_dt;
    private String cob_dt;

    public CustomerLosLmt(String pri_brnch_cd, String pri_brnch_nm, String area_cd, String area_dsc, String cus_cif_nbr,
                          BigDecimal total_lmt, BigDecimal cus_lmt_to_core, BigDecimal ex_crdt_lmt, BigDecimal loan_lmt,
                          BigDecimal disbur_lmt, BigDecimal mid_long_lmt, BigDecimal guarant_lmt, BigDecimal lc_lmt,
                          BigDecimal factoring_lmt, BigDecimal disct_lmt, BigDecimal crdt_crd_lmt, BigDecimal treasury_lmt,
                          String crcd, String exp_dt, String cob_dt) {
        this.pri_brnch_cd = pri_brnch_cd;
        this.pri_brnch_nm = pri_brnch_nm;
        this.area_cd = area_cd;
        this.area_dsc = area_dsc;
        this.cus_cif_nbr = cus_cif_nbr;
        this.total_lmt = total_lmt;
        this.cus_lmt_to_core = cus_lmt_to_core;
        this.ex_crdt_lmt = ex_crdt_lmt;
        this.loan_lmt = loan_lmt;
        this.disbur_lmt = disbur_lmt;
        this.mid_long_lmt = mid_long_lmt;
        this.guarant_lmt = guarant_lmt;
        this.lc_lmt = lc_lmt;
        this.factoring_lmt = factoring_lmt;
        this.disct_lmt = disct_lmt;
        this.crdt_crd_lmt = crdt_crd_lmt;
        this.treasury_lmt = treasury_lmt;
        this.crcd = crcd;
        this.exp_dt = exp_dt;
        this.cob_dt = cob_dt;
    }

    public String getPri_brnch_cd() {
        return pri_brnch_cd;
    }

    public void setPri_brnch_cd(String pri_brnch_cd) {
        this.pri_brnch_cd = pri_brnch_cd;
    }

    public String getPri_brnch_nm() {
        return pri_brnch_nm;
    }

    public void setPri_brnch_nm(String pri_brnch_nm) {
        this.pri_brnch_nm = pri_brnch_nm;
    }

    public String getArea_cd() {
        return area_cd;
    }

    public void setArea_cd(String area_cd) {
        this.area_cd = area_cd;
    }

    public String getArea_dsc() {
        return area_dsc;
    }

    public void setArea_dsc(String area_dsc) {
        this.area_dsc = area_dsc;
    }

    public String getCus_cif_nbr() {
        return cus_cif_nbr;
    }

    public void setCus_cif_nbr(String cus_cif_nbr) {
        this.cus_cif_nbr = cus_cif_nbr;
    }

    public BigDecimal getTotal_lmt() {
        return total_lmt;
    }

    public void setTotal_lmt(BigDecimal total_lmt) {
        this.total_lmt = total_lmt;
    }

    public BigDecimal getCus_lmt_to_core() {
        return cus_lmt_to_core;
    }

    public void setCus_lmt_to_core(BigDecimal cus_lmt_to_core) {
        this.cus_lmt_to_core = cus_lmt_to_core;
    }

    public BigDecimal getEx_crdt_lmt() {
        return ex_crdt_lmt;
    }

    public void setEx_crdt_lmt(BigDecimal ex_crdt_lmt) {
        this.ex_crdt_lmt = ex_crdt_lmt;
    }

    public BigDecimal getLoan_lmt() {
        return loan_lmt;
    }

    public void setLoan_lmt(BigDecimal loan_lmt) {
        this.loan_lmt = loan_lmt;
    }

    public BigDecimal getDisbur_lmt() {
        return disbur_lmt;
    }

    public void setDisbur_lmt(BigDecimal disbur_lmt) {
        this.disbur_lmt = disbur_lmt;
    }

    public BigDecimal getMid_long_lmt() {
        return mid_long_lmt;
    }

    public void setMid_long_lmt(BigDecimal mid_long_lmt) {
        this.mid_long_lmt = mid_long_lmt;
    }

    public BigDecimal getGuarant_lmt() {
        return guarant_lmt;
    }

    public void setGuarant_lmt(BigDecimal guarant_lmt) {
        this.guarant_lmt = guarant_lmt;
    }

    public BigDecimal getLc_lmt() {
        return lc_lmt;
    }

    public void setLc_lmt(BigDecimal lc_lmt) {
        this.lc_lmt = lc_lmt;
    }

    public BigDecimal getFactoring_lmt() {
        return factoring_lmt;
    }

    public void setFactoring_lmt(BigDecimal factoring_lmt) {
        this.factoring_lmt = factoring_lmt;
    }

    public BigDecimal getDisct_lmt() {
        return disct_lmt;
    }

    public void setDisct_lmt(BigDecimal disct_lmt) {
        this.disct_lmt = disct_lmt;
    }

    public BigDecimal getCrdt_crd_lmt() {
        return crdt_crd_lmt;
    }

    public void setCrdt_crd_lmt(BigDecimal crdt_crd_lmt) {
        this.crdt_crd_lmt = crdt_crd_lmt;
    }

    public BigDecimal getTreasury_lmt() {
        return treasury_lmt;
    }

    public void setTreasury_lmt(BigDecimal treasury_lmt) {
        this.treasury_lmt = treasury_lmt;
    }

    public String getCrcd() {
        return crcd;
    }

    public void setCrcd(String crcd) {
        this.crcd = crcd;
    }

    public String getExp_dt() {
        return exp_dt;
    }

    public void setExp_dt(String exp_dt) {
        this.exp_dt = exp_dt;
    }

    public String getCob_dt() {
        return cob_dt;
    }

    public void setCob_dt(String cob_dt) {
        this.cob_dt = cob_dt;
    }
}