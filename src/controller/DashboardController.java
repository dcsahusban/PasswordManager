package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
        this.view.AddBtnActionListener(new AddNewCredentials());
    }

    class DisplayCredentialTable implements AncestorListener{

        @Override
        public void ancestorAdded(AncestorEvent event) {
            String loggedUser = main.CredentialStore.getLoggedInUser();
            try {
                System.out.println(model.checkUserDataExists(loggedUser));
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

    class AddNewCredentials implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    class GenerateNewPassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String validCharacters = "!@#$%&*.?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            String generatedPassword = RandomStringUtils.random(10, validCharacters);
            System.out.println(generatedPassword);
            view.displayGeneratedPassword(generatedPassword);
        }

    }
}
