package service;
import java.time.LocalDate;
import database.JdbcUtils;
import model.AccountStatement;
import model.BusLinePerfomance;
import model.Collateral;
import model.CorporateBusLine;
import model.CorporateCustomerProfile;
import model.CreditApprove;
import model.CusRelated;
import model.Depdetail;
import model.PartnerPerformance;
import payload.request.AccountStatementRequest;
import payload.request.BusinessLineRequest;
import payload.request.CreditApprovalRequest;
import payload.request.CusProfileRequest;
import payload.request.CustomerRelationRequest;
import payload.request.DepdetailRequest;
import payload.request.PartnerPerformanceRequest;
import payload.response.Response;
import payload.response.ResponseStatement;
import query.AccountStatementQuery;
import query.BusLinePerfomanceQuery;
import query.CollateralQuery;
import query.CreditApprovalQuery;
import query.CusProfileQuery;
import query.CusRelatedQuery;
import query.CustomerBusinessLineQuery;
import query.DepdetailQuery;
import query.PartnerPerformanceQuery;

import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class AiApprovalService {
	public static Response getCorporateCustomerProfile(CusProfileRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        CusProfileQuery query = new CusProfileQuery(request);
        ArrayList<CorporateCustomerProfile> customerProfiles = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){ //b_i_2_1_1,b_i_2_2_1,b_i_2_3_1,b_i_3_2_29,b_i_3_2_29_0,b_i_3_2_30,b_i_3_2_30_0
                String categoryName = null;
                String customerId = rc.getString("cif");
                String no1 = rc.getString("no_1");
                String no4 = rc.getString("no_4");
                String no5 = rc.getString("no_5");
                String no6 = rc.getString("no_6");
                String no7 = rc.getString("no_7");
                String bi211 = rc.getString("b_i_2_1_1");
                String bi221 = rc.getString("b_i_2_2_1");
                String bi231 = rc.getString("b_i_2_3_1");
                BigDecimal b_i_3_2_29 = rc.getBigDecimal("b_i_3_2_29");
                BigDecimal b_i_3_2_29_0 = rc.getBigDecimal("b_i_3_2_29_0");
                BigDecimal b_i_3_2_30 = rc.getBigDecimal("b_i_3_2_30");
                BigDecimal b_i_3_2_30_0 = rc.getBigDecimal("b_i_3_2_30_0");
                customerProfiles.add(new CorporateCustomerProfile(customerId, no1,no4, no5,no6 ,no7,bi211,bi221,bi231,b_i_3_2_29,b_i_3_2_29_0,b_i_3_2_30,b_i_3_2_30_0));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,customerProfiles );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
	}
    public static Response getAccountStatement(AccountStatementRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        AccountStatementQuery query = new AccountStatementQuery(request);
        ArrayList<AccountStatement> accountStatements = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            int numPage = 0;
            while (rc.next()){
                String customerId = rc.getString("acn");
                String customerName = rc.getString("cus_name");
                String cid = rc.getString("cid");
                String tSeq = rc.getString("tseq");
                String dateTime = rc.getString("date_time");
                String amountLc = rc.getString("amount_lc");
                String endBalLc = rc.getString("endbal_lc");
                String tCmt = rc.getString("tcmt");
                String ofsCid = rc.getString("ofscid");
                String ofsName = rc.getString("ofsname");
                String ofsBrn = rc.getString("ofsbrn");
                String offBank = rc.getString("off_bank");
                String zPrfRefNo = rc.getString("zprfrefno");
                String standardizedOfsName = rc.getString("standardized_ofsname");
                String trxTypeLv1 = rc.getString("trx_type_lv1");
                String trxTypeLv2 = rc.getString("trx_type_lv2");
                String crCd = rc.getString("crcd");
                String cobDt = rc.getString("cob_dt");
                numPage = rc.getInt("num_page");
                accountStatements.add(new AccountStatement( customerId,customerName,cid,tSeq,dateTime,amountLc,endBalLc,tCmt,ofsCid,ofsName,ofsBrn,offBank,zPrfRefNo,standardizedOfsName,trxTypeLv1,trxTypeLv2,crCd,cobDt));
            }
            c.close();
            return new ResponseStatement(request.getRequestId(), false,"Success",null,accountStatements, numPage );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static Response getCorporateCustomerRelated(CustomerRelationRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        CusRelatedQuery query = new CusRelatedQuery(request);
        ArrayList<CusRelated> customerProfiles = new ArrayList<>();
        HashMap<String, String> map = request.convertHash();
        System.out.println("11111111");
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String cif = rc.getString("cif");
                String rel_cif = rc.getString("rel_cif");
                String oin = rc.getString("oin");
                String b_i_2_9_1 = rc.getString("b_i_2_9_1");
                String b_i_2_9_2 = rc.getString("b_i_2_9_2");
                String b_i_2_9_3 = rc.getString("b_i_2_9_3");
                BigDecimal b_i_2_9_4 = rc.getBigDecimal("b_i_2_9_4");
                int b_i_2_9_5 = rc.getInt("b_i_2_9_5");
                String b_i_2_9_5_2 = rc.getString("b_i_2_9_5_2");
                String b_i_2_9_6 = rc.getString("b_i_2_9_6");
                if (map.get(oin) != null){
                    b_i_2_9_6 = map.get(oin);
                }
                customerProfiles.add(new CusRelated(cif,rel_cif,oin,b_i_2_9_1,b_i_2_9_2,b_i_2_9_3,b_i_2_9_4,b_i_2_9_5,b_i_2_9_5_2,b_i_2_9_6));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,customerProfiles );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static  Boolean checkDate(String fromDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(fromDate,formatter);
        LocalDate toDate = LocalDate.parse(endDate,formatter);
        return (startDate.getDayOfMonth() == 1)&& (toDate.getDayOfMonth() == toDate.lengthOfMonth());
    }
    public static Response getCreditApproval(CreditApprovalRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        CreditApprovalQuery query = new CreditApprovalQuery(request);
        if (!checkDate(request.getFromDate(), request.getEndDate())){
            return new Response(request.getRequestId(),null,  "fromDate must be first day of month and endDate must be last day of month", 400, new ArrayList<>());
        }
        ArrayList<CreditApprove> creditApproves = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String customerId = rc.getString("cif");
                String cCode = rc.getString("ccode");
                BigDecimal bi3213 = rc.getBigDecimal("b_i_3_2_13");
                BigDecimal bi3214 = rc.getBigDecimal("b_i_3_2_14");
                BigDecimal bi3215 = rc.getBigDecimal("b_i_3_2_15");
                BigDecimal bi3216 = rc.getBigDecimal("b_i_3_2_16");
                BigDecimal bi3217 = rc.getBigDecimal("b_i_3_2_17");
                BigDecimal bi3218 = rc.getBigDecimal("b_i_3_2_18");
                BigDecimal bi3219 = rc.getBigDecimal("b_i_3_2_19");
                BigDecimal bi3220 = rc.getBigDecimal("b_i_3_2_20");
                BigDecimal bi3221 = rc.getBigDecimal("b_i_3_2_21");
                BigDecimal bi3222 = rc.getBigDecimal("b_i_3_2_22");
                BigDecimal bi3223 = rc.getBigDecimal("b_i_3_2_23");
                BigDecimal bi3224 = rc.getBigDecimal("b_i_3_2_24");
                BigDecimal bi3225 = rc.getBigDecimal("b_i_3_2_25");
                BigDecimal bi3226 = rc.getBigDecimal("b_i_3_2_26");
                BigDecimal bi3239 = rc.getBigDecimal("b_i_3_2_39");
                BigDecimal bi3240 = rc.getBigDecimal("b_i_3_2_40");
                BigDecimal bi3241 = rc.getBigDecimal("b_i_3_2_41");
                BigDecimal bi3242 = rc.getBigDecimal("b_i_3_2_42");
                BigDecimal bi3243 = rc.getBigDecimal("b_i_3_2_43");
                BigDecimal bi3245 = rc.getBigDecimal("b_i_3_2_45");
                creditApproves.add(new CreditApprove(customerId, cCode, bi3213 ,bi3214 ,bi3215 ,bi3216 ,bi3217 ,bi3218 ,bi3219 ,bi3220 ,bi3221 ,bi3222 ,bi3223 ,bi3224 ,bi3225 ,bi3226 ,bi3239 ,bi3240 ,bi3241 ,bi3242 ,bi3243 ,bi3245 ));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,creditApproves );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static  Response getCustomerCollateral(CusProfileRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        CollateralQuery query = new CollateralQuery(request);
        ArrayList<Collateral> collaterals = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String categoryName = null;
                //String customerId = rc.getString("cif");
                //b_i_7_2,b_i_7_3,b_i_7_4,b_i_7_5,b_i_7_6,b_i_7_7,b_i_7_8,b_i_7_9,b_i_7_10,b_i_7_11
                String b_i_7_2 = rc.getString("b_i_7_2");
                String b_i_7_3 = rc.getString("b_i_7_3");
                String b_i_7_4 = rc.getString("b_i_7_4");
                String b_i_7_5 = rc.getString("b_i_7_5");
                String b_i_7_6 = rc.getString("b_i_7_6");
                BigDecimal b_i_7_7 = rc.getBigDecimal("b_i_7_7");
                BigDecimal b_i_7_8 = rc.getBigDecimal("b_i_7_8");
                BigDecimal b_i_7_9 = rc.getBigDecimal("b_i_7_9");
                String b_i_7_10 = rc.getString("b_i_7_10");
                String b_i_7_11 = rc.getString("b_i_7_11");
                collaterals.add(new Collateral(b_i_7_2,b_i_7_3,b_i_7_4,b_i_7_5,b_i_7_6,b_i_7_7,b_i_7_8,b_i_7_9,b_i_7_10,b_i_7_11));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,collaterals );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static Response getCustomerBusinessLine(BusinessLineRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        CustomerBusinessLineQuery query = new CustomerBusinessLineQuery(request);
        ArrayList<CorporateBusLine> corporateBusLines = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                //String customerId = rc.getString("cif");
                //cif,ref_cif,b_i_5_3_171_1,b_i_5_3_172,b_i_5_3_173,b_i_5_3_173,b_i_5_3_175,b_i_5_3_176,b_i_5_3_177,b_i_5_3_178
                String customerId = rc.getString("cif");
                String level3 = rc.getString("level3");
                BigDecimal net_rev = rc.getBigDecimal("net_rev");
                String b_i_5_3_171_1 = rc.getString("b_i_5_3_171_1");
                BigDecimal b_i_5_3_172 = rc.getBigDecimal("b_i_5_3_172");
                BigDecimal b_i_5_3_173 = rc.getBigDecimal("b_i_5_3_173");
                BigDecimal b_i_5_3_174 = rc.getBigDecimal("b_i_5_3_174");
                BigDecimal b_i_5_3_175 = rc.getBigDecimal("b_i_5_3_175");
                BigDecimal b_i_5_3_176 = rc.getBigDecimal("b_i_5_3_176");
                BigDecimal b_i_5_3_177 = rc.getBigDecimal("b_i_5_3_177");
                BigDecimal b_i_5_3_178 = rc.getBigDecimal("b_i_5_3_178");
                corporateBusLines.add(new CorporateBusLine(customerId,net_rev, level3,b_i_5_3_171_1,b_i_5_3_172,b_i_5_3_173,b_i_5_3_174,b_i_5_3_175,b_i_5_3_176,b_i_5_3_177,b_i_5_3_178));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,corporateBusLines );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }

    }
    
    public static Response getCustomerBusinessLinePerformance(BusinessLineRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        BusLinePerfomanceQuery query = new BusLinePerfomanceQuery(request);
        ArrayList<BusLinePerfomance> busLinePerfomances = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                //String customerId = rc.getString("cif");
                //cif,nam,lv3,b_i_5_1_47_1,b_i_5_1_47_2,b_i_5_1_47_3,b_i_5_1_47_4,b_i_5_1_47_5,b_i_5_1_47_6,b_i_5_1_47_7,cob_dt,rn
                String cif = rc.getString("cif");
                String nam = rc.getString("nam");
                String lv3 = rc.getString("lv3");
                BigDecimal b_i_5_1_47_1 = rc.getBigDecimal("b_i_5_1_47_1");
                BigDecimal b_i_5_1_47_2 = rc.getBigDecimal("b_i_5_1_47_2");
                BigDecimal b_i_5_1_47_3 = rc.getBigDecimal("b_i_5_1_47_3");
                BigDecimal b_i_5_1_47_4 = rc.getBigDecimal("b_i_5_1_47_4");
                BigDecimal b_i_5_1_47_5 = rc.getBigDecimal("b_i_5_1_47_5");
                BigDecimal b_i_5_1_47_6 = rc.getBigDecimal("b_i_5_1_47_6");
                BigDecimal b_i_5_1_47_7 = rc.getBigDecimal("b_i_5_1_47_7");
                busLinePerfomances.add(new BusLinePerfomance(cif,nam,lv3,b_i_5_1_47_1,b_i_5_1_47_2,b_i_5_1_47_3,b_i_5_1_47_4,b_i_5_1_47_5,b_i_5_1_47_6,b_i_5_1_47_7));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,busLinePerfomances );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static Response partnerLinePerformance(PartnerPerformanceRequest request) throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbc = new JdbcUtils();
        PartnerPerformanceQuery query = new PartnerPerformanceQuery(request);
        ArrayList<PartnerPerformance> busLinePerfomances = new ArrayList<>();
        try {
            Connection c = jdbc.getConnectionUat();
            PreparedStatement statement = query.returnQuery(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                //String customerId = rc.getString("cif");
                //cif,nam,lv3,b_i_5_1_47_1,b_i_5_1_47_2,b_i_5_1_47_3,b_i_5_1_47_4,b_i_5_1_47_5,b_i_5_1_47_6,b_i_5_1_47_7,cob_dt,rn
                String cif = rc.getString("cif");
                String tax_id = rc.getString("taxid");
                BigDecimal b_i_5_3_64 = rc.getBigDecimal("b_i_5_3_64");
                BigDecimal b_i_5_3_65 = rc.getBigDecimal("b_i_5_3_65");
                busLinePerfomances.add(new PartnerPerformance(cif,tax_id, b_i_5_3_64, b_i_5_3_65));
            }
            c.close();
            return new Response(request.getRequestId(), false,"Success",null,busLinePerfomances );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(),null,  e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static Response getDepDetail(DepdetailRequest request) throws NoSuchAlgorithmException, KeyManagementException {
        JdbcUtils jdbcUtils = new JdbcUtils();
        DepdetailQuery query = new DepdetailQuery(request);
        ArrayList<Depdetail> depDetails = new ArrayList<>();
        Connection c = null;
        try {
            c = jdbcUtils.getConnectionUat();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();
            System.out.println(statement.toString());
            while (rc.next()) {
           	     String cifNo = rc.getString("acn"); 
            	 String acctNo = rc.getString("cid"); 
            	 String stat = rc.getString("stat"); 
            	 String cus_nm = rc.getString("cus_nm");
            	 String crcd = rc.getString("crcd");
            	 String cob_dt = rc.getString("cob_dt"); 
            	depDetails.add(new Depdetail(cifNo,acctNo, stat,cus_nm,crcd, cob_dt));
            }

            c.close();
        } catch (SQLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }

        return new Response(request.getRequestId(), false, "Success", null, depDetails);
    }    
}