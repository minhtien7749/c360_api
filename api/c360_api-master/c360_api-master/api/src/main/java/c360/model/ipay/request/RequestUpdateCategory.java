package c360.model.ipay.request;


public class RequestUpdateCategory {
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
    private String channel;
    private String lastUpdate;
    private int version;

    public RequestUpdateCategory(String pid, String customerNumber, String accountNumber, String serviceCode, String chanRefNo, String hostRefNo, String tseq, String mappingId, String categoryId, String subCategoryId, String parentId, String channel, String lastUpdate, int version) {
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
        this.channel = channel;
        this.lastUpdate = lastUpdate;
        this.version = version;
    }
    public RequestUpdateCategory(){}

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getChanRefNo() {
        return chanRefNo;
    }

    public void setChanRefNo(String chanRefNo) {
        this.chanRefNo = chanRefNo;
    }

    public String getHostRefNo() {
        return hostRefNo;
    }

    public void setHostRefNo(String hostRefNo) {
        this.hostRefNo = hostRefNo;
    }

    public String getTseq() {
        return tseq;
    }

    public void setTseq(String tseq) {
        this.tseq = tseq;
    }

    public String getMappingId() {
        return mappingId;
    }

    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}