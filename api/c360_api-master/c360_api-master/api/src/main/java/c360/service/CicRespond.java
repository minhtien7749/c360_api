package c360.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.model.*;
import c360.database.*;

public class CicRespond {
    public static ArrayList<Cic> getRespond(InputRequestRetail request) {
        ArrayList<Cic> cics = new ArrayList<>();
        String sql = "select * \n" +
                "from customer360.m5s01_cic_data\n" +
                "where cif = ? and update_dt = (select max(update_dt) from customer360.m5s01_cic_data where cif = ?  )";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            Connection c = jdbc.getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1,request.getCif());
            stm.setString(2,request.getCif());
            ResultSet rc = stm.executeQuery();
            while (rc.next()){
                String cif = rc.getString("cif");
                String cust_name = rc.getString("cust_name");
                String cic_code = rc.getString("cic_code");
                String id_code = rc.getString("id_code");
                String address = rc.getString("address");
                String credit_at_bank = rc.getString("credit_at_bank");
                String current_outstanding = rc.getString("current_outstanding");
                String current_group_debt = rc.getString("current_group_debt");
                String bad_debt_12m = rc.getString("bad_debt_12m");
                int collateral_value = rc.getInt("collateral_value");
                String credit_card_at_bank = rc.getString("credit_card_at_bank");
                String credit_card_limit = rc.getString("credit_card_limit");
                String credit_card_late_payment_12m = rc.getString("credit_card_late_payment_12m");
                int credit_score = rc.getInt("credit_score");
                String file_name = rc.getString("file_name");
                String update_dt = rc.getString("update_dt");
                String cob_dt = rc.getString("cob_dt");
                cics.add(new Cic(cif,cust_name,cic_code,id_code,address,credit_at_bank,current_outstanding,current_group_debt,bad_debt_12m,collateral_value,credit_card_at_bank,credit_card_limit,credit_card_late_payment_12m,credit_score,file_name,update_dt,cob_dt));
            }
            c.close();
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

        return cics;
    }
}
