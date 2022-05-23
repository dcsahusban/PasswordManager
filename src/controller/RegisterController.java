package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.RegisterModel;
import view.RegisterView;

/**
 *
 * @author husban
 * @author harshit
 */
public class RegisterController {

    RegisterModel model = null;
    RegisterView view = null;

    public RegisterController(RegisterView view, RegisterModel model) {
        this.model = model;
        this.view = view;
        this.view.RegisterBtnActionListener(new AddNewUser());
    }

    class AddNewUser implements ActionListener {
        
        boolean validateUsername(String username) {
            return username.length() >= 5 && (!username.contains(" "));
        }
        
        boolean validateEmail(String email) {
            return email.length() >= 6 && (!email.contains(" "));
        }
        
        boolean validatePassword(String password) {
            return password.length() >= 8 && (!password.contains(" "));
        }

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
                } catch(SQLException E) {
                    System.out.println("User registration failed.");
                    System.out.println(E.getMessage());
                }
            }
        }

    }

}
