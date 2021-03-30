package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {


    private JComboBox<String> GuideTypeBox;
    private JButton btnDeleteGuide;
    private JButton btnDeleteUser;
    private JButton btnEditGuide;
    private JButton btnLogOff;
    private JButton btnSearchGuide;
    private JTextField txtSearchUser;
    private JTextField guidesearch;
    private JButton btnSearchUser;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JScrollPane scrollGuide;
    private JScrollPane jScrollPane2;
    private JTable guideTable;
    private JTable userTable;
    private JLabel lblGuide;
    private JLabel lblUser;
    private JLabel lbladminName;
    private JLabel lblloginAdmin;
    private Controller controller;


    public AdminFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }


    private void initComponents() {

        scrollGuide = new JScrollPane();
        guideTable = new JTable();
        jScrollPane2 = new JScrollPane();
        userTable = new JTable();
        txtSearchUser = new JTextField();
        guidesearch = new JTextField();
        lblGuide = new JLabel();
        btnSearchGuide = new JButton();
        GuideTypeBox = new JComboBox<>();
        lblloginAdmin = new JLabel();
        lblUser = new JLabel();
        btnSearchUser = new JButton();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        lbladminName = new JLabel();
        btnLogOff = new JButton();
        btnDeleteUser = new JButton();
        btnEditGuide = new JButton();
        btnDeleteGuide = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);



        scrollGuide.setViewportView(guideTable);
        jScrollPane2.setViewportView(userTable);

        txtSearchUser.setPreferredSize(new Dimension(34, 23));

        guidesearch.setFont(new Font("Tahoma", 0, 14));

        lblGuide.setFont(new Font("Tahoma", 0, 14));
        lblGuide.setText("Guide");

        btnSearchGuide.setFont(new Font("Tahoma", 0, 14));
        btnSearchGuide.setText("Sök");


        lblloginAdmin.setFont(new Font("Tahoma", 0, 12));
        lblloginAdmin.setText("Inloggad:");

        lblUser.setFont(new Font("Tahoma", 0, 14));
        lblUser.setText("Användare");

        btnSearchUser.setFont(new Font("Tahoma", 0, 14));
        btnSearchUser.setText("Sök");

        lbladminName.setText("AdminText");
        btnLogOff.setText("LogOff");

        btnDeleteUser.setFont(new Font("Tahoma", 0, 14));
        btnDeleteUser.setText("Delete");

        btnEditGuide.setFont(new Font("Tahoma", 0, 14));
        btnEditGuide.setText("Redigera");

        btnDeleteGuide.setFont(new Font("Tahoma", 0, 14));
        btnDeleteGuide.setText("Delete");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblGuide, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(GuideTypeBox, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(guidesearch, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(scrollGuide, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDeleteGuide, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtSearchUser, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnSearchUser, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnLogOff, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(lblloginAdmin)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbladminName, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(39, 39, 39))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))
                                                .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 22, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblGuide, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(guidesearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtSearchUser, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSearchUser, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(GuideTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblloginAdmin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(lbladminName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnLogOff)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                                        .addComponent(scrollGuide))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteGuide, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );
        addListeners();

        setResizable(true);
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
            controller.btnAdminSearchUser(txtSearchUser.getText());
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
    }
}
