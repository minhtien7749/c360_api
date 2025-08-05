package query;

import dao.request.CorpStatementRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class CorpStatementQuery {
    private final String SQL_TEMPLATE = "select *, count() over (partition by cif, account , itc1) as cred_or_deb, row_number() over ( order by cast(transactionnumber as decimal(20,6))) as beginning, \n" +
            "row_number() over ( order by cast(transactionnumber as decimal(20,6)) desc ) as ending, \n" +
            "sum(debit) over (partition by cif, account) as total_debit, \n" +
            "sum(credit) over (partition by cif, account) as total_credit, accountbal - credit + debit as begball from customerc360_output.corp_statement_dtls where cob_dt >= ? and cob_dt <= ? and cif = ? and account = ?";

    private final String SQL_TEMPLATE_2 = "with base as (\r\n"
    		+ "    select *,count() over (partition by cif, account , itc1) as cred_or_deb, row_number() over ( order by cast(transactionnumber as decimal(20,6))) as beginning,\r\n"
    		+ "           row_number() over ( order by cast(transactionnumber as decimal(20,6)) desc ) as ending,\r\n"
    		+ "            sum(debit) over (partition by cif, account) as total_debit,\r\n"
    		+ "            sum(credit) over (partition by cif, account) as total_credit, accountbal - credit + debit as begball\r\n"
<<<<<<< HEAD
    		+ "    from customerc360_output.corp_statement_dtls\r\n"
    		+ "    where cob_dt >= ? and cob_dt <= ? and cif = ? and account = ?\r\n"
    		+ "), srs_9104 as (\r\n"
    		+ "    select *\r\n"
    		+ "    from customerc360_output.corp_statement_dtls_srs_9104\r\n"
=======
    		+ "    from  customerc360_output.corp_statement_dtls\r\n"
    		+ "    where cob_dt >= ? and cob_dt <= ? and cif = ? and account = ?\r\n"
    		+ "), srs_9104 as (\r\n"
    		+ "    select *\r\n"
    		+ "    from  customerc360_output.corp_statement_dtls_srs_9104\r\n"
>>>>>>> 95a151d0775827236a6be4ce0a4a27aaf6755a42
    		+ "    where cob_dt >= ? and cob_dt <= ?\r\n"
    		+ ")\r\n"
    		+ "select\r\n"
    		+ "    base.*,\r\n"
    		+ "    srs_9104.originalamount33b,\r\n"
    		+ "    srs_9104.originalamountccy33b,\r\n"
    		+ "    srs_9104.sendercharge71f1,\r\n"
    		+ "    srs_9104.senderchargeccy71f1,\r\n"
    		+ "    srs_9104.sendercharge71f2,\r\n"
    		+ "    srs_9104.senderchargeccy71f2,\r\n"
    		+ "    srs_9104.sendercharge71f3,\r\n"
    		+ "    srs_9104.senderchargeccy71f3,\r\n"
    		+ "    srs_9104.sendercharge71f4,\r\n"
    		+ "    srs_9104.senderchargeccy71f4,\r\n"
    		+ "    srs_9104.sendercharge71f5,\r\n"
    		+ "    srs_9104.senderchargeccy71f5,\r\n"
    		+ "    srs_9104.receivercharges71g,\r\n"
    		+ "    srs_9104.receiverchargesccy71g\r\n"
    		+ "from base\r\n"
    		+ "left join srs_9104\r\n"
    		+ "   on concat(base.account, '_', base.transactionnumber) = srs_9104.cid_tseq and base.cob_dt = srs_9104.cob_dt";

    private CorpStatementRequest request;

    public CorpStatementQuery(CorpStatementRequest request) {
        this.request = request;
    }
    

    public PreparedStatement returnSql(Connection connection) throws SQLException {
    	 // Ensure accStatementType is never null
        String accStatementType = Objects.toString(request.getAccStatementType(), "");
        
        System.out.println("accStatementType value: " + accStatementType); // Debug print
        
    	String sql = "TTQT".equals(accStatementType) ? SQL_TEMPLATE_2 : SQL_TEMPLATE;
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("Executing SQL: " + sql);
        int parameterIndex = 1;

        if ("TTQT".equals(accStatementType)) { 
            statement.setString(parameterIndex++, request.getFromDate());
            statement.setString(parameterIndex++, request.getToDate());
            statement.setString(parameterIndex++, request.getCif());
            statement.setString(parameterIndex++, request.getAccount());
            statement.setString(parameterIndex++, request.getFromDate());
            statement.setString(parameterIndex++, request.getToDate());
        } else { 
            statement.setString(parameterIndex++, request.getFromDate());
            statement.setString(parameterIndex++, request.getToDate());
            statement.setString(parameterIndex++, request.getCif());
            statement.setString(parameterIndex++, request.getAccount());

        }
        
        return statement;
    }
}