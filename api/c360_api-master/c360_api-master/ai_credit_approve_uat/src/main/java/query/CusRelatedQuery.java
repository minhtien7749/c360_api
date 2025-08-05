package query;

import database.JdbcUtils;
import payload.request.CusProfileRequest;
import payload.request.CustomerRelationRequest;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CusRelatedQuery {
    String SQL_TEMPLATE = "select * from (SELECT * , row_number () over (partition by oin order by case when cif is null then 1 else 0 end desc ) as rn   \n" +
            "FROM\n" +
            "customerc360_output.ai_pdtd_cus_relate\n" +
            "where cob_dt ='2025-06-29' and (cif = ? %s) ) a where rn = 1";
    CustomerRelationRequest request;

    private String generatePlaceholderString(ArrayList<String> items) {
        if (items.isEmpty()) {
            return "";
        }
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            placeholders.append("?");
            if (i < items.size() - 1) {
                placeholders.append(", ");
            }
        }
        return placeholders.toString();
    }
    public String buildId(){
        if (request.getIds().size() > 0){
            String ids = "or (cif is null and oin in (" + generatePlaceholderString(request.getIds()) + " ) )";
            return ids;
        }
        return "";
    }

    public CusRelatedQuery(CustomerRelationRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        String customerId = request.getCustomerId();
        ArrayList<String> ids = request.getIds();
        String buildIds = buildId();
        String buildQuery = String.format(SQL_TEMPLATE, buildIds);
        PreparedStatement statement = c.prepareStatement(buildQuery);
        int parameter = 1;
        statement.setString(parameter++,customerId);
        for ( int i = 0; i < ids.size(); i ++){
            statement.setString(parameter++, ids.get(i));
        }

        return statement;
    }

    }