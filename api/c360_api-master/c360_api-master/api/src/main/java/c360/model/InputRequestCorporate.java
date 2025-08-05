package c360.model;

public class InputRequestCorporate {
    private String transactionId;
    private String appId;
    private String timeRequest;
    private String cif;
    private String fromDate;
    private String cob_dt;
    private String branch;
    private String period;
    private String taxId;

    public InputRequestCorporate(String transactionId, String appId, String timeRequest, String cif, String fromDate, String cob_dt, String branch, String period) {
        this.transactionId = transactionId;
        this.appId = appId;
        this.timeRequest = timeRequest;
        this.cif = cif;
        this.fromDate = fromDate;
        this.cob_dt = cob_dt;
        this.branch = branch;
        this.period = period;
    }
    
    public InputRequestCorporate(String transactionId, String appId, String timeRequest, String cif, String fromDate, String cob_dt, String branch, String period, String taxId) {
        this.transactionId = transactionId;
        this.appId = appId;
        this.timeRequest = timeRequest;
        this.cif = cif;
        this.fromDate = fromDate;
        this.cob_dt = cob_dt;
        this.branch = branch;
        this.period = period;
        this.taxId = taxId;
    }
    
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getCob_dt() {
        return cob_dt;
    }

    public void setCob_dt(String cob_dt) {
        this.cob_dt = cob_dt;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}