package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import payload.request.DepdetailRequest;

public class DepdetailQuery {
	private final  String SQL_TEMPLATE = "select acn ,cid ,stat, cus_nm, crcd, "
			+ "cob_dt from customer360.c360_depst_dtls_fact where cob_dt = (select MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = 'c360_depst_dtls_fact') and cid = ?  ";
	
	private DepdetailRequest request;

    public DepdetailQuery(DepdetailRequest request) {
        this.request = request;
    }
        
    public PreparedStatement returnSql(Connection connection) throws SQLException {
        String sql;
        PreparedStatement statement;
        int parameterIndex = 1;
        
            	 sql = SQL_TEMPLATE;
            	statement = connection.prepareStatement(sql);
                System.out.println("sc sql");
                statement.setString(parameterIndex ++, request.getCid());

        return statement;
    }
}
