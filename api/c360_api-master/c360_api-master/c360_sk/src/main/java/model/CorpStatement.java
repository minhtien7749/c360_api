package model;

public class CorpStatement {
    private String cif;
    private String account;
    private String transactionDate;
    private String transactionContent;
    private String debit;
    private String credit;
    private String accountBal;
    private String transactionNumber;
    private String mTid;
    private String virtualAccount;
    private String corresponsiveBankName;
    private String corresponsiveBankId;
    private String corresponsiveAccount;
    private String corresponsiveAccountName;
    private String servicebranchId;
    private String serviceBankName;
    private String channel;
    private String agency;
    private String trxTypeDatalake;
    private String uid;
    private String eftType;
    private String zGrp;
    private String etc;
    private String prfLnGrp;
    private String eftpayZfeeacct;
    private String zChanRefNo;
    private String zPrfRefNo;
    private String zSpr;
    private String ict1;
	private String ztrid;
    private String trc;
    private String feeamt;
    private String taxamt;
    private String taxrate;
    private String zrefnum;
    private String invno;
    private String banktransid;
    private String cobDt;
    private String currency;
    private String netamount;

    public CorpStatement(String cif, String account, String transactionDate, String transactionContent, String debit,
			String credit, String accountBal, String transactionNumber, String mTid, String virtualAccount,
			String corresponsiveBankName, String corresponsiveBankId, String corresponsiveAccount,
			String corresponsiveAccountName, String servicebranchId, String serviceBankName, String channel,
			String agency, String trxTypeDatalake, String uid, String eftType, String zGrp, String etc, String prfLnGrp,
			String eftpayZfeeacct, String zChanRefNo, String zPrfRefNo, String zSpr, String ict1, String ztrid,
			String trc, String feeamt, String taxamt, String taxrate,String zrefnum ,String invno,String banktransid,String cobDt, String currency,String netamount) {
		this.cif = cif;
		this.account = account;
		this.transactionDate = transactionDate;
		this.transactionContent = transactionContent;
		this.debit = debit;
		this.credit = credit;
		this.accountBal = accountBal;
		this.transactionNumber = transactionNumber;
		this.mTid = mTid;
		this.virtualAccount = virtualAccount;
		this.corresponsiveBankName = corresponsiveBankName;
		this.corresponsiveBankId = corresponsiveBankId;
		this.corresponsiveAccount = corresponsiveAccount;
		this.corresponsiveAccountName = corresponsiveAccountName;
		this.servicebranchId = servicebranchId;
		this.serviceBankName = serviceBankName;
		this.channel = channel;
		this.agency = agency;
		this.trxTypeDatalake = trxTypeDatalake;
		this.uid = uid;
		this.eftType = eftType;
		this.zGrp = zGrp;
		this.etc = etc;
		this.prfLnGrp = prfLnGrp;
		this.eftpayZfeeacct = eftpayZfeeacct;
		this.zChanRefNo = zChanRefNo;
		this.zPrfRefNo = zPrfRefNo;
		this.zSpr = zSpr;
		this.ict1 = ict1;
		this.ztrid = ztrid;
		this.trc = trc;
		this.feeamt = feeamt;
		this.taxamt = taxamt;
		this.taxrate = taxrate;
		this.zrefnum= zrefnum;
		this.invno = invno;
		this.banktransid = banktransid;
		this.cobDt = cobDt;
		this.currency = currency;
		this.netamount = netamount;
	}

    public String getCif() {
        return cif;
    }

    public String getAccount() {
        return account;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public String getDebit() {
        return debit;
    }

    public String getCredit() {
        return credit;
    }

    public String getAccountBal() {
        return accountBal;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public String getmTid() {
        return mTid;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public String getCorresponsiveBankName() {
        return corresponsiveBankName;
    }

    public String getCorresponsiveBankId() {
        return corresponsiveBankId;
    }

    public String getCorresponsiveAccount() {
        return corresponsiveAccount;
    }

    public String getCorresponsiveAccountName() {
        return corresponsiveAccountName;
    }

    public String getServicebranchId() {
        return servicebranchId;
    }

    public String getServiceBankName() {
        return serviceBankName;
    }

    public String getChannel() {
        return channel;
    }

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getTrxTypeDatalake() {
        return trxTypeDatalake;
    }

    public String getUid() {
        return uid;
    }

    public String getEftType() {
        return eftType;
    }

    public String getzGrp() {
        return zGrp;
    }

    public String getEtc() {
        return etc;
    }

    public String getPrfLnGrp() {
        return prfLnGrp;
    }

    public String getEftpayZfeeacct() {
        return eftpayZfeeacct;
    }

    public String getzChanRefNo() {
        return zChanRefNo;
    }

    public String getzPrfRefNo() {
        return zPrfRefNo;
    }

    public String getzSpr() {
        return zSpr;
    }

    public String getIct1() {
        return ict1;
    }

    public String getCobDt() {
        return cobDt;
    }

    public String getCurrency() {
        return currency;
    }
    public String getZtrid() {
		return ztrid;
	}

	public void setZtrid(String ztrid) {
		this.ztrid = ztrid;
	}

	public String getTrc() {
		return trc;
	}

	public void setTrc(String trc) {
		this.trc = trc;
	}

	public String getFeeamt() {
		return feeamt;
	}

	public void setFeeamt(String feeamt) {
		this.feeamt = feeamt;
	}

	public String getTaxamt() {
		return taxamt;
	}

	public void setTaxamt(String taxamt) {
		this.taxamt = taxamt;
	}

	public String getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(String taxrate) {
		this.taxrate = taxrate;
	}

	public String getZrefnum() {
		return zrefnum;
	}

	public void setZrefnum(String zrefnum) {
		this.zrefnum = zrefnum;
	}

	public String getInvno() {
		return invno;
	}

	public void setInvno(String invno) {
		this.invno = invno;
	}

	public String getBanktransid() {
		return banktransid;
	}

	public void setBanktransid(String banktransid) {
		this.banktransid = banktransid;
	}

	public String getNetamount() {
		return netamount;
	}

	public void setNetamount(String netamount) {
		this.netamount = netamount;
	}
	
    
}