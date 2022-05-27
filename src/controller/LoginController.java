package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import view.LoginView;
import view.RegisterView;
import model.LoginModel;

/**
 *
 * @author harshit
 * @author husban
 */

public class LoginController extends FormValidater {

    LoginView view = null;
    LoginModel model = null;
    RegisterView rView = null;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
        this.view.LoginBtnActionListerner(new CheckUserInfo());
        this.view.RegisterBtnActionListerner(new DisplayRegisterView());
    }

    class CheckUserInfo implements ActionListener {
//        boolean validateUsername(String username) {
//            return username.length() >= 5 && (!username.contains(" "));
//        }
//
//        boolean validatePassword(String password) {
//            return password.length() >= 5 && (!password.contains(" "));
//        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (!validateUsername(username)) {
                view.displayUsernameError();
                view.clearUsername();
            }

            if (!validatePassword(password)) {
                view.displayPasswordError();
                view.clearPassword();
            }

            if (validateUsername(username) && validatePassword(password)) {
                try {
                    if (model.verifyUser(username,password)) {
                        
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

    }

   
    class DisplayRegisterView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            main.Initialize.getIntance().getRegisterView().setVisible(true);
        }

    }

}