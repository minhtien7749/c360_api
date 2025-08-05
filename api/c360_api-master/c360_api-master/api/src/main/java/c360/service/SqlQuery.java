package c360.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import c360.model.*;
import c360.database.*;

public class SqlQuery {
    private InputRequestCorporate request;

    private String sql;
    private String sqlBranch;
    private String tableName;

    public String getSqlBranch() {
        return sqlBranch;
    }

    public void setSqlBranch(String sqlBranch) {
        this.sqlBranch = sqlBranch;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }


    public SqlQuery(InputRequestCorporate request, String sql, String sqlBranch, String tableName){
        this.request = request;
        this.sql = sql;
        this.sqlBranch = sqlBranch;
        this.tableName = tableName;
    }
    public InputRequestCorporate getRequest() {
        return request;
    }
    public void setRequest(InputRequestCorporate request) {
        this.request = request;
    }

    public String returnPeriod(){
        // function return period for sql query
      if  (this.request.getPeriod() == null){
          return "mth_last_day_flag";
      }
      if (this.request.getPeriod().equals("Y")){
          return "year_end_flag";
      } else if (this.request.getPeriod().equals("M")) return "mth_last_day_flag";
      else return "clndr_qtr_end_flag";
    }

    public PreparedStatement from_cob_period(String cifName, String flag, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ?  and (cob_dt in (select cob_dt  \n" +
                "                                        from customer360.tm_dim \n" +
                "                                        where %s = \"Y\" and cob_dt >= ? and \n" +
                "                                        cob_dt  <= ?) or cob_dt = ? )\n" +
                "             ";
        String groupby = "             group by %s , cob_dt";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, flag, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName, flag);
        }
        
        String sql_final = String.format(this.sql, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2, this.request.getFromDate());
            stm.setString(3, this.request.getCob_dt());
            stm.setString(4, this.request.getCob_dt());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;

    }

    public PreparedStatement branch_from_cob_period(String cifName, String flag, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ? and branch = ?  and (cob_dt in (select cob_dt  \n" +
                "                                        from customer360.tm_dim \n" +
                "                                        where %s = \"Y\" and cob_dt >= ? and \n" +
                "                                        cob_dt  <= ?) or cob_dt = ? )\n" +
                "             ";
        String groupby = "             group by %s , cob_dt, branch";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, flag, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName, flag);
        }
        String sql_final = String.format(this.sqlBranch, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2, this.request.getBranch());
            stm.setString(3, this.request.getFromDate());
            stm.setString(4, this.request.getCob_dt());
            stm.setString(5, this.request.getCob_dt());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;

    }

    public PreparedStatement cob_dt(String cifName, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ?  and  cob_dt = ? \n" +
                "             ";
        String groupby = "             group by %s , cob_dt";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling,cifName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName);
        }
        String sql_final = String.format(this.sql, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2, this.request.getCob_dt());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;
    }

    public PreparedStatement branch_cob_dt(String cifName, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ? and branch = ? and  cob_dt = ? \n" +
                "             ";
        String groupby = "             group by %s , cob_dt, branch";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling,cifName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName);
        }
        String sql_final = String.format(this.sqlBranch, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2,this.getRequest().getBranch());
            stm.setString(3, this.request.getCob_dt());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;
    }

    public PreparedStatement from_period(String cifName, String flag, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ?  and (cob_dt in (select cob_dt  \n" +
                "                                        from customer360.tm_dim \n" +
                "                                        where %s = \"Y\" and cob_dt >= ? and \n" +
                "                                        cob_dt  <= CURDATE()) or cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = '%s'))\n" +
                "         ";
        String groupby = "             group by %s , cob_dt";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, flag, this.tableName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName , flag, this.tableName);
        }
        String sql_final = String.format(this.sql, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2,this.getRequest().getFromDate());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;
    }

    public PreparedStatement branch_from_period(String cifName, String flag, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ? and branch = ?  and (cob_dt in (select cob_dt  \n" +
                "                                        from customer360.tm_dim \n" +
                "                                        where %s = \"Y\" and cob_dt >= ? and \n" +
                "                                        cob_dt  <= CURDATE()) or cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = '%s'))\n" +
                "            ";
        String groupby = "             group by %s , cob_dt, branch";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, flag, this.tableName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName , flag, this.tableName);
        }
        String sql_final = String.format(this.sqlBranch, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2,this.getRequest().getBranch());
            stm.setString(3,this.getRequest().getFromDate());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;
    }

    public PreparedStatement cif_only(String cifName, Connection c, boolean hasGroupBy){
        String sql_filling = "where %s = ? and cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = '%s')\n" +
                "             ";
        String groupby = "             group by %s , cob_dt";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, this.tableName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName , this.tableName);
        }
        String sql_final = String.format(this.sql, sql_filling);
        System.out.println(sql_final);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            System.out.println(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;

    }
    public PreparedStatement branch_cif_only(String cifName, Connection c, boolean  hasGroupBy){
        String sql_filling = "where %s = ? and branch = ? and  cob_dt = (SELECT MAX(cob_dt) FROM customer360.ETL_PROCESS_LOG WHERE job_name = '%s')\n" +
                "             ";
        String groupby = "             group by %s , cob_dt, branch";
        if (hasGroupBy){
            sql_filling += groupby;
            sql_filling = String.format(sql_filling, cifName, this.tableName, cifName);
        } else {
            sql_filling = String.format(sql_filling, cifName , this.tableName);
        }
        String sql_final = String.format(this.sqlBranch, sql_filling);
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(sql_final);
            if (this.getRequest().getCif() != null){
                stm.setString(1,this.getRequest().getCif());
            } else {stm.setString(1,this.getRequest().getTaxId());}
            stm.setString(2,this.getRequest().getBranch());
            System.out.println(stm.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stm;
    }

    public PreparedStatement SQLPrepareFinal(String cifName, Connection c, boolean hasGroupBy){
        if (this.request.getBranch() == null){
            if (this.request.getCob_dt() != null & this.request.getFromDate() != null){
                String flag = returnPeriod();
                return from_cob_period(cifName, flag, c, hasGroupBy);
            } else if (this.request.getCob_dt() != null & this.request.getFromDate() == null) {
                return cob_dt(cifName, c, hasGroupBy);
            } else if (this.request.getCob_dt() == null & this.request.getFromDate() != null){
                String flag = returnPeriod();
                return from_period(cifName, flag, c, hasGroupBy);
            } else return cif_only(cifName, c, hasGroupBy);
        } else {
            if (this.request.getCob_dt() != null & this.request.getFromDate() != null){
                String flag = returnPeriod();
                return branch_from_cob_period(cifName, flag, c, hasGroupBy);
            } else if (this.request.getCob_dt() != null & this.request.getFromDate() == null) {
                return branch_cob_dt(cifName, c, hasGroupBy);
            } else if (this.request.getCob_dt() == null & this.request.getFromDate() != null){
                String flag = returnPeriod();
                return branch_from_period(cifName, flag, c, hasGroupBy);
            } else return branch_cif_only(cifName, c, hasGroupBy);
        }
    }


    public static void main(String args[]){
        String cifName = "acn";
        String flag = "clndr_qtr_end_flag";
        String sql_filling = "where %s = ?  and (cob_dt in (select cob_dt  \n" +
                "                                        from customer360.tm_dim \n" +
                "                                        where %s = \"Y\" and cob_dt >= ? and \n" +
                "                                        cob_dt  <= ?) or cob_dt = ? )\n" +
                "             group by %s , cob_dt";
        sql_filling = String.format(sql_filling,cifName, flag, cifName);

        System.out.println(sql_filling);

    }



}    