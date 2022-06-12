package model;

import java.sql.*;

/**
 *
 * @author Husban
 * @author Harshit
 */

public class RegisterModel {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet rs = null;
    PreparedStatement preStm = null;

    public RegisterModel() throws SQLException, ClassNotFoundException {
        conn = conn = main.Initialize.getIntance().getMySqlConnection();
        stm = conn.createStatement();
    }
    
    public boolean isUserExist(String username) throws SQLException {
        rs = stm.executeQuery("Select usr from users");
        while (rs.next()) {
            if (rs.getString("usr").equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmailExist(String email) throws SQLException {
        rs = stm.executeQuery("Select email from users");
        while (rs.next()) {
            if (rs.getString("email").equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    public void addUser(String username, String email, String password) throws SQLException {
        String insert = "INSERT INTO users(usr, email, pwd) VALUES(?, ?, AES_ENCRYPT(?, 'passmanagerKeyPhrase'))";
        preStm = conn.prepareStatement(insert);
        
        preStm.setString(1, username);
        preStm.setString(2, email);
        preStm.setString(3, password);
        
        int count = preStm.executeUpdate();
        
        System.out.println(count + " row(s) inserted.");
    }
}
