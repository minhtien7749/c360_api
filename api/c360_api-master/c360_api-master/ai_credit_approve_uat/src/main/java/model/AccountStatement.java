package model;

public class AccountStatement {
    String customerId;
    String customerName;
    String cid;
    String tSeq;
    String dateTime;
    String amountLc;
    String endBalLc;
    String tCmt;
    String ofsCid;
    String ofsName;
    String ofsBrn;
    String offBank;
    String zPrfRefNo;
    String standardizedOfsName;
    String trxTypeLv1;
    String trxTypeLv2;
    String crCd;
    String cobDt;

    public AccountStatement(String customerId, String customerName, String cid, String tSeq, String dateTime, String amountLc, String endBalLc, String tCmt, String ofsCid, String ofsName, String ofsBrn, String offBank, String zPrfRefNo, String standardizedOfsName, String trxTypeLv1, String trxTypeLv2, String crCd, String cobDt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cid = cid;
        this.tSeq = tSeq;
        this.dateTime = dateTime;
        this.amountLc = amountLc;
        this.endBalLc = endBalLc;
        this.tCmt = tCmt;
        this.ofsCid = ofsCid;
        this.ofsName = ofsName;
        this.ofsBrn = ofsBrn;
        this.offBank = offBank;
        this.zPrfRefNo = zPrfRefNo;
        this.standardizedOfsName = standardizedOfsName;
        this.trxTypeLv1 = trxTypeLv1;
        this.trxTypeLv2 = trxTypeLv2;
        this.crCd = crCd;
        this.cobDt = cobDt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCid() {
        return cid;
    }

    public String gettSeq() {
        return tSeq;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getAmountLc() {
        return amountLc;
    }

    public String getEndBalLc() {
        return endBalLc;
    }

    public String gettCmt() {
        return tCmt;
    }

    public String getOfsCid() {
        return ofsCid;
    }

    public String getOfsName() {
        return ofsName;
    }

    public String getOfsBrn() {
        return ofsBrn;
    }

    public String getOffBank() {
        return offBank;
    }

    public String getzPrfRefNo() {
        return zPrfRefNo;
    }

    public String getStandardizedOfsName() {
        return standardizedOfsName;
    }

    public String getTrxTypeLv1() {
        return trxTypeLv1;
    }

    public String getTrxTypeLv2() {
        return trxTypeLv2;
    }

    public String getCrCd() {
        return crCd;
    }

    public String getCobDt() {
        return cobDt;
    }
}