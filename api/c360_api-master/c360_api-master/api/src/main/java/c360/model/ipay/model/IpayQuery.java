package c360.model.ipay.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import c360.database.JdbcUtil;
import c360.model.ipay.request.IpayStatisticRequest;

public class IpayQuery {
    String sql = "Select acn, cid, in_out, category_id, category, name_vi, name_en ,sum(amt) as amount, %s as cob_dt from ipay.ipay_pmf_transaction_statistic_t_1 where %s acn  = ? and cob_dt >= ? and cob_dt <= ? %s and in_out = ? " +
            "group by acn, cid, in_out, category_id, category, name_vi, name_en, %s";
    IpayStatisticRequest request;
    public String getPeriod(IpayStatisticRequest request){
        if (request.getPeriod().equals("M") )
            return "CONCAT(LPAD(CAST(MONTH(cob_dt) AS CHAR(2)), 2, '0'), '-', CAST(YEAR(cob_dt) AS CHAR(4)))";
        else if (request.getPeriod().equals("W")) {
            return "CONCAT(LPAD(CAST(week(cob_dt) AS CHAR(2)), 2, '0'), '-', CAST(YEAR(cob_dt) AS CHAR(4))) ";
        } else if (request.getPeriod().equals("D")) {
            return "cob_dt";
        } else {
            return "year(cob_dt);";
        }
    }

    public IpayQuery(IpayStatisticRequest request) {
        this.request = request;
    }

    public String updateCidSql(){
        if (request.getListCid().isEmpty()){
            return "";
        }
        String listCid = "cid in (%s) and";
        String cid = "";
        int count = request.getListCid().size();
        for (int i = 0; i < count; i ++){
            if (i == count -1){
                cid += " ? ";
            }
            else
                cid += " ?, ";
        }
        return String.format(listCid, cid);
    }

    public PreparedStatement returnSql(Connection c) throws SQLException {
        String updateSql = getPeriod(request);
        String listCid = updateCidSql();
        String category_id = "and category_id = ?";
        if (request.getCategoryId() == null)
            category_id = "";
        System.out.print(category_id);
        String finalSql = String.format(sql,updateSql,listCid,category_id, updateSql);
        System.out.print(finalSql);
        PreparedStatement statement = c.prepareStatement(finalSql);
        int size = request.getListCid().size();
        for (int i = 1; i <= size; i ++){
            statement.setString(i,request.getListCid().get(i-1));
        }
        statement.setString(size + 1,request.getCustomerId());
        statement.setString(size + 2,request.getFromDate());
        statement.setString(size + 3,request.getLastDate());
        if (request.getCategoryId() == null)
            statement.setString(size + 4,request.getSource());
        else
            {statement.setString(size + 4,request.getCategoryId());
            statement.setString(size + 5,request.getSource());}

        System.out.println(statement.toString());
        return statement;
    }

}