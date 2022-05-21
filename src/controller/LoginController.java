/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.LoginModel;
import view.LoginView;

/**
 *
 * @author harshit passphrase: passmanagerKeyPhrase
 */
public class LoginController {

    LoginView view = null;
    LoginModel model = null;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
        this.view.LoginBtnActionListerner(new CheckUserInfo());
    }

    class CheckUserInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            try {
                if (model.isUserExsist(username)) {
                    System.out.println("Verified");
                }else{
                    System.out.println("Not-Verified");
                }
            } catch (SQLException ex) {

            }

        }

        void validateUsername() {

        }

        void validatePassword() {

        }
    }

}
