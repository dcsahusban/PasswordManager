package main;

import java.sql.SQLException;
import model.LoginModel;
import model.RegisterModel;
import model.DashboardModel;
import view.LoginView;
import view.RegisterView;
import view.DashboardView;
import controller.RegisterController;
import controller.LoginController;
import controller.DashboardController;
import controller.DataViewController;
import model.DatabaseModel;
import java.sql.Connection;
import model.DataViewModel;
import view.DataView;

/**
 *
 * @author harshit
 * @author husban
 */
public class Initialize extends InstanceStore implements DatabaseModel {

    private static Initialize init = null;
    private static Connection databseConnection = null;
    private DataViewController dataViewCtr = null;
    
    @Override
    public void setLoginView(LoginView view) {
        super.loginViewV = view;
    }

    @Override
    public void setRegisterView(RegisterView view) {
        super.registerViewV = view;
    }

    @Override
    public void setDashboardView(DashboardView view) {
        super.dashboardViewV = view;
    }
    
    @Override
    public void setLoginCtr(LoginController controller) {
        super.loginController = controller;
    }

    @Override
    public void setRegisterCtr(RegisterController controller) {
        super.registerController = controller;
    }

    @Override
    public void setDashboardCtr(DashboardController controller) {
        super.dashboardController = controller;
    }

    @Override
    public void setDataViewCtr(DataViewController controller) {
        super.dataViewController = controller;
    }
    
    public static Initialize getIntance() {
        return init;
    }

    public static void main(String[] args) {
        init = new Initialize();
        databseConnection = DatabaseModel.setMySqlConnection();
        if (databseConnection!=null) {
            try {
                LoginView loginWindow = new LoginView();
                init.setLoginView(loginWindow);
                LoginModel loginModel = new LoginModel();

                RegisterView registerWindow = new RegisterView();
                init.setRegisterView(registerWindow);
                RegisterModel registerModel = new RegisterModel();
                
                DashboardView dashboardWindow = new DashboardView();
                init.setDashboardView(dashboardWindow);
                DashboardModel dashboardModel = new DashboardModel();

                LoginController loginCtr = new LoginController(loginWindow, loginModel);
                init.setLoginCtr(loginCtr);
                RegisterController registerCtr = new RegisterController(registerWindow, registerModel);
                init.setRegisterCtr(registerCtr);
                DashboardController dashboardCtr = new DashboardController(dashboardWindow, dashboardModel);     
                init.setDashboardCtr(dashboardCtr);
                DataViewController dataViewController = new DataViewController(new DataViewModel());
                init.setDataViewCtr(dataViewController);
                
                loginWindow.setVisible(true);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            
            //TODO Display Error Window
            System.out.println("Connection not established");
           
        }    
    }


    @Override
    public Connection getMySqlConnection() {
        return databseConnection;    
    }
 
}
