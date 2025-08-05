package service;

import dao.request.BudgetRequest;
import dao.request.DeleteRequest;
import dao.request.PfmFinanceRequest;
import dao.request.PfmGetTranCardRequest;
import dao.request.PfmGetTranCatRequest;
import dao.request.PfmGetTransRequest;
import dao.request.PfmStatisticByCatRequest;
import dao.request.PfmStatisticDetailRequest;
import dao.request.PfmStatisticOverviewRequest;
import dao.response.Response;
import dao.response.ResponseData;
import dao.response.ResponseDataGetTrans;
import database.JdbcUtils;
import model.*;
import query.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class IpayService {

    public static Response getDdaTransByCat(PfmGetTransRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        ArrayList<PfmDdaTransaction> pfmDdaTransactions = new ArrayList<>();
        PfmGetTransByCateDdaQuery query = new PfmGetTransByCateDdaQuery(request);
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            Integer numPage = null;
            while (rc.next()){
                String categoryName = null;
                if (request.getLang().equals("vi")){
                    categoryName = rc.getString("name_vi");
                } else {
                    categoryName = rc.getString("name_en");
                }
                String categoryId = rc.getString("category");
                numPage = rc.getInt("num_page");
                String time = rc.getString("time");
                String channel = rc.getString("channel");
                String customerId = rc.getString("acn");
                String accountNo = rc.getString("cid");
                String tseq = rc.getString("tseq");
                BigDecimal amount = rc.getBigDecimal("amt");
                String zprfrefno = rc.getString("zprfrefno");
                String remark = rc.getString("remark");
                String crcd = rc.getString("crcd");
                String ofsname = rc.getString("ofsname");
                String ofscid = rc.getString("ofscid");
                Integer splitTransCount = rc.getInt("split_count");
                String pid = rc.getString("pid");
                String parentPid = rc.getString("parent_pid");
                pfmDdaTransactions.add(new PfmDdaTransaction(time, channel,customerId, accountNo,tseq ,amount,zprfrefno,remark,crcd,ofsname, ofscid,splitTransCount, categoryId, categoryName, pid, parentPid));
            }
            c.close();
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmDdaTransactions, numPage );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>(), null);
        }
    }

    public static Response getCardTranbyCat(PfmGetTransRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        ArrayList<PfmCreditCardTrans> pfmCreditCardTrans = new ArrayList<>();
        PfmGetTransByCatCardQuery query = new PfmGetTransByCatCardQuery(request);
        Integer numPage = null;
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String categoryName = null;
                if (request.getLang().equals("vi")){
                    categoryName = rc.getString("name_vi");
                } else {
                    categoryName = rc.getString("name_en");
                }
                String categoryId = rc.getString("category");
                numPage = rc.getInt("num_page");
                String cardId = rc.getString("cardid");
                String bin = rc.getString("bin");
                String cardName = rc.getString("card_name");
                String cardGrp = rc.getString("card_grp");
                String termLocation = rc.getString("termlocation");
                String termCity = rc.getString("termcity");
                String sicCode = rc.getString("siccode");
                String docNo = rc.getString("docno");
                String cobDate = rc.getString("cob_dt");
                BigDecimal amount = rc.getBigDecimal("amt");
                String currency = rc.getString("currency");
                String currencyOrg = rc.getString("currency_org");
                BigDecimal getCurrencyOrg = rc.getBigDecimal("amt_org");
                String shortRemark = rc.getString("shortremark");
                String fullRemark = rc.getString("fullremark");
                String accountNo = rc.getString("accountno");
                pfmCreditCardTrans.add(new PfmCreditCardTrans(cardId, bin,cardName,cardGrp,termLocation,termCity,sicCode, docNo,cobDate,amount,currency, categoryId, categoryName,getCurrencyOrg,currencyOrg,shortRemark,fullRemark, accountNo)); }
            c.close();
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmCreditCardTrans ,numPage);
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>(),null);
        }
    }

    public static Response getTranCat(PfmGetTranCatRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        ArrayList<PfmTranCat> transactions = new ArrayList<>();
        PfmGetTranCatQuery query = new PfmGetTranCatQuery(request);
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String accountNo = rc.getString("cid");
                String customerId = rc.getString("acn");
                String categoryName = null;
                if (request.getLang().equals("vi")){
                    categoryName = rc.getString("name_vi");
                } else {
                    categoryName = rc.getString("name_en");
                }
                String category = rc.getString("category");
                String splitCount = rc.getString("split_count");
                String pid = rc.getString("pid");
                String parentPid = rc.getString("parent_pid");
                transactions.add(new PfmTranCat(customerId, category, categoryName, splitCount, pid, parentPid));
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,transactions );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }

    }
    public static ResponseData getStatisticOverview(PfmStatisticOverviewRequest request) {
        JdbcUtils jdbc = new JdbcUtils();
        PfmStatisticOverviewQuery query = new PfmStatisticOverviewQuery(request);
        ArrayList<PfmStatistic> listStatistic = new ArrayList<>();
        if (request.getCustomerId() == null) {
            return new ResponseData(request.getRequestId(), request.getSessionId(), true, "CustomerID must be not null", 404, new ArrayList<>());
        }
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            Double income = 0.0;
            Double expense = 0.0;
            while (rc.next()) {
                String cif = rc.getString("acn");
                String type = rc.getString("in_out");
                BigDecimal amount = rc.getBigDecimal("amount");
                if (type.equals("income"))
                    income += amount.doubleValue();
                else if (type.equals("expense")) {
                    expense += amount.doubleValue();
                }
                if (request.getPeriodType() != null) {
                    String period = rc.getString("cob_dt");
                    listStatistic.add(new PfmStatisticView(cif, type, amount, period));
                } else {
                    listStatistic.add(new PfmStatisticView(cif, type, amount, null));
                }
            }
            c.close();
            return new ResponseData(request.getRequestId(), request.getSessionId(), false, "Success", null, listStatistic, income, expense);
        } catch (SQLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseData(request.getRequestId(), request.getSessionId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }

    public static ResponseData getStatisticDetail(PfmStatisticDetailRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        PfmStatisticDetailQuery query = new PfmStatisticDetailQuery(request);
        ArrayList<PfmStatistic> listStatistic = new ArrayList<>();
        if (request.getCustomerId() == null){
            return new ResponseData(request.getRequestId(), request.getSessionId(), true,"CustomerID must be not null", 404, new ArrayList<>());
        }
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            Double income = 0.0;
            Double expense = 0.0;
            while (rc.next()){
                String cif = rc.getString("acn");
                String type = rc.getString("in_out");
                BigDecimal amount = rc.getBigDecimal("amount");
                if (type.equals("income"))
                    income += amount.doubleValue();
                else if (type.equals("expense")) {
                    expense += amount.doubleValue();
                }
                if ( Objects.equals(request.getGroupBy(), "1")){
                    String categoryId = rc.getString("category");
                    String categoryName = "";
                    if (request.getLang().equals("vi")) {
                        categoryName = rc.getString("name_vi");
                    }
                    else
                        categoryName = rc.getString("name_en");
                    listStatistic.add(new PfmStatisticCategory(cif, type, amount,categoryId,categoryName));
                }
                else {
                    String accountNo = rc.getString("cid");
                    String cidType = rc.getString("cid_type");
                    listStatistic.add(new PfmStatisticAccount(cif, type, amount, cidType, accountNo));
                }
            }
            c.close();
            return new ResponseData(request.getRequestId(), request.getSessionId(), false,"Success",null,listStatistic , income, expense );}
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseData(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(),new ArrayList<>());
        }
    }
    
    public static Response getOriginalTrans(PfmGetTranCatRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        ArrayList<PfmDdaTransaction> pfmDdaTransactions = new ArrayList<>();
        PfmGetOriginalTransQuery query = new PfmGetOriginalTransQuery(request);
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            Integer numPage = null;
            while (rc.next()){
                String categoryName = null;
                if (request.getLang().equals("vi")){
                    categoryName = rc.getString("name_vi");
                } else {
                    categoryName = rc.getString("name_en");
                }
                String categoryId = rc.getString("category");
                String time = rc.getString("time");
                String channel = rc.getString("channel");
                String customerId = rc.getString("acn");
                String accountNo = rc.getString("cid");
                String tseq = rc.getString("tseq");
                BigDecimal amount = rc.getBigDecimal("amt");
                String zprfrefno = rc.getString("zprfrefno");
                String remark = rc.getString("remark");
                String crcd = rc.getString("crcd");
                String ofsname = rc.getString("ofsname");
                String ofscid = rc.getString("ofscid");
                Integer splitTransCount = rc.getInt("split_count");
                String pid = rc.getString("pid");
                String parentPid = rc.getString("parent_pid");
                pfmDdaTransactions.add(new PfmDdaTransaction(time, channel,customerId, accountNo,tseq ,amount,zprfrefno,remark,crcd,ofsname, ofscid,splitTransCount, categoryId, categoryName, pid, parentPid));
            }
            c.close();
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmDdaTransactions, numPage );
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>(), null);
        }
    }
    public static Response getCardCategory (PfmGetTranCardRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        PfmGetCatCardQuery query = new PfmGetCatCardQuery(request);
        ArrayList<PfmCardCategory> pfmCardCategories = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String accountNo = rc.getString("accountno");
                String customerId = rc.getString("acn");
                String categoryName = null;
                if (request.getLang().equals("vi")){
                    categoryName = rc.getString("name_vi");
                } else {
                    categoryName = rc.getString("name_en");
                }
                String category = rc.getString("category");
                pfmCardCategories.add(new PfmCardCategory(customerId,accountNo, category, categoryName));
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmCardCategories );

        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>(), null);
        }

    }
    
    public static Response test_card (){
        JdbcUtils jdbcUtils = new JdbcUtils();
        String query = "select count(*) from ipay.ipay_pfm_card_t_1 where cob_dt = '2024-10-01'";
        ArrayList<PfmCardCategory> pfmCardCategories = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = c.prepareStatement(query);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            c.close();
            return new Response("ipay_pfm_card_t_1", "ipay_pfm_card_t_1", false,"Success",null, null );

        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans("test", "test", true,e.getMessage(), e.getErrorCode(), new ArrayList<>(), null);
        }

    }
    
    public static Response test_pfm (){
        JdbcUtils jdbcUtils = new JdbcUtils();
        String query = "select cif_no  from pfm_sms_notify_hist psnh where cast(trans_time as date) = '2024-12-03' limit 1 ";
        ArrayList<PfmCardCategory> pfmCardCategories = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = c.prepareStatement(query);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            c.close();
            return new Response("pfm_sms_notify_hist", "pfm_sms_notify_hist", false,"Success",null, null );

        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseDataGetTrans("test", "test", true,e.getMessage(), e.getErrorCode(), new ArrayList<>(), null);
        }

    }
    public static Response deleteVirtualTrans(DeleteRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        DeleteQuery query = new DeleteQuery(request);
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            statement.executeUpdate();
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,null );}
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseData(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    public static Response getCategoryBudget(BudgetRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        BugetQuery query = new BugetQuery(request);
        Connection c = null;
        ArrayList<PfmBugdetByCategory> pfmBugdetByCategories = new ArrayList<>();
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String customerId = rc.getString("acn");
                String category = rc.getString("category");
                BigDecimal amount = rc.getBigDecimal("amount");
                if (request.getPeriodType() != null) {
                    String period = rc.getString("cob_dt");
                    pfmBugdetByCategories.add(new PfmBugdetByCategory(customerId, category, amount, period));
                } else {
                	pfmBugdetByCategories.add(new PfmBugdetByCategory(customerId, category, amount, null));
                }
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmBugdetByCategories );}
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new ResponseData(request.getRequestId(), request.getSessionId(), true,e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }

    }
    public static Response getFinanceHealth(PfmFinanceRequest request) {
        JdbcUtils jdbcUtils = new JdbcUtils();
        ArrayList<PfmFinaceHealth> pfmFinaceHealths = new ArrayList<>();
        try {
            PfmGetFinanceQuery query = new PfmGetFinanceQuery(request);
            Connection c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String customerId = rc.getString("acn");
                String fcf = rc.getString("fcf");
                String esr = rc.getString("esr");
                String lsr = rc.getString("lsr");
                String dti = rc.getString("dti");
                String efund = rc.getString("efund");
                String usedLimit = rc.getString("cur");
                String icic = rc.getString("cic");
                String finalGrade = rc.getString("final_grade");
                String cobDt = rc.getString("cob_dt");
                pfmFinaceHealths.add(new PfmFinaceHealth(customerId, fcf, esr,lsr, dti, efund, usedLimit, icic,finalGrade,cobDt));
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,pfmFinaceHealths );
        } catch (SQLException e){
            return new Response(request.getRequestId(), request.getSessionId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    
    public static Response getPredictedTransaction(PfmFinanceRequest request) {
        JdbcUtils jdbcUtils = new JdbcUtils();
        ArrayList<PredictedTransaction> predictedTransactions = new ArrayList<>();
        try {
            PredictedTransactionQuery query = new PredictedTransactionQuery(request);
            Connection c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
                String customerId = rc.getString("acn");
                BigDecimal amount = rc.getBigDecimal("amount");
                String category = rc.getString("category");
                String productType = rc.getString("product_type");
                String zBenAcn = rc.getString("zbenacn");
                String zBenCid = rc.getString("zbencid");
                String dueDate = rc.getString("predict_date");
                String predictDate = rc.getString("cob_dt");
                predictedTransactions.add(new PredictedTransaction(customerId, amount, category,productType, zBenAcn, zBenCid, predictDate, dueDate));
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false,"Success",null,predictedTransactions );
        } catch (SQLException e){
            return new Response(request.getRequestId(), request.getSessionId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    
    public static Response getStatisticByCat(PfmStatisticByCatRequest request){
        JdbcUtils jdbc = new JdbcUtils();
        PfmStatisticByCatQuery query = new PfmStatisticByCatQuery(request);
        ArrayList<PfmStatisticByCat> listStatistic = new ArrayList<>();
        if (request.getCustomerId() == null) {
            return new ResponseData(request.getRequestId(), request.getSessionId(), true, "CustomerID must be not null", 404, new ArrayList<>());
        }
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            while (rc.next()) {
                String cif = rc.getString("acn");
                BigDecimal amount = rc.getBigDecimal("amount");
                String category;
                if (request.getLang().equals("vi")){
                    category = rc.getString("name_vi");
                } else {
                    category = rc.getString("name_en");
                }
                if (request.getPeriodType() != null) {
                    String period = rc.getString("cob_dt");
                    listStatistic.add(new PfmStatisticByCat(cif, category, amount, period));
                } else {
                    listStatistic.add(new PfmStatisticByCat(cif, category, amount, null));
                }
            }
            c.close();
            return new Response(request.getRequestId(), request.getSessionId(), false, "Success", null, listStatistic);
        } catch (SQLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), request.getSessionId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
    }
    
    

}