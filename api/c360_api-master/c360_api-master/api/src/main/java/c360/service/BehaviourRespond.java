package c360.service;

import c360.database.*;
import c360.model.*;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;


public class BehaviourRespond {
    public static ArrayList<Behaviour> getRespond(InputRequestRetail t) {
        ArrayList<Behaviour> result = new ArrayList<Behaviour>();
        try {
//            String sql2 = String.format("select cif,invoice_category_name,hypothesis from customer360.retail_customer_behaviour where cif = '1100167775'",t.getCif());
            String sql = "select cif,invoice_category_name,hypothesis from customer360.retail_customer_behaviour where cif = ? and cob_dt = (select max(cob_dt) from customer360.ETL_PROCESS_LOG where job_name = 'retail_customer_behaviour' and process_sts = 'S' and clean_sts = '0')";
            JdbcUtil jdbc = new JdbcUtil();
            Connection c = jdbc.getConnection();
//            Statement stm = c.createStatement();
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1,t.getCif());
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                String cif = rs.getString("cif");
                String c360 = rs.getString("invoice_category_name");
                String haBehaviour = rs.getString("hypothesis");
                Behaviour b = new Behaviour(cif,c360,haBehaviour);
                result.add(b);
                }
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println("error");
        }
        return result;
    }
}