package dao.request;

public class MoneyTransactionRequest {
    private String requestId;
    private String acn;
    private String ofsCid;
    private String fromDate;
    private String toDate;
    private String limit;

    public MoneyTransactionRequest(String requestId, String acn, String ofsCid, String fromDate, String toDate,String limit) {
        this.requestId = requestId;
        this.acn = acn;
        this.ofsCid = ofsCid;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.limit = limit;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getAcn() {
        return acn;
    }

    public String ofsCid() {
        return ofsCid;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

	public String getLimit() {
		return limit;
	}
    
}
