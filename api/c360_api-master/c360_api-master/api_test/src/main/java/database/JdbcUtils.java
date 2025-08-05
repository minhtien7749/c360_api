package database;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    public Connection getConnection() throws SQLException, NoSuchAlgorithmException, KeyManagementException {
        String url = "jdbc:trino://10.4.88.131:8080/datalake/production?SSL=true&SSLVerification=NONE";
        String usernam = "minhth7";
        String pass = "Thuybinti242725";
        Connection connection = null;
        try {
            Class.forName("io.trino.jdbc.TrinoDriver");
            connection= DriverManager.getConnection(url, usernam, pass);
            System.out.println("connect success");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public Connection getConnectionDoris() throws SQLException, NoSuchAlgorithmException, KeyManagementException {
    	  String usernam = "customer360_user";
          String pass = "customer360_user"; 
          String database = "customer360";
          String hostName = "olap-db.icbv.com:9030";
          String url = "jdbc:mysql://" + hostName + "/" + database;
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url, usernam, pass);
            System.out.println("connect success");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return connection;
    }
    
    
    public Connection getConnectionUat(){
        String userName = "admin";
        String passWord = "";
        String database = "customer360";
        String hostName = "10.6.145.194:9030";
        String url = "jdbc:mysql://" + hostName + "/" + database;
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return c;
    }
    
}