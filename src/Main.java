
import controller.LoginController;
import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author harshit
 */
public class Main {

    public static void main(String[] arg) {
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
