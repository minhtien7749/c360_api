package model;

import java.math.BigDecimal;

public class PfmStatisticView extends PfmStatistic{
    private String period;

    public PfmStatisticView(String customerId, String type, BigDecimal amount, String period) {
        super(customerId, type, amount);
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
}