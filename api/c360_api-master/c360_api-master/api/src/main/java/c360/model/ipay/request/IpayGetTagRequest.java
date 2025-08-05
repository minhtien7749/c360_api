package c360.model.ipay.request;

public class IpayGetTagRequest {
    private String requestId;
    private String appId;
    private String mappingId;

    public IpayGetTagRequest(String requestId, String appId, String mappingId) {
        this.requestId = requestId;
        this.appId = appId;
        this.mappingId = mappingId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getAppId() {
        return appId;
    }

    public String getMappingId() {
        return mappingId;
    }
}