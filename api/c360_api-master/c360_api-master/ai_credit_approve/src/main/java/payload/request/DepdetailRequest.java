package payload.request;

public class DepdetailRequest {
	private String requestId;
    private String cid;
    private String convacn;
    private String mst;

	public DepdetailRequest(String requestId, String cid, String convacn, String mst) {
		super();
		this.requestId = requestId;
		this.cid = cid;
		this.convacn = convacn;
		this.mst = mst;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getConvacn() {
		return convacn;
	}
	public void setConvacn(String convacn) {
		this.convacn = convacn;
	}
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
}
