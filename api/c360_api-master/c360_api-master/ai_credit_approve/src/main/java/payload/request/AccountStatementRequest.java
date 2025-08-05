package payload.request;

public class AccountStatementRequest {
    String requestId;
    String customerId;
    String fromDate;
    String endDate;
    int pageSize;
    int pageNum;

    public AccountStatementRequest(String requestId, String customerId, String fromDate, String endDate, int pageSize, int pageNum) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
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

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }
}