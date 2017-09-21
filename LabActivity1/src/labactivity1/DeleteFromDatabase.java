package labactivity1;
import java.util.*;
import java.sql.*;

public class DeleteFromDatabase 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=LabActivity1";
    
    static final String USER = "username";
    static final String PASS = "password";
    
    Connection conn = null;
    Statement stmt = null;
    
    Scanner scan = new Scanner(System.in);
    
    public void deleteFromTable()
    {
        System.out.println("Connected to the database.");
        String yes = "Y";
        String no = "N";
        System.out.println("Enter the user ID to be deleted");
        Long deleteID = scan.nextLong();
        System.out.println("Are you sure you want to delete this user? Y or N?");
        String confirm = scan.next();
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            if(confirm.equals(yes))
            {
                String sql = "DELETE FROM User_Table " + "WHERE ID = ?";
                PreparedStatement prpstmt = conn.prepareStatement(sql);
                prpstmt.setLong(1,deleteID);
                prpstmt.execute();
                System.out.println("User has been deleted!");
                stmt.close();
                conn.close();
            }
            else if(confirm.equals(no))
            {
                System.out.println("Operation aborted.");
            }
            else
                System.out.println("Please enter either Y or N!");
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
    
 