package model;

import java.sql.*;

/**
 *
 * @author harshit
 * @author husban
 */
public class LoginModel {

    private final static String DB_USERNAME = "root";
    // private final static String DB_PASSWORD="abc";
    private final static String DB_PASSWORD = "root";
    Connection conn = null;
    Statement stm = null;

    public LoginModel() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/passwordmanager", DB_USERNAME, DB_PASSWORD);
        stm = conn.createStatement();
    }

    public boolean isUserExsist(String username) throws SQLException {
        ResultSet rs = stm.executeQuery("Select usr from users");
        while (rs.next()) {
            if (rs.getString(1).equals(username)) {
                return true;
            }
        }
        return false;
    }

}