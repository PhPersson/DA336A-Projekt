package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


/**
 *
 * @author Alexander Olsson
 */
public class UserSettings extends JFrame implements ActionListener {

    private JButton btnEmail;
    private JButton btnPassword;
    private JLabel changEmailLabel;
    private JLabel changePassLabel1;
    private JLabel changePassLabel2;
    private JTextField emailField;
    private JFrame jFrame1;
    private JTextField passField1;
    private JTextField passField2;
    private JLabel titelLabel;
    private JLabel titleEmailLabel;
    private JLabel titleUsernameLabel;
    private JLabel txtEmailLabel;
    private JLabel txtUsernameLabel;
    private Controller controller;
    private GuiUtilities util;

    public UserSettings(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        initComponents();
    }


    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        passField1 = new JPasswordField();
        passField2 = new JPasswordField();
        changePassLabel2 = new javax.swing.JLabel();
        btnPassword = new javax.swing.JButton();
        titelLabel = new javax.swing.JLabel();
        changePassLabel1 = new javax.swing.JLabel();
        titleUsernameLabel = new javax.swing.JLabel();
        txtUsernameLabel = new javax.swing.JLabel();
        titleEmailLabel = new javax.swing.JLabel();
        txtEmailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        changEmailLabel = new javax.swing.JLabel();
        btnEmail = new javax.swing.JButton();
        setTitle("Användar inställningar");
        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        changePassLabel2.setText("Bekräfta lösenord");
        btnPassword.setText("Ändra lösenord");
        titelLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        titelLabel.setText("Användarinställningar");
        changePassLabel1.setText("Ändra lösenord");
        titleUsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        titleUsernameLabel.setText("Användarnamn ");
        txtUsernameLabel.setText("jLabel2");
        titleEmailLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        titleEmailLabel.setText("Nuvarande email");
        txtEmailLabel.setText("jLabel4");
        changEmailLabel.setText("Ändra email");
        btnEmail.setText("Ändra email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(changEmailLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(changePassLabel2)
                                                        .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(changePassLabel1))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnPassword)
                                                        .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnEmail)
                                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(titleEmailLabel)
                                        .addComponent(txtEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(titelLabel)
                                                                .addComponent(titleUsernameLabel))
                                                        .addGap(13, 13, 13))
                                                .addComponent(txtUsernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(titelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleUsernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleEmailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changEmailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changePassLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changePassLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPassword)
                                .addGap(41, 41, 41))
        );

        setResizable(false);
        addListeners();
        pack();
    }// </editor-fold>

    private void addListeners() {
        btnPassword.addActionListener(this);
        btnEmail.addActionListener(this);
    }


    public String getPassField1() {
        return passField1.getText();
    }

    public String getPassField2() {
        return passField2.getText();
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public void setLblUsername(String username){
        txtUsernameLabel.setText(username);
    }
    public void setlblEmail(String email){
        txtEmailLabel.setText(email);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPassword) {
            if(getPassField1().equals(getPassField2())){
                controller.changePasswordUser();
                System.out.println("lyckades");
                setVisible(false);
            }else{
                util.showDialog("Lösenorden stämmer inte överrens");
            }
        } else if (e.getSource() == btnEmail){
            controller.changeEmailUser();
            System.out.println("Email...as.dasda");
        }
    }
}
