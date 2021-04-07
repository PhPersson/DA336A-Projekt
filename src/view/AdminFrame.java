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

public class AdminFrame extends JFrame implements ActionListener {

    private JTable userTable,guideTable;
    private JButton btnDeleteGuide,btnDeleteUser,btnEditGuide,btnLogOff,btnSearchGuide,btnSearchUser;
    private JScrollPane guideTableScroll,userTableScroll;
    private JTextField guidesearch,userSearch;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel lblGuideSearch,lblLogo,lblUserSearch,lbladminName,lbllogin;

    private Controller controller;

    public AdminFrame(Controller controller) {
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
                180 ,50, Image.SCALE_SMOOTH)));


        guidesearch = new JTextField();
        btnSearchGuide = new JButton();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        btnDeleteGuide = new JButton();
        btnEditGuide = new JButton();
        userTableScroll = new JScrollPane();
        userTable = new JTable();
        guideTableScroll = new JScrollPane();
        guideTable = new JTable();

        lblGuideSearch = new JLabel();
        userSearch = new JTextField();
        btnSearchUser = new JButton();
        lbllogin = new JLabel();
        lbladminName = new JLabel();
        btnLogOff = new JButton();
        btnDeleteUser = new JButton();
        lblUserSearch = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        guidesearch.setText("");
        setTitle("Admninistratör");
        btnSearchGuide.setFont(new Font("Tahoma", 0, 12));
        btnSearchGuide.setText("Sök");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDeleteGuide.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteGuide.setText("Ta bort");

        btnEditGuide.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        btnEditGuide.setText("Redigera");

        userTable.setModel(new DefaultTableModel(
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

        userTableScroll.setViewportView(userTable);

        guideTable.setModel(new DefaultTableModel(
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

        guideTableScroll.setViewportView(guideTable);

        lblGuideSearch.setText("Guide");

        userSearch.setText("");

        btnSearchUser.setFont(new Font("Tahoma", 0, 12));
        btnSearchUser.setText("Sök");

        lbllogin.setText("Inloggad:");

        lbladminName.setText("\"\"");



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        guidesearch.setText("");

        btnSearchGuide.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        btnSearchGuide.setText("Sök");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDeleteGuide.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteGuide.setText("Ta bort");

        btnEditGuide.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        btnEditGuide.setText("Redigera");

        userTable.setModel(new DefaultTableModel(
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

        userTableScroll.setViewportView(userTable);

        guideTable.setModel(new DefaultTableModel(
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

        guideTableScroll.setViewportView(guideTable);

        lblGuideSearch.setText("Guide");

        userSearch.setText("");

        btnSearchUser.setFont(new Font("Tahoma", 0, 12));
        btnSearchUser.setText("Sök");

        lbllogin.setText("Inloggad:");

        lbladminName.setText("\"\"");


        btnLogOff.setFont(new Font("Tahoma", 0, 12));
        btnLogOff.setText("Logga ut");

        btnDeleteUser.setFont(new Font("Tahoma", 0, 12));
        btnDeleteUser.setText("Ta Bort");

        lblUserSearch.setText("Användare");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLogo)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(guidesearch, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnDeleteGuide, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(97, 97, 97)
                                                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(guideTableScroll, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                        .addComponent(lblGuideSearch))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUserSearch)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(userTableScroll, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(userSearch, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btnSearchUser, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(btnLogOff, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(lbllogin)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(lbladminName))))
                                                        .addComponent(btnDeleteUser, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLogo)
                                        .addComponent(lbllogin)
                                        .addComponent(lbladminName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogOff)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGuideSearch)
                                        .addComponent(lblUserSearch))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(guidesearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSearchUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userTableScroll)
                                        .addComponent(guideTableScroll))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDeleteGuide)
                                        .addComponent(btnEditGuide)
                                        .addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
        );
        addListeners();
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addListeners() {
        btnDeleteUser.addActionListener(this);
        btnSearchUser.addActionListener(this);
        btnSearchGuide.addActionListener(this);
        btnLogOff.addActionListener(this);
        btnDeleteGuide.addActionListener(this);
        btnEditGuide.addActionListener(this);

    }

    public int getTableIndex() {
        return userTable.getSelectedRow();
    }


    public void updateUserList(DefaultTableModel update) {
        userTable.setModel(update);
    }

    public void updateGuideList(DefaultTableModel update) {
        guideTable.setModel(update);
    }

    public void setLblloginAdmin(String name) {
        lbladminName.setText(name);
        lbladminName.setForeground(Color.darkGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeleteUser) {
            int column = 0;
            int row = userTable.getSelectedRow();
            String value = userTable.getModel().getValueAt(row, column).toString();
            controller.btnAdminDeleteUser(value);
        } else if (e.getSource() == btnSearchUser) {
            controller.btnAdminSearchUser(userSearch.getText());
        } else if (e.getSource() == btnSearchGuide) {
            controller.btnAdminSearchGuide(guidesearch.getText());
        } else if (e.getSource() == btnLogOff) {
            controller.btnLoggOffAdmin();
        } else if (e.getSource() == btnDeleteGuide) {
            int column = 0;
            int row = guideTable.getSelectedRow();
            String indexGuide = guideTable.getModel().getValueAt(row, column).toString();
            controller.btnAdminDeleteGuide(indexGuide);
        }
        else if (e.getSource() == btnEditGuide) {
            controller.editGuideAdmin();
        }
    }
    public JTable getGuideTable() {
        return guideTable;
    }

}
