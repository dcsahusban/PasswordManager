package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        PreparedStatement pstm = conn.prepareStatement("select usr from " + table + " where usr=?");
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
    
    public static ArrayList<TableModel> getUserData(String loggedUser,Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement("select "
                + "user_data.pwd_id, user_data.website, "
                + "AES_DECRYPT(user_data.pwd,'passmanagerKeyPhrase'), user_data.ts "
                + "from users "
                + "inner join user_data "
                + "on users.usr=user_data.usr "
                + "where users.usr=?");
        pstm.setString(1, loggedUser);
        ResultSet rs = pstm.executeQuery();
        ArrayList<TableModel> list = new ArrayList<>();
        while(rs.next()){                       
            TableModel data = new TableModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
            list.add(data);
        }
        return list;
    }
    
    public static ArrayList<NotesModel> getUserNotes(String loggedUser,Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement("select "
                + "user_notes.notes_id, "
                + "AES_DECRYPT(user_notes.title,'passSecureNotesKey'), "
                + "AES_DECRYPT(user_notes.notes,'passSecureNotesKey'), "
                + "user_notes.dt "
                + "from "
                + "users inner join user_notes on users.usr=user_notes.usr "
                + "where users.usr=?");
        pstm.setString(1, loggedUser);
        ResultSet rs = pstm.executeQuery();
        ArrayList<NotesModel> list = new ArrayList<>();
        while(rs.next()){                       
            NotesModel data = new NotesModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
            list.add(data);
        }
        return list;
    }
    
    public Connection getMySqlConnection();
    
}
