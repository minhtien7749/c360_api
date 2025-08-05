package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.request.DepDltFactRequest;

public class DepDltFactQuery {
    private final String SQL_TEMPLATE = "SELECT acn, "
            + "SUM(YTD_AVG_LDGR_BAL_AMT_IN_LC) AS ytdAvgBalAmt, "
            + "SUM(YTD_AVG_LDGR_BAL_AMT_IN_LC) AS ytdAvgBalAmtTc, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN YTD_AVG_LDGR_BAL_AMT_IN_LC END) AS ytdOnlAvgBalAmt, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN YTD_AVG_LDGR_BAL_AMT_IN_LC END) AS ytdOnlAvgBalAmtTc, "
            + "SUM(dly_ldgr_bal_amt_in_lc) AS dlyBalAmt, "
            + "SUM(dly_ldgr_bal_amt_in_tc) AS dlyBalAmtTc, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN dly_ldgr_bal_amt_in_lc END) AS dlyOnBalAmt, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN dly_ldgr_bal_amt_in_lc END) AS dlyOnBalAmtTc, "
            + "SUM(QTD_AVG_LDGR_BAL_AMT_IN_LC) AS qtdAvgBalAmt, "
            + "SUM(QTD_AVG_LDGR_BAL_AMT_IN_TC) AS qtdAvgBalAmtTc, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN QTD_AVG_LDGR_BAL_AMT_IN_LC END) AS qtdOnlAvgBalAmt, "
            + "SUM(CASE WHEN zchanid IN ('78','77') THEN QTD_AVG_LDGR_BAL_AMT_IN_TC END) AS qtdOnlAvgBalAmtTc, "
            + "SUM(case when lnd.cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_depst_dtls_fact_update_nii') then null else ytd_nii_alco_amt_in_lc end) AS ytdNiiAmt, "
            + "SUM(case when lnd.cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_depst_dtls_fact_update_nii') then null else ytd_nii_alco_amt_in_lc end) / SUM(ytd_avg_ldgr_bal_amt_in_lc) AS ytdNimAmt, ";

    private DepDltFactRequest request;

    public DepDltFactQuery(DepDltFactRequest request) {
        this.request = request;
    }

    public String returnPeriod() {
        if (this.request.getPeriod() == null) {
            return "mth_last_day_flag";
        }
        switch (this.request.getPeriod()) {
            case "Y":
                return "year_end_flag";
            case "M":
                return "mth_last_day_flag";
            default:
                return "clndr_qtr_end_flag";
        }
    }

    private String buildBaseSQL(String flag) {
        StringBuilder sqlBuilder = new StringBuilder(SQL_TEMPLATE);

        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
        boolean hasToDate = request.getToDate() != null && !request.getToDate().isEmpty();
        boolean hasBranch = request.getBranch() != null;
        boolean hasCrcd = request.getCrcd() != null && !request.getCrcd().isEmpty();
        
     
        // Conditionally add branch
        if (hasBranch) {         
        	sqlBuilder.append(" substring(boo, 1, 3) AS branch,");     }     
        // Conditionally add crcd 
        if (hasCrcd) {         
        	sqlBuilder.append(" crcd,");     
        	}      
        // Always select basic columns   
        sqlBuilder.append(" cob_dt"); 
        
        if (this.request.getPeriod() == null && hasToDate && !hasFromDate) { 
            sqlBuilder.append(" FROM customer360.c360_depst_dtls_fact lnd WHERE ")
                      .append(" lnd.cob_dt = ? ");
        }
        if (this.request.getPeriod() == null && hasFromDate && hasToDate) {
            sqlBuilder.append(" FROM customer360.c360_depst_dtls_fact lnd WHERE ")
                      .append(""
                      		+ "((lnd.cob_dt >= ? AND lnd.cob_dt <= ?) or lnd.cob_dt = ?) ");
        }
        if(hasFromDate && !hasToDate) {
            sqlBuilder.append(" FROM customer360.c360_depst_dtls_fact lnd WHERE ")
            .append("lnd.cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND (cob_dt >= ? AND cob_dt <= CURDATE()) or cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact')) ");
        }        
        if (this.request.getPeriod() != null && (hasFromDate && hasToDate)) {
        	 sqlBuilder.append(" FROM customer360.c360_depst_dtls_fact lnd WHERE ")
             .append("(lnd.cob_dt in (select cob_dt  from customer360.tm_dim where ")
             .append(flag).append(" = 'Y' AND cob_dt >= ? AND cob_dt <= ?) OR lnd.cob_dt = ?) ");
        }
        sqlBuilder.append("AND type <> '2109' AND acn = ? ");

        return sqlBuilder.toString();
    }

    private String buildGroupBy(boolean hasBranch, boolean hasCrcd) {
        List<String> groupByColumns = new ArrayList<>();
        
        groupByColumns.add("acn");  // Always group by acn
        groupByColumns.add("cob_dt"); // Always group by cob_dt

        if (hasCrcd) {
            groupByColumns.add("crcd"); // Group by crcd if it exists
        }

        if (hasBranch) {
            groupByColumns.add("substring(boo, 1, 3)"); // Group by branch if it exists
        }

        return " GROUP BY " + String.join(", ", groupByColumns);
    }
    private PreparedStatement buildPreparedStatement(Connection c, String sql, List<Object> parameters) throws SQLException {
        PreparedStatement statement = c.prepareStatement(sql);
        for (int i = 0; i < parameters.size(); i++) {
            statement.setObject(i + 1, parameters.get(i));
        }
        System.out.println("Generated SQL: " + statement.toString());
        return statement;
    }

    public PreparedStatement buildQuery(Connection c, String flag, boolean hasBranch, boolean hasCrcd, boolean hasIrn, boolean hasGrp) throws SQLException {
    	
        StringBuilder sqlBuilder = new StringBuilder(buildBaseSQL(flag));
        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
        boolean hasToDate = request.getToDate() != null && !request.getToDate().isEmpty();
        List<Object> parameters = new ArrayList<>();
        
        
        if (this.request.getPeriod() == null && hasToDate && !hasFromDate) { 
        parameters.add(request.getToDate());
        parameters.add(request.getCif());
        }
        if (this.request.getPeriod() == null && hasFromDate && hasToDate) {
        parameters.add(request.getFromDate());
        parameters.add(request.getToDate());
        parameters.add(request.getToDate());
        parameters.add(request.getCif());
        }	
    
        if(hasFromDate && !hasToDate) {
        parameters.add(request.getFromDate());
        parameters.add(request.getCif());
        }
        if (this.request.getPeriod() != null && hasFromDate && hasToDate) {
        parameters.add(request.getFromDate());
        parameters.add(request.getToDate());
        parameters.add(request.getToDate());
        parameters.add(request.getCif());
        }
        
        if (hasBranch) {
            sqlBuilder.append("AND substring(boo, 1, 3) = ? ");
            parameters.add(request.getBranch());
        }

        if (hasCrcd) {
            if (request.getCrcd().contains("FULL") && request.getCrcd().size() == 1) {
                // No additional condition for CRCD
            } else {
                sqlBuilder.append("AND crcd IN (");
                StringBuilder placeholders = new StringBuilder();
                for (int i = 0; i < request.getCrcd().size(); i++) {
                    placeholders.append("?");
                    if (i < request.getCrcd().size() - 1) {
                        placeholders.append(",");
                    }
                }
                sqlBuilder.append(placeholders).append(") ");
                parameters.addAll(request.getCrcd());
            }
        }

        if (hasIrn) {
            List<Integer> irnList = new ArrayList<>();
            for (String irn : request.getIrnList()) {
                irnList.add(Integer.parseInt(irn));
            }
            Collections.sort(irnList);
            
            // Add IRN conditions to the SELECT statement
            sqlBuilder.insert(SQL_TEMPLATE.length(), irnGroupConditions(irnList));
        }

        if (hasGrp) {
            String grp = request.getGrp();
            if ("CASA".equalsIgnoreCase(grp)) {
                sqlBuilder.append("AND grp IN (?, ?) ");
                parameters.add("DDA");
                parameters.add("SAV");
            } else if ("FD".equalsIgnoreCase(grp)) {
                sqlBuilder.append("AND grp = ? ");
                parameters.add("CD");
            } else {
                sqlBuilder.append("AND grp = ? ");
                parameters.add(grp);
            }
        }

        sqlBuilder.append(buildGroupBy(hasBranch, hasCrcd));


        return buildPreparedStatement(c, sqlBuilder.toString(), parameters);
    }

    private String irnGroupConditions(List<Integer> irnList) {
        StringBuilder conditionBuilder = new StringBuilder();

        for (int i = 0; i < irnList.size(); i++) {
            if (i == 0) {
                conditionBuilder.append("SUM(CASE WHEN cast(irn as double) <= ").append(irnList.get(i))
                        .append(" THEN dly_ldgr_bal_amt_in_lc END) AS irnDlyGrp").append(i + 1).append(", ");
                conditionBuilder.append("SUM(CASE WHEN irn < ").append(irnList.get(i))
                .append(" THEN YTD_AVG_LDGR_BAL_AMT_IN_LC END) AS irnYtdGrp").append(i + 1).append(", ");
            } else {
                conditionBuilder.append("SUM(CASE WHEN cast(irn as double) > ").append(irnList.get(i - 1))
                        .append(" AND cast(irn as double) <= ").append(irnList.get(i))
                        .append(" THEN dly_ldgr_bal_amt_in_lc END) AS irnDlyGrp").append(i + 1).append(", ");
                conditionBuilder.append("SUM(CASE WHEN cast(irn as double) > ").append(irnList.get(i - 1))
                .append(" AND cast(irn as double) <= ").append(irnList.get(i))
                .append(" THEN YTD_AVG_LDGR_BAL_AMT_IN_LC END) AS irnYtdGrp").append(i + 1).append(", ");
            }
        }
        // Handle last group (irn > last value)
        conditionBuilder.append("SUM(CASE WHEN cast(irn as double) > ").append(irnList.get(irnList.size() - 1))
                .append(" THEN dly_ldgr_bal_amt_in_lc END) AS irnDlyGrp").append(irnList.size() + 1).append(", ");
        conditionBuilder.append("SUM(CASE WHEN cast(irn as double) > ").append(irnList.get(irnList.size() - 1))
        .append(" THEN YTD_AVG_LDGR_BAL_AMT_IN_LC END) AS irnYtdGrp").append(irnList.size() + 1).append(", ");
        return conditionBuilder.toString();
    }
    
    public PreparedStatement SQLPrepareFinal(Connection c) throws SQLException {
        String flag = returnPeriod();
        boolean hasBranch = request.getBranch() != null;
        boolean hasCrcd = request.getCrcd() != null && !request.getCrcd().isEmpty();
        boolean hasIrn = request.getIrnList() != null && !request.getIrnList().isEmpty();
        boolean hasGrp = request.getGrp() != null;

        return buildQuery(c, flag, hasBranch, hasCrcd, hasIrn, hasGrp);
    }
}
