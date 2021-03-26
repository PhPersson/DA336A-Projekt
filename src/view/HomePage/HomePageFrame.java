package view.HomePage;

import controller.Controller;

import javax.swing.*;

public class HomePageFrame extends JFrame {


    private JToggleButton btnEditGuide;
    private JButton btnLogOff;
    private JButton btnNewGuide;
    private JButton btnRemoveGuide;
    private JButton btnSearch;
    private JToggleButton btnShowGuide;
    private JButton btnShowGuides;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTable jTable2;
    private JLabel lblLoggedIn;
    private JLabel lblSearchResult;
    private JLabel lblYourGuides;
    private JLabel lblactiveUser;
    private JTextField txtSearch;
    private Controller controller;

    public HomePageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }


    private void initComponents() {

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane1 = new JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnShowGuide = new javax.swing.JToggleButton();
        btnEditGuide = new javax.swing.JToggleButton();
        lblSearchResult = new javax.swing.JLabel();
        btnShowGuides = new javax.swing.JButton();
        btnNewGuide = new javax.swing.JButton();
        lblYourGuides = new javax.swing.JLabel();
        btnLogOff = new javax.swing.JButton();
        lblactiveUser = new javax.swing.JLabel();
        lblLoggedIn = new javax.swing.JLabel();
        btnRemoveGuide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Sök");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable2);

        btnShowGuide.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnShowGuide.setText("Visa");

        btnEditGuide.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditGuide.setText("Redigera");

        lblSearchResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSearchResult.setText("Sökresultat:");

        btnShowGuides.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnShowGuides.setText("Visa");

        btnNewGuide.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNewGuide.setText("Skapa ny guide");

        lblYourGuides.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblYourGuides.setText("Dina guider:");

        btnLogOff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogOff.setText("Logga ut");

        lblactiveUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblactiveUser.setText("Inloggad:");

        lblLoggedIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoggedIn.setText("USERNAME");

        btnRemoveGuide.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemoveGuide.setText("Ta Bort");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblYourGuides)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblSearchResult)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(39, 39, 39)
                                                                .addComponent(btnRemoveGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEditGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnShowGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(btnNewGuide)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnShowGuides, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(txtSearch)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnSearch)))
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblactiveUser)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnLogOff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblLoggedIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblactiveUser)
                                        .addComponent(lblLoggedIn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogOff, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblSearchResult)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNewGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuides, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(lblYourGuides)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEditGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnShowGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemoveGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }// </editor-fold>

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


}


