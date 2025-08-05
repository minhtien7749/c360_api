package c360.model;

import java.math.BigDecimal;

public class LimitApprovedBal {
	private String cif;
	private String cifName;
	private String segment;
	private String ostdNBond;
	private BigDecimal undisbursedLoanLmt;
	private BigDecimal cardLmt;
	private BigDecimal tfBal;
	private BigDecimal total;
	private String cobDt;
	
	
	public LimitApprovedBal(String cif, String cifName, String segment, String ostdNBond, BigDecimal undisbursedLoanLmt,
			BigDecimal cardLmt, BigDecimal tfBal, BigDecimal total, String cobDt) {
		this.cif = cif;
		this.cifName = cifName;
		this.segment = segment;
		this.ostdNBond = ostdNBond;
		this.undisbursedLoanLmt = undisbursedLoanLmt;
		this.cardLmt = cardLmt;
		this.tfBal = tfBal;
		this.total = total;
		this.cobDt = cobDt;
	}
	
	
	@Override
	public String toString() {
		return "LimitApprovedBal [cif=" + cif + ", cifName=" + cifName + ", segment=" + segment + ", ostdNBond="
				+ ostdNBond + ", undisbursedLoanLmt=" + undisbursedLoanLmt + ", cardLmt=" + cardLmt + ", tfBal=" + tfBal
				+ ", total=" + total + ", cobDt=" + cobDt + "]";
	}


	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getOstdNBond() {
		return ostdNBond;
	}
	public void setOstdNBond(String ostdNBond) {
		this.ostdNBond = ostdNBond;
	}
	public BigDecimal getUndisbursedLoanLmt() {
		return undisbursedLoanLmt;
	}
	public void setUndisbursedLoanLmt(BigDecimal undisbursedLoanLmt) {
		this.undisbursedLoanLmt = undisbursedLoanLmt;
	}
	public BigDecimal getCardLmt() {
		return cardLmt;
	}
	public void setCardLmt(BigDecimal cardLmt) {
		this.cardLmt = cardLmt;
	}
	public BigDecimal getTfBal() {
		return tfBal;
	}
	public void setTfBal(BigDecimal tfBal) {
		this.tfBal = tfBal;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCobDt() {
		return cobDt;
	}
	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}
	
	

	


	

}
