package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import view.DashboardView;
import model.DashboardModel;
import model.DatabaseModel;
import model.NotesModel;
import model.TableModel;
import org.apache.commons.lang3.*;
import view.DataView;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        this.view.PasswordPanelActionListerner(new DisplayCredential());
        this.view.AddLoginsBtnActionListener(new DisplayAddLogins());
        this.view.LoginsBtnActionListener(new DisplayLogins());
        this.view.SubmitBtnActionListener(new AddNewCredential());

        this.view.GenerateBtnActionListener(new GenerateNewPassword());
                
        this.view.SecureNotesDisplayActionListerner(new DisplayNotes());
        this.view.SecureNotesAddBtnActionListener(new AddSecureNotes());
        this.view.SecureNotesBtnActionListener(new DisplaySecureNotes());
        this.view.NotesSubmitActionListener(new SubmitSecureNotes());
        this.view.PasswordLenghtSliderChangeListener(new PasswordLengthChanger());
        this.view.CheckBoxActionListener(new PasswordElementsChanger());
    }    

    public void updateUserInfo(boolean type,String loggedUser,Connection conn){
        try {
            if (type) {
                if (model.checkUserDataExists(loggedUser)) {
                    //show table
                    ArrayList<TableModel> data = DatabaseModel.getUserData(loggedUser, conn);
                    view.DisplayUserData(data);
                } else {
                    //show message
                    view.showPasswordPanelMessage();
                }
            } else {
                if (model.checkUserNotesExists(loggedUser)) {
                    ArrayList<NotesModel> data = DatabaseModel.getUserNotes(loggedUser, conn);
                    view.DisplayUserNotes(data);
                } else {
                    view.showSecureNotesMessage();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void generatePassword() {
//        int length = view.getPasswordLength();
//        String validCharacters = "!@#$%&*.?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        String generatedPassword = RandomStringUtils.random(length, validCharacters);
//        System.out.println(generatedPassword);
//        view.DisplayGeneratedPasswordPanel(generatedPassword);
//    }
    
    public void generatePassword() {
        int length = view.getPasswordLength();
        String validCharacters = "abcdefghijklmnopqrstuvwxyz";
        
        if(view.getMixedCaseStatus()) {
            validCharacters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        
        if(view.getNumberStatus()) {
            validCharacters += "0123456789";
        }
        
        if(view.getPunctuationStatus()) {
            validCharacters += "!@#$%&*.?";
        }
        
        String generatedPassword = RandomStringUtils.random(length, validCharacters);
        System.out.println(generatedPassword);
        view.DisplayGeneratedPasswordPanel(generatedPassword);
    }
    
    class DisplayCredential implements AncestorListener {
        @Override
        public void ancestorAdded(AncestorEvent event) {
            String loggedUser = main.CredentialStore.getLoggedInUser();
            try {
                if (model.checkUserDataExists(loggedUser)) {
                    //show table
                    ArrayList<TableModel> data = DatabaseModel.getUserData(loggedUser, main.Initialize.getIntance().getMySqlConnection());
                    view.DisplayUserData(data);
                } else {
                    //show message
                    view.showPasswordPanelMessage();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        public void ancestorRemoved(AncestorEvent event) {
        }
        @Override
        public void ancestorMoved(AncestorEvent event) {
        }
    }
    
    class DisplayLogins implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            view.DisplayLoginsPanel();
        }
    }
    class DisplayAddLogins implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.DisplayAddLoginsPanel();
        }

    }
    class AddNewCredential implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String website = view.getWebsite();
            String password = view.getPassword();
            String loggedUser = main.CredentialStore.getLoggedInUser();

            try {
                if (model.addUserCredential(loggedUser, website, password)) {
                    view.clearWebsiteField();
                    view.clearPasswordField();
                    view.showSuccess("Successfull Added Credentials");
                } else {
                    view.showError("Cannot insert provided credentials");
                }
            } catch (SQLException e) {
                System.out.println("New Credential insertion failed.");
                System.out.println(e.getMessage());
            }

        }
    }

    class GenerateNewPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            generatePassword();
        }

    }

    
    class DisplayNotes implements AncestorListener {

        @Override
        public void ancestorAdded(AncestorEvent event) {
            String loggedUser = main.CredentialStore.getLoggedInUser();
            try {
                if (model.checkUserNotesExists(loggedUser)) {
                    //show table
                    ArrayList<NotesModel> data = DatabaseModel.getUserNotes(loggedUser, main.Initialize.getIntance().getMySqlConnection());
                    view.DisplayUserNotes(data);
                } else {
                    //show message
                    view.showSecureNotesMessage();
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
    class AddSecureNotes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.DisplaySecureNotesArea();
        }        
    }
    class DisplaySecureNotes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.DisplaySecureNotesPanel();
        }
    }
    class SubmitSecureNotes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.getNotesTitle();
            String notes = view.getSecureNotesTxt();
            String loggedUser = main.CredentialStore.getLoggedInUser();

            try {
                if (model.addUserNotes(loggedUser, title, notes)) {
                    view.clearTitleField();
                    view.clearTextField();
                    view.showSuccess("Successfull Added notes");
                } else {
                    view.showError("Cannot insert provided notes");
                }
            } catch (SQLException ex) {
                System.out.println("New Credential insertion failed.");
                System.out.println(ex.getMessage());
            }

        }

    }
    
    class PasswordLengthChanger implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent c) {
            generatePassword();
        }
        
    }
    
    class PasswordElementsChanger implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            generatePassword();
        }
        
    }
}  

