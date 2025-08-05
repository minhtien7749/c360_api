package service;

import dao.request.CorpStatementRequest;
import dao.request.StateBudgetRequest;
import dao.response.Response;
import database.JdbcUtils;
import model.CorpStatement;
import model.CorpStatement9104;
import model.StateBudget;
import query.CorpStatementQuery;
import query.StateBudgetQuery;
import dao.response.ResponseStatement;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorpStatementService {

	public static Response getStatement(CorpStatementRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        CorpStatementQuery query = new CorpStatementQuery(request);
        ArrayList<CorpStatement> corpStatements = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            String beginningBalance = null;
            String endingBalance = null;
            String totalCredit = null;
            String totalDebit = null;
            String countDebit = "0";
            String countCredit = "0";

 
            while (rc.next()){
                String cif = rc.getString( "cif");
                String account = rc.getString( "account");
                String transactionDate = rc.getString( "transactiondate");
                String transactionContent = rc.getString( "transactioncontent");
                String debit = rc.getString( "debit");
                String credit = rc.getString( "credit");
                String accountBal = rc.getString( "accountbal");
                String transactionNumber = rc.getString( "transactionnumber");
                String mTid = rc.getString( "mtid");
                String virtualAccount = rc.getString( "virtualaccount");
                String corresponsiveBankName = rc.getString( "corresponsivebankname");
                String corresponsiveBankId = rc.getString( "corresponsivebankid");
                String corresponsiveAccount = rc.getString( "corresponsiveaccount");
                String corresponsiveAccountName = rc.getString( "corresponsiveaccountname");
                String servicebranchId = rc.getString( "servicebranchid");
                String serviceBankName = rc.getString( "servicebankname");
                String channel = rc.getString( "channel");
                String agency = rc.getString( "agency");
                String trxTypeDatalake = rc.getString( "trx_type_datalake");
                String uid = rc.getString( "uid");
                String eftType = rc.getString( "efttype");
                String zGrp = rc.getString( "zgrp");
                String etc = rc.getString( "etc");
                String prfLnGrp = rc.getString( "prf_ln_grp");
                String eftpayZfeeacct = rc.getString( "eftpay_zfeeacct");
                String zChanRefNo = rc.getString( "zchanrefno");
                String zPrfRefNo = rc.getString( "zprfrefno");
                String zSpr = rc.getString( "zspr");
                String itc1 = rc.getString( "itc1");
                String ztrid = rc.getString("ztrid");
                String trc =  rc.getString("trc");
                String feeamt = rc.getString("feeamt");
                String taxamt = rc.getString("taxamt");
                String taxrate = rc.getString("taxrate");
                String zrefnum = rc.getString("zrefnum");
                String invno = rc.getString("invno");
                String banktransid = rc.getString("banktransid");
                String cobDt = rc.getString( "cob_dt");
                String beginning = rc.getString("beginning");
                String ending = rc.getString("ending");
                String netamount = rc.getString("netamount");
                String currency = rc.getString("crcd");
                // Additional Fields for Channel 9104

                if (beginning.equals("1")){
                    beginningBalance = accountBal;
                }
                if (ending.equals("1")){
                    endingBalance = accountBal;
                }
                //debit itc = 0
                if (itc1.equals("1")){
                    totalCredit = rc.getString("total_credit");
                    countCredit = rc.getString("cred_or_deb");
                } else if (itc1.equals("0")) {
                    totalDebit = rc.getString("total_debit");
                    countDebit = rc.getString("cred_or_deb");
                }
                
                if (request.getAccStatementType().equals("TTQT")) {
               	  String originalamount33b  = rc.getString("originalamount33b");
            	  String originalamountccy33b  = rc.getString("originalamountccy33b");
            	  String sendercharge71f1  = rc.getString("sendercharge71f1");
            	  String senderchargeccy71f1 = rc.getString("senderchargeccy71f1");
            	  String sendercharge71f2 = rc.getString("sendercharge71f2");
                  String senderchargeccy71f2= rc.getString("senderchargeccy71f2");
                  String sendercharge71f3= rc.getString("sendercharge71f3");
                  String senderchargeccy71f3= rc.getString("senderchargeccy71f3");
                  String sendercharge71f4= rc.getString("sendercharge71f4");
                  String senderchargeccy71f4= rc.getString("senderchargeccy71f4");
                  String sendercharge71f5= rc.getString("sendercharge71f5");
                  String senderchargeccy71f5= rc.getString("senderchargeccy71f5");
                  String receivercharges71g= rc.getString("receivercharges71g");
                  String receiverchargesccy71g= rc.getString("receiverchargesccy71g");
                    
                    corpStatements.add(new CorpStatement9104(cif,account,transactionDate,transactionContent,debit ,credit,accountBal,transactionNumber,mTid,virtualAccount,corresponsiveBankName,
                            corresponsiveBankId,corresponsiveAccount,corresponsiveAccountName,servicebranchId,serviceBankName, channel,agency,trxTypeDatalake,uid, eftType, zGrp, etc, prfLnGrp, eftpayZfeeacct,
                            zChanRefNo, zPrfRefNo,zSpr, itc1,ztrid,trc,feeamt,taxamt,taxrate, zrefnum,invno,banktransid, cobDt,currency,netamount,originalamount33b,originalamountccy33b,sendercharge71f1,senderchargeccy71f1,sendercharge71f2,senderchargeccy71f2,sendercharge71f3,senderchargeccy71f3,sendercharge71f4,senderchargeccy71f4,sendercharge71f5,senderchargeccy71f5,receivercharges71g,receiverchargesccy71g));
                }else {
                	
                }
                corpStatements.add(new CorpStatement(cif,account,transactionDate,transactionContent,debit ,credit,accountBal,transactionNumber,mTid,virtualAccount,corresponsiveBankName,
                        corresponsiveBankId,corresponsiveAccount,corresponsiveAccountName,servicebranchId,serviceBankName, channel,agency,trxTypeDatalake,uid, eftType, zGrp, etc, prfLnGrp, eftpayZfeeacct,
                        zChanRefNo, zPrfRefNo,zSpr, itc1,ztrid,trc,feeamt,taxamt,taxrate, zrefnum,invno,banktransid, cobDt,currency,netamount));
            }
            c.close();
            return new ResponseStatement(request.getRequestId(), false,"Success",null,corpStatements ,beginningBalance, endingBalance, totalCredit,totalDebit,countDebit,countCredit);

        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static Response getStatementUat(CorpStatementRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        CorpStatementQuery query = new CorpStatementQuery(request);
        ArrayList<CorpStatement> corpStatements = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnectionUat();
            PreparedStatement statement = query.returnSql(c);
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            String beginningBalance = null;
            String endingBalance = null;
            String totalCredit = null;
            String totalDebit = null;
            String countDebit = "0";
            String countCredit = "0";

 
            while (rc.next()){
                String cif = rc.getString( "cif");
                String account = rc.getString( "account");
                String transactionDate = rc.getString( "transactiondate");
                String transactionContent = rc.getString( "transactioncontent");
                String debit = rc.getString( "debit");
                String credit = rc.getString( "credit");
                String accountBal = rc.getString( "accountbal");
                String transactionNumber = rc.getString( "transactionnumber");
                String mTid = rc.getString( "mtid");
                String virtualAccount = rc.getString( "virtualaccount");
                String corresponsiveBankName = rc.getString( "corresponsivebankname");
                String corresponsiveBankId = rc.getString( "corresponsivebankid");
                String corresponsiveAccount = rc.getString( "corresponsiveaccount");
                String corresponsiveAccountName = rc.getString( "corresponsiveaccountname");
                String servicebranchId = rc.getString( "servicebranchid");
                String serviceBankName = rc.getString( "servicebankname");
                String channel = rc.getString( "channel");
                String agency = rc.getString( "agency");
                String trxTypeDatalake = rc.getString( "trx_type_datalake");
                String uid = rc.getString( "uid");
                String eftType = rc.getString( "efttype");
                String zGrp = rc.getString( "zgrp");
                String etc = rc.getString( "etc");
                String prfLnGrp = rc.getString( "prf_ln_grp");
                String eftpayZfeeacct = rc.getString( "eftpay_zfeeacct");
                String zChanRefNo = rc.getString( "zchanrefno");
                String zPrfRefNo = rc.getString( "zprfrefno");
                String zSpr = rc.getString( "zspr");
                String itc1 = rc.getString( "itc1");
                String ztrid = rc.getString("ztrid");
                String trc =  rc.getString("trc");
                String feeamt = rc.getString("feeamt");
                String taxamt = rc.getString("taxamt");
                String taxrate = rc.getString("taxrate");
                String zrefnum = rc.getString("zrefnum");
                String invno = rc.getString("invno");
                String banktransid = rc.getString("banktransid");
                String cobDt = rc.getString( "cob_dt");
                String beginning = rc.getString("beginning");
                String ending = rc.getString("ending");
                String netamount = rc.getString("netamount");
                String currency = rc.getString("crcd");
                // Additional Fields for Channel 9104

                if (beginning.equals("1")){
                    beginningBalance = accountBal;
                }
                if (ending.equals("1")){
                    endingBalance = accountBal;
                }
                //debit itc = 0
                if (itc1.equals("1")){
                    totalCredit = rc.getString("total_credit");
                    countCredit = rc.getString("cred_or_deb");
                } else if (itc1.equals("0")) {
                    totalDebit = rc.getString("total_debit");
                    countDebit = rc.getString("cred_or_deb");
                }
                
                if (request.getAccStatementType().equals("TTQT")) {
                 	  String originalamount33b  = rc.getString("originalamount33b");
              	  String originalamountccy33b  = rc.getString("originalamountccy33b");
              	  String sendercharge71f1  = rc.getString("sendercharge71f1");
              	  String senderchargeccy71f1 = rc.getString("senderchargeccy71f1");
              	  String sendercharge71f2 = rc.getString("sendercharge71f2");
                    String senderchargeccy71f2= rc.getString("senderchargeccy71f2");
                    String sendercharge71f3= rc.getString("sendercharge71f3");
                    String senderchargeccy71f3= rc.getString("senderchargeccy71f3");
                    String sendercharge71f4= rc.getString("sendercharge71f4");
                    String senderchargeccy71f4= rc.getString("senderchargeccy71f4");
                    String sendercharge71f5= rc.getString("sendercharge71f5");
                    String senderchargeccy71f5= rc.getString("senderchargeccy71f5");
                    String receivercharges71g= rc.getString("receivercharges71g");
                    String receiverchargesccy71g= rc.getString("receiverchargesccy71g");
                    
                    corpStatements.add(new CorpStatement9104(cif,account,transactionDate,transactionContent,debit ,credit,accountBal,transactionNumber,mTid,virtualAccount,corresponsiveBankName,
                            corresponsiveBankId,corresponsiveAccount,corresponsiveAccountName,servicebranchId,serviceBankName, channel,agency,trxTypeDatalake,uid, eftType, zGrp, etc, prfLnGrp, eftpayZfeeacct,
                            zChanRefNo, zPrfRefNo,zSpr, itc1,ztrid,trc,feeamt,taxamt,taxrate, zrefnum,invno,banktransid, cobDt,currency,netamount,originalamount33b,originalamountccy33b,sendercharge71f1,senderchargeccy71f1,sendercharge71f2,senderchargeccy71f2,sendercharge71f3,senderchargeccy71f3,sendercharge71f4,senderchargeccy71f4,sendercharge71f5,senderchargeccy71f5,receivercharges71g,receiverchargesccy71g));
    
                }else {
                	
                
                corpStatements.add(new CorpStatement(cif,account,transactionDate,transactionContent,debit ,credit,accountBal,transactionNumber,mTid,virtualAccount,corresponsiveBankName,
                        corresponsiveBankId,corresponsiveAccount,corresponsiveAccountName,servicebranchId,serviceBankName, channel,agency,trxTypeDatalake,uid, eftType, zGrp, etc, prfLnGrp, eftpayZfeeacct,
                        zChanRefNo, zPrfRefNo,zSpr, itc1,ztrid,trc,feeamt,taxamt,taxrate, zrefnum,invno,banktransid, cobDt,currency,netamount));
            }
            }
            c.close();
            return new ResponseStatement(request.getRequestId(), false,"Success",null,corpStatements ,beginningBalance, endingBalance, totalCredit,totalDebit,countDebit,countCredit);

        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
	}
	
    public static Response  getStateBudget(StateBudgetRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        StateBudgetQuery query = new StateBudgetQuery(request);
        ArrayList<StateBudget> stateBudgets = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnection();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
            	String docdt = rc.getString("docdt");
            	String doccd = rc.getString("doccd");
            	String docid = rc.getString("docid");
            	String refno = rc.getString("refno");
            	String taxpn = rc.getString("taxpn");
            	String taxcd = rc.getString("taxcd");
            	String taxpa = rc.getString("taxpa");
            	String ptaxpn = rc.getString("ptaxpn");
            	String ptaxpa = rc.getString("ptaxpa");
            	String treacd = rc.getString("treacd");
            	String cid = rc.getString("cid");
            	String namSend = rc.getString("nam_send");
            	String city = rc.getString("city");
            	String origtrno = rc.getString("origtrno");
            	String period = rc.getString("period");
            	String cont = rc.getString("cont");
            	String amt  = rc.getString("amt");
            	String itm = rc.getString("itm");
            	String bsn = rc.getString("bsn");
            	String colacc = rc.getString("colacc");
            	String uid = rc.getString("uid");
            	String uidapp = rc.getString("uidapp");
            	String taxtyp = rc.getString("taxtyp");
            	String tseq = rc.getString("tseq");
            	String tjd = rc.getString("tjd");
            	String colagc = rc.getString("colagc");
            	String brcd = rc.getString("brcd");
            	String brchName = rc.getString("brch_name");
            	String sendCorr = rc.getString("sendcorr");
            	String namRev = rc.getString("nam_rev");
            	String taxref = rc.getString("taxref");
            	String zutblcolagctDesc = rc.getString("zutblcolagct_desc");
            	String areap = rc.getString("area");
            	String sndr = rc.getString("sndr");
            	String zrmkorg = rc.getString("zrmkorg");
            	String decno = rc.getString("decno");
            	String decdate = rc.getString("decdate");
            	String zutblareaDesc = rc.getString("zutblcolagct_desc");
            	String benname = rc.getString("benname");
            	String instnam = rc.getString("instnam");
            	String time = rc.getString("time");
            	String sendistl = rc.getString("sendistl");
            	String cobDt = rc.getString("cob_dt");
            	stateBudgets.add(new StateBudget(docdt,doccd,docid,refno,taxpn,taxcd,taxpa,ptaxpn,ptaxpa,treacd,cid,namSend,city,origtrno,period,cont,amt,itm,bsn,colacc,uid,uidapp,taxtyp,tseq,tjd,colagc,brcd,brchName,sendCorr,namRev,taxref,zutblcolagctDesc,areap,sndr,zrmkorg,decno,decdate,zutblareaDesc,benname,instnam,time,sendistl,cobDt));
            }
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        return new Response(request.getRequestId(), false,"Success",null, stateBudgets);
    }
    public static Response  getStateBudgetUat(StateBudgetRequest request){
        JdbcUtils jdbcUtils = new JdbcUtils();
        StateBudgetQuery query = new StateBudgetQuery(request);
        ArrayList<StateBudget> stateBudgets = new ArrayList();
        Connection c = null;
        try {
            c = jdbcUtils.getConnectionUat();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();
            while (rc.next()){
            	String docdt = rc.getString("docdt");
            	String doccd = rc.getString("doccd");
            	String docid = rc.getString("docid");
            	String refno = rc.getString("refno");
            	String taxpn = rc.getString("taxpn");
            	String taxcd = rc.getString("taxcd");
            	String taxpa = rc.getString("taxpa");
            	String ptaxpn = rc.getString("ptaxpn");
            	String ptaxpa = rc.getString("ptaxpa");
            	String treacd = rc.getString("treacd");
            	String cid = rc.getString("cid");
            	String namSend = rc.getString("nam_send");
            	String city = rc.getString("city");
            	String origtrno = rc.getString("origtrno");
            	String period = rc.getString("period");
            	String cont = rc.getString("cont");
            	String amt  = rc.getString("amt");
            	String itm = rc.getString("itm");
            	String bsn = rc.getString("bsn");
            	String colacc = rc.getString("colacc");
            	String uid = rc.getString("uid");
            	String uidapp = rc.getString("uidapp");
            	String taxtyp = rc.getString("taxtyp");
            	String tseq = rc.getString("tseq");
            	String tjd = rc.getString("tjd");
            	String colagc = rc.getString("colagc");
            	String brcd = rc.getString("brcd");
            	String brchName = rc.getString("brch_name");
            	String sendCorr = rc.getString("sendcorr");
            	String namRev = rc.getString("nam_rev");
            	String taxref = rc.getString("taxref");
            	String zutblcolagctDesc = rc.getString("zutblcolagct_desc");
            	String areap = rc.getString("area");
            	String sndr = rc.getString("sndr");
            	String zrmkorg = rc.getString("zrmkorg");
            	String decno = rc.getString("decno");
            	String decdate = rc.getString("decdate");
            	String zutblareaDesc = rc.getString("zutblcolagct_desc");
            	String benname = rc.getString("benname");
            	String instnam = rc.getString("instnam");
            	String time = rc.getString("time");
            	String sendistl = rc.getString("sendist");
            	String cobDt = rc.getString("cob_dt");
            	stateBudgets.add(new StateBudget(docdt,doccd,docid,refno,taxpn,taxcd,taxpa,ptaxpn,ptaxpa,treacd,cid,namSend,city,origtrno,period,cont,amt,itm,bsn,colacc,uid,uidapp,taxtyp,tseq,tjd,colagc,brcd,brchName,sendCorr,namRev,taxref,zutblcolagctDesc,areap,sndr,zrmkorg,decno,decdate,zutblareaDesc,benname,instnam,time,sendistl,cobDt));
            }
        }
        catch (SQLException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return new Response(request.getRequestId(), true, e.getMessage(), e.getErrorCode(), new ArrayList<>());
        }
        return new Response(request.getRequestId(), false,"Success",null, stateBudgets);
    }
    

}
