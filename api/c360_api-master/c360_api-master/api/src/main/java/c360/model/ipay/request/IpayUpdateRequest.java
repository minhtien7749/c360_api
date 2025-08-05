package c360.model.ipay.request;

import java.util.List;

import c360.model.ipay.model.Category;

public class IpayUpdateRequest {
    private String requestId;

    public List<Category> getData() {
        return data;
    }

    public String getRequestId() {
        return requestId;
    }

    public IpayUpdateRequest(String requestId, List<Category> data) {
        this.requestId = requestId;
        this.data = data;
    }

    private List<Category> data;

}