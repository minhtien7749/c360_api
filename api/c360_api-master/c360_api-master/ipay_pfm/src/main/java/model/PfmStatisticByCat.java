package model;

import java.math.BigDecimal;

public class PfmStatisticByCat {
    private String customerId;
    private String categoryName;
    private BigDecimal amount;
    private String period;

    public PfmStatisticByCat(String customerId,  String categoryName, BigDecimal amount, String period) {
        this.customerId = customerId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.period = period;
    }

    public String getCustomerId() {
        return customerId;
    }



    public String getCategoryName() {
        return categoryName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPeriod() {
        return period;
    }
}