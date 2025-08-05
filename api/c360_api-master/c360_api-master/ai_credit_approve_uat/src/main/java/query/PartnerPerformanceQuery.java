package query;

import payload.request.PartnerPerformanceRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartnerPerformanceQuery {
    String SQL_TEMPLATE = "SELECT * \n" +
            " FROM customerc360_output.ai_pdtd_partner_performance \n" +
            " WHERE cob_dt ='2025-07-01'/*t-1*/ \n" +
            "                AND taxid IN (%s) /* danh sách mã số thuế truyền vào */\n";

    PartnerPerformanceRequest request;

    public PartnerPerformanceQuery(PartnerPerformanceRequest request) {
        this.request = request;
    }

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

    public PreparedStatement returnQuery(Connection c) throws SQLException {

        ArrayList<String> ids = request.getTaxIds();
        String buildIds = generatePlaceholderString(ids);
        String buildQuery = String.format(SQL_TEMPLATE, buildIds);
        PreparedStatement statement = c.prepareStatement(buildQuery);
        int parameter = 1;
        for ( int i = 0; i < ids.size(); i ++){
            statement.setString(parameter++, ids.get(i));
        }

        return statement;
    }
}