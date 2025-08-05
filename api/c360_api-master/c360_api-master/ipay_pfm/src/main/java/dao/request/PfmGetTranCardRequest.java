package dao.request;

public class PfmGetTranCardRequest {
        private String requestId;
        private String sessionId;
        private String customerId;
        private String docNo;
        private String no;
        private String lang;

    public PfmGetTranCardRequest(String requestId, String sessionId, String customerId, String docNo, String no, String lang) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.docNo = docNo;
        this.no = no;
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

    public String getDocNo() {
        return docNo;
    }

    public String getNo() {
        return no;
    }

    public String getLang() {
        return lang;
    }
}
