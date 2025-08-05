package model;

public class PfmFinaceHealth {
    String customerId;
    String fcf;
    String esr;
    String lsr;
    String dti;
    String efund;
    String cur;
    String cic;
    String finalGrade;
    String cobDt;

    public PfmFinaceHealth(String customerId, String fcf, String esr, String lsr, String dti, String efund, String cur, String cic, String finalGrade, String cobDt) {
        this.customerId = customerId;
        this.fcf = fcf;
        this.esr = esr;
        this.lsr = lsr;
        this.dti = dti;
        this.efund = efund;
        this.cur = cur;
        this.cic = cic;
        this.finalGrade = finalGrade;
        this.cobDt = cobDt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFcf() {
        return fcf;
    }

    public String getEsr() {
        return esr;
    }

    public String getLsr() {
        return lsr;
    }

    public String getDti() {
        return dti;
    }

    public String getEfund() {
        return efund;
    }

    public String getCur() {
        return cur;
    }

    public String getCic() {
        return cic;
    }

    public String getFinalGrade() {
        return finalGrade;
    }
    public String getCobDt() {
        return cobDt;
    }
}