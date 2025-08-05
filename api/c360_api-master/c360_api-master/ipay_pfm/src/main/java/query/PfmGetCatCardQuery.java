package query;

import dao.request.PfmGetTranCardRequest;
import dao.request.PfmGetTranCatRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PfmGetCatCardQuery {
    private static final String SQL_TEMPLATE = "select acn , accountno , cardid,category , docno , in_out , name_en , name_vi\n" +
            "from ipay_pfm_card_t_1 ipct \n" +
            "where docno = ? and no = ?";
    PfmGetTranCardRequest request;
    
    public PfmGetCatCardQuery(PfmGetTranCardRequest request) {
        this.request = request;
    }
    public PreparedStatement returnSql(Connection c) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = c.prepareStatement(SQL_TEMPLATE);
            int paramIndex = 1;
            statement.setString(1, request.getDocNo());
            statement.setString(2, request.getNo());

        } catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
        System.out.println(statement.toString());
        return statement;
    }
}