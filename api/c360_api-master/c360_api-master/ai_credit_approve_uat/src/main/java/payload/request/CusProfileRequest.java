package payload.request;

public class CusProfileRequest {
    public String requestId;
    public String customerId;

    public CusProfileRequest(String requestId, String customerId) {
        this.requestId = requestId;
        this.customerId = customerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCustomerId() {
        return customerId;
    }
}