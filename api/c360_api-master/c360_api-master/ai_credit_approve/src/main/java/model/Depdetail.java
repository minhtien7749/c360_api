package model;

public class Depdetail {
	private String cifNo; 
	private String acctNo; 
	private String stat; 
	private String cus_nm;
	private String crcd;
	private String cob_dt;

	public Depdetail(String cifNo, String acctNo, String stat, String cus_nm, String crcd, String cob_dt) {
		super();
		this.cifNo = cifNo;
		this.acctNo = acctNo;
		this.stat = stat;
		this.cus_nm = cus_nm;
		this.crcd = crcd;
		this.cob_dt = cob_dt;
	}
	
	public String getCus_nm() {
		return cus_nm;
	}

	public void setCus_nm(String cus_nm) {
		this.cus_nm = cus_nm;
	}
	public String getCrcd() {
		return crcd;
	}
	public void setCrcd(String crcd) {
		this.crcd = crcd;
	}

	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getCob_dt() {
		return cob_dt;
	}

	public void setCob_dt(String cob_dt) {
		this.cob_dt = cob_dt;
	}

	
	
}
