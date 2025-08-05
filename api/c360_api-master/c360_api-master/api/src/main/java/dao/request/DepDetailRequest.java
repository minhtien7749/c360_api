package dao.request;

public class DepDetailRequest {
	private String requestId;
    private String cif;
    private String grp;
    private String cobDt;
    

	public DepDetailRequest(String requestId, String cif, String grp, String cobDt) {
		super();
		this.requestId = requestId;
		this.cif = cif;
		this.grp = grp;
		this.cobDt = cobDt;
	}
	
	
	public String getGrp() {
		return grp;
	}
	
	public void setGrp(String grp) {
		this.grp = grp;
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
	public String getCob_dt() {
		return cobDt;
	}
	public void setCob_dt(String cobDt) {
		this.cobDt = cobDt;
	}

    
}
