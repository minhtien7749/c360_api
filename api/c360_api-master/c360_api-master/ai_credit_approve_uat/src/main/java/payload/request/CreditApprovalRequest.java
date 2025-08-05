package payload.request;

public class CreditApprovalRequest {
    String requestId;
    String customerId;
    String fromDate;
    String endDate;

    public CreditApprovalRequest(String requestId, String customerId, String fromDate, String endDate) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.fromDate = fromDate;
        this.endDate = endDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
