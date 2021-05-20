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
public class AdminFrame extends JFrame implements ActionListener {

    private JTable userTable, guideTable;
    private JButton btnDeleteGuide, btnDeleteUser, btnEditGuide, btnLogOff, btnSearchGuide, btnSearchUser;
    private JScrollPane guideTableScroll, userTableScroll;
    private JTextField guideSearch, userSearch;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> categoryComboBox;
    private JLabel lblGuideSearch, lblLogo, lblUserSearch, lblAdminName, lblLogin;

    private final Controller controller;

    public AdminFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                180, 50, Image.SCALE_SMOOTH)));

        guideSearch = new JTextField();
        btnSearchGuide = new JButton();
        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();
        btnDeleteGuide = new JButton();
        btnEditGuide = new JButton();
        userTableScroll = new JScrollPane();
        userTable = new JTable();
        guideTableScroll = new JScrollPane();
        guideTable = new JTable();

        lblGuideSearch = new JLabel();
        userSearch = new JTextField();
        btnSearchUser = new JButton();
        lblLogin = new JLabel();
        lblAdminName = new JLabel();
        btnLogOff = new JButton();
        btnDeleteUser = new JButton();
        lblUserSearch = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        guideSearch.setText("");
        setTitle("SupportME");
        btnSearchGuide.setFont(new Font("Tahoma", 0, 12));
        btnSearchGuide.setText("Sök");

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        btnDeleteGuide.setFont(new Font("Tahoma", 0, 12));
        btnDeleteGuide.setText("Ta bort");

        btnEditGuide.setFont(new Font("Tahoma", 0, 12));
        btnEditGuide.setText("Redigera");


        userTableScroll.setViewportView(userTable);
        guideTableScroll.setViewportView(guideTable);


        userTable.setDefaultEditor(Object.class, null);
        guideTable.setDefaultEditor(Object.class, null);


        lblLogin.setText("Inloggad:");
        lblGuideSearch.setText("Guide");

        userSearch.setText(""); // TODO LÄGG TILL TOO TIP I KURSIV
        guideSearch.setText(""); // TODO LÄGG TILL TOO TIP I KURSIV
        userSearch.setText("");
        btnSearchUser.setFont(new Font("Tahoma", 0, 12));
        btnSearchUser.setText("Sök");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        btnSearchGuide.setFont(new Font("Tahoma", 0, 12));
        btnSearchGuide.setText("Sök");

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Typ:  ", "Mjukvara", "Hårdvara", "Snabbguide"}));

        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Kategori: ", "Internet", "Dator", "Mobil", "Övrigt"}));

        btnDeleteGuide.setFont(new Font("Tahoma", 0, 12));
        btnDeleteGuide.setText("Ta bort");

        btnEditGuide.setFont(new Font("Tahoma", 0, 12));
        btnEditGuide.setText("Redigera");


        userTableScroll.setViewportView(userTable);


        guideTableScroll.setViewportView(guideTable);

        lblGuideSearch.setText("Guide");


        btnSearchUser.setFont(new Font("Tahoma", 0, 12));
        btnSearchUser.setText("Sök");

        lblLogin.setText("Inloggad:");


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
                                                                        .addComponent(guideSearch, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(btnEditGuide, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnDeleteGuide, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(97, 97, 97)
                                                                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
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
                                                                                .addComponent(lblLogin)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(lblAdminName))))
                                                        .addComponent(btnDeleteUser, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLogo)
                                        .addComponent(lblLogin)
                                        .addComponent(lblAdminName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogOff)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGuideSearch)
                                        .addComponent(lblUserSearch))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(guideSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(userSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSearchUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSearchGuide, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
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
        guideTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

                }
            }
        });
        userTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

                }
            }
        });
    }

    public void addListeners() {
        btnDeleteUser.addActionListener(this);
        btnSearchUser.addActionListener(this);
        btnSearchGuide.addActionListener(this);
        btnLogOff.addActionListener(this);
        btnDeleteGuide.addActionListener(this);
        btnEditGuide.addActionListener(this);
        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.comboBoxSearchGuideADM(guideSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
                }
            }
        });
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.comboBoxSearchGuideADM(guideSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
                }
            }
        });
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

    public void setLblLoginAdmin(String name) {
        lblAdminName.setText(name.substring(0, 1).toUpperCase() + name.substring(1));
        lblAdminName.setForeground(Color.darkGray);
    }

    public String getAdminName() {
        return lblAdminName.getText();
    }

    public JTable getGuideTable() {
        return guideTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeleteUser) {
            int column = 0;
            int row = userTable.getSelectedRow();
            String value = userTable.getModel().getValueAt(row, column).toString();
            try {
                controller.btnAdminDeleteUser(value);
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har ännu inte valt någon guide!");
            }
        } else if (e.getSource() == btnSearchUser) {
            controller.btnAdminSearchUser(userSearch.getText());
        } else if (e.getSource() == btnSearchGuide) {
            controller.btnAdminSearchGuide(guideSearch.getText());
        } else if (e.getSource() == btnLogOff) {
            controller.btnLoggOffAdmin();
        } else if (e.getSource() == btnDeleteGuide) {
            int row = guideTable.getSelectedRow();
            String indexGuide = guideTable.getModel().getValueAt(row, 0).toString();
            try {
                controller.btnAdminDeleteGuide(indexGuide);
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har ännu inte valt någon guide!");
            }
        } else if (e.getSource() == btnEditGuide) {
            try {
                controller.editGuide();
            } catch (ArrayIndexOutOfBoundsException exception) {
                controller.getUtil().showErrorDialog("Du har ännu inte valt någon guide!");
            }
        }
    }
}
