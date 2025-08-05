package dao.request;

public class LnDetailRequest {
	private String requestId;
    private String cif;
    private String cobDt;
    

    
	public LnDetailRequest(String requestId, String cif, String cobDt) {
		super();
		this.requestId = requestId;
		this.cif = cif;
		this.cobDt = cobDt;
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
