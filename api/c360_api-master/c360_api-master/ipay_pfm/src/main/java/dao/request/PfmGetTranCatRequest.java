package dao.request;

public class PfmGetTranCatRequest {
    private String requestId;
    private String sessionId;
    private String customerId;
    private String executionDate;
    private String accountNo;
    private String tSeq;
    private String hostRefNo;
    private String transactionRef;
    private String lang;

    public PfmGetTranCatRequest(String requestId, String sessionId, String customerId, String executionDate, String accountNo, String tSeq, String hostRefNo, String transactionRef, String lang) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.executionDate = executionDate;
        this.accountNo = accountNo;
        this.tSeq = tSeq;
        this.hostRefNo = hostRefNo;
        this.transactionRef = transactionRef;
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

    public String getExecutionDate() {
        return executionDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String gettSeq() {
        return tSeq;
    }

    public String getHostRefNo() {
        return hostRefNo;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public String getLang() {
        return lang;
    }
}
