package model;

import java.math.BigDecimal;

public class PfmDdaTransaction {
    private String time;
    private String channel;
    private String customerId;
    private String accountNo;
    private String tseq;
    private BigDecimal amount;
    private  String zprfrefno;
    private String remark;
    private String crcd;
    private String ofsname;
    private String ofscid;
    private Integer splitTransCount;
    private String categoryId;
    private String categoryName;
    private String pid;
    private String parentPid;

    public PfmDdaTransaction(String time, String channel, String customerId, String accountNo, String tseq, BigDecimal amount, String zprfrefno, String remark, String crcd, String ofsname, String ofscid, Integer splitTransCount, String categoryId, String categoryName, String pid, String parentPid) {
        this.time = time;
        this.channel = channel;
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.tseq = tseq;
        this.amount = amount;
        this.zprfrefno = zprfrefno;
        this.remark = remark;
        this.crcd = crcd;
        this.ofsname = ofsname;
        this.ofscid = ofscid;
        this.splitTransCount = splitTransCount;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.pid = pid;
        this.parentPid = parentPid;
    }

    public String getTime() {
        return time;
    }

    public String getChannel() {
        return channel;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getTseq() {
        return tseq;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getZprfrefno() {
        return zprfrefno;
    }

    public String getRemark() {
        return remark;
    }

    public String getCrcd() {
        return crcd;
    }

    public String getOfsname() {
        return ofsname;
    }

    public String getOfscid() {
        return ofscid;
    }

    public Integer getSplitTransCount() {
        return splitTransCount;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getPid() {
        return pid;
    }

    public String getParentPid() {
        return parentPid;
    }
}