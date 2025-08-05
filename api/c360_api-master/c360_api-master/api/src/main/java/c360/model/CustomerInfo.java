package c360.model;

public class CustomerInfo {
    private String customer_id;
    private int timewithvtb;
    private String job_title;
    private String nam_khdn;
    private Double thu_nhap;
    private String nam_khcn;

    public CustomerInfo(String customer_id, int timewithvtb, String job_title, String nam_khdn, Double thu_nhap, String nam_khcn) {
        this.customer_id = customer_id;
        this.timewithvtb = timewithvtb;
        this.job_title = job_title;
        this.nam_khdn = nam_khdn;
        this.thu_nhap = thu_nhap;
        this.nam_khcn = nam_khcn;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getTimewithvtb() {
        return timewithvtb;
    }

    public void setTimewithvtb(int timewithvtb) {
        this.timewithvtb = timewithvtb;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getNam_khdn() {
        return nam_khdn;
    }

    public void setNam_khdn(String nam_khdn) {
        this.nam_khdn = nam_khdn;
    }

    public Double getThu_nhap() {
        return thu_nhap;
    }

    public void setThu_nhap(Double thu_nhap) {
        this.thu_nhap = thu_nhap;
    }

    public String getNam_khcn() {
        return nam_khcn;
    }

    public void setNam_khcn(String nam_khcn) {
        this.nam_khcn = nam_khcn;
    }
}