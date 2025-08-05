package dao.request;

public class PaySalFactRequest {
	private String requestId;
    private String cif;
    private String branch;
    private String fromDate;
    private String cobDt;
    private String period;
	
	public PaySalFactRequest(String requestId, String cif, String branch, String fromDate, String cobDt,
			String period) {
		super();
		this.requestId = requestId;
		this.cif = cif;
		this.branch = branch;
		this.fromDate = fromDate;
		this.cobDt = cobDt;
		this.period = period;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
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
	public String getCobDt() {
		return cobDt;
	}
	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}
    
    
    
}
