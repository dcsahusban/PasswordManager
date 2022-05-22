package view;

import java.awt.event.ActionListener;

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
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        RegisterBtn = new javax.swing.JButton();
        LoginBtn = new javax.swing.JButton();
        RegisterMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Logo.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/appicon.png"))); // NOI18N

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Logo)
                                .addGap(84, 84, 84)));
        HeaderLayout.setVerticalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        Username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        RegisterBtn.setText("Register");
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });

        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        RegisterMsg.setText("Don't have an account yet?");

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
                BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BodyLayout.createSequentialGroup()
                                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(BodyLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(BodyLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(BodyLayout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(RegisterBtn))
                                        .addGroup(BodyLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(RegisterMsg)))
                                .addContainerGap(44, Short.MAX_VALUE)));
        BodyLayout.setVerticalGroup(
                BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BodyLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20,
                                        Short.MAX_VALUE)
                                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(RegisterMsg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RegisterBtn)
                                .addGap(33, 33, 33)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Body, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_UsernameActionPerformed

    private void RegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RegisterBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_RegisterBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_LoginBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_LoginBtnActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel Logo;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JLabel RegisterMsg;
    private javax.swing.JTextField Username;
    // End of variables declaration//GEN-END:variables
}
