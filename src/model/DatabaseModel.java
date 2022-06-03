package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author harshit
 * @author husban
 */

public interface DatabaseModel {
    
    public final static String PASSKEY = "passmanagerKeyPhrase";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD="abc";
//     public final static String DB_PASSWORD = "root";
    
    public static Connection setMySqlConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/passwordmanager", DatabaseModel.DB_USERNAME, DatabaseModel.DB_PASSWORD);            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }        
    }
    
    public static boolean checkData(String table,String user,Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement("select usr from user_data where usr=?");
         pstm.setString(1, user);
        ResultSet rs = pstm.executeQuery();
        return rs.next();
    }
    
    public static boolean verifyUsername(String table,String user,Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement("select usr from users where usr=?");
        pstm.setString(1, user);
        ResultSet rs = pstm.executeQuery();
        return rs.next() && rs.getString(1).equals(user);
    }
    
    public static boolean verifyPassword(String table,String user,String password,Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement("select AES_DECRYPT(pwd,?) from users where usr=?");
        pstm.setString(1, DatabaseModel.PASSKEY);
        pstm.setString(2, user);        
        ResultSet rs = pstm.executeQuery();
        return rs.next() && rs.getString(1).equals(password);
    }
    
    public Connection getMySqlConnection();
    
}
