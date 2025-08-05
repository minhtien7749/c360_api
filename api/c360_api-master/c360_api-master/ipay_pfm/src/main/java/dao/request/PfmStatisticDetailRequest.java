package dao.request;

import java.util.ArrayList;

public class PfmStatisticDetailRequest {
    private String requestId;
    private String sessionId;
    private String customerId;
    private ArrayList<String> accountList;
    private ArrayList<String> cardList;
    private ArrayList<String> categoryList;
    private String periodFrom;
    private String periodTo;
    private  String groupBy;
    private String lang;

    public PfmStatisticDetailRequest(String requestId, String sessionId, String customerId, ArrayList<String> accountList, ArrayList<String> cardList, ArrayList<String> categoryList, String periodFrom, String periodTo, String groupBy, String lang) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.accountList = accountList;
        this.cardList = cardList;
        this.categoryList = categoryList;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.groupBy = groupBy;
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

    public ArrayList<String> getAccountList() {
        return accountList;
    }

    public ArrayList<String> getCardList() {
        return cardList;
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public String getLang() {
        return lang;
    }
}
