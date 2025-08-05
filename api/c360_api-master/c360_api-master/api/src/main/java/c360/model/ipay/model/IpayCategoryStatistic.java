package c360.model.ipay.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class IpayCategoryStatistic {
    private String cif;
    private String cid;
    private String inOut;
    private String categoryId;
    private String name_vi;
    private String name_en;
    private String cobDate;
    private BigDecimal amount;

    public IpayCategoryStatistic(String cif, String cid, String inOut, String categoryId, String name_vi, String name_en, String cobDate, BigDecimal amount) {
        this.cif = cif;
        this.cid = cid;
        this.inOut = inOut;
        this.categoryId = categoryId;
        this.name_vi = name_vi;
        this.name_en = name_en;
        this.cobDate = cobDate;
        this.amount = amount;
    }

    public String getCif() {
        return cif;
    }

    public String getCid() {
        return cid;
    }

    public String getInOut() {
        return inOut;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName_vi() {
        return name_vi;
    }

    public String getName_en() {
        return name_en;
    }

    public String getCobDate() {
        return cobDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "IpayCategoryStatistic{" +
                "cif='" + cif + '\'' +
                ", cid='" + cid + '\'' +
                ", inOut='" + inOut + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", name_vi='" + name_vi + '\'' +
                ", name_en='" + name_en + '\'' +
                ", cobDate='" + cobDate + '\'' +
                ", amount=" + amount +
                '}';
    }
}