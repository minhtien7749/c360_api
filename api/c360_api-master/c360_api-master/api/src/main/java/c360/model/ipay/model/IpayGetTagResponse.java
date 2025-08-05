package c360.model.ipay.model;
public class IpayGetTagResponse {
    private String customerId;
    private String accountNo;
    private String inOut;
    private String categoryId;
    private String nameEn;
    private String nameVi;
    private String pid;

    public IpayGetTagResponse( String customerId, String accountNo, String inOut, String categoryId, String name_en, String name_vi, String pid) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.inOut = inOut;
        this.categoryId = categoryId;
        this.nameEn = name_en;
        this.nameVi = name_vi;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "IpayGetTagResponse{" +
                "customerId='" + customerId + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", inOut='" + inOut + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", nameVi='" + nameVi + '\'' +
                '}';
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getInOut() {
        return inOut;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameVi() {
        return nameVi;
    }
    
    public String getPid() {
    	return pid;
    }
}