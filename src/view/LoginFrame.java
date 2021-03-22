package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private JPanel panel;

    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnLogin;
    private JButton btnNoLogin;

    private RegisterFrame registerFrame;
    private HomePageFrame homePageFrame;

    private Controller controller;

    public LoginFrame(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    public void createComponents() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GridLayout layout = new GridLayout(4, 2, 0, 8);

        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        panel = new JPanel();

        panel.setLayout(layout);
        panel.setBorder(emptyBorder);

        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnRegister = new JButton("Register");
        btnLogin = new JButton("Login");
        btnNoLogin = new JButton("Continue without login");

        panel.add(lblUsername);
        panel.add(lblPassword);
        panel.add(txtUsername);
        panel.add(txtPassword);
        panel.add(btnRegister);
        panel.add(btnLogin);
        panel.add(btnNoLogin);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
    }

    public String getLoginUsername() { return txtUsername.getText(); }

    public String getLoginPassword() { return txtPassword.getText(); }

    public RegisterFrame getRegisterFrame() { return registerFrame; }



    public void addListeners() {
        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);
        btnNoLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            registerFrame = new RegisterFrame(controller);

        } else if (e.getSource() == btnLogin) {
          controller.btnLoginClicked();
    //       boolean check = controller.btnLoginClicked();
    //        if (check) {
        } else if (e.getSource() == btnNoLogin) {
            controller.btnNoLoginClicked();

        }
   //     }
    }


}