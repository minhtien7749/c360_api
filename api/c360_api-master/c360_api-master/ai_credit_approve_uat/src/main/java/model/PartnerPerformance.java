package model;

import java.math.BigDecimal;

public class PartnerPerformance {
    public PartnerPerformance(String cif, String taxid, BigDecimal b_i_5_3_64, BigDecimal b_i_5_3_65) {
        this.cif = cif;
        this.taxid = taxid;
        this.b_i_5_3_64 = b_i_5_3_64;
        this.b_i_5_3_65 = b_i_5_3_65;
    }

    String cif;
    String taxid;
    BigDecimal b_i_5_3_64;
    BigDecimal b_i_5_3_65;

    public String getCif() {
        return cif;
    }

    public String getTaxid() {
        return taxid;
    }

    public BigDecimal getB_i_5_3_64() {
        return b_i_5_3_64;
    }

    public BigDecimal getB_i_5_3_65() {
        return b_i_5_3_65;
    }
}