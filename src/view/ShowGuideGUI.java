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
 */

public class ShowGuideGUI extends JFrame implements ActionListener {
    private final JFrame frame;
    private final JPanel centerPanel;
    private final JPanel southPanel;
    private final JPanel logoPanel;
    private final JPanel buttonPanel;
    private final JLabel txtTitle;
    private final JLabel txtAuthor;
    private final JLabel txtDate;
    private final JLabel lblTitle;
    private final JLabel lblAuthor;
    private final JLabel lblDate;
    private final JLabel lblCategory;
    private final JLabel lblCategoryTxt;
    private final JLabel lblType;



    private final JLabel lblTypeTxt;
    private final JTextArea descriptionArea;
    private final Font bold;
    private final Font plain;
    private final JButton btnClose;
    private final JButton btnShowPics;
    private final JButton btnDownload;
    private final JScrollPane scroll;
    private final Controller controller;

    public ShowGuideGUI(Controller controller, String titleString, String authorString, String dateString,
                        String indexGuide) {

        this.controller = controller;
        frame = new JFrame(titleString);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        centerPanel = new JPanel(new GridLayout(3, 2, 0, 5));
        southPanel = new JPanel(new BorderLayout());
        logoPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout());

        descriptionArea = new JTextArea();

        bold = new Font("", Font.BOLD, 14);
        plain = new Font("", Font.PLAIN, 14);

        lblTitle = new JLabel("Titel:");
        lblTitle.setFont(bold);
        txtTitle = new JLabel(titleString);
        txtTitle.setFont(plain);

        lblAuthor = new JLabel("Skapad av:");
        lblAuthor.setFont(bold);
        txtAuthor = new JLabel(authorString);
        txtAuthor.setFont(plain);

        lblDate = new JLabel("Datum:");
        lblDate.setFont(bold);
        txtDate = new JLabel(dateString);
        txtDate.setFont(plain);

        lblType = new JLabel("Typ:");
        lblType.setFont(bold);
        lblTypeTxt = new JLabel();
        lblTypeTxt.setFont(plain);

        lblCategory = new JLabel("Kategori:");
        lblCategory.setFont(bold);
        lblCategoryTxt = new JLabel();
        lblCategoryTxt.setFont(plain);

        btnClose = new JButton("Stäng");
        btnShowPics = new JButton("Visa bilder");
        btnDownload = new JButton("Ladda ner guide");
        setTitle("Visa Guide");
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140, 38, Image.SCALE_SMOOTH)));
        logoPanel.add(picLogo, BorderLayout.WEST);

        descriptionArea.setText(indexGuide);
        descriptionArea.setEditable(false);
        descriptionArea.setPreferredSize(new Dimension(500, 400));

        scroll = new JScrollPane(descriptionArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(logoPanel);
        frame.add(centerPanel);
        frame.add(southPanel);
        frame.add(buttonPanel);

        centerPanel.add(lblTitle);
        centerPanel.add(txtTitle);
        centerPanel.add(lblAuthor);
        centerPanel.add(txtAuthor);
        centerPanel.add(lblDate);
        centerPanel.add(txtDate);

        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 10));

        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));
        southPanel.add(scroll);

        buttonPanel.add(btnClose);
        buttonPanel.add(btnShowPics);
        buttonPanel.add(btnDownload);

        SwingUtilities.getRootPane(btnShowPics).setDefaultButton(btnShowPics);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setSize(800, 800);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addListeners();
    }

    public void addListeners() {
        btnClose.addActionListener(this);
        btnShowPics.addActionListener(this);
        btnDownload.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            frame.dispose();
        } else if (e.getSource() == btnShowPics) {
            controller.pictureGUI();
        } else if (e.getSource() == btnDownload) {
            System.out.println("ladda ner");
            controller.downloadGuide();
        }
    }

    public String getTxtTitle() {
        return txtTitle.getText();
    }

    public JFrame getFrame() {
        return frame;
    }
}
