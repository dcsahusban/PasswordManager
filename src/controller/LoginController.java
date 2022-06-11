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

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (!validateUsername(username)) {
                view.displayUsernameError();
                view.clearUsername();
                return;
            }

            if (!validatePassword(password)) {
                view.displayPasswordError();
                view.clearPassword();
                return;
            }

            try {
                if (model.verifyUseranmePassword(username, password)) {
                    view.setVisible(false);
                    main.CredentialStore.setLoggedInUser(username);
                    main.Initialize.getIntance().getDashboardView().setVisible(true);
                    System.out.println("Verified");
                } else {
                    System.out.println("Not-Verified");
                }
            } catch (SQLException ex) {

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
