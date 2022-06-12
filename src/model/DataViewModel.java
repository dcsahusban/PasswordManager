package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Harshit
 */
public class DataViewModel {
    
    Connection conn=null;
    
    public DataViewModel(){}
            
    public boolean deleteUserData(int id,Connection conn) throws SQLException{
        PreparedStatement preStm = conn.prepareStatement("DELETE FROM user_data "
                + "WHERE pwd_id=?");
        preStm.setInt(1, id);   
        System.out.println("Deleting...");
        int count = preStm.executeUpdate();        
        System.out.println(count + " row(s) deleted.");
        return count > 0;
    }
    
    public boolean deleteUserNotes(int id,Connection conn) throws SQLException{
        PreparedStatement preStm = conn.prepareStatement("DELETE FROM user_notes "
                + "WHERE notes_id=?");
        preStm.setInt(1, id);   
        System.out.println("Deleting...");
        int count = preStm.executeUpdate();        
        System.out.println(count + " row(s) deleted.");
        return count > 0;
    }
}
