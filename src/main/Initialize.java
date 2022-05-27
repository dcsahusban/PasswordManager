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
import view.ViewStore;

/**
 *
 * @author harshit
 * @author husban
 */

public class Initialize extends ViewStore {
   
    private static Initialize init = null;
    
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
    
    public static Initialize getIntance(){
        return init;
    }
    
    public static void main(String[] args) {
        init = new Initialize();
        
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
            RegisterController registerCtr = new RegisterController(registerWindow, registerModel);
            DashboardController dashboardCtr = new DashboardController(dashboardWindow, dashboardModel);

            loginWindow.setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
}