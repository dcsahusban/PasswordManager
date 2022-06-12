package controller;

import java.sql.Connection;
import java.sql.SQLException;
import model.DataViewModel;
import view.DataView;

/**
 *
 * @author Harshit
 */
public class DataViewController {
    
    Connection conn = null;
    DataViewModel model =null;
    
    public DataViewController(DataViewModel model){
        this.model = model;
        this.conn = main.Initialize.getIntance().getMySqlConnection();
    }
    
    public void handleViewBtnActionListener(DataView view){
        if("Pwd".equals(view.getType())){
            view.displayInformation("Password: ","Password");
        }else{
            view.displayInformation("Notes: ", "Notes");
        }
    }
    
    public void handleDeleteBtnActionListener(DataView view) throws SQLException{
        String loggedUser = main.CredentialStore.getLoggedInUser();
        if("Pwd".equals(view.getType())){            
            this.model.deleteUserData(view.getID(),conn);
            main.Initialize.getIntance().getDashboardCtr().updateUserInfo(true,loggedUser,conn);
        }else{
            this.model.deleteUserNotes(view.getID(), conn);
            main.Initialize.getIntance().getDashboardCtr().updateUserInfo(false,loggedUser,conn);
        }
    }
    
}
