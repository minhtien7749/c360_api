package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.TaxDataRequest;

public class TaxDataQuery {
	private final  String SQL_TEMPLATE = "select id, tax_no, name, tax_city_dep, tax_district_dept, rpt_num,rpt_dt, apply, tax_amt, link, status, cob_dt from outsite.tax_data where tax_no = ? ";
	private final  String SQL_TEMPLATE_COB_DT = "select id, tax_no, name, tax_city_dep, tax_district_dept, rpt_num,rpt_dt, apply, tax_amt, link, status, cob_dt from outsite.tax_data where tax_no = ? and cob_dt = ? ";

	private TaxDataRequest request;

    public TaxDataQuery(TaxDataRequest request) {
        this.request = request;
    }
        
    public PreparedStatement returnSql(Connection connection) throws SQLException {

        if(request.getCobDt() != null && request.getTaxNo() != null ) {
        	PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE_COB_DT);
            System.out.println("sc sql");
            int parameterIndex = 1;
        statement.setString(parameterIndex ++, request.getTaxNo());
        statement.setString(parameterIndex ++, request.getCobDt());
        return statement;
        }else {
        	PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE);
            System.out.println("sc sql");
            int parameterIndex = 1;
            statement.setString(parameterIndex ++, request.getTaxNo());
        System.out.println("sc2");
        return statement;
        }
    }
}


