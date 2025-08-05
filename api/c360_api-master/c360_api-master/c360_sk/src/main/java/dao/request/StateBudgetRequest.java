package dao.request;

public class StateBudgetRequest {
    private String requestId;
    private String refNo;
    private String taxTyp;
    private String fromDate;
    private String toDate;

    public StateBudgetRequest(String requestId, String refNo, String taxTyp, String fromDate, String toDate) {
        this.requestId = requestId;
        this.refNo = refNo;
        this.taxTyp = taxTyp;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRefNo() {
        return refNo;
    }

    public String getTaxTyp() {
        return taxTyp;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
