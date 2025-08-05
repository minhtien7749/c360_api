package c360.model.ipay.model;

import java.math.BigDecimal;

public class Category {
    private String pid;
    private String customerNumber;
    private String accountNumber;
    private String serviceCode;
    private String chanRefNo;
    private String hostRefNo;
    private String tseq;
    private String mappingId;
    private String categoryId;
    private String subCategoryId;
    private String parentId;
    private BigDecimal amount;
    private String channel;
    private String lastUpdate;
    private String version;

    public Category(String pid, String customerNumber, String accountNumber, String serviceCode, String chanRefNo, String hostRefNo, String tseq, String mappingId,
                    String categoryId, String subCategoryId, String parentId, BigDecimal amount, String channel, String lastUpdate, String version) {
        this.pid = pid;
        this.customerNumber = customerNumber;
        this.accountNumber = accountNumber;
        this.serviceCode = serviceCode;
        this.chanRefNo = chanRefNo;
        this.hostRefNo = hostRefNo;
        this.tseq = tseq;
        this.mappingId = mappingId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.parentId = parentId;
        this.amount = amount;
        this.channel = channel;
        this.lastUpdate = lastUpdate;
        this.version = version;
    }

    public String getPid() {
        return pid;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getChanRefNo() {
        return chanRefNo;
    }

    public String getHostRefNo() {
        return hostRefNo;
    }

    public String getTseq() {
        return tseq;
    }

    public String getMappingId() {
        return mappingId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public String getParentId() {
        return parentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getChannel() {
        return channel;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getVersion() {
        return version;
    }
}