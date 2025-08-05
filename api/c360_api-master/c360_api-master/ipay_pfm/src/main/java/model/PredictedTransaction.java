package model;

import java.math.BigDecimal;

public class PredictedTransaction {
    String customerId;
    BigDecimal amount;
    String category;
    String productType;
    String benAcn;
    String benCid;
    String predictDate ;
    String dueDays;

    public PredictedTransaction(String customerId, BigDecimal amount, String category, String productType, String benAcn, String benCid, String predictDate, String dueDays) {
        this.customerId = customerId;
        this.amount = amount;
        this.category = category;
        this.productType = productType;
        this.benAcn = benAcn;
        this.benCid = benCid;
        this.predictDate = predictDate;
        this.dueDays = dueDays;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getProductType() {
        return productType;
    }

    public String getBenAcn() {
        return benAcn;
    }

    public String getBenCid() {
        return benCid;
    }

    public String getPredictDate() {
        return predictDate;
    }

    public String getDueDays() {
        return dueDays;
    }
}

