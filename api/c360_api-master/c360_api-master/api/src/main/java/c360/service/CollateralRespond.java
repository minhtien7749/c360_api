package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.model.*;
import c360.database.*;

public class CollateralRespond {
    public static ArrayList<Collateral> getRespond(InputRequestRetail request) {
        ArrayList<Collateral> collaterals = new ArrayList<>();
        String sql = "SELECT owner_cif , colla_id_group_name , sum(cast(colla_amt AS DECIMAL)) AS gt_tsdb\n" +
                "FROM customer360.c360_cus_los_colla_dtls cclcd \n" +
                "WHERE cob_dt = (SELECT MAX(COB_DT) FROM customer360.ETL_PROCESS_LOG epl WHERE job_name = 'c360_cus_los_colla_dtls' and process_sts = 'S' and clean_sts = '0') and owner_cif = ? \n" +
                "GROUP BY owner_cif , colla_id_group_name ;";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            Connection c = jdbc.getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1,request.getCif());
            ResultSet rc = stm.executeQuery();
            while (rc.next()){
                String owner_cif = rc.getString("owner_cif");
                String colla_id_group_name = rc.getString("colla_id_group_name");
                BigDecimal gt_tsdb = rc.getBigDecimal("gt_tsdb");
                collaterals.add(new Collateral(owner_cif, colla_id_group_name, gt_tsdb));
            }
            c.close();
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

        return collaterals;
    }
}