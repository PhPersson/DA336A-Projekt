package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserHomepageFrame extends JFrame implements ActionListener {


    private JButton btnLogOff,btnNewGuide,btnRemoveGuide,btnSearch, btnShowGuideLower, btnShowGuideUpper,btnEditGuide;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTable jTable2;
    private JLabel lblLoggedIn,lblSearchResult,lblYourGuides,lblactiveUser;
    private JTextField txtSearch;
    private Controller controller;

    public UserHomepageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }


    private void initComponents() {

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane1 = new JScrollPane();
        jTable2 = new JTable();
        btnShowGuideUpper = new JButton();
        btnEditGuide = new JButton();
        lblSearchResult = new JLabel();
        btnShowGuideLower = new JButton();
        btnNewGuide = new JButton();
        lblYourGuides = new JLabel();
        btnLogOff = new JButton();
        lblactiveUser = new JLabel();
        lblLoggedIn = new JLabel();
        btnRemoveGuide = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        txtSearch.setFont(new Font("Tahoma", 0, 14));


        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");


        jScrollPane2.setViewportView(jTable1);

        jScrollPane1.setViewportView(jTable2);

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

        lblYourGuides.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblYourGuides.setText("Dina guider:");

        btnLogOff.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        btnLogOff.setText("Logga ut");

        lblactiveUser.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblactiveUser.setText("Inloggad:");

        lblLoggedIn.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblLoggedIn.setText("USERNAME");

        btnRemoveGuide.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        btnRemoveGuide.setText("Ta Bort");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblYourGuides)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblSearchResult)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(39, 39, 39)
                                                                .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnShowGuideUpper, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(btnNewGuide)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnShowGuideLower, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(txtSearch)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnSearch)))
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblactiveUser)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnLogOff, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblLoggedIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblactiveUser)
                                        .addComponent(lblLoggedIn))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogOff, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblSearchResult)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNewGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuideLower, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(lblYourGuides)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuideUpper, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );
        
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        addListeners();
    }

    public void addListeners() {
        btnNewGuide.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuideLower.addActionListener(this);
        btnLogOff.addActionListener(this);
    }

    public void setLblloginUser(String name) {
        lblLoggedIn.setText(name);
        lblLoggedIn.setForeground(Color.darkGray);
    }

    public void updateUserSearchGuideList(DefaultTableModel update) {
        jTable2.setModel(update);
    }
    public void updateUserGuideList(DefaultTableModel update) {
        jTable1.setModel(update);
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
            int column = 4;
            int row = jTable1.getSelectedRow();
            String indexGuide = jTable1.getModel().getValueAt(row, column).toString();
            String titleString = jTable1.getModel().getValueAt(row,0).toString();
            String authorString = jTable1.getModel().getValueAt(row,1).toString();
            String dateString = jTable1.getModel().getValueAt(row,2).toString();

            try {
                controller.btnShowGuideLoggedInPressed(indexGuide, titleString, dateString, authorString);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (e.getSource() == btnShowGuideLower) {
            int column = 4;
            int row = jTable2.getSelectedRow();
            String indexGuide = jTable2.getModel().getValueAt(row, column).toString();
            String titleString = jTable2.getModel().getValueAt(row,0).toString();
            String authorString = jTable2.getModel().getValueAt(row,1).toString();
            String dateString = jTable2.getModel().getValueAt(row,2).toString();

            try {
                controller.btnShowGuideLoggedInPressed(indexGuide, titleString, dateString, authorString);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        /*
        int column = 4;
        int row = table.getSelectedRow();
        String indexGuide = table.getModel().getValueAt(row, column).toString();
        String titleString = table.getModel().getValueAt(row,0).toString();
        String authorString = table.getModel().getValueAt(row,1).toString();
        String dateString = table.getModel().getValueAt(row,2).toString();

        controller.btnShowGuideNotLoggedInPressed(indexGuide, titleString, dateString, authorString);
*/

    }
}


