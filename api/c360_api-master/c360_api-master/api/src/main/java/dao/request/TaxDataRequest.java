package dao.request;

public class TaxDataRequest {
	private String requestId;
	private String taxNo;
	private String cobDt;
	
	
	public TaxDataRequest(String requestId,String taxNo,String cobDt) {
		super();
		this.requestId = requestId;
		this.taxNo = taxNo;
		this.cobDt = cobDt;
	}


	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTaxNo() {
		return taxNo;
	}


	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}


	public String getCobDt() {
		return cobDt;
	}


	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}
	

	
}
