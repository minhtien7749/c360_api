package model;

import java.math.BigDecimal;

public class PfmStatisticCategory extends PfmStatistic {
    private String categoryId;
    private String categoryName;

    public PfmStatisticCategory(String customerId, String type, BigDecimal amount, String categoryId, String categoryName ) {
        super(customerId, type, amount);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }
}