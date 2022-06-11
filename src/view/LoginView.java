package view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author harshit
 * @author husban
 */
public class LoginView extends javax.swing.JFrame {

        /**
         * Creates new form Login
         */
        public LoginView() {
                initComponents();
                this.setResizable(false);
                this.setLocationRelativeTo(null);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        UsernameLabel = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        RegisterBtn = new javax.swing.JButton();
        LoginBtn = new javax.swing.JButton();
        RegisterMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setPreferredSize(new java.awt.Dimension(300, 500));

        Header.setBackground(new java.awt.Color(255, 255, 255));

        Logo.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/appicon.png"))); // NOI18N

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(Logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Body.setBackground(new java.awt.Color(255, 255, 255));

        UsernameLabel.setText("Username");

        Username.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        EmailLabel.setText("Password");

        RegisterBtn.setText("Register");

        LoginBtn.setText("Login");

        RegisterMsg.setText("Don't have an account yet?");

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsernameLabel)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLabel)))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(RegisterBtn))
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(RegisterMsg)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(UsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(RegisterMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterBtn)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public void LoginBtnActionListerner(ActionListener action) {
                LoginBtn.addActionListener(action);
        }

        public void RegisterBtnActionListerner(ActionListener action) {
                RegisterBtn.addActionListener(action);
        }

        public String getUsername() {
                return Username.getText();
        }

        public String getPassword() {
                return new String(Password.getPassword());
        }

        public void clearUsername() {
                Username.setText("");
        }

        public void clearPassword() {
                Password.setText("");
        }
        
        public void displayUsernameError() {
           JOptionPane.showMessageDialog(this, "Please enter a valid username.", "Invalid username",
                           JOptionPane.WARNING_MESSAGE);
           clearUsername();
        }
        
        public void displayPasswordError() {
            JOptionPane.showMessageDialog(this, "Please enter a valid password.", "Invalid password",
                            JOptionPane.WARNING_MESSAGE);
            clearPassword();
        }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JPanel Header;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JLabel RegisterMsg;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel UsernameLabel;
    // End of variables declaration//GEN-END:variables
}
