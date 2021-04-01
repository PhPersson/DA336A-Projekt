package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHomepageFrame extends JFrame implements ActionListener {


    private JButton btnEditGuide,btnLogOff,btnNewGuide,btnShowGuide,btnRemoveGuide,btnSearch,btnShowGuides;
    private JScrollPane jScrollPane1,jScrollPane2;
    private JTable jTable1;
    private JTable jTable2;
    private JLabel lblLoggedIn,lblSearchResult,lblYourGuides,lblactiveUser;
    private JTextField txtSearch;
    private Controller controller;

    public UserHomepageFrame(Controller controller){
        initComponents();
    }



    private void initComponents() {

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane1 = new JScrollPane();
        jTable2 = new JTable();
        btnShowGuide = new JButton();
        btnEditGuide = new JButton();
        lblSearchResult = new JLabel();
        btnShowGuides = new JButton();
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

        btnShowGuide.setFont(new Font("Tahoma", 0, 14));
        btnShowGuide.setText("Visa");

        btnEditGuide.setFont(new Font("Tahoma", 0, 14));
        btnEditGuide.setText("Redigera");

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuides.setFont(new Font("Tahoma", 0, 14));
        btnShowGuides.setText("Visa");

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
                                .addGap(50, 50, 50)
                                .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShowGuide, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(220, Short.MAX_VALUE)
                                                .addComponent(btnNewGuide)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblYourGuides)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(lblSearchResult)
                                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                        .addComponent(txtSearch)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(btnSearch)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblactiveUser)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(btnLogOff, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lblLoggedIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                .addGap(1, 1, 1)))))
                                .addGap(26, 26, 26))
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblSearchResult)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNewGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addComponent(lblYourGuides)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRemoveGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
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
        btnShowGuides.addActionListener(this);
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