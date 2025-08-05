package payload.request;

public class DepdetailRequest {
    String requestId;
    String cid;

    public DepdetailRequest(String requestId, String cid) {
        this.requestId = requestId;
        this.cid = cid;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCid() {
        return cid;
    }
}