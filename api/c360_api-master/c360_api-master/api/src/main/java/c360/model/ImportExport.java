package c360.model;

import java.math.BigDecimal;

public class ImportExport {
    private String tax_id;
    private String branch;
    private String acn;
    private String corp_name;
    private String address;
    private String phone;
    private BigDecimal mtd_import_amt_usd;
    private BigDecimal mtd_export_amt_usd;
    private BigDecimal ytd_total_import_amt_usd;
    private BigDecimal ytd_total_exp_amt_usd;
    private String cob_dt;

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public String getCorp_name() {
        return corp_name;
    }

    public void setCorp_name(String corp_name) {
        this.corp_name = corp_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMtd_import_amt_usd() {
        return mtd_import_amt_usd;
    }

    public void setMtd_import_amt_usd(BigDecimal mtd_import_amt_usd) {
        this.mtd_import_amt_usd = mtd_import_amt_usd;
    }

    public BigDecimal getMtd_export_amt_usd() {
        return mtd_export_amt_usd;
    }

    public void setMtd_export_amt_usd(BigDecimal mtd_export_amt_usd) {
        this.mtd_export_amt_usd = mtd_export_amt_usd;
    }

    public BigDecimal getYtd_total_import_amt_usd() {
        return ytd_total_import_amt_usd;
    }

    public void setYtd_total_import_amt_usd(BigDecimal ytd_total_import_amt_usd) {
        this.ytd_total_import_amt_usd = ytd_total_import_amt_usd;
    }

    public BigDecimal getYtd_total_exp_amt_usd() {
        return ytd_total_exp_amt_usd;
    }

    public void setYtd_total_exp_amt_usd(BigDecimal ytd_total_exp_amt_usd) {
        this.ytd_total_exp_amt_usd = ytd_total_exp_amt_usd;
    }

    public String getCob_dt() {
        return cob_dt;
    }

    public void setCob_dt(String cob_dt) {
        this.cob_dt = cob_dt;
    }

    @Override
    public String toString() {
        return "ImportExport{" +
                "tax_id='" + tax_id + '\'' +
                ", branch='" + branch + '\'' +
                ", acn='" + acn + '\'' +
                ", corp_name='" + corp_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", mtd_import_amt_usd=" + mtd_import_amt_usd +
                ", mtd_export_amt_usd=" + mtd_export_amt_usd +
                ", ytd_total_import_amt_usd=" + ytd_total_import_amt_usd +
                ", ytd_total_exp_amt_usd=" + ytd_total_exp_amt_usd +
                ", cob_dt='" + cob_dt + '\'' +
                '}';
    }

    public ImportExport(String tax_id, String branch, String acn, String corp_name, String address, String phone, BigDecimal mtd_import_amt_usd,
                        BigDecimal mtd_export_amt_usd, BigDecimal ytd_total_import_amt_usd, BigDecimal ytd_total_exp_amt_usd, String cob_dt) {
        this.tax_id = tax_id;
        this.branch = branch;
        this.acn = acn;
        this.corp_name = corp_name;
        this.address = address;
        this.phone = phone;
        this.mtd_import_amt_usd = mtd_import_amt_usd;
        this.mtd_export_amt_usd = mtd_export_amt_usd;
        this.ytd_total_import_amt_usd = ytd_total_import_amt_usd;
        this.ytd_total_exp_amt_usd = ytd_total_exp_amt_usd;
        this.cob_dt = cob_dt;
    }
}