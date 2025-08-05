package model;

import java.math.BigDecimal;

public class BusLinePerfomance {
    String cif;
    String nam;
    String lv3;
    BigDecimal b_i_5_1_47_1;
    BigDecimal b_i_5_1_47_2;
    BigDecimal b_i_5_1_47_3;
    BigDecimal b_i_5_1_47_4;
    BigDecimal b_i_5_1_47_5;
    BigDecimal b_i_5_1_47_6;
    BigDecimal b_i_5_1_47_7;

    public BusLinePerfomance(String cif, String nam, String lv3, BigDecimal b_i_5_1_47_1, BigDecimal b_i_5_1_47_2, BigDecimal b_i_5_1_47_3, BigDecimal b_i_5_1_47_4, BigDecimal b_i_5_1_47_5, BigDecimal b_i_5_1_47_6, BigDecimal b_i_5_1_47_7) {
        this.cif = cif;
        this.nam = nam;
        this.lv3 = lv3;
        this.b_i_5_1_47_1 = b_i_5_1_47_1;
        this.b_i_5_1_47_2 = b_i_5_1_47_2;
        this.b_i_5_1_47_3 = b_i_5_1_47_3;
        this.b_i_5_1_47_4 = b_i_5_1_47_4;
        this.b_i_5_1_47_5 = b_i_5_1_47_5;
        this.b_i_5_1_47_6 = b_i_5_1_47_6;
        this.b_i_5_1_47_7 = b_i_5_1_47_7;
    }

    public String getCif() {
        return cif;
    }

    public String getNam() {
        return nam;
    }

    public String getLv3() {
        return lv3;
    }

    public BigDecimal getB_i_5_1_47_1() {
        return b_i_5_1_47_1;
    }

    public BigDecimal getB_i_5_1_47_2() {
        return b_i_5_1_47_2;
    }

    public BigDecimal getB_i_5_1_47_3() {
        return b_i_5_1_47_3;
    }

    public BigDecimal getB_i_5_1_47_4() {
        return b_i_5_1_47_4;
    }

    public BigDecimal getB_i_5_1_47_5() {
        return b_i_5_1_47_5;
    }

    public BigDecimal getB_i_5_1_47_6() {
        return b_i_5_1_47_6;
    }

    public BigDecimal getB_i_5_1_47_7() {
        return b_i_5_1_47_7;
    }
}