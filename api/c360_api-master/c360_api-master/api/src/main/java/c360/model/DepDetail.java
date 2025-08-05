package c360.model;

public class DepDetail {
	private String cifNo; 
	private String acctNo; 
	private String crcd; 
	private String grp; 
	private String intrstRate;
	private String mdt;
	private String odt;
	private String trm; 
	private String type;
	private String dlyBalAmt;
	private String dlyBalAmtTc;
	private String mtdAcctAvgBal;
	private String qtdAcctAvgBal;
	private String ytdAcctAvgBal;
	private String cobDt;
	
	public DepDetail(String cifNo, String acctNo, String crcd, String grp, String intrstRate, String mdt, String odt, String trm,
			String type, String dlyBalAmt, String dlyBalAmtTc, String mtdAcctAvgBal, String qtdAcctAvgBal,
			String ytdAcctAvgBal, String cobDt) {
		super();
		this.cifNo = cifNo;
		this.acctNo = acctNo;
		this.crcd = crcd;
		this.grp = grp;
		this.intrstRate = intrstRate;
		this.mdt = mdt;
		this.odt = odt;
		this.trm = trm;
		this.type = type;
		this.dlyBalAmt = dlyBalAmt;
		this.dlyBalAmtTc = dlyBalAmtTc;
		this.mtdAcctAvgBal = mtdAcctAvgBal;
		this.qtdAcctAvgBal = qtdAcctAvgBal;
		this.ytdAcctAvgBal = ytdAcctAvgBal;
		this.cobDt = cobDt;
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
	public String getCrcd() {
		return crcd;
	}
	public void setCrcd(String crcd) {
		this.crcd = crcd;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public String getIntrstRate() {
		return intrstRate;
	}
	public void setIntrstRate(String intrstRate) {
		this.intrstRate = intrstRate;
	}
	public String getMdt() {
		return mdt;
	}
	public void setMdt(String mdt) {
		this.mdt = mdt;
	}
	public String getOdt() {
		return odt;
	}
	public void setOdt(String odt) {
		this.odt = odt;
	}
	public String getTrm() {
		return trm;
	}
	public void setTrm(String trm) {
		this.trm = trm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDlyBalAmt() {
		return dlyBalAmt;
	}
	public void setDlyBalAmt(String dlyBalAmt) {
		this.dlyBalAmt = dlyBalAmt;
	}
	public String getDlyBalAmtTc() {
		return dlyBalAmtTc;
	}
	public void setDlyBalAmtTc(String dlyBalAmtTc) {
		this.dlyBalAmtTc = dlyBalAmtTc;
	}
	public String getMtdAcctAvgBal() {
		return mtdAcctAvgBal;
	}
	public void setMtdAcctAvgBal(String mtdAcctAvgBal) {
		this.mtdAcctAvgBal = mtdAcctAvgBal;
	}
	public String getQtdAcctAvgBal() {
		return qtdAcctAvgBal;
	}
	public void setQtdAcctAvgBal(String qtdAcctAvgBal) {
		this.qtdAcctAvgBal = qtdAcctAvgBal;
	}
	public String getYtdAcctAvgBal() {
		return ytdAcctAvgBal;
	}
	public void setYtdAcctAvgBal(String ytdAcctAvgBal) {
		this.ytdAcctAvgBal = ytdAcctAvgBal;
	}
	public String getCobDt() {
		return cobDt;
	}
	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	} 

	
}


