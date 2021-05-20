package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Philip Persson
 * @author
 * @author
 * @version 1.0
 */
public class UserHomePageFrame extends JFrame implements ActionListener {

    private JButton btnEditGuide, btnLogOff, btnNewGuide, btnShowGuideLower, btnRemoveGuide, btnSearch, btnShowGuideUpper;
    private JScrollPane jScrollPane1, jScrollPane2;
    private JPanel pnlLogo, pnlBtnNorth, pnlSearchField, pnlSearchTable, pnlGuideTable, pnlTableUp, pnlTableUpBtn, pnlTableLow, pnlTableLowBtn,
            pnlTxtUp, pnlTxtLow;
    private JTable jTableLow;
    private JTable jTableUp;
    private JLabel lblLoggedIn, lblSearchResult, lblYourGuides, lblActiveUser;
    private JTextField txtSearch;
    private JLabel lblLogo;
    private JButton btnUserSettings;
    private Controller controller;
    private String btnEditGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill redigera " + " Tryck sedan här igen</p></html>";
    private String btnRemoveGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill radera " + "Tryck sedan här igen</p></html>";
    private String btnSearchToolTip = "<html><p style='font-style:italic;color:black;'>" +
            "Sök efter en guide baserat på användarnamn och/eller titel</p></html> ";
    private String btnUserSettingsToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Tryck här för att ändra dina nvändarinställningar</p></html>";
    private String btnShowGuidesToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill se" + " Tryck sedan här igen</p></html> ";

    public UserHomePageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    /*public static void main(String[] args) {
        new UserHomePageFrame(this);
    }*/

    private void initComponents() {
        setTitle("SupportME");
        setLayout(new BorderLayout());

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140, 38, Image.SCALE_SMOOTH)));

        txtSearch = new JTextField("Sök efter guide, Sök på titel och skapare...");
        btnSearch = new JButton();
        jScrollPane2 = new JScrollPane();
        jTableLow = new JTable();
        jScrollPane1 = new JScrollPane();
        jTableUp = new JTable();
        btnShowGuideUpper = new JButton();
        btnEditGuide = new JButton();
        lblSearchResult = new JLabel();
        btnShowGuideLower = new JButton();
        btnNewGuide = new JButton();
        lblYourGuides = new JLabel();
        btnLogOff = new JButton();
        lblActiveUser = new JLabel();
        lblLoggedIn = new JLabel();
        btnRemoveGuide = new JButton();
        btnUserSettings = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        txtSearch.setFont(new Font("Tahoma", 0, 14));
        txtSearch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtSearch.setText("");
            }
        });

        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");
        btnSearch.setToolTipText(btnSearchToolTip);

        btnShowGuideUpper.setFont(new Font("Tahoma", 0, 14));
        btnShowGuideUpper.setText("Visa");
        btnShowGuideUpper.setToolTipText(btnShowGuidesToolTip);

        btnEditGuide.setFont(new Font("Tahoma", 0, 14));
        btnEditGuide.setText("Redigera");
        btnEditGuide.setToolTipText(btnEditGuideToolTip);

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuideLower.setFont(new Font("Tahoma", 0, 14));
        btnShowGuideLower.setText("Visa");
        btnShowGuideLower.setToolTipText(btnShowGuidesToolTip);

        btnNewGuide.setFont(new Font("Tahoma", 0, 14));
        btnNewGuide.setText("Skapa ny guide");

        lblYourGuides.setFont(new Font("Tahoma", 0, 14));
        lblYourGuides.setText("Dina guider:");

        btnLogOff.setFont(new Font("Tahoma", 0, 14));
        btnLogOff.setText("Logga ut");

        lblActiveUser.setFont(new Font("Tahoma", 0, 14));
        lblActiveUser.setText("Inloggad:");

        lblLoggedIn.setFont(new Font("Tahoma", 0, 14));
        lblLoggedIn.setText("Användarnamn");

        btnRemoveGuide.setFont(new Font("Tahoma", 0, 14));
        btnRemoveGuide.setText("Ta Bort");
        btnRemoveGuide.setToolTipText(btnRemoveGuideToolTip);

        btnUserSettings.setFont(new Font("Tahoma", 0, 14));
        btnUserSettings.setText("Inställningar");
        btnUserSettings.setToolTipText(btnUserSettingsToolTip);

        jScrollPane1.setViewportView(jTableUp);
        jScrollPane2.setViewportView(jTableLow);

        jScrollPane1.setPreferredSize(new Dimension(500,200));
        jScrollPane2.setPreferredSize(new Dimension(500,200));

        jTableUp.setDefaultEditor(Object.class, null);
        jTableLow.setDefaultEditor(Object.class, null);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        pnlLogo = new JPanel(new BorderLayout());
        pnlBtnNorth = new JPanel(new BorderLayout());
        pnlSearchField = new JPanel(new BorderLayout());
        pnlSearchTable = new JPanel(new BorderLayout());
        pnlTableUp = new JPanel();
        pnlTableUpBtn = new JPanel(new FlowLayout());
        pnlGuideTable = new JPanel(new BorderLayout());
        pnlTableLow = new JPanel();
        pnlTableLowBtn = new JPanel(new FlowLayout());
        pnlTxtUp = new JPanel(new BorderLayout());
        pnlTxtLow = new JPanel(new BorderLayout());

        add(pnlLogo, getContentPane());
        add(pnlBtnNorth, getContentPane());
        add(pnlSearchField, getContentPane());
        add(pnlTxtUp);
        add(pnlSearchTable, getContentPane());
        add(pnlTxtLow);
        add(pnlGuideTable, getContentPane());

        pnlLogo.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlBtnNorth.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlSearchField.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlTxtUp.setBorder(BorderFactory.createEmptyBorder(2,20,2,10));
        pnlSearchTable.setBorder(BorderFactory.createEmptyBorder(5,15,2,15));
        pnlTxtLow.setBorder(BorderFactory.createEmptyBorder(2,20,2,10));
        pnlGuideTable.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));

        pnlLogo.add(lblLogo, BorderLayout.WEST);
        pnlLogo.add(lblLoggedIn, BorderLayout.EAST);
        pnlLogo.add(lblActiveUser);
        
        pnlBtnNorth.add(btnUserSettings, BorderLayout.WEST);
        pnlBtnNorth.add(btnLogOff, BorderLayout.EAST);

        pnlSearchField.add(txtSearch, BorderLayout.WEST);
        pnlSearchField.add(btnSearch, BorderLayout.EAST);

        pnlTxtUp.add(lblSearchResult, BorderLayout.WEST);

        pnlSearchTable.add(pnlTableUp, BorderLayout.NORTH);
        pnlSearchTable.add(pnlTableUpBtn, BorderLayout.SOUTH);

        pnlTableUp.add(jScrollPane1);
        pnlTableUpBtn.add(btnNewGuide);
        pnlTableUpBtn.add(btnShowGuideUpper);

        pnlTxtLow.add(lblYourGuides, BorderLayout.WEST);

        pnlGuideTable.add(pnlTableLow, BorderLayout.NORTH);
        pnlGuideTable.add(pnlTableLowBtn, BorderLayout.SOUTH);

        pnlTableLow.add(jScrollPane2);
        pnlTableLowBtn.add(btnRemoveGuide);
        pnlTableLowBtn.add(btnEditGuide);
        pnlTableLowBtn.add(btnShowGuideLower);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
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
        btnNewGuide.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuideLower.addActionListener(this);
        btnShowGuideUpper.addActionListener(this);
        btnLogOff.addActionListener(this);
        btnUserSettings.addActionListener(this);
        btnEditGuide.addActionListener(this);
        btnRemoveGuide.addActionListener(this);
    }

    public void setLblLoginUser(String name) {
        lblLoggedIn.setText(name.substring(0, 1).toUpperCase() + name.substring(1));
        lblLoggedIn.setForeground(Color.darkGray);
    }

    public void updateUserSearchGuideList(DefaultTableModel update) {
        jTableUp.setModel(update);
    }

    public void updateUserGuideList(DefaultTableModel update) {
        jTableLow.setModel(update);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewGuide) {
            controller.btnOpenCreateGuideFrame();

        } else if (e.getSource() == btnLogOff) {
            controller.btnUserLoggOff();
        } else if (e.getSource() == btnSearch) {
            controller.btnUserSearchGuide(txtSearch.getText());
        } else if (e.getSource() == btnShowGuideUpper) {
            try {
                int row = jTableUp.getSelectedRow();
                int guideId = controller.getGuideId(jTableUp.getModel().getValueAt(row, 0).toString());
                controller.userHomeOpenGuide(guideId,
                        jTableUp.getModel().getValueAt(row, 0).toString(),
                        jTableUp.getModel().getValueAt(row, 1).toString(),
                        jTableUp.getModel().getValueAt(row, 2).toString(),
                        controller.getGuideDescription(guideId));
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har inte valt någon guide!");
            }
        } else if (e.getSource() == btnShowGuideLower) {
            try {
                int row = jTableLow.getSelectedRow();
                int guideId = controller.getGuideId(jTableLow.getModel().getValueAt(row, 0).toString());
                controller.userHomeOpenGuide(guideId,
                        jTableLow.getModel().getValueAt(row, 0).toString(),
                        jTableLow.getModel().getValueAt(row, 1).toString(),
                        jTableLow.getModel().getValueAt(row, 2).toString(),

                        controller.getGuideDescription(guideId));
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har inte valt någon guide!");
                exception.printStackTrace();
            }
        } else if (e.getSource() == btnUserSettings) {
            controller.btnUserSettings();
        } else if (e.getSource() == btnEditGuide) {
            try {
                controller.editGuide();
            } catch (ArrayIndexOutOfBoundsException exception) {
                exception.printStackTrace();
                controller.getUtil().showErrorDialog("Du har ännu inte valt någon guide!");
            }
        } else if (e.getSource() == btnRemoveGuide) {
            try {
                String titleToRemove = jTableLow.getModel().getValueAt(jTableLow.getSelectedRow(), 0).toString();
                controller.btnDeleteGuide(titleToRemove);
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har ännu inte valt någon guide!");
            }
        }
    }

    public JTable getTableLow() {
        return jTableLow;
    }

    public JTable getjTableUp() {
        return jTableUp;
    }
}
