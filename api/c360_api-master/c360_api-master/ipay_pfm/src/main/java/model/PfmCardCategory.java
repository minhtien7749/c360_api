package model;

public class PfmCardCategory {
    private String customerId;
    private String accountNo;
    private String categoryId;
    private String categoryName;

    public PfmCardCategory(String customerId, String accountNo, String categoryId, String categoryName) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}