package payload.request;

import java.math.BigDecimal;

public class BusinessLineRequest {
    String requestId;
    BigDecimal net_rev;
    String level3;

    public BusinessLineRequest(String requestId, BigDecimal net_rev, String level3) {
        this.requestId = requestId;
        this.net_rev = net_rev;
        this.level3 = level3;
    }

    public String getRequestId() {
        return requestId;
    }

    public BigDecimal getNet_rev() {
        return net_rev;
    }

    public String getLevel3() {
        return level3;
    }
}
