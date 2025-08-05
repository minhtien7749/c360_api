package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.request.LnDtlFactRequest;

public class LnDtlFactQuery {
	private final  String SQL_TEMPLATE = "select cus_cif_nbr," +
		    "SUM(cast(ytd_avg_bal_amt_in_lc as double)) as ytdAvgBalAmt,"
		    + "SUM(cast(dly_ostd_bal_amt_in_lc as double)) as dlyBalAmt,"
		    + "SUM(case when cast(trmm as double) <= 12 then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdAvgBalAmtNh ,"
            + "SUM(case when cast(trmm as double) > 12 and cast(trmm as double) <= 60 then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdAvgBalAmtTh ,"
            + "SUM(case when cast(trmm as double) > 60 then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdAvgBalAmtDh ,"
            + "SUM(case when loan_clsfy = '1' then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdBalAmtGroup1 ," 
            + "SUM(case when loan_clsfy = '2' then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdBalAmtGroup2 ,"
            + "SUM(case when loan_clsfy = '3' then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdBalAmtGroup3 ,"
            + "SUM(case when loan_clsfy = '4' then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdBalAmtGroup4 ,"
            + "SUM(case when loan_clsfy = '5' then cast(ytd_avg_bal_amt_in_lc as double) end) as ytdBalAmtGroup5 ,"
            + "SUM(case when cast(trmm as double) <= 12 then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyAvgBalAmtNh ,"
            + "SUM(case when cast(trmm as double) > 12 and cast(trmm as double) <= 60 then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtTh ,"
            + "SUM(case when cast(trmm as double) > 60 then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyAvgBalAmtDh ,"
            + "SUM(case when loan_clsfy = '1' then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtGroup1 ,"
            + "SUM(case when loan_clsfy = '2' then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtGroup2 ,"
            + "SUM(case when loan_clsfy = '3' then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtGroup3 ,"
            + "SUM(case when loan_clsfy = '4' then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtGroup4 ,"
            + "SUM(case when loan_clsfy = '5' then cast(dly_ostd_bal_amt_in_lc as double) end) as dlyBalAmtGroup5 ,"
            + "SUM(case when cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact_update_nii') then null else cast(ytd_nii_alco_amt_in_lc as double) end ) as ytdNiiAmt ,"
            + "SUM(case when cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact_update_nii') then null "
            + " when cast(trmm as double) <= 12 then cast(ytd_nii_alco_amt_in_lc as double) end) as ytdNiiAmtNh ,"
            + "SUM(case when cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact_update_nii') then null "
            + "when cast(trmm as double) > 12 and cast(trmm as double) <= 60 then cast(ytd_nii_alco_amt_in_lc as double) end) as ytdNiiAmtTh ,"
            + "SUM(case when cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact_update_nii') then null "
            + "when cast(trmm as double) > 60 then cast(ytd_nii_alco_amt_in_lc as double) end) as ytdNiiAmtDh ,"
            + "SUM(case when lnd.cob_dt >= (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact_update_nii') then null else cast(ytd_nii_alco_amt_in_lc as double) end) / SUM(cast(ytd_avg_bal_amt_in_lc as double)) as ytdNimAmt,";


    private LnDtlFactRequest request;

    public LnDtlFactQuery(LnDtlFactRequest request) {
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
        	sqlBuilder.append(" brnch_cd AS branch,");     }     
        // Conditionally add crcd 
        if (hasCrcd) {         
        	sqlBuilder.append(" crcd,");     
        	}  
        
        // Always select basic columns   
        sqlBuilder.append("lnd.cob_dt");   
        
        if (this.request.getPeriod() == null && hasToDate && !hasFromDate) {   
        	sqlBuilder.append(" FROM customer360.c360_lon_dtls_fact lnd WHERE ")
                      .append(" lnd.cob_dt = ? ");
        }
        if (this.request.getPeriod() == null && hasFromDate && hasToDate) {
            sqlBuilder.append(" FROM customer360.c360_lon_dtls_fact lnd WHERE ")
                      .append("((lnd.cob_dt >= ? AND lnd.cob_dt <= ?) or lnd.cob_dt = ?) ");
        }
        if(hasFromDate && !hasToDate) {
            sqlBuilder.append(" FROM customer360.c360_lon_dtls_fact lnd WHERE ")
            .append("lnd.cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND (cob_dt >= ? AND cob_dt <= CURDATE()) or cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_lon_dtls_fact')) ");
        }        
        if (this.request.getPeriod() != null && (hasFromDate && hasToDate)) {
        	 sqlBuilder.append(" FROM customer360.c360_lon_dtls_fact lnd WHERE ")
             .append("(lnd.cob_dt in (select cob_dt  from customer360.tm_dim where ")
             .append(flag).append(" = 'Y' AND cob_dt >= ? AND cob_dt <= ?) OR lnd.cob_dt = ?) ");
        }

        sqlBuilder.append(" AND cus_cif_nbr = ? ");

        return sqlBuilder.toString();
    }

    private String buildGroupBy(boolean hasBranch, boolean hasCrcd) {
        List<String> groupByColumns = new ArrayList<>();
        
        groupByColumns.add("cus_cif_nbr");  // Always group by cus_cif_nbr
        groupByColumns.add(" lnd.cob_dt"); // Always group by cob_dt

        if (hasCrcd) {
            groupByColumns.add("crcd"); // Group by crcd if it exists
        }

        if (hasBranch) {
            groupByColumns.add("brnch_cd"); // Group by branch if it exists
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

    public PreparedStatement buildQuery(Connection c, String flag, boolean hasBranch, boolean hasCrcd, boolean hasIrn) throws SQLException {
        StringBuilder sqlBuilder = new StringBuilder(buildBaseSQL(flag));
        List<Object> parameters = new ArrayList<>();
        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
        boolean hasToDate = request.getToDate() != null && !request.getToDate().isEmpty();
        
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
            sqlBuilder.append("AND brnch_cd = ? ");
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

        sqlBuilder.append(buildGroupBy(hasBranch, hasCrcd));


        return buildPreparedStatement(c, sqlBuilder.toString(), parameters);
    }

    private String irnGroupConditions(List<Integer> irnList) {
        StringBuilder conditionBuilder = new StringBuilder();

        for (int i = 0; i < irnList.size(); i++) {
            if (i == 0) {
                conditionBuilder.append("SUM(CASE WHEN cast(intrst_rate as double) <= ").append(irnList.get(i))
                        .append(" THEN cast(dly_ostd_bal_amt_in_lc as double)  END) AS irnDlyGrp").append(i + 1).append(", ");
                conditionBuilder.append("SUM(CASE WHEN cast(intrst_rate as double) <= ").append(irnList.get(i))
                .append(" THEN cast(YTD_AVG_BAL_AMT_IN_LC as double)  END) AS irnYtdGrp").append(i + 1).append(", ");
            } else {
                conditionBuilder.append("SUM(CASE WHEN cast(intrst_rate as double) > ").append(irnList.get(i - 1))
                        .append(" AND cast(intrst_rate as double) <= ").append(irnList.get(i))
                        .append(" THEN cast(dly_ostd_bal_amt_in_lc as double)  END) AS irnDlyGrp").append(i + 1).append(", ");
                conditionBuilder.append("SUM(CASE WHEN cast(intrst_rate as double) > ").append(irnList.get(i - 1))
                .append(" AND cast(intrst_rate as double) <= ").append(irnList.get(i))
                .append(" THEN cast(YTD_AVG_BAL_AMT_IN_LC as double)  END) AS irnYtdGrp").append(i + 1).append(", ");
            }
        }

        // Handle last group (irn > last value)
        conditionBuilder.append("SUM(CASE WHEN intrst_rate > ").append(irnList.get(irnList.size() - 1))
                .append(" THEN cast(dly_ostd_bal_amt_in_lc as double) END) AS irnDlyGrp").append(irnList.size() + 1).append(", ");
        
     // Handle last group (irn > last value)
        conditionBuilder.append("SUM(CASE WHEN intrst_rate > ").append(irnList.get(irnList.size() - 1))
                .append(" THEN cast(YTD_AVG_BAL_AMT_IN_LC as double) END) AS irnYtdGrp").append(irnList.size() + 1).append(", ");
        return conditionBuilder.toString();
    }
    
    public PreparedStatement SQLPrepareFinal(Connection c) throws SQLException {
        String flag = returnPeriod();
        boolean hasBranch = request.getBranch() != null;
        boolean hasCrcd = request.getCrcd() != null && !request.getCrcd().isEmpty();
        boolean hasIrn = request.getIrnList() != null && !request.getIrnList().isEmpty();

        return buildQuery(c, flag, hasBranch, hasCrcd, hasIrn);
    }
    
}

