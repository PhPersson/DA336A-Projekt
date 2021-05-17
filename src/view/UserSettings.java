package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Alexander Olsson
 * @author Philip Persson
 */
public class UserSettings extends JFrame implements ActionListener {

    private JButton btnEmail, btnPassword, btnClose;
    private JLabel lblChangeEmail, lblChangePass1, lblChangePass2, lblTitle, lblEmailTitle, txtUsername, lblUsername, txtEmail;
    private JTextField fieldEmail;
    private JFrame jFrame1;
    private JTextField fieldPass1, fieldPass2;
    private Controller controller;
    private GuiUtilities util;
    private JPanel panel,panelText,panelSouth;
    private javax.swing.text.Document emailDoc;
    private Document passDoc;


    public UserSettings(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        initComponents();
    }

    private void initComponents() {

        setSize(300,485);


        setTitle("Användarinställningar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        GridLayout layout = new GridLayout(8,1,0,5);
        GridLayout layoutText = new GridLayout(5, 1, 0, 5 );

        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border emptyBorderButton = BorderFactory.createEmptyBorder(0, 10, 10, 10);


        //Dimension fieldSize = new Dimension(180, 30);

        panel = new JPanel();
        panel.setLayout(layout);
        panel.setBorder(emptyBorder);

        panelText = new JPanel();
        panelText.setLayout(layoutText);
        panelText.setBorder(emptyBorder);

        panelSouth = new JPanel();
        panelSouth.setBorder(emptyBorderButton);




        //jFrame1 = new JFrame();
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
        btnClose = new JButton();

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
        btnClose.setText("Stäng");

        panelText.add(lblTitle);
        panelText.add(lblUsername);
        panelText.add(txtUsername);
        panelText.add(lblEmailTitle);
        panelText.add(txtEmail);
        panel.add(lblChangeEmail);
        panel.add(fieldEmail);
        panel.add(btnEmail);
        panel.add(lblChangePass1);
        panel.add(fieldPass1);
        panel.add(lblChangePass2);
        panel.add(fieldPass2);
        panel.add(btnPassword);
        panelSouth.add(btnClose);


        add(panelText, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);

        add(panelSouth, BorderLayout.SOUTH);


        btnEmail.setEnabled(false);
        btnPassword.setEnabled(false);

        setLocationRelativeTo(null);

        addListeners();

        emailDoc = fieldEmail.getDocument();
        emailDoc.addDocumentListener(new EmailButtonController(btnEmail));

        passDoc = fieldPass2.getDocument();
        passDoc.addDocumentListener(new PassButtonController(btnPassword));


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

    public void setLblEmail(String email) {
        txtEmail.setText(email);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPassword) {
            if (getFieldPass1().equals(getFieldPass2())) {
                controller.changePasswordUser();
                util.showDialog("Lösenordet uppdaterat!");

            } else {
                util.showErrorDialog("Lösenorden stämmer inte överrens");
            }
        } else if (e.getSource() == btnEmail) {
            controller.changeEmailUser();
            util.showDialog("Email är uppdaterat!");
        }
    }
}

class EmailButtonController implements DocumentListener {
    private JButton email;

    EmailButtonController(JButton b){
        email = b;
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


        email.setEnabled(e.getDocument().getLength() > 0);
    }


}

class PassButtonController implements DocumentListener {
    private JButton pass;

    PassButtonController(JButton b){
        pass = b;
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


        pass.setEnabled(e.getDocument().getLength() > 0);
    }


}