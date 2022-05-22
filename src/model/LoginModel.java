package model;

import java.sql.*;

/**
 *
 * @author harshit
 * @author husban
 */
public class LoginModel {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    
    public LoginModel() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/passwordmanager", DatabaseModel.DB_USERNAME, DatabaseModel.DB_PASSWORD);
        stm = conn.createStatement();
    }

    public boolean isUserExsists(String username,String password) throws SQLException {
        pstm = conn.prepareStatement("select usr,AES_DECRYPT(pwd,?) from users where usr=?");
        pstm.setString(1, DatabaseModel.PASSKEY);
        pstm.setString(2, username);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String user = rs.getString(1);
            String pass = rs.getString(2);
            System.out.println(pass);
            if (user.equals(username) && pass.equals(password)) {
                return true;
            }
        }
        return false;
    }

}