package c360.model;

import java.math.BigDecimal;

public class PaySalFact {
private String branch;
private String cif;
private BigDecimal totAmt;
private BigDecimal amtChiLuongOut;
private BigDecimal amtChiLuongIn;
private String countKh;
private String countCbnvOut;
private String countCbnvIn;
private String slGd;
private String cobDt;

public PaySalFact(String branch, String cif, BigDecimal totAmt, BigDecimal amtChiLuongOut, BigDecimal amtChiLuongIn,
		String countKh, String countCbnvOut, String countCbnvIn, String slGd, String cobDt) {
	super();
	this.branch = branch;
	this.cif = cif;
	this.totAmt = totAmt;
	this.amtChiLuongOut = amtChiLuongOut;
	this.amtChiLuongIn = amtChiLuongIn;
	this.countKh = countKh;
	this.countCbnvOut = countCbnvOut;
	this.countCbnvIn = countCbnvIn;
	this.slGd = slGd;
	this.cobDt = cobDt;
}


public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getCif() {
	return cif;
}
public void setCif(String cif) {
	this.cif = cif;
}
public BigDecimal getTotAmt() {
	return totAmt;
}
public void setTotAmt(BigDecimal totAmt) {
	this.totAmt = totAmt;
}
public BigDecimal getAmtChiLuongOut() {
	return amtChiLuongOut;
}
public void setAmtChiLuongOut(BigDecimal amtChiLuongOut) {
	this.amtChiLuongOut = amtChiLuongOut;
}
public BigDecimal getAmtChiLuongIn() {
	return amtChiLuongIn;
}
public void setAmtChiLuongIn(BigDecimal amtChiLuongIn) {
	this.amtChiLuongIn = amtChiLuongIn;
}
public String getCountKh() {
	return countKh;
}
public void setCountKh(String countKh) {
	this.countKh = countKh;
}
public String getCountCbnvOut() {
	return countCbnvOut;
}
public void setCountCbnvOut(String countCbnvOut) {
	this.countCbnvOut = countCbnvOut;
}
public String getCountCbnvIn() {
	return countCbnvIn;
}
public void setCountCbnvIn(String countCbnvIn) {
	this.countCbnvIn = countCbnvIn;
}
public String getSlGd() {
	return slGd;
}
public void setSlGd(String slGd) {
	this.slGd = slGd;
}
public String getCobDt() {
	return cobDt;
}
public void setCobDt(String cobDt) {
	this.cobDt = cobDt;
}



}
