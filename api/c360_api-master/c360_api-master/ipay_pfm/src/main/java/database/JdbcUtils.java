package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private String userName = "admin" ; //"ipay1_user";
    private String passWord = ""; //"ipay1_user";
    private String database = "ipay";
    private String hostName = "10.6.145.194:9030"; //"olap-db.icbv.com:9030";
    private String url = "jdbc:mysql://" + hostName + "/" + database;

    public Connection getConnection(){
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return c;
    }
    public void closeConnection(Connection c){
        try {
            if (c != null){
                c.close();
                System.out.println("connection has closed");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
