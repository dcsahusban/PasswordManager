package view;

/**
 *
 * @author harshit
 * @author husban
 */

public abstract class ViewStore {
    
    protected LoginView loginViewV = null;
    protected RegisterView registerViewV = null;
    protected DashboardView dashboardViewV = null;
    
    abstract public void setLoginView(LoginView view);
    abstract public void setRegisterView(RegisterView view);
    abstract public void setDashboardView(DashboardView view);
    
    public  LoginView getLoginView(){
        return loginViewV;
    }
    
    public RegisterView getRegisterView(){
        return registerViewV;
    }
    
    public DashboardView getDashboardView(){
        return dashboardViewV;
    }    
}
