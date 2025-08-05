package dao.request;

public class PfmStatisticOverviewRequest {
    private String requestId;
    private String sessionId;
    private String customerId;
    private String periodFrom;
    private String periodTo;
    private String periodType;


    public PfmStatisticOverviewRequest(String requestId, String sessionId, String customerId, String periodFrom, String periodTo, String periodType) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.periodType = periodType;
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

    public String getPeriodFrom() {
        return periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public String getPeriodType() {
        return periodType;
    }
}
