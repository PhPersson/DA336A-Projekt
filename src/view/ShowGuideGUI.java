package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShowGuideGUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel centerPanel, southPanel, logoPanel, buttonPanel;
    private JLabel titleTxt, authorTxt, dateTxt, titleLbl, authorLbl, dateLbl;
    private JTextArea descriptionArea;
    private Font bold, plain;
    private JButton btnClose, btnShowPics;
    private JScrollPane scroll;

    public ShowGuideGUI (String titleString, String authorString, String dateString, String indexGuide) {

        frame = new JFrame(titleString);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        centerPanel = new JPanel(new GridLayout(3, 2, 0, 5));
        southPanel = new JPanel(new BorderLayout());
        logoPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout());

        descriptionArea = new JTextArea();

        bold = new Font("", Font.BOLD, 14);
        plain = new Font("", Font.PLAIN, 14);

        titleLbl = new JLabel("Titel:");
        titleLbl.setFont(bold);
        titleTxt = new JLabel(titleString);
        titleTxt.setFont(plain);

        authorLbl = new JLabel("Skapad av:");
        authorLbl.setFont(bold);
        authorTxt = new JLabel(authorString);
        authorTxt.setFont(plain);

        dateLbl = new JLabel("Datum:");
        dateLbl.setFont(bold);
        dateTxt = new JLabel(dateString);
        dateTxt.setFont(plain);

        btnClose = new JButton("Stäng");
        btnShowPics = new JButton("Visa bilder");

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                    140,46, Image.SCALE_SMOOTH)));
        logoPanel.add(picLogo, BorderLayout.WEST);

        descriptionArea.setText(indexGuide);
        descriptionArea.setEditable(false);
        descriptionArea.setPreferredSize(new Dimension(500,400));

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

        centerPanel.setBorder(BorderFactory.createEmptyBorder(0,15,10,5));

        southPanel.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        southPanel.add(scroll);

        buttonPanel.add(btnClose);
        buttonPanel.add(btnShowPics);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.pack();

        addListeners();
    }

    public void addListeners() {
        btnClose.addActionListener(this);
        btnShowPics.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            frame.dispose();
        }
        else if (e.getSource() == btnShowPics) {

        }
    }
}
