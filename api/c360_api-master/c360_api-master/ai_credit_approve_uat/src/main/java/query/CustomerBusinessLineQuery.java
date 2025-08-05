package query;

import payload.request.BusinessLineRequest;
import payload.request.CusProfileRequest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerBusinessLineQuery {
    String SQL_TEMPLATE = "with base AS (\n" +
            " select *, ROW_NUMBER () OVER (order by abs(net_rev - ?)) rn \n" +
            "FROM\n" +
            "customerc360_output.ai_pdtd_co_buss_line\n" +
            "where cob_dt ='2025-06-29' and net_rev BETWEEN ?*0.5 and ?*1.5 and level3 like ? )\n" +
            "SELECT *\n" +
            "from base where rn<=3/*cif*/\n";
    BusinessLineRequest request;

    public CustomerBusinessLineQuery(BusinessLineRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        BigDecimal netRev = request.getNet_rev();
        String level3 = request.getLevel3();
        PreparedStatement statement = c.prepareStatement(SQL_TEMPLATE);
        statement.setBigDecimal(1,netRev);
        statement.setBigDecimal(2,netRev);
        statement.setBigDecimal(3,netRev);
        statement.setString(4,"%;" + level3 + ";%");
        return statement;
    }
}
