package view;

import controller.Controller;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Philip Persson
 * @author Simon Pizevski
 * @author Alexander Olsson
 * @version 1.0
 */
public class LoginFrame extends JFrame implements ActionListener{

    private JPanel panel, panelLogo, panelNoLog, panelInfo, panelUpper;
    private JLabel lblUsername, lblPassword, lblLogo, lblInfo, lblContact;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnLogin, btnInfo;
    private JButton btnNoLogin;
    private RegisterFrame registerFrame;
    private Document username, password;
    private String btnnoLoginToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Utan inloggning ges en begränsad tillgänglighet till systemet</p></html>";
    private String txtUsernameToolTip = "<html><p style='font-style:italic;color:black;'>" +
            "Ditt unika användarnamn för att logga in till systemet</p></html>";
    private String infoMessage = "<html><p style='font-style:italic;color:black;'>" +
            "För att komma i kontakt med ansvariga utvecklare eller för att lämna feedback kontakta gärna oss på support@supportme.com</p></html>";

    private Controller controller;

    public LoginFrame(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    public void createComponents() {

        setTitle("Inloggning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400,270); //275
        setLayout(new BorderLayout());

        GridLayout layout = new GridLayout(2, 2, 0, 0);
        GridLayout layoutButton = new GridLayout(3, 1, 3, 8);


        Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        Border emptyBorderLogo = BorderFactory.createEmptyBorder(0, 0, 0, 10);

        Border southBorder = BorderFactory.createEmptyBorder(0,70,10,70);

        panel = new JPanel();
        panelLogo = new JPanel(new BorderLayout());
        panelNoLog = new JPanel(new BorderLayout());

        panelUpper = new JPanel();
        panelUpper.setLayout(new GridLayout(2,1));

        panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1,4));
        panelInfo.setBorder(emptyBorder);

        panel.setLayout(layout);
        panel.setBorder(emptyBorder);

        panelNoLog.setBorder(southBorder);

        lblUsername = new JLabel("Användarnamn");
        lblPassword = new JLabel("Lösenord");

        lblContact = new JLabel("Kontakta oss");
        Font contactFont = new Font("Kontakta oss", Font.ITALIC, 12);
        lblContact.setFont(contactFont);



        lblInfo = new JLabel("Om SupportMe");
        Font infoFont = new Font("Om SupportMe", Font.ITALIC, 12);
        lblInfo.setFont(infoFont);
        lblInfo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                controller.openPDF();
            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lblInfo.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lblInfo.setForeground(Color.black);
            }
        });


        BufferedImage logo = null;
        BufferedImage infoIcon = null;
        try {
            logo = ImageIO.read(new File("files/Logga.png"));
            infoIcon = ImageIO.read(new File("files/InfoLogga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(logo.getScaledInstance(
                140,38, Image.SCALE_SMOOTH)));

        lblContact.setIcon(new ImageIcon(infoIcon.getScaledInstance(15,15,Image.SCALE_SMOOTH)));


        lblContact.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null,infoMessage,"Kontaktinformation",JOptionPane.INFORMATION_MESSAGE);

            }
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lblContact.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lblContact.setForeground(Color.black);

            }
        });

        txtUsername = new JTextField();
        txtUsername.setToolTipText(txtUsernameToolTip);
        txtPassword = new JPasswordField();



        btnRegister = new JButton("Registrera ny användare");
        btnLogin = new JButton("Logga in");
        btnLogin.setEnabled(false);
        btnNoLogin = new JButton("Fortsätt utan att logga in");
        btnNoLogin.setToolTipText(btnnoLoginToolTip);

        panelLogo.add(lblLogo, BorderLayout.WEST);
        panelLogo.add(lblContact, BorderLayout.EAST);
        panelLogo.setBorder(emptyBorderLogo);

        panel.add(lblUsername);
        panel.add(lblPassword);
        panel.add(txtUsername);
        panel.add(txtPassword);

        panelInfo.add(lblInfo, BorderLayout.WEST);
        panelInfo.add(Box.createRigidArea(new Dimension(90,10)));
        panelInfo.add(Box.createRigidArea(new Dimension(90,10)));
        panelInfo.add(Box.createRigidArea(new Dimension(90,10)));


        panelUpper.add(panelLogo);
        panelUpper.add(panelInfo);
        panelUpper.setLayout(new BoxLayout(panelUpper, BoxLayout.Y_AXIS));

        panelNoLog.setLayout(layoutButton);

        panelNoLog.add(btnLogin);
        panelNoLog.add(btnRegister);
        panelNoLog.add(btnNoLogin);


        add(panelUpper, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panelNoLog, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnLogin);


        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();


        password = txtPassword.getDocument();
        password.addDocumentListener(new LoginButtonController(btnLogin));


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
            this.dispose();
        } else if (e.getSource() == lblInfo){
            System.out.println("INFOFOFOFOFO");
        } if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null,infoMessage,"Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

/**
 * Listner som kollar att användarnamn inte är ifyllt
 */
class LoginButtonController implements DocumentListener{
    private JButton login;

    LoginButtonController(JButton b){
        login = b;
    }


    public void insertUpdate(DocumentEvent e) {
        disableIfEmpty(e);
    }

    public void removeUpdate(DocumentEvent e) {
        disableIfEmpty(e);
    }

    public void changedUpdate(DocumentEvent e) {
        disableIfEmpty(e);
    }

    public void disableIfEmpty(DocumentEvent e){
        login.setEnabled(e.getDocument().getLength() > 0);
    }


}