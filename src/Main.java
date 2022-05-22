import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;
import view.RegisterView;
import model.RegisterModel;
import controller.RegisterController;
import controller.LoginController;

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
            RegisterView registerWindow = new RegisterView();
            RegisterModel registerModel = new RegisterModel();
            LoginController loginCtr = new LoginController(loginWindow, loginModel, registerWindow);
            RegisterController registerCtr = new RegisterController(registerWindow, registerModel);

            loginWindow.setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}