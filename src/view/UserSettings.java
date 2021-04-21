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
    private JLabel lblChangeEmail, lblChangePass1, lblChangePass2, lblTitle, lblEmailTitle, txtUsername,
            lblUsername, txtEmail;
    private JTextField fieldEmail;
    private JFrame jFrame1;
    private JTextField fieldPass1, fieldPass2;
    private Controller controller;
    private GuiUtilities util;

    public UserSettings(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        initComponents();
    }
    private void initComponents() {

        jFrame1 = new JFrame();
        fieldPass1 = new JPasswordField();
        fieldPass2 = new JPasswordField();
        lblChangePass2 = new JLabel();
        btnPassword = new JButton();
        lblTitle = new JLabel();
        lblChangePass1 = new JLabel();
        lblUsername = new JLabel();
        txtUsername = new JLabel();
        lblEmailTitle = new JLabel();
        txtEmail = new JLabel();
        fieldEmail = new JTextField();
        lblChangeEmail = new JLabel();
        btnEmail = new JButton();
        setTitle("Användarinställningar");
        GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        lblChangePass2.setText("Bekräfta lösenord");
        btnPassword.setText("Ändra lösenord");
        lblTitle.setFont(new Font("Tahoma", 1, 14));
        lblTitle.setText("Användarinställningar");
        lblChangePass1.setText("Ändra lösenord");
        lblUsername.setFont(new Font("Tahoma", 1, 11));
        lblUsername.setText("Användarnamn ");
        txtUsername.setText("jLabel2");
        lblEmailTitle.setFont(new Font("Tahoma", 1, 11));
        lblEmailTitle.setText("Nuvarande email");
        txtEmail.setText("jLabel4");
        lblChangeEmail.setText("Ändra email");
        btnEmail.setText("Ändra email");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblChangeEmail)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblChangePass2)
                                                        .addComponent(fieldPass1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblChangePass1))
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnPassword)
                                                        .addComponent(fieldPass2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnEmail)
                                                .addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblEmailTitle)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblTitle)
                                                                .addComponent(lblUsername))
                                                        .addGap(13, 13, 13))
                                                .addComponent(txtUsername, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsername)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEmailTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblChangeEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblChangePass1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblChangePass2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPass2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

    public String getFieldPass1() {
        return fieldPass1.getText();
    }

    public String getFieldPass2() {
        return fieldPass2.getText();
    }

    public String getFieldEmail() {
        return fieldEmail.getText();
    }

    public void setLblUsername(String username) {
        txtUsername.setText(username);
    }

    public void setlblEmail(String email) {
        txtEmail.setText(email);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPassword) {
            if (getFieldPass1().equals(getFieldPass2())) {
                controller.changePasswordUser();
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
