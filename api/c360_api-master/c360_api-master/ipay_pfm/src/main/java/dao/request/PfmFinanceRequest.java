package dao.request;

public class PfmFinanceRequest {
    private String requestId;
    private String sessionId;
    private String customerId;

    public PfmFinanceRequest(String requestId, String sessionId, String customerId) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getCustomerId() {
        return customerId;
    }
}