import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.sql.*;


public class DataAccess {
    private dbUtil dbUtil;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    
    
    public DataAccess(){
        dbUtil = new dbUtil();
        
        if(connection== null) dbUtil.getConnection();
    }
    
    public List viewUsers(){
        //select statement
        List<User> result = new LinkedList<User>();
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Users");
            
            //get each object on rs, store on list
            while(rs.next()){
                User user = new User( rs.getInt("id"), 
                                rs.getString("username"), 
                                rs.getString("firstName"), 
                                rs.getString("lastName"), 
                                rs.getString("password"), 
                                rs.getString("userType"));
                
                result.add(user);
                System.out.println("Adding " + user.toString());
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Total size of List = " + result.size());
        return result;
    }
}
