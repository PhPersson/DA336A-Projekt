package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Philip Persson
 * @author Alexander Olsson
 * @version 2.0
 */

public class HomePageFrame extends JFrame implements ActionListener {

    private JPanel middle, top, topUpper, topLower, lower;

    private JButton btnLogin, btnSearch, btnShowGuides;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JLabel lblLogo, lblSearchResult, lblEmpty;
    private JTextField txtSearch;
    private final Controller controller;
    private final String btnSearchToolTip = "<html><p style='font-style:italic;color:black;'>" +
            "Sök efter en guide baserat på användarnamn och/eller titel</p></html> ";
    private final String btnShowGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill se" + " Tryck sedan här igen</p></html> ";

    public HomePageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        setTitle("SupportME");

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140, 38, Image.SCALE_SMOOTH)));

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        lblSearchResult = new JLabel();
        btnShowGuides = new JButton();
        btnLogin = new JButton();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        txtSearch.setFont(new Font("Tahoma", 0, 14));
        txtSearch.setPreferredSize(new Dimension(400, 25));
        txtSearch.setText("Sök här efter guide...");


        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");

        btnSearch.setToolTipText(btnSearchToolTip);
        btnSearch.setPreferredSize(new Dimension(100, 25));

        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Title", "Username", "Date", "Ratings"
                }
        ));
        jScrollPane1.setViewportView(table);

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuides.setFont(new Font("Tahoma", 0, 14));
        btnShowGuides.setText("Visa");
        btnShowGuides.setToolTipText(btnShowGuideToolTip);

        btnLogin.setFont(new Font("Tahoma", 0, 14));
        btnLogin.setText("Logga in");
        btnLogin.setPreferredSize(new Dimension(10, 10));

        table.setDefaultEditor(Object.class, null);


        GridLayout layout = new GridLayout(2, 1, 0, 0);

        GridLayout layoutTopGap = new GridLayout(1, 2, 200, 0);
        GridLayout gridLayout = new GridLayout(1, 2, 250, 0);
        GridLayout layoutTop = new GridLayout(1, 2, 0, 0);
        Container panel;


        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border emptyBorderLower = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        Border emptyBorderMiddle = BorderFactory.createEmptyBorder(10, 20, 10, 20);


        top = new JPanel();
        top.setLayout(layout);
        top.setBorder(emptyBorder);
        // top.setPreferredSize(new Dimension(400,800));

        topUpper = new JPanel();
        topUpper.setLayout(new BoxLayout(topUpper, BoxLayout.X_AXIS));
        topUpper.setBorder(emptyBorder);

        topLower = new JPanel(new GridLayout(1, 2));
        topLower.setLayout(new BoxLayout(topLower, BoxLayout.X_AXIS));
        topLower = new JPanel();
        //topLower.setLayout(layoutTop);
        topLower.setBorder(emptyBorder);

        topUpper.add(lblLogo);
        topUpper.add(Box.createRigidArea(new Dimension(275, 10)));
        topUpper.add(btnLogin);

        topLower.add(txtSearch);
        topLower.add(btnSearch);

        top.add(topUpper, BorderLayout.NORTH);
        top.add(topLower, BorderLayout.CENTER);

        add(top, BorderLayout.NORTH);

        middle = new JPanel(new GridLayout(2, 1));
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
        middle.setBorder(emptyBorderMiddle);

        middle.add(lblSearchResult, BorderLayout.NORTH);
        middle.add(jScrollPane1, BorderLayout.SOUTH);

        add(middle, BorderLayout.CENTER);

        lower = new JPanel();
        lower.setLayout(gridLayout);
        lower.setBorder(emptyBorderMiddle);

        btnShowGuides.setPreferredSize(new Dimension(10, 30));
        lblEmpty = new JLabel();

        lower.add(lblEmpty);

        lower.add(btnShowGuides);

        add(lower, BorderLayout.SOUTH);

        //add(btnShowGuides, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Stäng progammet?",
                        "Stäng", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    public void addListeners() {
        btnLogin.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuides.addActionListener(this);
    }

    public void updateSearchGuideList(DefaultTableModel update) {
        table.setModel(update);
    }

    public int getGuideId() {
        int guideId = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
        return guideId;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        } else if (e.getSource() == btnLogin) {
            controller.btnHomePageFrameLogin();
        } else if (e.getSource() == btnShowGuides) {

            int row = table.getSelectedRow();
            int guideId = controller.getGuideId(table.getModel().getValueAt(row, 0).toString());
            controller.homeOpenGuide(
                    guideId,
                    table.getModel().getValueAt(row, 0).toString(),
                    table.getModel().getValueAt(row, 1).toString(),
                    table.getModel().getValueAt(row, 2).toString(),
                    controller.getGuideDescription(guideId));


        } else if (e.getSource() == btnSearch) {
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        }
    }


}
