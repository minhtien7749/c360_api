package payload.request;

import java.util.ArrayList;

public class PartnerPerformanceRequest {
    String requestId;
    ArrayList<String> taxIds;

    public PartnerPerformanceRequest(String requestId, ArrayList<String> taxIds) {
        this.requestId = requestId;
        this.taxIds = taxIds;
    }

    public String getRequestId() {
        return requestId;
    }

    public ArrayList<String> getTaxIds() {
        return taxIds;
    }
}
