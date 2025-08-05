package dao.request;

public class DeleteRequest {
    private String requestId;
    private String sessionId;
    private String executionDate;
    private String pid;
    private String mappingId;

    public DeleteRequest(String requestId, String sessionId, String executionDate, String pid, String mappingId) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.executionDate = executionDate;
        this.pid = pid;
        this.mappingId = mappingId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public String getPid() {
        return pid;
    }

    public String getMappingId() {
        return mappingId;
    }
}
