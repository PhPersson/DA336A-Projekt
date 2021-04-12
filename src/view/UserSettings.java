package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Autogenererad av Netbeans och redigerad utav:
 * @author Alexander Olsson
 * @author Philip Persson
 */
public class UserSettings extends JFrame implements ActionListener {

    private JButton btnEmail, btnPassword;
    private JLabel changEmailLabel, changePassLabel1, changePassLabel2, titelLabel, titleEmailLabel, txtUsernameLabel, titleUsernameLabel, txtEmailLabel;

    private JTextField emailField;
    private JFrame jFrame1;
    private JTextField passField1, passField2;

    private Controller controller;
    private GuiUtilities util;

    public UserSettings(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        initComponents();
    }


    private void initComponents() {

        jFrame1 = new JFrame();
        passField1 = new JPasswordField();
        passField2 = new JPasswordField();
        changePassLabel2 = new JLabel();
        btnPassword = new JButton();
        titelLabel = new JLabel();
        changePassLabel1 = new JLabel();
        titleUsernameLabel = new JLabel();
        txtUsernameLabel = new JLabel();
        titleEmailLabel = new JLabel();
        txtEmailLabel = new JLabel();
        emailField = new JTextField();
        changEmailLabel = new JLabel();
        btnEmail = new JButton();
        setTitle("Användar inställningar");
        GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        changePassLabel2.setText("Bekräfta lösenord");
        btnPassword.setText("Ändra lösenord");
        titelLabel.setFont(new Font("Tahoma", 1, 14));
        titelLabel.setText("Användarinställningar");
        changePassLabel1.setText("Ändra lösenord");
        titleUsernameLabel.setFont(new Font("Tahoma", 1, 11));
        titleUsernameLabel.setText("Användarnamn ");
        txtUsernameLabel.setText("jLabel2");
        titleEmailLabel.setFont(new Font("Tahoma", 1, 11));
        titleEmailLabel.setText("Nuvarande email");
        txtEmailLabel.setText("jLabel4");
        changEmailLabel.setText("Ändra email");
        btnEmail.setText("Ändra email");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(changEmailLabel)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(changePassLabel2)
                                                        .addComponent(passField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(changePassLabel1))
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnPassword)
                                                        .addComponent(passField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnEmail)
                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(titleEmailLabel)
                                        .addComponent(txtEmailLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(titelLabel)
                                                                .addComponent(titleUsernameLabel))
                                                        .addGap(13, 13, 13))
                                                .addComponent(txtUsernameLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(titelLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleUsernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleEmailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changEmailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changePassLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changePassLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPassword)
                                .addGap(41, 41, 41))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        addListeners();
    }

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

    public void setLblUsername(String username) {
        txtUsernameLabel.setText(username);
    }

    public void setlblEmail(String email) {
        txtEmailLabel.setText(email);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPassword) {
            if (getPassField1().equals(getPassField2())) {
                controller.changePasswordUser();
                System.out.println("lyckades");
                setVisible(false);
            } else {
                util.showErrorDialog("Lösenorden stämmer inte överrens");
            }
        } else if (e.getSource() == btnEmail) {
            controller.changeEmailUser();
            System.out.println("Email...as.dasda");
        }
    }
}
