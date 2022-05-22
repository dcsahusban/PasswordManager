package model;

import java.sql.*;

/**
 *
 * @author husban
 * @author harshit
 */
public class RegisterModel {
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "root";

    Connection conn = null;
    Statement stm = null;

    public RegisterModel() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/passwordmanager", DB_USERNAME, DB_PASSWORD);
        stm = conn.createStatement();
    }
    
    public boolean isUserExist(String username) throws SQLException {
        ResultSet rs = stm.executeQuery("Select usr from users");
        while (rs.next()) {
            if (rs.getString("usr").equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmailExist(String email) throws SQLException {
        ResultSet rs = stm.executeQuery("Select email from users");
        while (rs.next()) {
            if (rs.getString("email").equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    public void addUser(String username, String email, String password) throws SQLException {
        String insert = "INSERT INTO users(usr, email, pwd) VALUES(?, ?, AES_ENCRYPT(?, 'passmanagerKeyPhrase'))";
        PreparedStatement preStm = conn.prepareCall(insert);
        
        preStm.setString(1, username);
        preStm.setString(2, email);
        preStm.setString(3, password);
        
        int count = preStm.executeUpdate();
        
        System.out.println(count + " row(s) inserted.");
    }
}
