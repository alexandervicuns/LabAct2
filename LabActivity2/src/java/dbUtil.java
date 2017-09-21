import java.sql.*;
import java.util.*;
/**
 *
 * @author Bacon
 */
public class dbUtil 

{
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=LabActivity2";
    
    static final String USER = "username";
    static final String PASS = "password";
    
    Connection conn = null;
    
    public Connection getConnection() {
       try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        }catch(SQLException se){
                 se.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
       return conn;
    }
}
