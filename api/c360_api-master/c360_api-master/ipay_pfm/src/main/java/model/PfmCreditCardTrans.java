package model;

import java.math.BigDecimal;

public class PfmCreditCardTrans {
    private String cardId;
    private String bin;
    private String cardName;
    private String cardGrp;
    private String termLocation;
    private String termCity;
    private String sicCode;
    private String docNo;
    private String cobDate;
    private BigDecimal amount;
    private String currency;
    private String categoryId;
    private String categoryName;
    private BigDecimal amountOrg;
    private String currencyOrg;
    private String shortRemark;
    private String fullRemark;
    private String accountNo;

    public PfmCreditCardTrans(String cardId, String bin, String cardName, String cardGrp, String termLocation, String termCity, String sicCode, String docNo, String cobDate, BigDecimal amount, String currency, String categoryId, String categoryName, BigDecimal amountOrg, String currencyOrg, String shortRemark, String fullRemark, String accountNo) {
        this.cardId = cardId;
        this.bin = bin;
        this.cardName = cardName;
        this.cardGrp = cardGrp;
        this.termLocation = termLocation;
        this.termCity = termCity;
        this.sicCode = sicCode;
        this.docNo = docNo;
        this.cobDate = cobDate;
        this.amount = amount;
        this.currency = currency;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.amountOrg = amountOrg;
        this.currencyOrg = currencyOrg;
        this.shortRemark = shortRemark;
        this.fullRemark = fullRemark;
        this.accountNo = accountNo;
    }

    public String getCardId() {
        return cardId;
    }

    public String getBin() {
        return bin;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardGrp() {
        return cardGrp;
    }

    public String getTermLocation() {
        return termLocation;
    }

    public String getTermCity() {
        return termCity;
    }

    public String getSicCode() {
        return sicCode;
    }

    public String getDocNo() {
        return docNo;
    }

    public String getCobDate() {
        return cobDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public BigDecimal getAmountOrg() {
        return amountOrg;
    }

    public String getCurrencyOrg() {
        return currencyOrg;
    }

    public String getShortRemark() {
        return shortRemark;
    }

    public String getFullRemark() {
        return fullRemark;
    }

    public String getAccountNo() {
        return accountNo;
    }
}