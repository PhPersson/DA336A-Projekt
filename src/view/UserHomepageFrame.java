package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class UserHomepageFrame extends JFrame implements ActionListener {

    private JButton btnEditGuide,btnLogOff,btnNewGuide,btnShowGuideLower,btnRemoveGuide,btnSearch,btnShowGuideUpper;
    private JScrollPane jScrollPane1,jScrollPane2;

    private JTable jTableLow;
    private JTable jTableUp;
    private JLabel lblLoggedIn,lblSearchResult,lblYourGuides,lblActiveUser;
    private JTextField txtSearch;
    private JLabel lblLogo;
    private JButton btnUserSettings;
    private Controller controller;

    public UserHomepageFrame(Controller controller){
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140,38, Image.SCALE_SMOOTH)));

        txtSearch = new JTextField();
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

        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");

        jScrollPane2.setViewportView(jTableLow);

        jScrollPane1.setViewportView(jTableUp);

        btnShowGuideUpper.setFont(new Font("Tahoma", 0, 14));
        btnShowGuideUpper.setText("Visa");

        btnEditGuide.setFont(new Font("Tahoma", 0, 14));
        btnEditGuide.setText("Redigera");

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuideLower.setFont(new Font("Tahoma", 0, 14));
        btnShowGuideLower.setText("Visa");

        btnNewGuide.setFont(new Font("Tahoma", 0, 14));
        btnNewGuide.setText("Skapa ny guide");

        lblYourGuides.setFont(new Font("Tahoma", 0, 14));
        lblYourGuides.setText("Dina guider:");

        btnLogOff.setFont(new Font("Tahoma", 0, 10));
        btnLogOff.setText("Logga ut");

        lblActiveUser.setFont(new Font("Tahoma", 0, 14));
        lblActiveUser.setText("Inloggad:");

        lblLoggedIn.setFont(new Font("Tahoma", 0, 14));
        lblLoggedIn.setText("Användarnamn");


        btnRemoveGuide.setFont(new Font("Tahoma", 0, 14));
        btnRemoveGuide.setText("Ta Bort");

        btnUserSettings.setFont(new Font("Tahoma", 0, 14));
        btnUserSettings.setText("Inställningar");

        jTableUp.setDefaultEditor(Object.class, null);
        jTableLow.setDefaultEditor(Object.class, null);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShowGuideLower, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(220, Short.MAX_VALUE)
                                                .addComponent(btnNewGuide)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnShowGuideUpper, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblYourGuides)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(lblSearchResult)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtSearch)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnSearch))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblLogo)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 269, Short.MAX_VALUE)
                                                                                .addComponent(lblActiveUser)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(lblLoggedIn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addGap(290, 290, 290)
                                                                                .addComponent(btnUserSettings, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnLogOff, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addGap(1, 1, 1)))))
                                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblActiveUser)
                                        .addComponent(lblLoggedIn)
                                        .addComponent(lblLogo))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLogOff, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUserSettings, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblSearchResult)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNewGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuideUpper, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(lblYourGuides)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuideLower, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        addListeners();
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

    public void setLblloginUser(String name) {
        lblLoggedIn.setText(name);
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
        }  else if (e.getSource() == btnLogOff) {
            controller.btnUserLoggOff();
        } else if (e.getSource() == btnSearch) {
            controller.btnUserSearchGuide(txtSearch.getText());
        } else if (e.getSource() == btnShowGuideUpper) {
            int row = jTableUp.getSelectedRow();

            String titleString = jTableUp.getModel().getValueAt(row,1).toString();
            String authorString = jTableUp.getModel().getValueAt(row,2).toString();
            String dateString = jTableUp.getModel().getValueAt(row,3).toString();
            String descriptionString = jTableUp.getModel().getValueAt(row, 5).toString();

            new ShowGuideGUI(controller,titleString, authorString, dateString, descriptionString);
        } else if (e.getSource() == btnShowGuideLower) {
            int row = jTableLow.getSelectedRow();

            String titleString = jTableLow.getModel().getValueAt(row,1).toString();
            String authorString = jTableLow.getModel().getValueAt(row,2).toString();
            String dateString = jTableLow.getModel().getValueAt(row,3).toString();
            String descriptionString = jTableLow.getModel().getValueAt(row, 5).toString();

            new ShowGuideGUI(controller,titleString, authorString, dateString, descriptionString);
        } else if (e.getSource() == btnUserSettings) {
            controller.btnUserSettings();
        }
        else if (e.getSource() == btnEditGuide) {
            controller.editGuide();
        } else if (e.getSource() == btnRemoveGuide) {
            int row = jTableLow.getSelectedRow();
            String titleToRemove = jTableLow.getModel().getValueAt(row,0).toString();
            controller.btnDeleteGuide(titleToRemove);

        }
    }
    public JTable getTableLow() {
        return jTableLow;
    }
}
