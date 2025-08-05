package c360.service.ipay;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import c360.database.*;
import c360.model.*;
import c360.model.ipay.model.IpayQuery;
import c360.model.ipay.request.*;
import c360.model.response.*;
import c360.model.ipay.model.*;

public class IpayService {
    public static ResponseData insetData(RequestUpdateCategory request){
        JdbcUtil jdbc = new JdbcUtil();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
        String sql = "insert into ipay.ib_pfm_transaction_category_realtime\n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection c = null;
        try {
            c = jdbc.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, request.getAccountNumber());
            statement.setString(2,request.getTseq());
            statement.setString(3, formattedDate);
            statement.setString(4,request.getCustomerNumber());
            statement.setString(5, request.getChanRefNo());
            statement.setString(6, request.getHostRefNo());
            statement.setString(7, request.getMappingId());
            statement.setString(8,request.getCategoryId());
            statement.setString(9, request.getSubCategoryId());
            statement.setString(10, request.getParentId());
            statement.setString(11, request.getChannel());
            statement.setString(12, request.getLastUpdate());
            System.out.println(statement.toString());
            statement.execute();
            c.close();
            return new ResponseData(200, "Success");
        } catch(SQLException e){
            System.out.println(e.getErrorCode());
            return new ResponseData(500, "Internal Server Error", e.getErrorCode());
        }
    }
    public static ResponseData insertData(IpayUpdateRequest request){
        JdbcUtil jdbc = new JdbcUtil();
        int splitNumber = request.getData().size();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String cobDate = localDate.format(formater);
        String sql = "insert into ipay.ib_pfm_transaction_category_realtime\n" +
                "values %s ;";
        String value = "";
        for (int i = 0 ; i < splitNumber; i ++){
            if ( i == splitNumber - 1){
                value += " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            }
            else
                value += "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?),";
        }
        sql = String.format(sql, value);
        Connection c = null;
        try {
            c = jdbc.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            for (int i = 0; i < splitNumber; i ++ ){
                statement.setString(i*15 + 1, request.getData().get(i).getPid());
                statement.setString(i*15 + 2, cobDate);
                statement.setString(i*15 + 3,request.getData().get(i).getAccountNumber());
                statement.setString(i*15 + 4,request.getData().get(i).getTseq());
                statement.setString(i*15 + 5,request.getData().get(i).getCustomerNumber());
                statement.setString(i*15 + 6, request.getData().get(i).getChanRefNo());
                statement.setString(i*15 + 7, request.getData().get(i).getHostRefNo());
                statement.setString(i*15 + 8, request.getData().get(i).getMappingId());
                statement.setString(i*15 + 9,request.getData().get(i).getCategoryId());
                statement.setString(i*15 + 10, request.getData().get(i).getSubCategoryId());
                statement.setString(i*15 + 11, request.getData().get(i).getParentId());
                statement.setBigDecimal(i*15 + 12, request.getData().get(i).getAmount());
                statement.setString(i*15 + 13, request.getData().get(i).getChannel());
                statement.setString(i*15 + 14, request.getData().get(i).getLastUpdate());
                statement.setString(i*15 + 15, request.getData().get(i).getVersion());
            }
            System.out.println(statement.toString());
            statement.execute();
            c.close();
            return new ResponseData(200, "Success");
        } catch (SQLException e){
            return new ResponseData(501, "Internal Server Eror", e.getErrorCode());
        }
    }
    
    public static ResponseData getStatistic(IpayStatisticRequest request){
        JdbcUtil jdbc = new JdbcUtil();
        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(request.getFromDate());
        LocalDate endDate = LocalDate.parse(request.getLastDate());
        if (ChronoUnit.DAYS.between(startDate, endDate) > 30 && request.getPeriod().equals("D")){
            return new ResponseData(404, "The distance between fromDate and endDate must be less than 30 days");
        }
//        if (request.getCustomerId() == null){
//            return new ResponseData(404, "customerId must be not null");
//        }
//        if (request.getListCid() == null){
//            return new ResponseData(404, "cid must be not null");
//        }
        if (request.getFromDate() == null){
            return new ResponseData(404, "fromDate must be not null");
        }
        if (request.getLastDate() == null){
            return new ResponseData(404, "lastDate must be not null");
        }
//        if (request.getCategoryId() == null){
//           return new ResponseData(404, "categoryId must be not null");
//        }
        if (request.getSource() == null){
            return new ResponseData(404, "source must be not null");
        }

        IpayQuery query = new IpayQuery(request);
        List<IpayCategoryStatistic> listStatistic = new ArrayList<>();
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = query.returnSql(c);
            ResultSet rc = statement.executeQuery();

            while (rc.next()){
                String cif = rc.getString("acn");
                String cid = rc.getString("cid");
                String inOut = rc.getString("in_out");
                String categoryId = rc.getString("category_id");
                String name_vi = rc.getString("name_vi");
                String name_en = rc.getString("name_en");
                String cobDate = rc.getString("cob_dt");
                BigDecimal amount = rc.getBigDecimal("amount");
                IpayCategoryStatistic statistic = new IpayCategoryStatistic(cif,cid,inOut,categoryId, name_vi, name_en, cobDate, amount);
                listStatistic.add(statistic);
            }
            c.close();
            return new ResponseData(200,"Success",listStatistic);
        }
        catch (SQLException e){
            return new ResponseData(501, "Internal Server Error", e.getErrorCode());
        }
    }
    
    public static ResponseData getTag(IpayGetTagRequest request){
        String sql = " select * from ipay.ipay_pfm_transaction_t_1 where %s ";
        String mapping = request.getMappingId();
        String mapCol = "";
        if (mapping.contains("T")){
            mapCol = "concat('T','_',cid,'_',tseq) = ? ";
        }
        else {
            mapCol = "concat('H','_',cid,'_',zprfrefno) = ? ";
        }
        sql = String.format(sql,mapCol);
        JdbcUtil jdbc = new JdbcUtil();
        try {
            Connection c = jdbc.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, request.getMappingId());
            System.out.println(statement.toString());
            ResultSet rc = statement.executeQuery();
            ArrayList<IpayGetTagResponse> listResponse = new ArrayList<>();
            while (rc.next()){
                String customerId = rc.getString("acn");
                String accountNo = rc.getString("cid");
                String inOut = rc.getString("in_out");
                String categoryId = rc.getString("category");
                String nameEn = rc.getString("name_en");
                String nameVi = rc.getString("name_vi");
                String pid = rc.getString("pid");
                IpayGetTagResponse tagResponse = new IpayGetTagResponse( customerId, accountNo, inOut,categoryId, nameEn, nameVi, pid);
                listResponse.add(tagResponse);
            }
            c.close();
            return new ResponseData(200,"Success",listResponse);
        } catch(SQLException e){
            return new ResponseData(501, "Internal Server Eror", e.getErrorCode());
        }
    }

}