package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author husbankhalid
 */
public class DashboardModel {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet rs = null;
    PreparedStatement pstm = null;
    
    public DashboardModel() throws SQLException{
        conn = main.Initialize.getIntance().getMySqlConnection();
        stm = conn.createStatement();
    }
    
    public boolean checkUserDataExists(String loggedUsername) throws SQLException{
        return DatabaseModel.checkData("user_data", loggedUsername, conn);
    }     
    public boolean checkUserNotesExists(String loggedUsername) throws SQLException{
        return DatabaseModel.checkData("user_notes", loggedUsername, conn);
    }
    
    
    public boolean addUserCredential(String username, String website, String password) throws SQLException {
        PreparedStatement preStm = conn.prepareStatement("INSERT INTO user_data (usr, website, pwd) "
                + "VALUES(?, ?, AES_ENCRYPT(?, 'passmanagerKeyPhrase'));");
        preStm.setString(1, username);
        preStm.setString(2, website);
        preStm.setString(3, password);
        
        int count = preStm.executeUpdate();        
        System.out.println(count + " row(s) inserted.");
        return count>0;
    }
            
    public boolean addUserNotes(String username, String title, String notes) throws SQLException{
        PreparedStatement preStm = conn.prepareStatement("INSERT INTO user_notes(usr,title,notes) "
                + "VALUES(?,AES_ENCRYPT(?,'passSecureNotesKey'),AES_ENCRYPT(?,'passSecureNotesKey'))");
        preStm.setString(1, username);
        preStm.setString(2, title);
        preStm.setString(3, notes);
        int count = preStm.executeUpdate();
        System.out.println(count + " row(s) inserted.");
        return count>0;
    }
}
