package c360.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.database.*;
import c360.model.*;

public class CustomerInfoRespond {
    public static ArrayList<CustomerInfo> getRespond(InputRequestRetail request) {
        ArrayList<CustomerInfo> customerInfors = new ArrayList<>();
        String sql = "select distinct A.cif_no as customer_id, A.age_bank timewithvtb, B.job_title, B.nam_khdn, C.thu_nhap, nam_khcn\n" +
                "from (\n" +
                "select * \n" +
                "from customer360.c360_retail_cus_profile_dly crcpd \n" +
                "where cif_no = ? and cob_dt = (select max(cob_dt) from customer360.ETL_PROCESS_LOG epl2 where job_name = 'c360_retail_cus_profile_dly' and process_sts = 'S' and clean_sts = '0')) A \n" +
                "left join \n" +
                "(select cif_khcn , job_title , nam_khdn, nam_khcn \n" +
                "from customer360.c360_leader_dly cld \n" +
                "where cob_dt = (select max(cob_dt) from customer360.ETL_PROCESS_LOG epl2 where job_name = 'c360_leader_dly' and process_sts = 'S' and clean_sts = '0') and cif_khcn = ?) B  on A.cif_no = B.cif_khcn\n" +
                "left join \n" +
                "(select crdt_cus_cif_nbr , sum(tot_sal_in_tc) as thu_nhap\n" +
                "from customer360.c360_pay_sal_fact cpsf \n" +
                "where cob_dt = (select max(cob_dt) from customer360.ETL_PROCESS_LOG epl2 where job_name = 'c360_pay_sal_fact' and process_sts = 'S' and clean_sts = '0') and crdt_cus_cif_nbr = ? \n" +
                "group by crdt_cus_cif_nbr) C on C.crdt_cus_cif_nbr = A.cif_no;";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            Connection c = jdbc.getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1,request.getCif());
            stm.setString(2,request.getCif());
            stm.setString(3,request.getCif());
            ResultSet rc = stm.executeQuery();
            while (rc.next()){
                String customer_id = rc.getString("customer_id");
                int timewithvtb = rc.getInt("timewithvtb");
                String job_title = rc.getString("job_title");
                String nam_khdn = rc.getString("nam_khdn");
                Double thu_nhap = rc.getDouble("thu_nhap");
                String nam_khcn = rc.getString("nam_khcn");
                customerInfors.add(new CustomerInfo(customer_id, timewithvtb, job_title,nam_khdn, thu_nhap, nam_khcn));
            }
            c.close();
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

        return customerInfors;
    }
}