package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * @author Philip Persson
 * @author Simon Pizevski
 * @version
 */
public class LoginFrame extends JFrame implements ActionListener {

    private JPanel panel, panelLogo, panelNoLog;
    private JLabel lblUsername, lblPassword, lblLogo;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnLogin;
    private JButton btnNoLogin;
    private RegisterFrame registerFrame;
    private UserHomepageFrame homePageFrame;
    private Controller controller;

    public LoginFrame(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    public void createComponents() {

        setTitle("Inloggning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400,220);
        setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(3, 3, 0, 8);

        Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        Border southBorder = BorderFactory.createEmptyBorder(0,70,10,70);

        panel = new JPanel();
        panelLogo = new JPanel(new BorderLayout());
        panelNoLog = new JPanel(new BorderLayout());

        panel.setLayout(layout);
        panel.setBorder(emptyBorder);

        panelNoLog.setBorder(southBorder);

        lblUsername = new JLabel("Användarnamn");
        lblPassword = new JLabel("Lösenord");

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140,38, Image.SCALE_SMOOTH)));

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnRegister = new JButton("Registrera");
        btnLogin = new JButton("Logga in");
        btnNoLogin = new JButton("Fortsätt utan att logga in");

        panelLogo.add(lblLogo, BorderLayout.WEST);

        panel.add(lblUsername);
        panel.add(lblPassword);
        panel.add(txtUsername);
        panel.add(txtPassword);
        panel.add(btnRegister);
        panel.add(btnLogin);

        panelNoLog.add(btnNoLogin, BorderLayout.CENTER);

        add(panelLogo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panelNoLog, BorderLayout.SOUTH);

        SwingUtilities.getRootPane(btnLogin).setDefaultButton(btnLogin);

        //frame.pack();
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
        } else if (e.getSource() == btnNoLogin) {
            controller.btnNoLoginClicked();

        }
    }


}