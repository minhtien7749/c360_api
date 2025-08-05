package c360.model.ipay.request;

import java.util.ArrayList;
import java.util.List;

public class IpayStatisticRequest {
    private String customerId;
    private ArrayList<String> listCid;
    private String source;
    private String categoryId;
    private String fromDate;
    private String lastDate;
    private String period;

    public IpayStatisticRequest(String customerId, ArrayList<String> listCid, String source, String categoryId, String fromDate, String lastDate, String period) {
        this.customerId = customerId;
        this.listCid = listCid;
        this.source = source;
        this.categoryId = categoryId;
        this.fromDate = fromDate;
        this.lastDate = lastDate;
        this.period = period;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ArrayList<String> getListCid() {
        return listCid;
    }

    public String getSource() {
        return source;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getPeriod() {
        return period;
    }
}