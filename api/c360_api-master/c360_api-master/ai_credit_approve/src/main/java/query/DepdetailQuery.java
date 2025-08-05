package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import payload.request.DepdetailRequest;

public class DepdetailQuery {
	private final  String SQL_TEMPLATE = "select acn ,cid ,stat, cus_nm, crcd,"
			+ "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_depst_dtls_fact') and cid = ? ";
	
	private final  String SQL_TEMPLATE_ACN = "select acn ,cid ,stat, cus_nm, crcd,"
			+ "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_depst_dtls_fact') and convacn = ? ";
	
	private final  String SQL_TEMPLATE_TAXID = "select acn ,cid ,stat, cus_nm, crcd,"
			+ "cob_dt from customer360.taxid_depst_dtls_fact where taxid = ? ";
	
	private DepdetailRequest request;

    public DepdetailQuery(DepdetailRequest request) {
        this.request = request;
    }
        
    public PreparedStatement returnSql(Connection connection) throws SQLException {
    	String convacn = request.getConvacn();
    	String cid = request.getCid();
    	String sql;
        PreparedStatement statement;
        int parameterIndex = 1;
        
            	if(convacn != null) {
            		sql = SQL_TEMPLATE_ACN;
                	statement = connection.prepareStatement(sql);
                    System.out.println("sc sql");
                    statement.setString(parameterIndex ++, request.getConvacn());
            	} else if(cid != null) {
        		sql = SQL_TEMPLATE;
            	statement = connection.prepareStatement(sql);
                System.out.println("sc sql");
                statement.setString(parameterIndex ++, request.getCid());
            	} else {
            		sql = SQL_TEMPLATE_TAXID;
                	statement = connection.prepareStatement(sql);
                    System.out.println("sc sql");
                    statement.setString(parameterIndex ++, request.getMst());
            	}
        return statement;
            	
    }
}
