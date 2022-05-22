package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.LoginModel;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author harshit
 * @author husban
 * passphrase: passmanagerKeyPhrase
 */

public class LoginController {

    LoginView view = null;
    LoginModel model = null;
    RegisterView rView = null;

    public LoginController(LoginView view, LoginModel model, RegisterView rView) {
        this.view = view;
        this.model = model;
        this.rView = rView;
        this.view.LoginBtnActionListerner(new CheckUserInfo());
        this.view.RegisterBtnActionListerner(new DisplayRegisterView());
    }

    class CheckUserInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (!validateUsername(username)) {
                JOptionPane.showMessageDialog(view, "Please enter a valid username.", "Invalid username",
                        JOptionPane.WARNING_MESSAGE);
                view.clearUsername();
            }

            if (!validatePassword(password)) {
                JOptionPane.showMessageDialog(view, "Please enter a valid password.", "Invalid password",
                        JOptionPane.WARNING_MESSAGE);
                view.clearPassword();
            }

            if (validateUsername(username) && validatePassword(password)) {
                try {
                    if (model.isUserExsist(username)) {
                        System.out.println("Verified");
                    } else {
                        System.out.println("Not-Verified");
                    }
                } catch (SQLException ex) {

                }
            } else {
                System.out.println("Username and/or Password validation failed.");
            }
        }

        boolean validateUsername(String username) {
            return username.length() >= 5 && (!username.contains(" "));
        }

        boolean validatePassword(String password) {
            return password.length() >= 8 && (!password.contains(" "));
        }

    }

    class DisplayRegisterView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            rView.setVisible(true);
        }

    }

}