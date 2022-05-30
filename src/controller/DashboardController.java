package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DashboardView;
import model.DashboardModel;
import org.apache.commons.lang3.*;

/**
 *
 * @author husban
 */

public class DashboardController {
    DashboardView view = null;
    DashboardModel model = null;
    
    public DashboardController(DashboardView view, DashboardModel model) {
        this.view = view;
        this.model = model;
        this.view.GenerateBtnActionListener(new generateNewPassword());
        this.view.AddBtnActionListener(new addNewCredentials());
    }
    
    public void displayCredentialList(){
        if(this.model.checkUserData()){
            //show table
            
        }else{
            //show message
            
        }
    }
    
    class addNewCredentials implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    class generateNewPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String validCharacters = "!@#$%&*.?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            String generatedPassword = RandomStringUtils.random(10, validCharacters);
            System.out.println(generatedPassword);
            view.displayGeneratedPassword(generatedPassword);
        }
        
    }
}
