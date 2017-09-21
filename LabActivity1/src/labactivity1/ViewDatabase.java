package labactivity1;
import java.util.*;
import java.sql.*;


public class ViewDatabase 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=LabActivity1";
    
    static final String USER = "username";
    static final String PASS = "password";
    
    Connection conn = null;
    Statement stmt = null;
    
    
    
    public void viewDatabase()
    {
        System.out.println("Connected to the database.");
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "SELECT ID, FirstName, LastName, UserType FROM User_Table";
            ResultSet rs = stmt.executeQuery(sql);

                    while(rs.next())
                    {
                        int id = rs.getInt("ID");
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String userType = rs.getString("UserType");

                        System.out.print("ID: " + id);
                        System.out.print(", First Name: " + firstName);
                        System.out.print(", Last Name: " + lastName);
                        System.out.println(", User Type: " + userType);
                    }

                    rs.close();
                    stmt.close();
                    conn.close();
        }catch(SQLException se){
                 se.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    try{
                        if(stmt!=null)
                            stmt.close();
                    }catch (SQLException se2){
                    }
                    try{
                        if(conn!=null)
                            conn.close();
                    }catch(SQLException se){
                        se.printStackTrace();
                    }
                }
    }
}
