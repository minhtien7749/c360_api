package dao.request;

import java.util.List;

public class LnDtlFactRequest {
    private String requestId;
    private String cif;
    private String branch;
    private String period;
    private List<String> crcd;
    private List<String> irnList;
    private String fromDate;
    private String toDate;
    

	public LnDtlFactRequest(String requestId, String cif, String branch,String period, List<String> crcd, List<String> irnList,String fromDate, String toDate) {
		super();
		this.requestId = requestId;
		this.cif = cif;
		this.branch = branch;
		this.period = period;
		this.crcd = crcd;
		this.irnList = irnList;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	public List<String> getCrcd() {
		return crcd;
	}
	public void setCrcd(List<String> crcd) {
		this.crcd = crcd;
	}	
	public List<String> getIrnList() {
		return irnList;
	}
	public void setIrnList(List<String> irnList) {
		this.irnList = irnList;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
}
