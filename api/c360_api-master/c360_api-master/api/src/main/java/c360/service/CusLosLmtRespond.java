package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import c360.model.*;
import c360.database.*;
import c360.service.*;
import dao.response.Response;


public class CusLosLmtRespond {
    public static ArrayList<CustomerLosLmt> getRespond(InputRequestCorporate request) {
        ArrayList<CustomerLosLmt> cusloslmts = new ArrayList<>();
        String sql = "select * from customer360.c360_cus_los_lmt_fact %s";
        String sqlBranch  = "select * from customer360.c360_cus_los_lmt_fact %s";
        String cifName = "cus_cif_nbr";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_cus_los_lmt_fact");
            Connection c = jdbc.getConnection();
            boolean hasGroupBy = false;
            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
            ResultSet rc = stm.executeQuery();
            while (rc.next()){
                String pri_brnch_cd = rc.getString("pri_brnch_cd");
                String pri_brnch_nm = rc.getString("pri_brnch_nm");
                String area_cd = rc.getString("area_cd");
                String area_dsc = rc.getString("area_dsc");
                String cus_cif_nbr = rc.getString("cus_cif_nbr");
                BigDecimal total_lmt = rc.getBigDecimal("total_lmt");
                BigDecimal cus_lmt_to_core = rc.getBigDecimal("cus_lmt_to_core");
                BigDecimal ex_crdt_lmt = rc.getBigDecimal("ex_crdt_lmt");
                BigDecimal loan_lmt = rc.getBigDecimal("loan_lmt");
                BigDecimal disbur_lmt = rc.getBigDecimal("disbur_lmt");
                BigDecimal mid_long_lmt = rc.getBigDecimal("mid_long_lmt");
                BigDecimal guarant_lmt = rc.getBigDecimal("guarant_lmt");
                BigDecimal lc_lmt = rc.getBigDecimal("lc_lmt");
                BigDecimal factoring_lmt = rc.getBigDecimal("factoring_lmt");
                BigDecimal disct_lmt = rc.getBigDecimal("disct_lmt");
                BigDecimal crdt_crd_lmt = rc.getBigDecimal("crdt_crd_lmt");
                BigDecimal treasury_lmt = rc.getBigDecimal("treasury_lmt");
                String crcd = rc.getString("crcd");
                String exp_dt = rc.getString("exp_dt");
                String cob_dt = rc.getString("cob_dt");
                cusloslmts.add(new CustomerLosLmt(pri_brnch_cd,pri_brnch_nm,area_cd,area_dsc,cus_cif_nbr,total_lmt,cus_lmt_to_core,ex_crdt_lmt,
                        loan_lmt,disbur_lmt,mid_long_lmt,guarant_lmt,lc_lmt,factoring_lmt,disct_lmt,crdt_crd_lmt,treasury_lmt,crcd,exp_dt,cob_dt));
            }
            c.close();

        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        for (CustomerLosLmt cus : cusloslmts){
            System.out.println(cus.toString());
        }
        return cusloslmts;

    }

    public static void main(String[] args) {
        InputRequestCorporate request = new InputRequestCorporate("1","1","1","300069577","2022-01-01",null,null,null);
        ArrayList<CustomerLosLmt> a = getRespond(request);
    }
}