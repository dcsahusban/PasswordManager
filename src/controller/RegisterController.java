package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import view.RegisterView;
import model.RegisterModel;

/**
 *
 * @author husban
 * @author harshit
 */
public class RegisterController extends FormValidater {

    RegisterModel model = null;
    RegisterView view = null;

    public RegisterController(RegisterView view, RegisterModel model) {
        this.model = model;
        this.view = view;
        this.view.RegisterBtnActionListener(new AddNewUser());
    }

    class AddNewUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int flag = 1;
            String username = view.getUsername();
            String email = view.getEmail();
            String password = view.getPassword();
            
            if (!validateUsername(username)) {
                view.displayUsernameError();;
            }
            
            if (!validateEmail(email)) {
                view.displayEmailError();
            }            

            if (!validatePassword(password)) {
                view.displayPasswordError();
            }
            
            //TODO change db username to be unique
            try {
                if(model.isUserExist(username)) {
                    view.displayUsernameExistError();
                    flag = 0;
                }
                if(model.isEmailExist(email)) {
                    view.displayEmailExistError();
                    flag = 0;
                }                
            } catch(SQLException E) {
                System.out.println(E.getMessage());
            }
            
            if(validateUsername(username) && validateEmail(email) && validatePassword(password) && flag == 1) {
                try {
                    model.addUser(username, email, password);    
                    main.CredentialStore.setLoggedInUser(username);
                    main.Initialize.getIntance().getDashboardView().setVisible(true);
                } catch(SQLException E) {
                    System.out.println("User registration failed.");
                    System.out.println(E.getMessage());
                }finally{
                   view.setVisible(false);
                }
            }
        }

    }

}
