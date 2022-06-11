package main;

import controller.DashboardController;
import controller.DataViewController;
import controller.LoginController;
import controller.RegisterController;
import view.DashboardView;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author harshit
 * @author husban
 */

public abstract class InstanceStore {
    
    protected LoginView loginViewV = null;
    protected RegisterView registerViewV = null;
    protected DashboardView dashboardViewV = null;
    
    protected DashboardController dashboardController = null;
    protected DataViewController dataViewController = null;
    protected LoginController loginController = null;
    protected RegisterController registerController = null;
    
    abstract public void setLoginView(LoginView view);
    abstract public void setRegisterView(RegisterView view);
    abstract public void setDashboardView(DashboardView view);
    
    abstract public void setLoginCtr(LoginController controller);
    abstract public void setRegisterCtr(RegisterController controller);
    abstract public void setDashboardCtr(DashboardController controller);
    abstract public void setDataViewCtr(DataViewController controller);
   
    public  LoginView getLoginView(){
        return loginViewV;
    }
    
    public RegisterView getRegisterView(){
        return registerViewV;
    }
    
    public DashboardView getDashboardView(){
        return dashboardViewV;
    } 
    
    public  LoginController getLoginCtr(){
        return loginController;
    }
    
    public RegisterController getRegisterCtr(){
        return registerController;
    }
    
    public DashboardController getDashboardCtr(){
        return dashboardController;
    }
    
    public DataViewController getDataViewCtr(){
        return dataViewController;
    }
}
