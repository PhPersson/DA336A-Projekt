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

    private JPanel pnlUpper, pnlLogo, pnlUser, pnlBtnNorth, pnlSearchField, pnlSearchTable, pnlGuideTable, pnlTableUp, pnlTableUpBtn, pnlTableLow, pnlTableLowBtn,
            pnlTxtUp, pnlTxtLow, pnlCombo, pnlLowerBorder, pnlUpperBorder, pnlLogoAndUser;

    private JTable jTableLow;
    private JTable jTableUp;
    private JLabel lblLoggedIn, lblSearchResult, lblYourGuides, lblActiveUser;
    private JTextField txtSearch;
    private JLabel lblLogo, lblType, lblCategory, lblChoose;
    private JButton btnUserSettings;
    private final Controller controller;
    private final String btnEditGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill redigera " + " Tryck sedan här igen</p></html>";
    private final String btnRemoveGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill radera " + "Tryck sedan här igen</p></html>";
    private final String btnSearchToolTip = "<html><p style='font-style:italic;color:black;'>" +
            "Sök efter en guide baserat på användarnamn och/eller titel</p></html> ";
    private final String btnUserSettingsToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Tryck här för att ändra dina nvändarinställningar</p></html>";
    private final String btnShowGuidesToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill se" + " Tryck sedan här igen</p></html> ";

    private JComboBox<String> categoryComboBox, typeComboBox;


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
        lblCategory = new JLabel();
        lblType = new JLabel();
        lblChoose = new JLabel();


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
        lblActiveUser.setText("Inloggad: ");

        lblLoggedIn.setFont(new Font("Tahoma", 0, 14));
        lblLoggedIn.setText("Användarnamn");

        btnRemoveGuide.setFont(new Font("Tahoma", 0, 14));
        btnRemoveGuide.setText("Ta Bort");
        btnRemoveGuide.setToolTipText(btnRemoveGuideToolTip);

        btnUserSettings.setFont(new Font("Tahoma", 0, 14));
        btnUserSettings.setText("Användarinställningar");
        btnUserSettings.setToolTipText(btnUserSettingsToolTip);

        lblType.setFont(new Font("Tahoma", 1, 11));
        lblType.setText("Typ av guide");

        lblCategory.setFont(new Font("Tahoma", 1, 11));
        lblCategory.setText("Kategori av guide");

        lblChoose.setFont(new Font("Tahoma", 1, 11));
        lblChoose.setText("Välj en guide ovanför");

        jScrollPane1.setViewportView(jTableUp);
        jScrollPane2.setViewportView(jTableLow);

        jScrollPane1.setPreferredSize(new Dimension(500,200));
        jScrollPane2.setPreferredSize(new Dimension(500,200));

        jTableUp.setDefaultEditor(Object.class, null);
        jTableLow.setDefaultEditor(Object.class, null);

        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Sök efter typ", "Mjukvara", "Hårdvara", "Snabbguide"}));
        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Sök efter kategori", "Internet", "Dator", "Mobil", "Övrigt"}));

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        pnlUpper = new JPanel(new BorderLayout());
        pnlLogoAndUser = new JPanel(new BorderLayout());

        pnlBtnNorth = new JPanel(new BorderLayout());
        pnlSearchField = new JPanel(new BoxLayout(pnlSearchField, BoxLayout.Y_AXIS));
        pnlSearchTable = new JPanel(new BorderLayout());
        pnlTableUp = new JPanel();
        pnlTableUpBtn = new JPanel(new FlowLayout());

        //pnlTableUpBtn.setLayout(new GridLayout(2,1));

        pnlGuideTable = new JPanel(new BorderLayout());
        pnlTableLow = new JPanel();
        pnlTableLowBtn = new JPanel(new FlowLayout());
        pnlTxtUp = new JPanel(new BorderLayout());
        pnlTxtLow = new JPanel(new BorderLayout());
        pnlLowerBorder = new JPanel();
        pnlUpperBorder = new JPanel(new GridLayout(3,1));
        pnlUpperBorder.setLayout(new BoxLayout(pnlUpperBorder, BoxLayout.Y_AXIS));

        pnlUpper = new JPanel();
        pnlUser = new JPanel();
        pnlLogo = new JPanel();

        pnlCombo = new JPanel(new GridLayout(1,3,10,0));
        //pnlCombo.setLayout(new BoxLayout(pnlCombo,BoxLayout.X_AXIS));

        GridLayout layoutTop = new GridLayout(1,2,0,0);

        pnlLogo.setLayout(new GridLayout(1,2));

        pnlUpper.setLayout(layoutTop);

        //pnlUser.setLayout(new GridLayout(1,3));

        pnlUser = new JPanel(new GridLayout(1,3));
        pnlUser.setLayout(new BoxLayout(pnlUser,BoxLayout.X_AXIS));
        //pnlUser.setAlignmentX(50);
        //pnlUser = new JPanel();

        add(pnlUpper);

        pnlLogo.add(lblLogo);
        pnlLogo.add(Box.createRigidArea(new Dimension(1,1)));

        pnlUpper.add(pnlUser);
        pnlUpper.add(pnlLogo, BoxLayout.X_AXIS);
        //pnlUpper.setBorder();

        pnlUser.add(Box.createHorizontalGlue());

        //pnlUser.add(Box.createRigidArea(new Dimension(1,10)));

        lblLoggedIn.setAlignmentX(Component.RIGHT_ALIGNMENT);

        pnlUser.add(lblActiveUser);
        pnlUser.add(lblLoggedIn);

        //pnlCombo.add(lblType);
        //pnlCombo.add(Box.createRigidArea(new Dimension(40,10)));
        //pnlCombo.add(lblCategory);

        pnlCombo.add(typeComboBox);
        pnlCombo.add(Box.createRigidArea(new Dimension(40,10)));
        pnlCombo.add(categoryComboBox);

        pnlSearchField.setLayout(new GridLayout(1,2));
        pnlSearchField.setLayout(new BoxLayout(pnlSearchField, BoxLayout.X_AXIS));

        //add(pnlLogoAndUser, getContentPane());
        add(pnlBtnNorth, getContentPane());
        //add(pnlSearchField, getContentPane());
        add(pnlSearchField);
        add(pnlCombo);
        add(pnlTxtUp);
        add(pnlSearchTable, getContentPane());
        add(pnlTxtLow);
        add(pnlGuideTable, getContentPane());

        pnlUpper.setBorder(BorderFactory.createEmptyBorder(10,0,5,15));
        pnlBtnNorth.setBorder(BorderFactory.createEmptyBorder(10,15,30,15));
       // pnlLogoAndUser.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlBtnNorth.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlSearchField.setBorder(BorderFactory.createEmptyBorder(10,15,5,15));
        pnlCombo.setBorder(BorderFactory.createEmptyBorder(0,75,0,75));
        pnlTxtUp.setBorder(BorderFactory.createEmptyBorder(2,20,2,10));
        pnlSearchTable.setBorder(BorderFactory.createEmptyBorder(5,15,2,15));
        pnlTxtLow.setBorder(BorderFactory.createEmptyBorder(2,20,2,10));
        pnlGuideTable.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
        //pnlUpperBorder.setBorder(BorderFactory.createEmptyBorder(5,25,5,5));
        //pnlLowerBorder.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        pnlLowerBorder.setBorder((BorderFactory.createTitledBorder("Dina guider")));
        pnlUpperBorder.setBorder((BorderFactory.createTitledBorder("Alla guider")));
       // pnlUpper.add(lblLogo, BorderLayout.WEST);


        //pnlUpper.add(lblActiveUser, BorderLayout.CENTER);
        //pnlUpper.add(lblLoggedIn, BorderLayout.EAST);



        //pnlLogoAndUser.add(lblLogo, BorderLayout.WEST);
        //pnlLogoAndUser.add(lblLoggedIn, BorderLayout.AFTER_LINE_ENDS);
        //pnlLogoAndUser.add(lblActiveUser, BorderLayout.EAST);


        pnlBtnNorth.add(btnUserSettings, BorderLayout.WEST);
        pnlBtnNorth.add(btnLogOff, BorderLayout.EAST);

        add(pnlUpperBorder);
        pnlUpperBorder.add(pnlSearchField);
        pnlUpperBorder.add(pnlCombo);
        pnlUpperBorder.add(pnlSearchTable);

        pnlSearchField.add(txtSearch);
        pnlSearchField.add(btnSearch);

        //pnlTxtUp.add(lblSearchResult, BorderLayout.WEST);

        pnlSearchTable.add(pnlTableUp, BorderLayout.NORTH);
        //pnlSearchTable.add(lblChoose);
        pnlSearchTable.add(pnlTableUpBtn, BorderLayout.SOUTH);

        pnlTableUp.add(jScrollPane1);
        //add(lblChoose);
        pnlTableUpBtn.add(btnShowGuideUpper);
        //pnlTableUpBtn.add(lblChoose);

       // pnlUpperBorder.add(pnlTableUp);
        //pnlUpperBorder.add(btnShowGuideUpper);

        add(pnlLowerBorder);
        //pnlTxtLow.add(lblYourGuides, BorderLayout.WEST);

        //pnlLower.add(lblYourGuides);

        pnlGuideTable.add(pnlTableLow, BorderLayout.NORTH);
        pnlGuideTable.add(pnlTableLowBtn, BorderLayout.SOUTH);
        pnlLowerBorder.add(pnlGuideTable);

        pnlTableLow.add(jScrollPane2);
        pnlTableLowBtn.add(btnRemoveGuide);
        pnlTableLowBtn.add(btnEditGuide);
        pnlTableLowBtn.add(btnShowGuideLower);
        pnlTableLowBtn.add(btnNewGuide);

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

        jTableUp.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        int guideId = controller.getGuideId(jTableUp.getModel().getValueAt(row, 0).toString());
                        controller.userHomeOpenGuide(guideId,
                                jTableUp.getModel().getValueAt(row, 0).toString(),
                                jTableUp.getModel().getValueAt(row, 1).toString(),
                                jTableUp.getModel().getValueAt(row, 2).toString(),
                                controller.getGuideDescription(guideId));
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        controller.getUtil().showErrorDialog("Du har inte valt någon guide!");
                    }
                }
            }
        });

        jTableLow.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        int guideId = controller.getGuideId(jTableLow.getModel().getValueAt(row, 0).toString());
                        controller.userHomeOpenGuide(guideId,
                                jTableLow.getModel().getValueAt(row, 0).toString(),
                                jTableLow.getModel().getValueAt(row, 1).toString(),
                                jTableLow.getModel().getValueAt(row, 2).toString(),
                                controller.getGuideDescription(guideId));
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        controller.getUtil().showErrorDialog("Du har inte valt någon guide!");
                    }
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
        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                controller.comboBoxSearchGuideUHP(txtSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
            }
        });
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.comboBoxSearchGuideUHP(txtSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
                }
            }
        });
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
