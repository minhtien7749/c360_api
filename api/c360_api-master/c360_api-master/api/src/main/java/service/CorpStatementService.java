package service;

import dao.request.CustomerComplaintsRequest;
import dao.request.DepDetailRequest;
import dao.request.DepDltFactRequest;
import dao.request.LimitApprovedBalRequest;
import dao.request.LnDetailRequest;
import dao.request.LnDtlFactRequest;
import dao.request.LonStatisticRequest;
import dao.request.MoneyTransactionRequest;
import dao.request.PaySalFactRequest;
import dao.request.TaxDataRequest;
import dao.response.Response;
import dao.response.ResponseDto;
import database.JdbcUtils;
import c360.model.CustomerComplaints;
import c360.model.DepDetail;
import c360.model.DepDtlFact;
import c360.model.DepDtlFactDto;
import c360.model.LimitApprovedBal;
import c360.model.LnDetail;
import c360.model.LnDtlFact;
import c360.model.LonStatistic;
import c360.model.TaxData;
import c360.model.MoneyTransaction;
import c360.model.PaySalFact;
import query.CustomerComplaintsQuery;
import query.DepDetailQuery;
import query.DepDltFactQuery;
import query.LimitApprovedBalQuery;
import query.LnDetailQuery;
import query.LnDtlFactQuery;
import query.LonStatisticQuery;
import query.TaxDataQuery;
import query.MoneyTransactionQuery;
import query.PaySalFactQuery;

import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorpStatementService {


public static Response getMoneyTransaction(MoneyTransactionRequest request) throws KeyManagementException, NoSuchAlgorithmException{
    JdbcUtils jdbcUtils = new JdbcUtils();
    MoneyTransactionQuery query = new MoneyTransactionQuery(request);
    ArrayList<MoneyTransaction> moneyTransactions = new ArrayList();
    Connection c = null;
    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.returnSql(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());
        while (rc.next()){
        	String acn =rc.getString("acn");
        	String ofscid =rc.getString("ofscid");
        	String ofsname =rc.getString("ofsname");
        	String bank_code =rc.getString("bank_code");
        	String short_name =rc.getString("short_name");
        	String trx_type =rc.getString("trx_type");
        	String ofsbrn =rc.getString("ofsbrn");
        	String trans_type_flag =rc.getString("trans_type_flag");
        	String mtd_total_amount_transaction_lc =rc.getString("mtd_total_amount_transaction_lc");
        	String count_mtd_transaction =rc.getString("count_mtd_transaction");
        	String cob_dt =rc.getString("cob_dt");
        	moneyTransactions.add(new MoneyTransaction(acn,ofscid,ofsname,bank_code,short_name,trx_type,ofsbrn,trans_type_flag,mtd_total_amount_transaction_lc,count_mtd_transaction,cob_dt));
        }
    }
    catch (SQLException e){
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }
    return new Response(request.getRequestId(), false,"Success",null, moneyTransactions);
}

public static Response getDepDtlFact(DepDltFactRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    DepDltFactQuery query = new DepDltFactQuery(request);
    ArrayList<DepDtlFact> depDtlFact = new ArrayList<>();
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.SQLPrepareFinal(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());

        while (rc.next()) {
            String cif = rc.getString("acn");
            String ytdAvgBalAmt = rc.getString("ytdAvgBalAmt");
            String ytdAvgBalAmtTc = rc.getString("ytdAvgBalAmtTc");
            String ytdOnlAvgBalAmt = rc.getString("ytdOnlAvgBalAmt");
            String ytdOnlAvgBalAmtTc = rc.getString("ytdOnlAvgBalAmtTc");
            String dlyBalAmt = rc.getString("dlyBalAmt");
            String dlyBalAmtTc = rc.getString("dlyBalAmtTc");
            String dlyOnBalAmt = rc.getString("dlyOnBalAmt");
            String dlyOnBalAmtTc = rc.getString("dlyOnBalAmtTc");
            String qtdAvgBalAmt = rc.getString("qtdAvgBalAmt");
            String qtdAvgBalAmtTc = rc.getString("qtdAvgBalAmtTc");
            String qtdOnlAvgBalAmt = rc.getString("qtdOnlAvgBalAmt");
            String qtdOnlAvgBalAmtTc = rc.getString("qtdOnlAvgBalAmtTc");
            String ytdNiiAmt = rc.getString("ytdNiiAmt");
            String ytdNimAmt = rc.getString("ytdNimAmt");
            String cobDt = rc.getString("cob_dt");
            
            // Branch-specific logic
            String branch = (request.getBranch() != null) ? rc.getString("branch") : null;
            Map<String, String> irnGroups = new HashMap<>(); // Create a new map for each entry

            
            if (request.getIrnList() != null && !request.getIrnList().isEmpty()) { 

            	irnGroups.clear();       
            	
            	System.out.println("Processing irnGroups for CIF: " + cif + ", COB_DT: " + cobDt);
                
                for (int i = 0; i <= request.getIrnList().size(); i++) { 
                    String irnYtdKey = "irnYtdGrp" + (i + 1);
                    String irnDlyKey = "irnDlyGrp" + (i + 1);
                    
                    String irnYtdValue = rc.getString(irnYtdKey);
                    String irnDlyValue = rc.getString(irnDlyKey);
                    
                    System.out.println(irnYtdKey + " = " + irnYtdValue);
                    System.out.println(irnDlyKey + " = " + irnDlyValue);
                    
                    irnGroups.put(irnYtdKey, irnYtdValue);      
                    irnGroups.put(irnDlyKey, irnDlyValue);                 
                }                       
            	}
            System.out.println("Pass condition branch");
            // Conditional logic to add DepDtlFact based on request parameters
            	System.out.println("get grp: ");
            	System.out.println(request.getGrp());
            if (request.getBranch() == null && request.getCrcd() == null) {
                    System.out.println("It got here");
                        depDtlFact.add(new DepDtlFact(cif, null,null,ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc,ytdNimAmt, cobDt, irnGroups));
                } 
            if (request.getBranch() == null && request.getCrcd() != null) {
                    String crcd = rc.getString("crcd");
                    System.out.println("It got here crcd");
                    depDtlFact.add(new DepDtlFact(cif,null, crcd, ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc, ytdNimAmt, cobDt, irnGroups));
            } if (request.getBranch() != null && request.getCrcd() == null) {
                // Branch is not null
                    System.out.println("It got here branch");
                    depDtlFact.add(new DepDtlFact(cif, branch,null, ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc, ytdNimAmt, cobDt, irnGroups));
            } if (request.getBranch() != null && request.getCrcd() != null) {
                    String crcd = rc.getString("crcd");
                    System.out.println("It got here branch crcd");
                    depDtlFact.add(new DepDtlFact(cif, branch, crcd, ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc, ytdNimAmt, cobDt, irnGroups));
                }
            }
        
        System.out.println(depDtlFact.size());   
        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }
    
    System.out.println(depDtlFact.toString().length());
   
    return new Response(request.getRequestId(), false, "Success", null, depDtlFact);
}

public static Response getLnDltFact(LnDtlFactRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    LnDtlFactQuery query = new LnDtlFactQuery(request);
    ArrayList<LnDtlFact> LnDltFact = new ArrayList<>();
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.SQLPrepareFinal(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());

        while (rc.next()) {
            String act_nbr = rc.getString("cus_cif_nbr");
            String ytdAvgBalAmtNh = rc.getString("ytdAvgBalAmtNh");
            String dlyBalAmt = rc.getString("dlyBalAmt");
            String ytdAvgBalAmt = rc.getString("ytdAvgBalAmt");
            String ytdAvgBalAmtTh = rc.getString("ytdAvgBalAmtTh");
            String ytdAvgBalAmtDh = rc.getString("ytdAvgBalAmtDh");
            String ytdBalAmtGroup1 = rc.getString("ytdBalAmtGroup1");
            String ytdBalAmtGroup2 = rc.getString("ytdBalAmtGroup2");
            String ytdBalAmtGroup3 = rc.getString("ytdBalAmtGroup3");
            String ytdBalAmtGroup4 = rc.getString("ytdBalAmtGroup4");
            String ytdBalAmtGroup5 = rc.getString("ytdBalAmtGroup5");
            String dlyAvgBalAmtNh = rc.getString("dlyAvgBalAmtNh");
            String dlyBalAmtTh = rc.getString("dlyBalAmtTh");
            String dlyAvgBalAmtDh = rc.getString("dlyAvgBalAmtDh");
            String dlyBalAmtGroup1 = rc.getString("dlyBalAmtGroup1");
            String dlyBalAmtGroup2 = rc.getString("dlyBalAmtGroup2");
            String dlyBalAmtGroup3 = rc.getString("dlyBalAmtGroup3");
            String dlyBalAmtGroup4 = rc.getString("dlyBalAmtGroup4");
            String dlyBalAmtGroup5 = rc.getString("dlyBalAmtGroup5");
            String ytdNiiAmt = rc.getString("ytdNiiAmt");
            String ytdNiiAmtNh = rc.getString("ytdNiiAmtNh");
            String ytdNiiAmtTh = rc.getString("ytdNiiAmtTh");
            String ytdNiiAmtDh = rc.getString("ytdNiiAmtDh");
            String ytdNimAmt =  rc.getString("ytdNimAmt");
            String cobDt = rc.getString("cob_dt");

            // Branch-specific logic
            String brnch_cd = (request.getBranch() != null) ? rc.getString("brnch_cd") : null;
           
            Map<String,String> irnGroups = new HashMap<>();

            
            if (request.getIrnList() != null && !request.getIrnList().isEmpty()) {                 
            	irnGroups.clear();                 
            	for (int i = 0; i <= request.getIrnList().size(); i++) {                     
            	irnGroups.put("irnYtdGrp" + (i +1),rc.getString("irnYtdGrp" + (i + 1))); 
            	irnGroups.put("irnDlyGrp" + (i +1),rc.getString("irnDlyGrp" + (i + 1)));                 
            		}             
            	}
            System.out.println("Pass condition branch");
            // Conditional logic to add LnDltFact based on request parameters
            if (request.getBranch() == null && request.getCrcd() == null) {
                    System.out.println("It got here");
                        LnDltFact.add(new LnDtlFact( act_nbr,  null, null,dlyBalAmt, ytdAvgBalAmt,ytdAvgBalAmtNh,  ytdAvgBalAmtTh,ytdAvgBalAmtDh,  ytdBalAmtGroup1,  ytdBalAmtGroup2,  ytdBalAmtGroup3,ytdBalAmtGroup4,  ytdBalAmtGroup5,  dlyAvgBalAmtNh, dlyBalAmtTh,dlyAvgBalAmtDh,  dlyBalAmtGroup1,  dlyBalAmtGroup2,  dlyBalAmtGroup3,dlyBalAmtGroup4,  dlyBalAmtGroup5,  ytdNiiAmt, ytdNiiAmtNh, ytdNiiAmtTh, ytdNiiAmtDh, ytdNimAmt,cobDt,irnGroups));
                } 
            if (request.getBranch() == null && request.getCrcd() != null) {
                    String crcd = rc.getString("crcd");
                    System.out.println("It got here crcd");
                    LnDltFact.add(new LnDtlFact(act_nbr,  null,crcd,dlyBalAmt, ytdAvgBalAmt,  ytdAvgBalAmtNh,  ytdAvgBalAmtTh,ytdAvgBalAmtDh,  ytdBalAmtGroup1,  ytdBalAmtGroup2,  ytdBalAmtGroup3,ytdBalAmtGroup4,  ytdBalAmtGroup5,  dlyAvgBalAmtNh, dlyBalAmtTh,dlyAvgBalAmtDh,  dlyBalAmtGroup1,  dlyBalAmtGroup2,  dlyBalAmtGroup3,dlyBalAmtGroup4,  dlyBalAmtGroup5,  ytdNiiAmt, ytdNiiAmtNh, ytdNiiAmtTh, ytdNiiAmtDh, ytdNimAmt, cobDt,irnGroups));
            } 
            if (request.getBranch() != null && request.getCrcd() == null)  { 
                // Branch is not null
              
                         System.out.println("It got here branch");
                        LnDltFact.add(new LnDtlFact(act_nbr, brnch_cd,null,dlyBalAmt, ytdAvgBalAmt,  ytdAvgBalAmtNh,  ytdAvgBalAmtTh,ytdAvgBalAmtDh,  ytdBalAmtGroup1,  ytdBalAmtGroup2,  ytdBalAmtGroup3,ytdBalAmtGroup4,  ytdBalAmtGroup5,  dlyAvgBalAmtNh, dlyBalAmtTh,dlyAvgBalAmtDh,  dlyBalAmtGroup1,  dlyBalAmtGroup2,  dlyBalAmtGroup3,dlyBalAmtGroup4,  dlyBalAmtGroup5,  ytdNiiAmt, ytdNiiAmtNh, ytdNiiAmtTh, ytdNiiAmtDh, ytdNimAmt, cobDt,irnGroups));
                } 
            if (request.getBranch() != null && request.getCrcd() != null) {
                    String crcd = rc.getString("crcd");
                    System.out.println("It got here branch crcd");
                    LnDltFact.add(new LnDtlFact(act_nbr, brnch_cd,crcd, dlyBalAmt, ytdAvgBalAmt, ytdAvgBalAmtNh,  ytdAvgBalAmtTh,ytdAvgBalAmtDh,  ytdBalAmtGroup1,  ytdBalAmtGroup2,  ytdBalAmtGroup3,ytdBalAmtGroup4,  ytdBalAmtGroup5,  dlyAvgBalAmtNh, dlyBalAmtTh,dlyAvgBalAmtDh,  dlyBalAmtGroup1,  dlyBalAmtGroup2,  dlyBalAmtGroup3,dlyBalAmtGroup4,  dlyBalAmtGroup5,  ytdNiiAmt, ytdNiiAmtNh, ytdNiiAmtTh, ytdNiiAmtDh, ytdNimAmt,cobDt,irnGroups));
                }
            }
        System.out.println(LnDltFact.size());
        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }
    
    System.out.println(LnDltFact.toString().length());
   
    return new Response(request.getRequestId(), false, "Success", null, LnDltFact);
}


public static Response getTaxData(TaxDataRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    TaxDataQuery query = new TaxDataQuery(request);
    ArrayList<TaxData> taxDatas = new ArrayList<>();
    Connection c = null;

    try {
        c = jdbcUtils.getConnection();
        PreparedStatement statement = query.returnSql(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());

        while (rc.next()) {
        	String cob_dt = rc.getString("cob_dt");
        	String id = rc.getString("id");
        	String mst = rc.getString("tax_no");
        	String nguoiNopThue = rc.getString("name");
        	String cucThue = rc.getString("tax_city_dep");
        	String chiCucThue = rc.getString("tax_district_dept");
        	String soThongBaoCongKhai = rc.getString("rpt_num");
        	String rptDt = rc.getString("rpt_dt");
        	String bienPhapCuongCheDangApDung = rc.getString("apply");
        	String soTienNoThueVnd = rc.getString("tax_amt");
        	String link= rc.getString("link");
        	String status = rc.getString("status");
            taxDatas.add(new TaxData(cob_dt,id,mst,nguoiNopThue,cucThue,chiCucThue,soThongBaoCongKhai,rptDt,bienPhapCuongCheDangApDung,soTienNoThueVnd,link,status));
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, taxDatas);
}


public static Response getCustomerComplaints(CustomerComplaintsRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    CustomerComplaintsQuery query = new CustomerComplaintsQuery(request);
    ArrayList<CustomerComplaints> CustomerComplaints = new ArrayList<>();
    Connection c = null;

    try {
    	c = jdbcUtils.getConnection();
        PreparedStatement statement = query.returnSql(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());

        while (rc.next()) {
        	String stt = rc.getString("stt");
        	String thoi_gian_lien_he = rc.getString("thoi_gian_lien_he");
        	String ten_kh = rc.getString("ten_kh");
        	String tu_so = rc.getString("tu_so");
        	String cif = rc.getString("cif");
        	String yc_khieu_nai = rc.getString("yc_khieu_nai");
        	String ma_loi = rc.getString("ma_loi");
        	String contact = rc.getString("contact");
        	String atm_id = rc.getString("atm_id");
        	String so_luot_kh_phan_anh = rc.getString("so_luot_kh_phan_anh");
        	String nghiep_vu = rc.getString("nghiep_vu");
        	String nghiep_vu_chi_tiet = rc.getString("nghiep_vu_chi_tiet");
        	String kenh_gd = rc.getString("kenh_gd");
        	String doi_tuong = rc.getString("doi_tuong");
        	String phan_loai_don_vi_giai_quyet = rc.getString("phan_loai_don_vi_giai_quyet");
        	String don_vi_giai_quyet_cn = rc.getString("don_vi_giai_quyet_cn");
        	String don_vi_giai_quyet_cap_2_pgd = rc.getString("don_vi_giai_quyet_cap_2_pgd");
        	String nguyen_nhan = rc.getString("nguyen_nhan");
        	String ket_qua = rc.getString("ket_qua");
        	String phan_loai_nguyen_nhan = rc.getString("phan_loai_nguyen_nhan");
        	String note = rc.getString("note");
        	String ngay_bat_dau = rc.getString("ngay_bat_dau");
        	String ngay_ket_thuc = rc.getString("ngay_ket_thuc");
        	String phan_loai_kh = rc.getString("phan_loai_kh");
        	String cob_dt = rc.getString("cob_dt");
            CustomerComplaints.add(new CustomerComplaints(stt,thoi_gian_lien_he,ten_kh,tu_so,cif,yc_khieu_nai,ma_loi,contact,atm_id,so_luot_kh_phan_anh,nghiep_vu,nghiep_vu_chi_tiet,kenh_gd,doi_tuong,phan_loai_don_vi_giai_quyet,don_vi_giai_quyet_cn,don_vi_giai_quyet_cap_2_pgd,nguyen_nhan,ket_qua,phan_loai_nguyen_nhan,note,ngay_bat_dau,ngay_ket_thuc,phan_loai_kh,cob_dt));
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, CustomerComplaints);
}

public static Response getDepDetail(DepDetailRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    DepDetailQuery query = new DepDetailQuery(request);
    System.out.println("get query sc");

    ArrayList<DepDetail> depDetails = new ArrayList<>();
    System.out.println("get array sc");
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.returnSql(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());
        System.out.println("get Connection sc");
        while (rc.next()) {
       	     String cifNo = rc.getString("acn"); 
        	 String acctNo = rc.getString("cid"); 
        	 String crcd = rc.getString("crcd"); 
        	 String grp = rc.getString("grp"); 
        	 String intrstRate = rc.getString("irn");
        	 String mdt = rc.getString("mdt");
        	 String odt = rc.getString("odt");
        	 String trm = rc.getString("trm"); 
        	 String type = rc.getString("type");
        	 String dlyBalAmt = rc.getString("dly_ldgr_bal_amt_in_lc");
        	 String dlyBalAmtTc = rc.getString("dly_ldgr_bal_amt_in_tc");
        	 String mtdAcctAvgBal = rc.getString("mtd_avg_ldgr_bal_amt_in_lc");
        	 String qtdAcctAvgBal = rc.getString("qtd_avg_ldgr_bal_amt_in_lc");
        	 String ytdAcctAvgBal = rc.getString("ytd_avg_ldgr_bal_amt_in_lc");
        	 String cobDt = rc.getString("cob_dt"); 
        	depDetails.add(new DepDetail(cifNo,acctNo, crcd, grp, intrstRate, mdt, odt, trm,type, dlyBalAmt, dlyBalAmtTc, mtdAcctAvgBal, qtdAcctAvgBal, ytdAcctAvgBal, cobDt));
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, depDetails);
}

public static Response getLnDetail(LnDetailRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    LnDetailQuery query = new LnDetailQuery(request);
    System.out.println("get query sc");

    ArrayList<LnDetail> lnDetails = new ArrayList<>();
    System.out.println("get array sc");
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.returnSql(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());
        System.out.println("get Connection sc");
        while (rc.next()) {
       	     String cifNo = rc.getString("cus_cif_nbr"); 
        	 String acctNo = rc.getString("act_nbr");
        	 String boo = rc.getString("full_brnch_cd"); 
        	 String branchCd = rc.getString("brnch_cd"); 
        	 String crcd = rc.getString("crcd"); 
        	 String grp = rc.getString("loan_clsfy"); 
        	 String intrstRate = rc.getString("intrst_rate");
        	 String mdt = rc.getString("mdt");
        	 String odt = rc.getString("open_dt");
        	 String trm = rc.getString("trm"); 
        	 String dueDt = rc.getString("next_due_dt");
        	 String type = rc.getString("type");
        	 String dlyBalAmt = rc.getString("dly_ostd_bal_amt_in_lc");
        	 String dlyBalAmtTc = rc.getString("dly_ostd_bal_amt_in_tc");
        	 String mtdAcctAvgBal = rc.getString("mtd_avg_bal_amt_in_lc");
        	 String qtdAcctAvgBal = rc.getString("qtd_avg_bal_amt_in_lc");
        	 String ytdAcctAvgBal = rc.getString("ytd_avg_bal_amt_in_lc");
        	 String cobDt = rc.getString("cob_dt"); 
        	 lnDetails.add(new LnDetail( cifNo,  acctNo,  boo,  branchCd,  crcd,  grp, intrstRate,  mdt,  dueDt,  odt,  trm,  type,  dlyBalAmt, dlyBalAmtTc,  mtdAcctAvgBal,  qtdAcctAvgBal,  ytdAcctAvgBal,  cobDt));
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, lnDetails);
}

public static Response getLonStatistic(LonStatisticRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    LonStatisticQuery query = new LonStatisticQuery(request);
    ArrayList<LonStatistic> lonStatistics = new ArrayList<>();
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.SQLPrepareFinal(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());

        while (rc.next()) {
        	String cus_cif_nbr = rc.getString("cus_cif_nbr");
        	BigDecimal dly_st_ln_bal_amt = rc.getBigDecimal("dly_st_ln_bal_amt");
        	BigDecimal mtd_st_ln_avg_bal_amt = rc.getBigDecimal("mtd_st_ln_avg_bal_amt");
        	BigDecimal qtd_st_ln_avg_bal_amt = rc.getBigDecimal("qtd_st_ln_avg_bal_amt");
        	BigDecimal ytd_st_ln_avg_bal_amt = rc.getBigDecimal("ytd_st_ln_avg_bal_amt");
        	BigDecimal dly_mt_ln_bal_amt = rc.getBigDecimal("dly_mt_ln_bal_amt");
        	BigDecimal mtd_mt_ln_avg_bal_amt = rc.getBigDecimal("mtd_mt_ln_avg_bal_amt");
        	BigDecimal qtd_mt_ln_avg_bal_amt = rc.getBigDecimal("qtd_mt_ln_avg_bal_amt");
        	BigDecimal ytd_mt_ln_avg_bal_amt = rc.getBigDecimal("ytd_mt_ln_avg_bal_amt");
        	BigDecimal dly_lt_ln_bal_amt = rc.getBigDecimal("dly_lt_ln_bal_amt");
        	BigDecimal mtd_lt_ln_avg_bal_amt = rc.getBigDecimal("mtd_lt_ln_avg_bal_amt");
        	BigDecimal qtd_lt_ln_avg_bal_amt = rc.getBigDecimal("qtd_lt_ln_avg_bal_amt");
        	BigDecimal ytd_lt_ln_avg_bal_amt = rc.getBigDecimal("ytd_lt_ln_avg_bal_amt");
        	BigDecimal dly_traiphieu_avg_bal_amt = rc.getBigDecimal("dly_traiphieu_avg_bal_amt");
        	BigDecimal mtd_traiphieu_avg_bal_amt = rc.getBigDecimal("mtd_traiphieu_avg_bal_amt");
        	BigDecimal qtd_traiphieu_avg_bal_amt = rc.getBigDecimal("qtd_traiphieu_avg_bal_amt");
        	BigDecimal ytd_traiphieu_avg_bal_amt = rc.getBigDecimal("ytd_traiphieu_avg_bal_amt");
        	BigDecimal dly_loan_bal_amt = rc.getBigDecimal("dly_loan_bal_amt");
        	BigDecimal mtd_loan_avg_bal_amt = rc.getBigDecimal("mtd_loan_avg_bal_amt");
        	BigDecimal qtd_loan_avg_bal_amt = rc.getBigDecimal("qtd_loan_avg_bal_amt");
        	BigDecimal ytd_loan_avg_bal_amt = rc.getBigDecimal("ytd_loan_avg_bal_amt");
        	BigDecimal ytd_prncpl_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_shrtrm_amt");
        	BigDecimal ytd_prncpl_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_mttrm_amt");
        	BigDecimal ytd_prncpl_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_lngtrm_amt");
        	BigDecimal ytd_intrst_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_shrtrm_amt");
        	BigDecimal ytd_intrst_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_mttrm_amt");
        	BigDecimal ytd_intrst_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_intrst_chrg_off_lngtrm_amt");
        	BigDecimal ytd_ltchrg_chrg_off_shrtrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_shrtrm_amt");
        	BigDecimal ytd_ltchrg_chrg_off_mttrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_mttrm_amt");
        	BigDecimal ytd_ltchrg_chrg_off_lngtrm_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_lngtrm_amt");
        	BigDecimal ytd_prncpl_chrg_off_bond_amt = rc.getBigDecimal("ytd_prncpl_chrg_off_bond_amt");
        	BigDecimal ytd_intrst_chrg_off_bond_amt = rc.getBigDecimal("ytd_intrst_chrg_off_bond_amt");
        	BigDecimal ytd_ltchrg_chrg_off_bond_amt = rc.getBigDecimal("ytd_ltchrg_chrg_off_bond_amt");
        	BigDecimal dly_nii_st_ln_amt_in_lc = rc.getBigDecimal("dly_nii_st_ln_amt_in_lc");
        	BigDecimal mtd_nii_st_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_st_ln_amt_in_lc");
        	BigDecimal qtd_nii_st_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_st_ln_amt_in_lc");
        	BigDecimal ytd_nii_st_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_st_ln_amt_in_lc");
        	BigDecimal dly_nii_mt_ln_amt_in_lc = rc.getBigDecimal("dly_nii_mt_ln_amt_in_lc");
        	BigDecimal mtd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_mt_ln_amt_in_lc");
        	BigDecimal qtd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_mt_ln_amt_in_lc");
        	BigDecimal ytd_nii_mt_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_mt_ln_amt_in_lc");
        	BigDecimal dly_nii_lt_ln_amt_in_lc = rc.getBigDecimal("dly_nii_lt_ln_amt_in_lc");
        	BigDecimal mtd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("mtd_nii_lt_ln_amt_in_lc");
        	BigDecimal qtd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("qtd_nii_lt_ln_amt_in_lc");
        	BigDecimal ytd_nii_lt_ln_amt_in_lc = rc.getBigDecimal("ytd_nii_lt_ln_amt_in_lc");
        	BigDecimal dly_nii_traiphieu_amt = rc.getBigDecimal("dly_nii_traiphieu_amt");
        	BigDecimal mtd_nii_traiphieu_amt = rc.getBigDecimal("mtd_nii_traiphieu_amt");
        	BigDecimal qtd_nii_traiphieu_amt = rc.getBigDecimal("qtd_nii_traiphieu_amt");
        	BigDecimal ytd_nii_traiphieu_amt = rc.getBigDecimal("ytd_nii_traiphieu_amt");
        	BigDecimal ytd_overdue_cnt = rc.getBigDecimal("ytd_overdue_cnt");
        	String cobDt = rc.getString("cob_dt");
            // Branch-specific logic
            String brnch_cd = (request.getBranch() != null) ? rc.getString("brnch_cd") : null;
            if (request.getBranch() != null){
                String branch  = rc.getString("branch");
                System.out.println("Success");
                lonStatistics.add(new LonStatistic(cus_cif_nbr,branch,dly_st_ln_bal_amt,mtd_st_ln_avg_bal_amt,qtd_st_ln_avg_bal_amt,ytd_st_ln_avg_bal_amt,dly_mt_ln_bal_amt,mtd_mt_ln_avg_bal_amt,qtd_mt_ln_avg_bal_amt,ytd_mt_ln_avg_bal_amt,dly_lt_ln_bal_amt,mtd_lt_ln_avg_bal_amt,qtd_lt_ln_avg_bal_amt,ytd_lt_ln_avg_bal_amt,dly_traiphieu_avg_bal_amt,mtd_traiphieu_avg_bal_amt,qtd_traiphieu_avg_bal_amt,ytd_traiphieu_avg_bal_amt,dly_loan_bal_amt,mtd_loan_avg_bal_amt,qtd_loan_avg_bal_amt,ytd_loan_avg_bal_amt,ytd_prncpl_chrg_off_shrtrm_amt,ytd_prncpl_chrg_off_mttrm_amt,ytd_prncpl_chrg_off_lngtrm_amt,ytd_intrst_chrg_off_shrtrm_amt,ytd_intrst_chrg_off_mttrm_amt,ytd_intrst_chrg_off_lngtrm_amt,ytd_ltchrg_chrg_off_shrtrm_amt,ytd_ltchrg_chrg_off_mttrm_amt,ytd_ltchrg_chrg_off_lngtrm_amt,ytd_prncpl_chrg_off_bond_amt,ytd_intrst_chrg_off_bond_amt,ytd_ltchrg_chrg_off_bond_amt,dly_nii_st_ln_amt_in_lc,mtd_nii_st_ln_amt_in_lc,qtd_nii_st_ln_amt_in_lc,ytd_nii_st_ln_amt_in_lc,dly_nii_mt_ln_amt_in_lc,mtd_nii_mt_ln_amt_in_lc,qtd_nii_mt_ln_amt_in_lc,ytd_nii_mt_ln_amt_in_lc,dly_nii_lt_ln_amt_in_lc,mtd_nii_lt_ln_amt_in_lc,qtd_nii_lt_ln_amt_in_lc,ytd_nii_lt_ln_amt_in_lc,dly_nii_traiphieu_amt,mtd_nii_traiphieu_amt,qtd_nii_traiphieu_amt,ytd_nii_traiphieu_amt,ytd_overdue_cnt,cobDt));
            }
            else {
            	lonStatistics.add(new LonStatistic(cus_cif_nbr,null,dly_st_ln_bal_amt,mtd_st_ln_avg_bal_amt,qtd_st_ln_avg_bal_amt,ytd_st_ln_avg_bal_amt,dly_mt_ln_bal_amt,mtd_mt_ln_avg_bal_amt,qtd_mt_ln_avg_bal_amt,ytd_mt_ln_avg_bal_amt,dly_lt_ln_bal_amt,mtd_lt_ln_avg_bal_amt,qtd_lt_ln_avg_bal_amt,ytd_lt_ln_avg_bal_amt,dly_traiphieu_avg_bal_amt,mtd_traiphieu_avg_bal_amt,qtd_traiphieu_avg_bal_amt,ytd_traiphieu_avg_bal_amt,dly_loan_bal_amt,mtd_loan_avg_bal_amt,qtd_loan_avg_bal_amt,ytd_loan_avg_bal_amt,ytd_prncpl_chrg_off_shrtrm_amt,ytd_prncpl_chrg_off_mttrm_amt,ytd_prncpl_chrg_off_lngtrm_amt,ytd_intrst_chrg_off_shrtrm_amt,ytd_intrst_chrg_off_mttrm_amt,ytd_intrst_chrg_off_lngtrm_amt,ytd_ltchrg_chrg_off_shrtrm_amt,ytd_ltchrg_chrg_off_mttrm_amt,ytd_ltchrg_chrg_off_lngtrm_amt,ytd_prncpl_chrg_off_bond_amt,ytd_intrst_chrg_off_bond_amt,ytd_ltchrg_chrg_off_bond_amt,dly_nii_st_ln_amt_in_lc,mtd_nii_st_ln_amt_in_lc,qtd_nii_st_ln_amt_in_lc,ytd_nii_st_ln_amt_in_lc,dly_nii_mt_ln_amt_in_lc,mtd_nii_mt_ln_amt_in_lc,qtd_nii_mt_ln_amt_in_lc,ytd_nii_mt_ln_amt_in_lc,dly_nii_lt_ln_amt_in_lc,mtd_nii_lt_ln_amt_in_lc,qtd_nii_lt_ln_amt_in_lc,ytd_nii_lt_ln_amt_in_lc,dly_nii_traiphieu_amt,mtd_nii_traiphieu_amt,qtd_nii_traiphieu_amt,ytd_nii_traiphieu_amt,ytd_overdue_cnt,cobDt));
            }
            
            }
        System.out.println(lonStatistics.size());
        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }
    
   
    return new Response(request.getRequestId(), false, "Success", null, lonStatistics);
}

public static Response getPaySalFact(PaySalFactRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    PaySalFactQuery query = new PaySalFactQuery(request);
    System.out.println("get query sc");

    ArrayList<PaySalFact> paysalfact = new ArrayList<>();
    System.out.println("get array sc");
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.SQLPrepareFinal(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());
        System.out.println("get Connection sc");
        while (rc.next()) {
        	 String cif = rc.getString("debt_cus_cif_nbr");
        	 BigDecimal totAmt = rc.getBigDecimal("tot_sal_in_lc"); 
        	 BigDecimal amtChiLuongOut = rc.getBigDecimal("tot_sal_in_lc_nht"); 
        	 BigDecimal amtChiLuongIn = rc.getBigDecimal("tot_sal_in_lc_tht"); 
        	 String countKh = rc.getString("sl_cbnv_nhan_luong"); 
        	 String countCbnvOut = rc.getString("sl_cbnv_nhan_luong_nht");
        	 String countCbnvIn = rc.getString("sl_cbnv_nhan_luong_tht");
        	 String slGd = rc.getString("slgd_luy_ke");
        	 String cobDt = rc.getString("cob_dt");
        	 
        	 if (request.getBranch() != null) {
           	     String branch = rc.getString("debt_pri_brnch_cd"); 
            	 paysalfact.add(new PaySalFact(branch, cif,  totAmt, amtChiLuongOut,
            			 amtChiLuongIn, countKh, countCbnvOut,countCbnvIn,
            			 slGd, cobDt)); 
        	 }
        	 if (request.getBranch() == null) {
            	 paysalfact.add(new PaySalFact(null, cif,  totAmt,  amtChiLuongOut,
            			 amtChiLuongIn, countKh, countCbnvOut,countCbnvIn,slGd, cobDt)); 
        	 }
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, paysalfact);
}

public static Response getLimitApprovedBal(LimitApprovedBalRequest request) throws NoSuchAlgorithmException, KeyManagementException {
    JdbcUtils jdbcUtils = new JdbcUtils();
    LimitApprovedBalQuery query = new LimitApprovedBalQuery(request);
    System.out.println("get query sc");

    ArrayList<LimitApprovedBal> limitApprovedBal = new ArrayList<>();
    System.out.println("get array sc");
    Connection c = null;

    try {
        c = jdbcUtils.getConnectionDoris();
        PreparedStatement statement = query.SQLPrepareFinal(c);
        ResultSet rc = statement.executeQuery();
        System.out.println(statement.toString());
        System.out.println("get Connection sc");
        Integer numPage = null;
        while (rc.next()) {
        	
        	 String cif = rc.getString("cif");
        	 String cifName = rc.getString("cif_name");
        	 String segment = rc.getString("segment");
        	 String ostdNBond = rc.getString("ostd_n_bond");
        	 BigDecimal undisbursedLoanLmt = rc.getBigDecimal("undisbursed_loan_lmt");
        	 BigDecimal cardLmt = rc.getBigDecimal("card_lmt");
        	 BigDecimal tfBal = rc.getBigDecimal("tf_bal");
        	 BigDecimal total = rc.getBigDecimal("total");
        	 String cobDt = rc.getString("cob_dt");
        	
        	 limitApprovedBal.add(new LimitApprovedBal(cif, cifName,  segment,  ostdNBond,  undisbursedLoanLmt,
        				 cardLmt, tfBal,  total,cobDt));
        	 
        }

        c.close();
    } catch (SQLException e) {
        System.out.println(e.getCause());
        System.out.println(e.getMessage());
        return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
    }

    return new Response(request.getRequestId(), false, "Success", null, limitApprovedBal);
}

}
