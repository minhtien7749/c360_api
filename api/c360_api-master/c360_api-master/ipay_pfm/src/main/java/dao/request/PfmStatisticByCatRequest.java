package dao.request;

public class PfmStatisticByCatRequest {
    private String requestId;
    private String sessionId;
    private String customerId;
    private String category;
    private String periodFrom;
    private String periodTo;
    private  String periodType;
    private String lang;

    public PfmStatisticByCatRequest(String requestId, String sessionId, String customerId, String category, String periodFrom, String periodTo, String periodType, String lang) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.category = category;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.periodType = periodType;
        this.lang = lang;
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

    public String getCategory() {
        return category;
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

    public String getLang() {
        return lang;
    }
}
