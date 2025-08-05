package c360.model;

import java.math.BigDecimal;

public class Collateral {
    private String owner_cif;
    private String colla_id_group_name;
    private BigDecimal gt_tsdb;

    @Override
    public String toString() {
        return "Collateral{" +
                "owner_cif='" + owner_cif + '\'' +
                ", colla_id_group_name='" + colla_id_group_name + '\'' +
                ", gt_tsdb=" + gt_tsdb +
                '}';
    }

    public Collateral(String owner_cif, String colla_id_group_name, BigDecimal gt_tsdb) {
        this.owner_cif = owner_cif;
        this.colla_id_group_name = colla_id_group_name;
        this.gt_tsdb = gt_tsdb;
    }

    public String getOwner_cif() {
        return owner_cif;
    }

    public void setOwner_cif(String owner_cif) {
        this.owner_cif = owner_cif;
    }

    public String getColla_id_group_name() {
        return colla_id_group_name;
    }

    public void setColla_id_group_name(String colla_id_group_name) {
        this.colla_id_group_name = colla_id_group_name;
    }

    public BigDecimal getGt_tsdb() {
        return gt_tsdb;
    }

    public void setGt_tsdb(BigDecimal gt_tsdb) {
        this.gt_tsdb = gt_tsdb;
    }
}