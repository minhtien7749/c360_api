package c360.service;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import c360.model.*;
import c360.database.*;
import c360.service.SqlQuery;

public class CustomerStatisticRespond {
    public static ArrayList<CustomerStatistic> getRespondBranch(InputRequestCorporate request){
       ArrayList<CustomerStatistic> customers = new ArrayList<CustomerStatistic>();
        String sql = "select \n" +
                "\tcif_no,\n" +
                "\t-- branch varchar,\n" +
                "\tsum(cast(dly_shrtrm_ln_avg_bal_amt as double))*1e6  dly_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_shrtrm_ln_avg_bal_amt as double))*1e6  mtd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_shrtrm_ln_avg_bal_amt as double))*1e6  qtd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_shrtrm_ln_avg_bal_amt as double))*1e6  ytd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_lngtrm_ln_avg_bal_amt as double))*1e6  dly_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_lngtrm_ln_avg_bal_amt as double))*1e6 mtd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_lngtrm_ln_avg_bal_amt as double))*1e6 qtd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_lngtrm_ln_avg_bal_amt as double))*1e6 ytd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_bond_ln_avg_bal_amt as double))*1e6 dly_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_bond_ln_avg_bal_amt as double))*1e6 mtd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_bond_ln_avg_bal_amt as double))*1e6 qtd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_bond_ln_avg_bal_amt as double))*1e6 ytd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_loan_bal_amt as double))*1e6 dly_loan_bal_amt,\n" +
                "\tsum(cast(mtd_loan_avg_bal_amt as double))*1e6 mtd_loan_avg_bal_amt,\n" +
                "\tsum(cast(qtd_loan_avg_bal_amt as double))*1e6 qtd_loan_avg_bal_amt,\n" +
                "\tsum(cast(ytd_loan_avg_bal_amt as double))*1e6 ytd_loan_avg_bal_amt,\n" +
                "\tsum(cast(dly_depst_bal_amt as double))*1e6 dly_depst_bal_amt,\n" +
                "\tsum(cast(mtd_depst_avg_bal_amt as double))*1e6 mtd_depst_avg_bal_amt,\n" +
                "\tsum(cast(qtd_depst_avg_bal_amt as double))*1e6 qtd_depst_avg_bal_amt,\n" +
                "\tsum(cast(ytd_depst_avg_bal_amt as double))*1e6 ytd_depst_avg_bal_amt,\n" +
                "\tsum(cast(dly_tdepst_bal_amt as double))*1e6 dly_tdepst_bal_amt,\n" +
                "\tsum(cast(mtd_tdepst_avg_bal_amt as double))*1e6  mtd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(qtd_tdepst_avg_bal_amt as double))*1e6 qtd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(ytd_tdepst_avg_bal_amt as double))*1e6 ytd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(dly_casa_bal_amt as double))*1e6 dly_casa_bal_amt,\n" +
                "\tsum(cast(mtd_casa_avg_bal_amt as double))*1e6 mtd_casa_avg_bal_amt,\n" +
                "\tsum(cast(qtd_casa_avg_bal_amt as double))*1e6 qtd_casa_avg_bal_amt,\n" +
                "\tsum(cast(ytd_casa_avg_bal_amt as double))*1e6 ytd_casa_avg_bal_amt,\n" +
                "\tmax(cast(loan_clsfy as double)) loan_clsfy,\n" +
                "\tsum(cast(ytd_fx_sale_amt as double))*1e6 ytd_fx_sale_amt,\n" +
                "\tsum(cast(ytd_fx_buy_amt as double))*1e6 ytd_fx_buy_amt,\n" +
                "\tsum(prncpl_chrg_off_shrtrm_amt)*1e6 as prncpl_chrg_off_shrtrm_amt , \n" +
                "sum(prncpl_chrg_off_lngtrm_amt)*1e6 as prncpl_chrg_off_lngtrm_amt , \n" +
                "sum(intrst_chrg_off_shrtrm_amt)*1e6 intrst_chrg_off_shrtrm_amt , \n" +
                "sum(intrst_chrg_off_lngtrm_amt)*1e6 intrst_chrg_off_lngtrm_amt,\n" +
                "sum(ytd_prncpl_chrg_off_shrtrm_amt)*1e6 ytd_prncpl_chrg_off_shrtrm_amt , \n" +
                "sum(ytd_prncpl_chrg_off_lngtrm_amt)*1e6 ytd_prncpl_chrg_off_lngtrm_amt ,\n" +
                "sum(ytd_prncpl_chrg_off_bond_amt )*1e6 ytd_prncpl_chrg_off_bond_amt , \n" +
                "sum(ytd_prncpl_chrg_off_amt )*1e6 ytd_prncpl_chrg_off_amt ,\n" +
                "sum(ytd_intrst_chrg_off_shrtrm_amt)*1e6 ytd_intrst_chrg_off_shrtrm_amt,\n" +
                "sum(ytd_intrst_chrg_off_lngtrm_amt)*1e6 ytd_intrst_chrg_off_lngtrm_amt,\n" +
                "sum(ytd_intrst_chrg_off_bond_amt)*1e6 ytd_intrst_chrg_off_bond_amt,\n" +
                "sum(ytd_intrst_chrg_off_amt)*1e6 ytd_intrst_chrg_off_amt,\n" +
                "\tcob_dt \n" +
                "from customer360.fact_customer_summary_statistic %s ";
        String sqlBranch = "select \n" +
                "\tcif_no,\n" +
                "\tbranch,\n" +
                "\tsum(cast(dly_shrtrm_ln_avg_bal_amt as double))*1e6 dly_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_shrtrm_ln_avg_bal_amt as double))*1e6  mtd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_shrtrm_ln_avg_bal_amt as double))*1e6  qtd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_shrtrm_ln_avg_bal_amt as double))*1e6  ytd_shrtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_lngtrm_ln_avg_bal_amt as double))*1e6  dly_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_lngtrm_ln_avg_bal_amt as double))*1e6 mtd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_lngtrm_ln_avg_bal_amt as double))*1e6 qtd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_lngtrm_ln_avg_bal_amt as double))*1e6 ytd_lngtrm_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_bond_ln_avg_bal_amt as double))*1e6 dly_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(mtd_bond_ln_avg_bal_amt as double))*1e6 mtd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(qtd_bond_ln_avg_bal_amt as double))*1e6 qtd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(ytd_bond_ln_avg_bal_amt as double))*1e6 ytd_bond_ln_avg_bal_amt,\n" +
                "\tsum(cast(dly_loan_bal_amt as double))*1e6 dly_loan_bal_amt,\n" +
                "\tsum(cast(mtd_loan_avg_bal_amt as double))*1e6 mtd_loan_avg_bal_amt,\n" +
                "\tsum(cast(qtd_loan_avg_bal_amt as double))*1e6 qtd_loan_avg_bal_amt,\n" +
                "\tsum(cast(ytd_loan_avg_bal_amt as double))*1e6 ytd_loan_avg_bal_amt,\n" +
                "\tsum(cast(dly_depst_bal_amt as double))*1e6 dly_depst_bal_amt,\n" +
                "\tsum(cast(mtd_depst_avg_bal_amt as double))*1e6 mtd_depst_avg_bal_amt,\n" +
                "\tsum(cast(qtd_depst_avg_bal_amt as double))*1e6 qtd_depst_avg_bal_amt,\n" +
                "\tsum(cast(ytd_depst_avg_bal_amt as double))*1e6 ytd_depst_avg_bal_amt,\n" +
                "\tsum(cast(dly_tdepst_bal_amt as double))*1e6 dly_tdepst_bal_amt,\n" +
                "\tsum(cast(mtd_tdepst_avg_bal_amt as double))*1e6  mtd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(qtd_tdepst_avg_bal_amt as double))*1e6 qtd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(ytd_tdepst_avg_bal_amt as double))*1e6 ytd_tdepst_avg_bal_amt,\n" +
                "\tsum(cast(dly_casa_bal_amt as double))*1e6 dly_casa_bal_amt,\n" +
                "\tsum(cast(mtd_casa_avg_bal_amt as double))*1e6 mtd_casa_avg_bal_amt,\n" +
                "\tsum(cast(qtd_casa_avg_bal_amt as double))*1e6 qtd_casa_avg_bal_amt,\n" +
                "\tsum(cast(ytd_casa_avg_bal_amt as double))*1e6 ytd_casa_avg_bal_amt,\n" +
                "\tmax(cast(loan_clsfy as double))*1e6 loan_clsfy,\n" +
                "\tsum(cast(ytd_fx_sale_amt as double))*1e6 ytd_fx_sale_amt,\n" +
                "\tsum(cast(ytd_fx_buy_amt as double))*1e6 ytd_fx_buy_amt,\n" +
                "\tsum(prncpl_chrg_off_shrtrm_amt)*1e6 as prncpl_chrg_off_shrtrm_amt , \n" +
                "sum(prncpl_chrg_off_lngtrm_amt)*1e6 as prncpl_chrg_off_lngtrm_amt , \n" +
                "sum(intrst_chrg_off_shrtrm_amt)*1e6 intrst_chrg_off_shrtrm_amt , \n" +
                "sum(intrst_chrg_off_lngtrm_amt)*1e6 intrst_chrg_off_lngtrm_amt,\n" +
                "sum(ytd_prncpl_chrg_off_shrtrm_amt)*1e6 ytd_prncpl_chrg_off_shrtrm_amt , \n" +
                "sum(ytd_prncpl_chrg_off_lngtrm_amt)*1e6 ytd_prncpl_chrg_off_lngtrm_amt ,\n" +
                "sum(ytd_prncpl_chrg_off_bond_amt )*1e6 ytd_prncpl_chrg_off_bond_amt , \n" +
                "sum(ytd_prncpl_chrg_off_amt )*1e6 ytd_prncpl_chrg_off_amt ,\n" +
                "sum(ytd_intrst_chrg_off_shrtrm_amt)*1e6 ytd_intrst_chrg_off_shrtrm_amt,\n" +
                "sum(ytd_intrst_chrg_off_lngtrm_amt)*1e6 ytd_intrst_chrg_off_lngtrm_amt,\n" +
                "sum(ytd_intrst_chrg_off_bond_amt)*1e6 ytd_intrst_chrg_off_bond_amt,\n" +
                "sum(ytd_intrst_chrg_off_amt)*1e6 ytd_intrst_chrg_off_amt,\n" +
                "\tcob_dt \n" +
                "from customer360.fact_customer_summary_statistic %s";
        String cifName = "cif_no";
       try {
           JdbcUtil jdbc = new JdbcUtil();
           SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "fact_customer_summary_statistic");
           Connection c = jdbc.getConnection();
           boolean hasGroupBy = true;
           PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
           ResultSet rc = stm.executeQuery();
           while (rc.next()){
               String cif_no  = rc.getString("cif_no");
               BigDecimal dly_shrtrm_ln_avg_bal_amt  = rc.getBigDecimal("dly_shrtrm_ln_avg_bal_amt");
               BigDecimal mtd_shrtrm_ln_avg_bal_amt  = rc.getBigDecimal("mtd_shrtrm_ln_avg_bal_amt");
               BigDecimal qtd_shrtrm_ln_avg_bal_amt  = rc.getBigDecimal("qtd_shrtrm_ln_avg_bal_amt");
               BigDecimal ytd_shrtrm_ln_avg_bal_amt  = rc.getBigDecimal("ytd_shrtrm_ln_avg_bal_amt");
               BigDecimal dly_lngtrm_ln_avg_bal_amt  = rc.getBigDecimal("dly_lngtrm_ln_avg_bal_amt");
               BigDecimal mtd_lngtrm_ln_avg_bal_amt  = rc.getBigDecimal("mtd_lngtrm_ln_avg_bal_amt");
               BigDecimal qtd_lngtrm_ln_avg_bal_amt  = rc.getBigDecimal("qtd_lngtrm_ln_avg_bal_amt");
               BigDecimal ytd_lngtrm_ln_avg_bal_amt  = rc.getBigDecimal("ytd_lngtrm_ln_avg_bal_amt");
               BigDecimal dly_bond_ln_avg_bal_amt  = rc.getBigDecimal("dly_bond_ln_avg_bal_amt");
               BigDecimal mtd_bond_ln_avg_bal_amt  = rc.getBigDecimal("mtd_bond_ln_avg_bal_amt");
               BigDecimal qtd_bond_ln_avg_bal_amt  = rc.getBigDecimal("qtd_bond_ln_avg_bal_amt");
               BigDecimal ytd_bond_ln_avg_bal_amt  = rc.getBigDecimal("ytd_bond_ln_avg_bal_amt");
               BigDecimal dly_loan_bal_amt  = rc.getBigDecimal("dly_loan_bal_amt");
               BigDecimal mtd_loan_avg_bal_amt  = rc.getBigDecimal("mtd_loan_avg_bal_amt");
               BigDecimal qtd_loan_avg_bal_amt  = rc.getBigDecimal("qtd_loan_avg_bal_amt");
               BigDecimal ytd_loan_avg_bal_amt  = rc.getBigDecimal("ytd_loan_avg_bal_amt");
               BigDecimal dly_depst_bal_amt  = rc.getBigDecimal("dly_depst_bal_amt");
               BigDecimal mtd_depst_avg_bal_amt  = rc.getBigDecimal("mtd_depst_avg_bal_amt");
               BigDecimal qtd_depst_avg_bal_amt  = rc.getBigDecimal("qtd_depst_avg_bal_amt");
               BigDecimal ytd_depst_avg_bal_amt  = rc.getBigDecimal("ytd_depst_avg_bal_amt");
               BigDecimal dly_tdepst_bal_amt  = rc.getBigDecimal("dly_tdepst_bal_amt");
               BigDecimal mtd_tdepst_avg_bal_amt  = rc.getBigDecimal("mtd_tdepst_avg_bal_amt");
               BigDecimal qtd_tdepst_avg_bal_amt  = rc.getBigDecimal("qtd_tdepst_avg_bal_amt");
               BigDecimal ytd_tdepst_avg_bal_amt  = rc.getBigDecimal("ytd_tdepst_avg_bal_amt");
               BigDecimal dly_casa_bal_amt  = rc.getBigDecimal("dly_casa_bal_amt");
               BigDecimal mtd_casa_avg_bal_amt  = rc.getBigDecimal("mtd_casa_avg_bal_amt");
               BigDecimal qtd_casa_avg_bal_amt  = rc.getBigDecimal("qtd_casa_avg_bal_amt");
               BigDecimal ytd_casa_avg_bal_amt  = rc.getBigDecimal("ytd_casa_avg_bal_amt");
               Double loan_clsfy  = rc.getDouble("loan_clsfy");
               BigDecimal ytd_fx_sale_amt  = rc.getBigDecimal("ytd_fx_sale_amt");
               BigDecimal ytd_fx_buy_amt  = rc.getBigDecimal("ytd_fx_buy_amt");
               BigDecimal prncpl_chrg_off_shrtrm_amt  = rc.getBigDecimal("prncpl_chrg_off_shrtrm_amt");
               BigDecimal prncpl_chrg_off_lngtrm_amt  = rc.getBigDecimal("prncpl_chrg_off_lngtrm_amt");
               BigDecimal intrst_chrg_off_shrtrm_amt  = rc.getBigDecimal("intrst_chrg_off_shrtrm_amt");
               BigDecimal intrst_chrg_off_lngtrm_amt  = rc.getBigDecimal("intrst_chrg_off_lngtrm_amt");
               BigDecimal ytd_prncpl_chrg_off_shrtrm_amt  = rc.getBigDecimal("ytd_prncpl_chrg_off_shrtrm_amt");
               BigDecimal ytd_prncpl_chrg_off_lngtrm_amt  = rc.getBigDecimal("ytd_prncpl_chrg_off_lngtrm_amt");
               BigDecimal ytd_prncpl_chrg_off_bond_amt  = rc.getBigDecimal("ytd_prncpl_chrg_off_bond_amt");
               BigDecimal ytd_prncpl_chrg_off_amt  = rc.getBigDecimal("ytd_prncpl_chrg_off_amt");
               BigDecimal ytd_intrst_chrg_off_shrtrm_amt  = rc.getBigDecimal("ytd_intrst_chrg_off_shrtrm_amt");
               BigDecimal ytd_intrst_chrg_off_lngtrm_amt  = rc.getBigDecimal("ytd_intrst_chrg_off_lngtrm_amt");
               BigDecimal ytd_intrst_chrg_off_bond_amt  = rc.getBigDecimal("ytd_intrst_chrg_off_bond_amt");
               BigDecimal ytd_intrst_chrg_off_amt  = rc.getBigDecimal("ytd_intrst_chrg_off_amt");
               String cob_dt  = rc.getString("cob_dt");
               if (request.getBranch() != null){
                   String branch  = rc.getString("branch");
                   customers.add(new CustomerStatistic(cif_no,
                       branch, dly_shrtrm_ln_avg_bal_amt, mtd_shrtrm_ln_avg_bal_amt, qtd_shrtrm_ln_avg_bal_amt, ytd_shrtrm_ln_avg_bal_amt, dly_lngtrm_ln_avg_bal_amt, mtd_lngtrm_ln_avg_bal_amt,
                       qtd_lngtrm_ln_avg_bal_amt, ytd_lngtrm_ln_avg_bal_amt, dly_bond_ln_avg_bal_amt, mtd_bond_ln_avg_bal_amt, qtd_bond_ln_avg_bal_amt, ytd_bond_ln_avg_bal_amt,
                       dly_loan_bal_amt, mtd_loan_avg_bal_amt, qtd_loan_avg_bal_amt, ytd_loan_avg_bal_amt, dly_depst_bal_amt, mtd_depst_avg_bal_amt, qtd_depst_avg_bal_amt,
                       ytd_depst_avg_bal_amt, dly_tdepst_bal_amt, mtd_tdepst_avg_bal_amt, qtd_tdepst_avg_bal_amt, ytd_tdepst_avg_bal_amt, dly_casa_bal_amt, mtd_casa_avg_bal_amt,
                       qtd_casa_avg_bal_amt, ytd_casa_avg_bal_amt, loan_clsfy, ytd_fx_sale_amt, ytd_fx_buy_amt, prncpl_chrg_off_shrtrm_amt, prncpl_chrg_off_lngtrm_amt,
                       intrst_chrg_off_shrtrm_amt, intrst_chrg_off_lngtrm_amt, ytd_prncpl_chrg_off_shrtrm_amt, ytd_prncpl_chrg_off_lngtrm_amt, ytd_prncpl_chrg_off_bond_amt, ytd_prncpl_chrg_off_amt,
                       ytd_intrst_chrg_off_shrtrm_amt, ytd_intrst_chrg_off_lngtrm_amt, ytd_intrst_chrg_off_bond_amt, ytd_intrst_chrg_off_amt, cob_dt
               ));}
               else {
                   customers.add(new CustomerStatistic(cif_no,null,
                           dly_shrtrm_ln_avg_bal_amt, mtd_shrtrm_ln_avg_bal_amt, qtd_shrtrm_ln_avg_bal_amt, ytd_shrtrm_ln_avg_bal_amt, dly_lngtrm_ln_avg_bal_amt, mtd_lngtrm_ln_avg_bal_amt,
                           qtd_lngtrm_ln_avg_bal_amt, ytd_lngtrm_ln_avg_bal_amt, dly_bond_ln_avg_bal_amt, mtd_bond_ln_avg_bal_amt, qtd_bond_ln_avg_bal_amt, ytd_bond_ln_avg_bal_amt,
                           dly_loan_bal_amt, mtd_loan_avg_bal_amt, qtd_loan_avg_bal_amt, ytd_loan_avg_bal_amt, dly_depst_bal_amt, mtd_depst_avg_bal_amt, qtd_depst_avg_bal_amt,
                           ytd_depst_avg_bal_amt, dly_tdepst_bal_amt, mtd_tdepst_avg_bal_amt, qtd_tdepst_avg_bal_amt, ytd_tdepst_avg_bal_amt, dly_casa_bal_amt, mtd_casa_avg_bal_amt,
                           qtd_casa_avg_bal_amt, ytd_casa_avg_bal_amt, loan_clsfy, ytd_fx_sale_amt, ytd_fx_buy_amt, prncpl_chrg_off_shrtrm_amt, prncpl_chrg_off_lngtrm_amt,
                           intrst_chrg_off_shrtrm_amt, intrst_chrg_off_lngtrm_amt, ytd_prncpl_chrg_off_shrtrm_amt, ytd_prncpl_chrg_off_lngtrm_amt, ytd_prncpl_chrg_off_bond_amt, ytd_prncpl_chrg_off_amt,
                           ytd_intrst_chrg_off_shrtrm_amt, ytd_intrst_chrg_off_lngtrm_amt, ytd_intrst_chrg_off_bond_amt, ytd_intrst_chrg_off_amt, cob_dt
                   ));
               }
           }
           c.close();
       } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
       System.out.println(customers.size());
       for (CustomerStatistic cus : customers){
           System.out.println(cus.toString());
       }
       return customers;
    }
    
}