package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
                JOptionPane.showMessageDialog(view, "Please enter a valid username.", "Invalid username",
                        JOptionPane.WARNING_MESSAGE);
                view.clearUsername();
            }
            
            if (!validateEmail(email)) {
                JOptionPane.showMessageDialog(view, "Please enter a valid email.", "Invalid email",
                        JOptionPane.WARNING_MESSAGE);
                view.clearPassword();
            }            

            if (!validatePassword(password)) {
                JOptionPane.showMessageDialog(view, "Please enter a valid password.", "Invalid password",
                        JOptionPane.WARNING_MESSAGE);
                view.clearPassword();
            }
            
            try {
                if(model.isUserExist(username)) {
                    JOptionPane.showMessageDialog(view, "Username already taken. Please enter different username", "Username already exists",
                        JOptionPane.WARNING_MESSAGE);
                    view.clearUsername();
                    flag = 0;
                }
                if(model.isEmailExist(email)) {
                    JOptionPane.showMessageDialog(view, "Email already taken. Please enter different email", "Email already exists",
                        JOptionPane.WARNING_MESSAGE);
                    view.clearEmail();
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
