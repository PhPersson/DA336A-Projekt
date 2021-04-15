package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel lblUsername, lblEmail, lblPassword, lblConPassword;
    private JTextField txtUsername, txtEmail, txtPassword, txtConPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private Controller controller;
    private GuiUtilities util;

    public RegisterFrame(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        createComponents();
    }

    public void createComponents() {
        setTitle("Registrera");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        GridLayout layout = new GridLayout(5, 2, 0, 8);

        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        Dimension fieldSize = new Dimension(180, 30);

        panel = new JPanel();

        panel.setLayout(layout);
        panel.setSize(new Dimension(250, 500));
        panel.setBorder(emptyBorder);
        lblUsername = new JLabel("Användarnamn");
        lblEmail = new JLabel("Email");
        lblPassword = new JLabel("Lösenord");
        lblConPassword = new JLabel("Bekräfta lösenord");

        txtUsername = new JTextField();
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        txtConPassword = new JPasswordField();

        txtUsername.setPreferredSize(fieldSize);
        txtEmail.setPreferredSize(fieldSize);
        txtPassword.setPreferredSize(fieldSize);
        txtConPassword.setPreferredSize(fieldSize);

        btnRegister = new JButton("Registrera");
        btnCancel = new JButton("Avbryt");

        btnRegister.setPreferredSize(new Dimension(20, 30));
        btnCancel.setPreferredSize(new Dimension(20, 30));

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPassword);
        panel.add(txtPassword);

        panel.add(lblConPassword);
        panel.add(txtConPassword);
        panel.add(btnRegister);
        panel.add(btnCancel);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
    }

    public void addListeners() {
        btnRegister.addActionListener(this);
        btnCancel.addActionListener(this);
    }

    public String getTxtUsername() {
        return txtUsername.getText();
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public String getTxtConPassword() {
        return txtConPassword.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            if(getTxtPassword().equals(getTxtConPassword())){
                controller.btnRegisterClicked();
            }else{
                util.showDialog("Lösenorden stämmer inte överrens");
            }
        } else if (e.getSource() == btnCancel){
            if (util.showConfirmationDialog("Säker att du vill avbryta registreringen?") == 1) {
                setVisible(false);
            }
        }
    }
}