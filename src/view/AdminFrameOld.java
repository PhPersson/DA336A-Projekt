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
public class AdminFrameOld extends JFrame implements ActionListener {

    private JTable userTable, guideTable;
    private JPanel top, middle, lower;
    private JPanel pnlLogo, pnlLogOut, pnlWest, pnlEast;
    private JButton btnDeleteGuide, btnDeleteUser, btnEditGuide, btnLogOff, btnSearchGuide, btnSearchUser;
    private JScrollPane guideTableScroll, userTableScroll;
    private JTextField guideSearch, userSearch;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> categoryComboBox;
    private JLabel lblGuideSearch, lblLogo, lblUserSearch, lblAdminName, lblLogin;

    private Controller controller;

    public static void main(String[] args) {
        new AdminFrameOld();
    }

    public AdminFrameOld() {
        //this.controller = controller;
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
        setTitle("SupportME");

        guideSearch.setText("");

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

        top = new JPanel(new BorderLayout());
        middle = new JPanel(new BorderLayout());
        pnlLogo = new JPanel(new BorderLayout());
        pnlLogOut = new JPanel(new BorderLayout());
        pnlWest = new JPanel();
        pnlEast = new JPanel();

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        pnlWest.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pnlEast.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        pnlLogo.add(lblLogo, BorderLayout.WEST);

        add(top);
        add(middle);
        top.add(pnlLogo, BorderLayout.NORTH);
        top.add(pnlLogOut, BorderLayout.SOUTH);
        middle.add(pnlWest, BorderLayout.WEST);
        middle.add(pnlEast, BorderLayout.EAST);


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
