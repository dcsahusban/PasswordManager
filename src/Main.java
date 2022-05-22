import controller.LoginController;
import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;

/**
 *
 * @author harshit
 * @author husban
 */

public class Main {
    public static void main(String[] args) {
        try {
            LoginView loginWindow = new LoginView();
            LoginModel loginModel = new LoginModel();
            LoginController loginCtr = new LoginController(loginWindow, loginModel);

            loginWindow.setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}