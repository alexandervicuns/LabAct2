package labactivity1;
import java.util.*;
import java.sql.*;

public class UpdateDatabase 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=LabActivity1";
    
    static final String USER = "username";
    static final String PASS = "password";
    
    Connection conn = null;
    Statement stmt = null;
    
    Scanner scan = new Scanner(System.in);
    
    public void updateTable()
    {
        System.out.println("Connected to the database.");
        String admin = "Admin";
        String student = "Student";
        System.out.println("Please enter the user ID.");
        int userID = scan.nextInt();
        System.out.println("Please update the first name of the new user: ");
        String newFirst = scan.next();
        System.out.println("Please update the last name of the new user: ");
        String newLast = scan.next();
        System.out.println("Please update the user type: "); 
        String newUserType = scan.next();
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            if(newUserType.equals(admin) || (newUserType.equals(student)))
                {
                    String sql = "UPDATE User_Table SET FirstName = ?, LastName = ?, UserType = ? WHERE ID = ?";
                    PreparedStatement prpstmt = conn.prepareStatement(sql);
                    prpstmt.setString(1,newFirst);
                    prpstmt.setString(2,newLast);
                    prpstmt.setString(3,newUserType);
                    prpstmt.setInt(4,userID);
                    prpstmt.executeUpdate();
                    System.out.println("Table has been updated!");
                    stmt.close();
                    conn.close();
                }
                else
                {
                    System.out.println("ERROR! Please enter Admin or Student only.");
                }            
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
