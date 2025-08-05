package query;

import payload.request.BusinessLineRequest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusLinePerfomanceQuery {
    String SQL_TEMPLATE = "WITH base AS ( \n" +
            "SELECT *, ROW_NUMBER () OVER (ORDER BY abs(b_i_5_1_47_1 - ?)) rn \n" +
            "FROM datalake.customerc360_output.ai_pdtd_co_buss_line_performance  \n" +
            "WHERE cob_dt ='2025-06-29' \n" +
            "AND position(? in lv3 ) > 0 \n" +
            ")\n" +
            "SELECT * FROM base WHERE rn<=5 \n";
    BusinessLineRequest request;

    public BusLinePerfomanceQuery(BusinessLineRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        BigDecimal netRev = request.getNet_rev();
        String level3 = request.getLevel3();
        PreparedStatement statement = c.prepareStatement(SQL_TEMPLATE);
        statement.setBigDecimal(1,netRev);
        statement.setString(2,level3);
        return statement;
    }
}
