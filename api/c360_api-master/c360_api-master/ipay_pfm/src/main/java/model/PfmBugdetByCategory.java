package model;

import java.math.BigDecimal;

public class PfmBugdetByCategory {
    private String customerId;
    private String categoryId;
    private BigDecimal amount;
    private String period;

    public PfmBugdetByCategory(String customerId, String categoryId, BigDecimal amount, String period) {
        this.customerId = customerId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.period = period;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPeriod() {
        return period;
    }
}