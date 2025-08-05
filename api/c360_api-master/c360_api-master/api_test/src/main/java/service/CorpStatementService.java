package service;

import dao.request.DepDltFactRequest;
import dao.response.Response;
import database.JdbcUtils;
import query.DepDltFactQuery;


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

import c360.model.DepDtlFact;

public class CorpStatementService {
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
	            	
	                
	                for (int i = 0; i <= request.getIrnList().size(); i++) { 
	                    String irnYtdKey = "irnYtdGrp" + (i + 1);
	                    String irnDlyKey = "irnDlyGrp" + (i + 1);
	                    
	                    String irnYtdValue = rc.getString(irnYtdKey);
	                    String irnDlyValue = rc.getString(irnDlyKey);
	                    
	                    
	                    irnGroups.put(irnYtdKey, irnYtdValue);      
	                    irnGroups.put(irnDlyKey, irnDlyValue);                 
	                }                       
	            	}
	            // Conditional logic to add DepDtlFact based on request parameters
	            if (request.getBranch() == null && request.getCrcd() == null) {
	                        depDtlFact.add(new DepDtlFact(cif, null,null,ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc,ytdNimAmt, cobDt, irnGroups));
	                } 
	            if (request.getBranch() == null && request.getCrcd() != null) {
	                    String crcd = rc.getString("crcd");
	                    depDtlFact.add(new DepDtlFact(cif,null, crcd, ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc, ytdNimAmt, cobDt, irnGroups));
	            } if (request.getBranch() != null && request.getCrcd() == null) {
	                    depDtlFact.add(new DepDtlFact(cif, branch,null, ytdAvgBalAmt,ytdAvgBalAmtTc, ytdOnlAvgBalAmt,ytdOnlAvgBalAmtTc, ytdNiiAmt, dlyBalAmt,dlyBalAmtTc,dlyOnBalAmt,dlyOnBalAmtTc, qtdAvgBalAmt,qtdAvgBalAmtTc,qtdOnlAvgBalAmt,qtdOnlAvgBalAmtTc, ytdNimAmt, cobDt, irnGroups));
	            } if (request.getBranch() != null && request.getCrcd() != null) {
	                    String crcd = rc.getString("crcd");
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
}