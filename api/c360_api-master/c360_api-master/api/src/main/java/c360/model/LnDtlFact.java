package c360.model;

import java.util.Map;

public class LnDtlFact {
	private String act_nbr;
	private String brnch_cd;
	private String crcd;
	private String dlyBalAmt;
	private String ytdAvgBalAmt;
	private String ytdAvgBalAmtNh;
	private String ytdAvgBalAmtTh;
	private String ytdAvgBalAmtDh;
	private String ytdBalAmtGroup1;
	private String ytdBalAmtGroup2;
	private String ytdBalAmtGroup3;
	private String ytdBalAmtGroup4;
	private String ytdBalAmtGroup5;
	private String dlyAvgBalAmtNh;
	private String dlyBalAmtTh;
	private String dlyAvgBalAmtDh;
	private String dlyBalAmtGroup1;
	private String dlyBalAmtGroup2;
	private String dlyBalAmtGroup3;
	private String dlyBalAmtGroup4;
	private String dlyBalAmtGroup5;
	private String ytdNiiAmt;
	private String ytdNiiAmtNh;
	private String ytdNiiAmtTh;
	private String ytdNiiAmtDh;
	private String ytdNimAmt;
	private String cobDt;
    private Map<String, String> irnList;  // Add this field

	


	public LnDtlFact(String act_nbr, String brnch_cd, String crcd, String dlyBalAmt, String ytdAvgBalAmt,
			String ytdAvgBalAmtNh, String ytdAvgBalAmtTh, String ytdAvgBalAmtDh, String ytdBalAmtGroup1,
			String ytdBalAmtGroup2, String ytdBalAmtGroup3, String ytdBalAmtGroup4, String ytdBalAmtGroup5,
			String dlyAvgBalAmtNh, String dlyBalAmtTh, String dlyAvgBalAmtDh, String dlyBalAmtGroup1,
			String dlyBalAmtGroup2, String dlyBalAmtGroup3, String dlyBalAmtGroup4, String dlyBalAmtGroup5,
			String ytdNiiAmt, String ytdNiiAmtNh, String ytdNiiAmtTh, String ytdNiiAmtDh, String ytdNimAmt,
			String cobDt, Map<String, String> irnList) {
		super();
		this.act_nbr = act_nbr;
		this.brnch_cd = brnch_cd;
		this.crcd = crcd;
		this.dlyBalAmt = dlyBalAmt;
		this.ytdAvgBalAmt = ytdAvgBalAmt;
		this.ytdAvgBalAmtNh = ytdAvgBalAmtNh;
		this.ytdAvgBalAmtTh = ytdAvgBalAmtTh;
		this.ytdAvgBalAmtDh = ytdAvgBalAmtDh;
		this.ytdBalAmtGroup1 = ytdBalAmtGroup1;
		this.ytdBalAmtGroup2 = ytdBalAmtGroup2;
		this.ytdBalAmtGroup3 = ytdBalAmtGroup3;
		this.ytdBalAmtGroup4 = ytdBalAmtGroup4;
		this.ytdBalAmtGroup5 = ytdBalAmtGroup5;
		this.dlyAvgBalAmtNh = dlyAvgBalAmtNh;
		this.dlyBalAmtTh = dlyBalAmtTh;
		this.dlyAvgBalAmtDh = dlyAvgBalAmtDh;
		this.dlyBalAmtGroup1 = dlyBalAmtGroup1;
		this.dlyBalAmtGroup2 = dlyBalAmtGroup2;
		this.dlyBalAmtGroup3 = dlyBalAmtGroup3;
		this.dlyBalAmtGroup4 = dlyBalAmtGroup4;
		this.dlyBalAmtGroup5 = dlyBalAmtGroup5;
		this.ytdNiiAmt = ytdNiiAmt;
		this.ytdNiiAmtNh = ytdNiiAmtNh;
		this.ytdNiiAmtTh = ytdNiiAmtTh;
		this.ytdNiiAmtDh = ytdNiiAmtDh;
		this.ytdNimAmt = ytdNimAmt;
		this.cobDt = cobDt;
		this.irnList = irnList;
	}



	public Map<String, String> getIrnList() {
		return irnList;
	}



	public void setIrnList(Map<String, String> irnList) {
		this.irnList = irnList;
	}

	public String getYtdNiiAmt() {
		return ytdNiiAmt;
	}


	public void setYtdNiiAmt(String ytdNiiAmt) {
		this.ytdNiiAmt = ytdNiiAmt;
	}


	public String getYtdNiiAmtNh() {
		return ytdNiiAmtNh;
	}


	public void setYtdNiiAmtNh(String ytdNiiAmtNh) {
		this.ytdNiiAmtNh = ytdNiiAmtNh;
	}
	public String getYtdNiiAmtTh() {
		return ytdNiiAmtTh;
	}
	public void setYtdNiiAmtTh(String ytdNiiAmtTh) {
		this.ytdNiiAmtTh = ytdNiiAmtTh;
	}
	public String getYtdNiiAmtDh() {
		return ytdNiiAmtDh;
	}
	public void setYtdNiiAmtDh(String ytdNiiAmtDh) {
		this.ytdNiiAmtDh = ytdNiiAmtDh;
	}
	public String getCrcd() {
		return crcd;
	}
	public void setCrcd(String crcd) {
		this.crcd = crcd;
	}
	public String getCobDt() {
		return cobDt;
	}
	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}
	public String getAct_nbr() {
		return act_nbr;
	}
	public void setAct_nbr(String act_nbr) {
		this.act_nbr = act_nbr;
	}
	public String getBrnch_cd() {
		return brnch_cd;
	}
	public void setBrnch_cd(String brnch_cd) {
		this.brnch_cd = brnch_cd;
	}
	public String getYtdAvgBalAmtNh() {
		return ytdAvgBalAmtNh;
	}
	public void setYtdAvgBalAmtNh(String ytdAvgBalAmtNh) {
		this.ytdAvgBalAmtNh = ytdAvgBalAmtNh;
	}
	public String getYtdAvgBalAmtTh() {
		return ytdAvgBalAmtTh;
	}
	public void setYtdAvgBalAmtTh(String ytdAvgBalAmtTh) {
		this.ytdAvgBalAmtTh = ytdAvgBalAmtTh;
	}
	public String getYtdAvgBalAmtDh() {
		return ytdAvgBalAmtDh;
	}
	public void setYtdAvgBalAmtDh(String ytdAvgBalAmtDh) {
		this.ytdAvgBalAmtDh = ytdAvgBalAmtDh;
	}
	public String getYtdBalAmtGroup1() {
		return ytdBalAmtGroup1;
	}
	public void setYtdBalAmtGroup1(String ytdBalAmtGroup1) {
		this.ytdBalAmtGroup1 = ytdBalAmtGroup1;
	}
	public String getYtdBalAmtGroup2() {
		return ytdBalAmtGroup2;
	}
	public void setYtdBalAmtGroup2(String ytdBalAmtGroup2) {
		this.ytdBalAmtGroup2 = ytdBalAmtGroup2;
	}
	public String getYtdBalAmtGroup3() {
		return ytdBalAmtGroup3;
	}
	public void setYtdBalAmtGroup3(String ytdBalAmtGroup3) {
		this.ytdBalAmtGroup3 = ytdBalAmtGroup3;
	}
	public String getYtdBalAmtGroup4() {
		return ytdBalAmtGroup4;
	}
	public void setYtdBalAmtGroup4(String ytdBalAmtGroup4) {
		this.ytdBalAmtGroup4 = ytdBalAmtGroup4;
	}
	public String getYtdBalAmtGroup5() {
		return ytdBalAmtGroup5;
	}
	public void setYtdBalAmtGroup5(String ytdBalAmtGroup5) {
		this.ytdBalAmtGroup5 = ytdBalAmtGroup5;
	}
	public String getDlyAvgBalAmtNh() {
		return dlyAvgBalAmtNh;
	}
	public void setDlyAvgBalAmtNh(String dlyAvgBalAmtNh) {
		this.dlyAvgBalAmtNh = dlyAvgBalAmtNh;
	}
	public String getDlyBalAmtTh() {
		return dlyBalAmtTh;
	}
	public void setDlyBalAmtTh(String dlyBalAmtTh) {
		this.dlyBalAmtTh = dlyBalAmtTh;
	}
	public String getDlyAvgBalAmtDh() {
		return dlyAvgBalAmtDh;
	}
	public void setDlyAvgBalAmtDh(String dlyAvgBalAmtDh) {
		this.dlyAvgBalAmtDh = dlyAvgBalAmtDh;
	}
	public String getDlyBalAmtGroup1() {
		return dlyBalAmtGroup1;
	}
	public void setDlyBalAmtGroup1(String dlyBalAmtGroup1) {
		this.dlyBalAmtGroup1 = dlyBalAmtGroup1;
	}
	public String getDlyBalAmtGroup2() {
		return dlyBalAmtGroup2;
	}
	public void setDlyBalAmtGroup2(String dlyBalAmtGroup2) {
		this.dlyBalAmtGroup2 = dlyBalAmtGroup2;
	}
	public String getDlyBalAmtGroup3() {
		return dlyBalAmtGroup3;
	}
	public void setDlyBalAmtGroup3(String dlyBalAmtGroup3) {
		this.dlyBalAmtGroup3 = dlyBalAmtGroup3;
	}
	public String getDlyBalAmtGroup4() {
		return dlyBalAmtGroup4;
	}
	public void setDlyBalAmtGroup4(String dlyBalAmtGroup4) {
		this.dlyBalAmtGroup4 = dlyBalAmtGroup4;
	}
	public String getDlyBalAmtGroup5() {
		return dlyBalAmtGroup5;
	}
	public void setDlyBalAmtGroup5(String dlyBalAmtGroup5) {
		this.dlyBalAmtGroup5 = dlyBalAmtGroup5;
	}
	public String getYtdNimAmt() {
		return ytdNimAmt;
	}
	public void setYtdNimAmt(String ytdNimAmt) {
		this.ytdNimAmt = ytdNimAmt;
	}


	public String getDlyBalAmt() {
		return dlyBalAmt;
	}


	public void setDlyBalAmt(String dlyBalAmt) {
		this.dlyBalAmt = dlyBalAmt;
	}


	public String getYtdAvgBalAmt() {
		return ytdAvgBalAmt;
	}


	public void setYtdAvgBalAmt(String ytdAvgBalAmt) {
		this.ytdAvgBalAmt = ytdAvgBalAmt;
	}


}
