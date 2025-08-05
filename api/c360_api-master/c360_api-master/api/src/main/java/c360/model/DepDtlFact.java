package c360.model;

import java.util.List;
import java.util.Map;

public class DepDtlFact {
	private String cif;
    private String branch;
    private String crcd;
    private String ytdAvgBalAmt;
    private String ytdAvgBalAmtTc;
    private String ytdOnlAvgBalAmt;
    private String ytdOnlAvgBalAmtTc;
    private String ytdNiiAmt;
    private String dlyBalAmt;
    private String dlyBalAmtTc;
    private String dlyOnBalAmt;
    private String dlyOnBalAmtTc;
    private String qtdAvgBalAmt;
    private String qtdAvgBalAmtTc;
    private String qtdOnlAvgBalAmt;
    private String qtdOnlAvgBalAmtTc;
    private String ytdNimAmt;
    private String cobDt;
    private Map<String, String> irnList;  // Add this field

    public DepDtlFact(String cif, String branch, String crcd, 
                      String ytdAvgBalAmt, String ytdAvgBalAmtTc, 
                      String ytdOnlAvgBalAmt, String ytdOnlAvgBalAmtTc, 
                      String ytdNiiAmt, String dlyBalAmt, String dlyBalAmtTc, 
                      String dlyOnBalAmt, String dlyOnBalAmtTc, 
                      String qtdAvgBalAmt, String qtdAvgBalAmtTc, 
                      String qtdOnlAvgBalAmt, String qtdOnlAvgBalAmtTc, 
                      String ytdNimAmt, String cobDt, 
                      Map<String, String> irnList) { // Include irnList
        this.cif = cif;
        this.branch = branch;
        this.crcd = crcd;
        this.ytdAvgBalAmt = ytdAvgBalAmt;
        this.ytdAvgBalAmtTc = ytdAvgBalAmtTc;
        this.ytdOnlAvgBalAmt = ytdOnlAvgBalAmt;
        this.ytdOnlAvgBalAmtTc = ytdOnlAvgBalAmtTc;
        this.ytdNiiAmt = ytdNiiAmt;
        this.dlyBalAmt = dlyBalAmt;
        this.dlyBalAmtTc = dlyBalAmtTc;
        this.dlyOnBalAmt = dlyOnBalAmt;
        this.dlyOnBalAmtTc = dlyOnBalAmtTc;
        this.qtdAvgBalAmt = qtdAvgBalAmt;
        this.qtdAvgBalAmtTc = qtdAvgBalAmtTc;
        this.qtdOnlAvgBalAmt = qtdOnlAvgBalAmt;
        this.qtdOnlAvgBalAmtTc = qtdOnlAvgBalAmtTc;
        this.ytdNimAmt = ytdNimAmt;
        this.cobDt = cobDt;
        this.irnList = irnList;
    }




public String getQtdAvgBalAmt() {
		return qtdAvgBalAmt;
	}




	public void setQtdAvgBalAmt(String qtdAvgBalAmt) {
		this.qtdAvgBalAmt = qtdAvgBalAmt;
	}




	public String getQtdAvgBalAmtTc() {
		return qtdAvgBalAmtTc;
	}




	public void setQtdAvgBalAmtTc(String qtdAvgBalAmtTc) {
		this.qtdAvgBalAmtTc = qtdAvgBalAmtTc;
	}




	public String getQtdOnlAvgBalAmt() {
		return qtdOnlAvgBalAmt;
	}




	public void setQtdOnlAvgBalAmt(String qtdOnlAvgBalAmt) {
		this.qtdOnlAvgBalAmt = qtdOnlAvgBalAmt;
	}




	public String getQtdOnlAvgBalAmtTc() {
		return qtdOnlAvgBalAmtTc;
	}




	public void setQtdOnlAvgBalAmtTc(String qtdOnlAvgBalAmtTc) {
		this.qtdOnlAvgBalAmtTc = qtdOnlAvgBalAmtTc;
	}

	public Map<String, String> getIrnList() {
		return irnList;
	}


	public void setIrnList(Map<String, String> irnList) {
		this.irnList = irnList;
	}




	public String getCrcd() {
		return crcd;
	}




public void setCrcd(String crcd) {
	this.crcd = crcd;
}

public String getCif() {
	return cif;
}

public void setCif(String cif) {
	this.cif = cif;
}

public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getYtdAvgBalAmt() {
	return ytdAvgBalAmt;
}
public void setYtdAvgBalAmt(String ytdAvgBalAmt) {
	this.ytdAvgBalAmt = ytdAvgBalAmt;
}

public String getYtdOnlAvgBalAmt() {
	return ytdOnlAvgBalAmt;
}

public void setYtdOnlAvgBalAmt(String ytdOnlAvgBalAmt) {
	this.ytdOnlAvgBalAmt = ytdOnlAvgBalAmt;
}

public String getDlyBalAmt() {
	return dlyBalAmt;
}

public void setDlyBalAmt(String dlyBalAmt) {
	this.dlyBalAmt = dlyBalAmt;
}

public String getYtdNiiAmt() {
	return ytdNiiAmt;
}

public void setYtdNiiAmt(String ytdNiiAmt) {
	this.ytdNiiAmt = ytdNiiAmt;
}

public String getYtdNimAmt() {
	return ytdNimAmt;
}

public void setYtdNimAmt(String ytdNimAmt) {
	this.ytdNimAmt = ytdNimAmt;
}


public String getYtdAvgBalAmtTc() {
	return ytdAvgBalAmtTc;
}

public void setYtdAvgBalAmtTc(String ytdAvgBalAmtTc) {
	this.ytdAvgBalAmtTc = ytdAvgBalAmtTc;
}

public String getYtdOnlAvgBalAmtTc() {
	return ytdOnlAvgBalAmtTc;
}

public void setYtdOnlAvgBalAmtTc(String ytdOnlAvgBalAmtTc) {
	this.ytdOnlAvgBalAmtTc = ytdOnlAvgBalAmtTc;
}

public String getDlyBalAmtTc() {
	return dlyBalAmtTc;
}

public void setDlyBalAmtTc(String dlyBalAmtTc) {
	this.dlyBalAmtTc = dlyBalAmtTc;
}

public String getCobDt() {
	return cobDt;
}

public void setCobDt(String cobDt) {
	this.cobDt = cobDt;
}

public String getDlyOnBalAmt() {
	return dlyOnBalAmt;
}

public void setDlyOnBalAmt(String dlyOnBalAmt) {
	this.dlyOnBalAmt = dlyOnBalAmt;
}

public String getDlyOnBalAmtTc() {
	return dlyOnBalAmtTc;
}

public void setDlyOnBalAmtTc(String dlyOnBalAmtTc) {
	this.dlyOnBalAmtTc = dlyOnBalAmtTc;
}


}
