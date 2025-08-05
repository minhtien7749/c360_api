package c360.database;

import java.sql.*;

public class JdbcUtil {
    private String hostName =  "olap-db.icbv.com:9030";//
    private String userName =  "customer360_user";
    private String dbName = "customer360";
    private String password = "customer360_user"; //"nmpF2ADA4Dy4ur";
    private String Url = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection getConnection(){
        Connection c = null;
        try {
            c = DriverManager.getConnection(Url, userName, password);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return c;
    }
    public void closeConnection(Connection c){
        try {
            if (c != null){
                c.close();
                System.out.println("connection was closed");
            }
        } catch (Exception e){
            System.out.println("Connection close error");
        }
    }
    public static void main(String args[]){
        JdbcUtil jdbc = new JdbcUtil();
        Connection c = jdbc.getConnection();
        String sql = "select distinct job_name , cob_dt , process_sts  from customer360.ETL_PROCESS_LOG epl ;";
        Statement stm = null;
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String jobName = rs.getString("job_name");
                String cobDate = rs.getString("cob_dt");
                String processStatus = rs.getString("process_sts");
                System.out.println(jobName + " " + cobDate + " " + processStatus);
            }
        } catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
        jdbc.closeConnection(c);
    }
}