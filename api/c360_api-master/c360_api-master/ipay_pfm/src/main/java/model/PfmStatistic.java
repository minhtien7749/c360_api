package model;

import java.math.BigDecimal;

public class PfmStatistic {
    private String customerId;
    private String type;
    private BigDecimal amount;

    public PfmStatistic(String customerId, String type, BigDecimal amount) {
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
    }


    public String getCustomerId() {
        return customerId;
    }


    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "PfmStatistic{" +
                "customerId='" + customerId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
