    package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import view.DashboardView;
import model.DashboardModel;
import model.TableModel;
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
        this.view.PasswordPanelActionListerner(new DisplayCredentialTable());
        this.view.GenerateBtnActionListener(new GenerateNewPassword());
        this.view.AddLoginsBtnActionListener(new DisplayAddLogins());
        this.view.LoginsBtnActionListener(new DisplayLogins());
        this.view.SecureNotesBtnActionListener(new DisplaySecureNotes());
        this.view.SubmitBtnActionListener(new AddNewCredential());
    }

    class DisplayCredentialTable implements AncestorListener{

        @Override
        public void ancestorAdded(AncestorEvent event) {
            String loggedUser = main.CredentialStore.getLoggedInUser();
            try {
//                System.out.println(model.checkUserDataExists(loggedUser));
                if(model.checkUserDataExists(loggedUser)){
                    //show table
                    ArrayList<TableModel> list = model.getUserData(loggedUser);
                    view.DisplayTable(list);
                }else{
                    //show message
                    view.showMessage();        
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void ancestorRemoved(AncestorEvent event) {}

        @Override
        public void ancestorMoved(AncestorEvent event) {}
      

    }

    class DisplayAddLogins implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.DisplayAddLoginsPanel();
        }

    }

    class GenerateNewPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String validCharacters = "!@#$%&*.?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            String generatedPassword = RandomStringUtils.random(10, validCharacters);
            System.out.println(generatedPassword);
            view.DisplayGeneratedPasswordPanel(generatedPassword);
        }

    }
    
    class DisplayLogins implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.DisplayLoginsPanel();
        }
    }
    
    class DisplaySecureNotes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.DisplaySecureNotesPanel();
        }
        
    }
    
    class AddNewCredential implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String website = view.getWebsite();
            String password = view.getPassword();
            String loggedUser = main.CredentialStore.getLoggedInUser();
            
            try {
                model.addUserCredential(loggedUser, website, password);
                view.clearWebsiteField();
                view.clearPasswordField();
            } catch(SQLException e) {
                System.out.println("New Credential insertion failed.");
                System.out.println(e.getMessage());
            }
            
        }
    }
}
