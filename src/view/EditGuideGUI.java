package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Simon Pizevski
 * @author Philip Persson
 * @author
 * @author
 * @version 1.0
 */

public class EditGuideGUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel centerPanel, southPanel, logoPanel, buttonPanel;
    private JLabel authorTxt, dateTxt, titleLbl, authorLbl, dateLbl, lblType, lblCategory;
    private JTextArea descriptionArea;
    private JTextField titleTxt;
    private Font bold, plain;
    private JButton btnClose, btnSaveGuide;
    private JScrollPane scroll;
    private Controller controller;
    private JComboBox typeComboBox, categoryComboBox;

    public EditGuideGUI(Controller controller, String titleString, String authorString, String dateString, String descriptionString) {
        this.controller = controller;
        frame = new JFrame("Redigera guide");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        centerPanel = new JPanel(new GridLayout(5, 2, 0, 5));
        southPanel = new JPanel(new BorderLayout());
        logoPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout());

        descriptionArea = new JTextArea();

        bold = new Font("", Font.BOLD, 14);
        plain = new Font("", Font.PLAIN, 14);

        titleLbl = new JLabel("Titel:");
        titleLbl.setFont(bold);
        titleTxt = new JTextField(titleString);
        titleTxt.setFont(plain);

        authorLbl = new JLabel("Skapad av:");
        authorLbl.setFont(bold);
        authorTxt = new JLabel(authorString);
        authorTxt.setFont(plain);

        dateLbl = new JLabel("Datum:");
        dateLbl.setFont(bold);
        dateTxt = new JLabel(dateString);
        dateTxt.setFont(plain);

        lblType = new JLabel("Typ");
        lblType.setFont(bold);
        lblCategory = new JLabel("Kategori");
        lblCategory.setFont(bold);

        String [] items = { "Mjukvara", "Hårdvara", "Snabbguide"};
        String [] items2 = {"Internet", "Dator", "Mobil", "Övrigt"};

        typeComboBox = new JComboBox(items);
        categoryComboBox = new JComboBox(items2);

        btnClose = new JButton("Stäng");
        btnSaveGuide = new JButton("Spara guide");

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140, 38, Image.SCALE_SMOOTH)));
        logoPanel.add(picLogo, BorderLayout.WEST);

        descriptionArea.setText(descriptionString);
        descriptionArea.setEditable(true);
        descriptionArea.setPreferredSize(new Dimension(500, 400));

        scroll = new JScrollPane(descriptionArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(logoPanel);
        frame.add(centerPanel);
        frame.add(southPanel);
        frame.add(buttonPanel);

        centerPanel.add(titleLbl);
        centerPanel.add(titleTxt);
        centerPanel.add(authorLbl);
        centerPanel.add(authorTxt);
        centerPanel.add(dateLbl);
        centerPanel.add(dateTxt);
        centerPanel.add(lblType);
        centerPanel.add(typeComboBox);
        centerPanel.add(lblCategory);
        centerPanel.add(categoryComboBox);

        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 10));

        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));
        southPanel.add(scroll);

        buttonPanel.add(btnClose);
        buttonPanel.add(btnSaveGuide);

        SwingUtilities.getRootPane(btnSaveGuide).setDefaultButton(btnSaveGuide);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addListeners();
    }

    public void addListeners() {
        btnClose.addActionListener(this);
        btnSaveGuide.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            frame.dispose();
        } else if (e.getSource() == btnSaveGuide) {
            controller.btnSaveGuide();
            frame.dispose();
        }
    }

    public String getTitleEdit() {
        return titleTxt.getText();
    }

    public String getDescription() {
        return descriptionArea.getText();
    }

    public String getTypeString(){
        return typeComboBox.getSelectedItem().toString();
    }

    public String getCategoryString(){
        return categoryComboBox.getSelectedItem().toString();
    }

    public JFrame getFrame() {
        return frame;
    }
}
