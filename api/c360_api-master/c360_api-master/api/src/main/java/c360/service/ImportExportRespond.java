package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.database.*;
import c360.model.*;
import c360.service.*;

public class ImportExportRespond {
    public static ArrayList<ImportExport> getRespond(InputRequestCorporate request) {
        ArrayList<ImportExport> importExports = new ArrayList<>();
        ArrayList<ImportExport> importExports1 = new ArrayList<>();
        String sql = "select tax_id, corp_name, acn, address ,phone,cob_dt, "
                + "sum(coalesce(mtd_import_amt_usd,0)) mtd_import_amt_usd, sum(coalesce(mtd_export_amt_usd,0)) mtd_export_amt_usd,sum(coalesce(ytd_total_import_amt_usd,0)) ytd_total_import_amt_usd ,"
                + " sum(coalesce(ytd_total_exp_amt_usd,0)) ytd_total_exp_amt_usd \n" +
                "from customer360.c360_bcl_cor_imp_exp %s group by tax_id, corp_name, acn, address ,phone, cob_dt";
        String sqlBranch = "select *\n" +
                "from customer360.c360_bcl_cor_imp_exp %s ";
        String cifName = "";
        if (request.getCif() != null){
            cifName = "acn";
        } else {cifName = "tax_id";}


        try {
            JdbcUtil jdbc = new JdbcUtil();
            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_bcl_cor_imp_exp");
            Connection c = jdbc.getConnection();
            boolean hasGroupBy = false;
            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
            ResultSet rc = stm.executeQuery();
            BigDecimal mtd_import_amt_usd = BigDecimal.valueOf(0.0);
            BigDecimal mtd_export_amt_usd = BigDecimal.valueOf(0.0);
            BigDecimal ytd_total_import_amt_usd = BigDecimal.valueOf(0.0);
            BigDecimal ytd_total_exp_amt_usd = BigDecimal.valueOf(0.0);
            String tax_id = null;
            String branch = null;
            String acn = null;
            String corp_name = null;
            String address = null;
            String phone = null;
            String cob_dt = null;
            System.out.print("1");
            while (rc.next()){
                tax_id = rc.getString ("tax_id");
                if (request.getBranch() != null) {
                	branch = rc.getString ("branch");
                }
                acn = rc.getString ("acn");
                corp_name = rc.getString ("corp_name");
                address = rc.getString ("address");
                phone = rc.getString ("phone");
                BigDecimal mtd_import_amt_usd1 = rc.getBigDecimal ("mtd_import_amt_usd");
                BigDecimal mtd_export_amt_usd1 = rc.getBigDecimal ("mtd_export_amt_usd");
                BigDecimal ytd_total_import_amt_usd1 = rc.getBigDecimal ("ytd_total_import_amt_usd");
                BigDecimal ytd_total_exp_amt_usd1 = rc.getBigDecimal ("ytd_total_exp_amt_usd");
                mtd_import_amt_usd = mtd_import_amt_usd.add(mtd_import_amt_usd1);
                mtd_export_amt_usd = mtd_export_amt_usd.add(mtd_export_amt_usd1);
                ytd_total_import_amt_usd = ytd_total_import_amt_usd.add(ytd_total_import_amt_usd1);
                ytd_total_exp_amt_usd = ytd_total_exp_amt_usd.add(ytd_total_exp_amt_usd1);
                cob_dt = rc.getString ("cob_dt");
                importExports.add(new ImportExport(tax_id,branch,acn,corp_name,address,phone,mtd_import_amt_usd1,mtd_export_amt_usd1,
                        ytd_total_import_amt_usd1,ytd_total_exp_amt_usd1,cob_dt));} 
            
            
            System.out.print("1");
            c.close(); 
        }
        
        catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        for (ImportExport cus : importExports){
            System.out.println(cus.toString());
        }
       
        	return importExports;
        

    }

    public static void main(String[] args) {
        InputRequestCorporate request = new InputRequestCorporate("1","1","1",null,"2022-01-01",null,null,null, "123456");
        ArrayList<ImportExport> a = getRespond(request);
    }


}