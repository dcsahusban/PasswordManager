/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author harshit  
 */
public class LoginModel {
    
    private final static String DB_USERNAME="root";
    private final static String DB_PASSWORD="abc";
    Connection conn = null;
    Statement stm = null;
    
    public LoginModel() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/passwordmanager",DB_USERNAME,DB_PASSWORD);
        stm = conn.createStatement();    
    }
    
    public boolean isUserExsist(String username) throws SQLException{
        ResultSet rs = stm.executeQuery("Select usr from users");
        while(rs.next()){
            if(rs.getString(1).equals(username)){
                return true;
            }
        }
        return false;
    }
    
}
