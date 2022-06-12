package model;

import java.sql.*;

/**
 *
 * @author Harshit
 * @author Husban
 */

public class LoginModel {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    
    public LoginModel() throws ClassNotFoundException, SQLException {
        conn = main.Initialize.getIntance().getMySqlConnection();
        stm = conn.createStatement();
    }

    public boolean verifyUseranmePassword(String username,String password) throws SQLException {
        return DatabaseModel.verifyUsername("users", username, conn) && 
                 DatabaseModel.verifyPassword("users", username, password, conn);
    }
}
