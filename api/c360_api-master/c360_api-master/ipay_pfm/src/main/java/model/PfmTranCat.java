package model;

public class PfmTranCat {
    private String customerId;
    private String categoryId;
    private String categoryName;
    private String splitCount;
    private String pid;
    private String parentPid;


    public PfmTranCat(String customerId, String categoryId, String categoryName, String splitCount, String pid, String parentPid) {
        this.customerId = customerId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.splitCount = splitCount;
        this.pid = pid;
        this.parentPid = parentPid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSplitCount() {
        return splitCount;
    }

    public String getPid() {
        return pid;
    }

    public String getParentPid() {
        return parentPid;
    }
}
