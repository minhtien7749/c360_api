package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.request.PaySalFactRequest;

public class PaySalFactQuery {
	private final  String SQL_TEMPLATE = "SELECT\r\n"
			+ "    p.debt_cus_cif_nbr, -- CIF khách hàng chi lương\r\n"
			+ "    SUM(p.tot_sal_in_lc)  AS tot_sal_in_lc, -- Tổng giá trị các giao dịch chi lương của CIF khách hàng trả lương\r\n"
			+ "    SUM(CASE WHEN p.crdt_cus_cif_nbr IS NULL THEN p.tot_sal_in_lc ELSE NULL END)      AS tot_sal_in_lc_nht, -- Doanh số chi lương ngoài hệ thống\r\n"
			+ "    SUM(CASE WHEN p.crdt_cus_cif_nbr IS NOT NULL THEN p.tot_sal_in_lc ELSE NULL END)  AS tot_sal_in_lc_tht, -- Doanh số chi lương trong hệ thống\r\n"
			+ "    COUNT(DISTINCT p.crdt_act_nbr) AS sl_cbnv_nhan_luong, -- Số lượng CBNV nhận lương\r\n"
			+ "    COUNT(DISTINCT (CASE WHEN p.crdt_cus_cif_nbr IS NULL THEN p.crdt_act_nbr ELSE NULL END))     AS sl_cbnv_nhan_luong_nht, -- Số lượng CBNV nhận lương ngoài hệ thống\r\n"
			+ "    COUNT(DISTINCT (CASE WHEN p.crdt_cus_cif_nbr IS NOT NULL THEN p.crdt_act_nbr ELSE NULL END)) AS sl_cbnv_nhan_luong_tht, -- Số lượng CBNV nhận lương trong hệ thống\r\n"
			+ "    SUM(sal_trnsfr_nbr) as slgd_luy_ke, -- Số lượng giao dịch lũy kế \r\n"
			+ "    p.cob_dt\r\n";


	private PaySalFactRequest request;
	
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
	  
    public PaySalFactQuery(PaySalFactRequest request) {
        this.request = request;
    }
            
    private String buildBaseSQL(String flag) {
        StringBuilder sqlBuilder = new StringBuilder(SQL_TEMPLATE);

        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
        boolean hasToDate = request.getCobDt() != null && !request.getCobDt().isEmpty();
        boolean hasBranch = request.getBranch() != null;
   
        // Conditionally add branch
        if (hasBranch) {         
        	sqlBuilder.append(", debt_pri_brnch_cd ,");     
        }     
        
        if (this.request.getPeriod() == null  && (hasFromDate && hasToDate)) {
        	sqlBuilder.append(" cob_dt FROM customer360.c360_pay_sal_fact p WHERE ")
                      .append("(cob_dt >= ? AND cob_dt <= ?) ");
        }
        if(hasFromDate && !hasToDate) {
        	sqlBuilder.append(" cob_dt FROM customer360.c360_pay_sal_fact p WHERE ")
            .append("cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND (cob_dt >= ? AND cob_dt <= CURDATE()) or cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_pay_sal_fact')) ");
        }
        if (this.request.getPeriod() != null && (hasFromDate && hasToDate)) {
            System.out.println("Pass period from to");

        	sqlBuilder.append(" cob_dt FROM customer360.c360_pay_sal_fact p WHERE ")
            .append("(cob_dt in (select cob_dt  from customer360.tm_dim where ")
            .append(flag).append(" = 'Y' AND cob_dt >= ? AND cob_dt <= ?) or cob_dt = ? ) ");
        }

        sqlBuilder.append(" AND debt_cus_cif_nbr = ? ");

        return sqlBuilder.toString();
    }

    private String buildGroupBy(boolean hasBranch) {
        List<String> groupByColumns = new ArrayList<>();
        
        groupByColumns.add("debt_cus_cif_nbr");  // Always group by debt_cus_cif_nbr
        groupByColumns.add("cob_dt"); // Always group by cob_dt

        if (hasBranch) {
            groupByColumns.add("debt_pri_brnch_cd"); // Group by branch if it exists
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

    public PreparedStatement buildQuery(Connection c, String flag, boolean hasBranch) throws SQLException {
    	
        StringBuilder sqlBuilder = new StringBuilder(buildBaseSQL(flag));
        boolean hasFromDate = request.getFromDate() != null && !request.getFromDate().isEmpty();
        boolean hasToDate = request.getCobDt() != null && !request.getCobDt().isEmpty();
        List<Object> parameters = new ArrayList<>();
        
        if (this.request.getPeriod() == null  && (hasFromDate && hasToDate)) {
        parameters.add(request.getFromDate());
        parameters.add(request.getCobDt());
        parameters.add(request.getCif());
        }
        if(hasFromDate && !hasToDate) {
        parameters.add(request.getFromDate());
        parameters.add(request.getCif());
        }
        if (this.request.getPeriod() != null && hasFromDate && hasToDate) {
        parameters.add(request.getFromDate());
        parameters.add(request.getCobDt());
        parameters.add(request.getCobDt());
        parameters.add(request.getCif());
        }
        
        if (hasBranch) {
            sqlBuilder.append("AND debt_pri_brnch_cd = ? ");
            parameters.add(request.getBranch());
        }

        sqlBuilder.append(buildGroupBy(hasBranch));


        return buildPreparedStatement(c, sqlBuilder.toString(), parameters);
    }
    
    public PreparedStatement SQLPrepareFinal(Connection c) throws SQLException {
        String flag = returnPeriod();
        boolean hasBranch = request.getBranch() != null;


        return buildQuery(c, flag, hasBranch);
    }

}
