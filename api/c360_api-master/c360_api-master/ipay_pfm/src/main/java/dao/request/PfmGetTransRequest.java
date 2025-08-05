package dao.request;

import java.util.ArrayList;

public class PfmGetTransRequest {
    private String requestId;
    private String sessionId;
    private String customerId;
    private ArrayList<String> accountList;
    private ArrayList<String> cardList;
    private ArrayList<String> categoryList;
    private String periodFrom;
    private String periodTo;
    private String periodType;
    private  String groupBy;
    private Integer pageSize;
    private Integer pageNum;
    private String lang;

    public PfmGetTransRequest(String requestId, String sessionId, String customerId, ArrayList<String> accountList, ArrayList<String> cardList, ArrayList<String> categoryList, String periodFrom, String periodTo, String periodType, String groupBy, Integer pageSize, Integer pageNum, String lang) {
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.accountList = accountList;
        this.cardList = cardList;
        this.categoryList = categoryList;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.periodType = periodType;
        this.groupBy = groupBy;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
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

    public String getPeriodType() {
        return periodType;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public String getLang() {
        return lang;
    }
}