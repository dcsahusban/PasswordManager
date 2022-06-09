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
        //mysql check
        return DatabaseModel.checkData("user_data", loggedUsername, conn);
    }     
    
    
    public ArrayList<TableModel> getUserData(String loggedUser) throws SQLException{
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
    
    public void addUserCredential(String username, String website, String password) throws SQLException {
        PreparedStatement preStm = conn.prepareStatement("INSERT INTO user_data (usr, website, pwd) "
                + "VALUES(?, ?, AES_ENCRYPT(?, 'passmanagerKeyPhrase'));");
        preStm.setString(1, username);
        preStm.setString(2, website);
        preStm.setString(3, password);
        
        int count = preStm.executeUpdate();
        
        System.out.println(count + " row(s) inserted.");
    }
            
}
