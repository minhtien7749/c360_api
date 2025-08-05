package query;

import dao.request.PfmGetTransRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PfmGetTransByCatCardQuery {
    private static final String SQL_TEMPLATE =
            "SELECT *, CEILING(record_num / ?) AS num_page FROM ( \n" +
                    "    SELECT acn,accountno,cardid,docno,shortremark,fullremark,cob_dt,trancode,amt,crd_stat,bin,card_name,card_grp,termlocation,termcity,siccode,value,category,in_out,name_en,name_vi,type,currency_org,amt_org, 'VND' AS currency, ROW_NUMBER() OVER (ORDER BY cob_dt desc) AS rank_, " +
                    "           COUNT() OVER (PARTITION BY acn) AS record_num \n" +
                    "    FROM ipay.ipay_pfm_card_t_1 \n" +
                    "    WHERE %s %s %s cob_dt >= ? AND cob_dt <= ? AND acn = ? \n" +
                    ") a WHERE CEILING(rank_ / ?) = ?; \n";

    private PfmGetTransRequest request;

    public PfmGetTransByCatCardQuery(PfmGetTransRequest request) {
        this.request = request;
    }

    private String generatePlaceholderString(List<String> items) {
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
    
    public String updateAccountSql() {
    	String placeholderString = generatePlaceholderString(request.getAccountList());
    	if (placeholderString.isEmpty()) {
        	return placeholderString;
        }
    	return "accountno IN (" + placeholderString + ") AND cardid is null and";
    }

    public String updateCardSql() {
        String placeholderString = generatePlaceholderString(request.getCardList());
        if (placeholderString.isEmpty()) {
        	return placeholderString;
        }
        return "cardid IN (" + placeholderString + ") AND ";
    }

    public String updateCategoryId() {
        String placeholderString = generatePlaceholderString(request.getCategoryList());
        if (placeholderString.isEmpty()) {
        	return placeholderString;
        }
        return "category IN (" + placeholderString + ") AND ";
    }

    public PreparedStatement returnSql(Connection connection) throws SQLException {
        String cardSql = updateCardSql();
        String categorySql = updateCategoryId();
        String accountSql = updateAccountSql();
        String finalSql = String.format(SQL_TEMPLATE,accountSql, cardSql, categorySql);
        

        PreparedStatement statement = connection.prepareStatement(finalSql);
        int paramIndex = 1;

        statement.setInt(paramIndex++, request.getPageSize());
        for (String accountNo : request.getAccountList()) {
            statement.setString(paramIndex++, accountNo);
        }

        // Set card parameters
        for (String cardId : request.getCardList()) {
            statement.setString(paramIndex++, cardId);
        }

        // Set category parameters
        for (String categoryId : request.getCategoryList()) {
            statement.setString(paramIndex++, categoryId);
        }

        // Set date and customer parameters
        statement.setString(paramIndex++, request.getPeriodFrom());
        statement.setString(paramIndex++, request.getPeriodTo());
        statement.setString(paramIndex++, request.getCustomerId());

        // Set pagination parameters
        statement.setInt(paramIndex++, request.getPageSize());
        statement.setInt(paramIndex++, request.getPageNum());

        System.out.println(statement.toString());
        return statement;
    }
}
