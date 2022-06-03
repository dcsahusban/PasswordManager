/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
    

            
}
