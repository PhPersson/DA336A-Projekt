package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Philip Persson
 * @author Alexander Olsson
 * @version 2.0
 */

public class HomePageFrame extends JFrame implements ActionListener {


    private JPanel middle, top, topUpper, topLower, lower, pnlSearchResult, pnlCombo;
    private JButton btnLogin, btnSearch, btnShowGuides;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JLabel lblLogo, lblSearchResult, lblEmpty, lblLoginInfo;
    private JTextField txtSearch;
    private final Controller controller;
    private final String btnSearchToolTip = "<html><p style='font-style:italic;color:black;'>" +
            "Sök efter en guide baserat på användarnamn och/eller titel</p></html> ";
    private final String btnShowGuideToolTip = "<html><p style='font-style:italic;color:black'>" +
            "Markera den guide du vill se" + " Tryck sedan här igen</p></html> ";

    private JComboBox<String> categoryComboBox, typeComboBox;

    private String infoMessage = "Logga in för att få tillgång till att skapa dina egna guider!";


    public HomePageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        setTitle("SupportME");

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("files/Logga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblLogo = new JLabel(new ImageIcon(myPicture.getScaledInstance(
                140, 38, Image.SCALE_SMOOTH)));

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        lblSearchResult = new JLabel();
        btnShowGuides = new JButton();
        btnLogin = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        txtSearch.setFont(new Font("Tahoma", 0, 14));
        txtSearch.setPreferredSize(new Dimension(400, 25));
        txtSearch.setText("Sök här efter guide...");
        txtSearch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtSearch.setText("");
            }
        });


        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");

        btnSearch.setToolTipText(btnSearchToolTip);
        btnSearch.setPreferredSize(new Dimension(100, 25));

        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Title", "Username", "Date", "Ratings"
                }
        ));

        jScrollPane1.setViewportView(table);

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuides.setFont(new Font("Tahoma", 0, 14));
        btnShowGuides.setText("Visa");
        btnShowGuides.setToolTipText(btnShowGuideToolTip);

        btnLogin.setFont(new Font("Tahoma", 0, 14));
        btnLogin.setText("Logga in");
        btnLogin.setPreferredSize(new Dimension(10, 10));

        table.setDefaultEditor(Object.class, null);

        BufferedImage infoIcon = null;
        try {
            infoIcon = ImageIO.read(new File("files/InfoLogga.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lblLoginInfo = new JLabel();

        lblLoginInfo.setIcon(new ImageIcon(infoIcon.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));

        lblLoginInfo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, infoMessage, "Kontaktinformation", JOptionPane.INFORMATION_MESSAGE);
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lblLoginInfo.setForeground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lblLoginInfo.setForeground(Color.black);

            }
        });

        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Sök efter typ", "Mjukvara", "Hårdvara", "Snabbguide"}));
        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Sök efter kategori", "Internet", "Dator", "Mobil", "Övrigt"}));

        GridLayout layout = new GridLayout(3,1,0,0);
        GridLayout gridLayout = new GridLayout(1, 2, 250, 0);

        Border emptyBorder = BorderFactory.createEmptyBorder(5, 2, 0, 5);
        Border emptyBorderUpper = BorderFactory.createEmptyBorder(5, 2, 0, 0);
        Border emptyBorderMiddle = BorderFactory.createEmptyBorder(0, 10, 2, 10);

        top = new JPanel();
        top.setLayout(layout);
        top.setBorder(emptyBorder);

        topUpper = new JPanel();
        topUpper.setLayout(new BoxLayout(topUpper, BoxLayout.X_AXIS));
        topUpper.setBorder(emptyBorderUpper);

        topLower = new JPanel(new GridLayout(1, 2));
        topLower.setLayout(new BoxLayout(topLower, BoxLayout.X_AXIS));
        topLower = new JPanel();
        //topLower.setLayout(layoutTop);
        topLower.setBorder(emptyBorder);

        topUpper.add(lblLogo);
        topUpper.add(Box.createRigidArea(new Dimension(275, 10)));
        topUpper.add(btnLogin);
        topUpper.add(Box.createRigidArea(new Dimension(5, 10)));
        topUpper.add(lblLoginInfo);

        topLower.add(txtSearch);
        topLower.add(btnSearch);

        pnlCombo = new JPanel();
        pnlCombo.add(typeComboBox);
        pnlCombo.add(Box.createRigidArea(new Dimension(200, 10)));
        pnlCombo.add(categoryComboBox);

        top.add(topUpper, BorderLayout.NORTH);
        top.add(topLower, BorderLayout.CENTER);
        top.add(pnlCombo);

        add(top, BorderLayout.NORTH);

        pnlSearchResult = new JPanel(new BorderLayout());
        pnlSearchResult.add(lblSearchResult, BorderLayout.WEST);
        pnlSearchResult.setBorder(BorderFactory.createEmptyBorder(0,0,2,10));

        middle = new JPanel(new GridLayout(2,1));

        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
        middle.setBorder(emptyBorderMiddle);

        middle.add(pnlSearchResult);
        middle.add(jScrollPane1, BorderLayout.SOUTH);
        add(middle, BorderLayout.CENTER);

        lower = new JPanel();
        lower.setLayout(gridLayout);
        lower.setBorder(emptyBorderMiddle);

        btnShowGuides.setPreferredSize(new Dimension(10, 30));
        lblEmpty = new JLabel();

        //lower.add(lblEmpty);

        lower.add(btnShowGuides);
        lower.setBorder(BorderFactory.createEmptyBorder(0,225,0,225));

        add(lower, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        int guideId = controller.getGuideId(table.getModel().getValueAt(row, 0).toString());
                        controller.homeOpenGuide(guideId,
                                table.getModel().getValueAt(row, 0).toString(),
                                table.getModel().getValueAt(row, 1).toString(),
                                table.getModel().getValueAt(row, 2).toString(),
                                controller.getGuideDescription(guideId));
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        controller.getUtil().showErrorDialog("Du har inte valt någon guide!");
                    }
                }
            }
        });
    }

    public void addListeners() {
        btnLogin.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuides.addActionListener(this);

        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.comboBoxSearchGuideHPF(txtSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
                }
            }
        });
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.comboBoxSearchGuideHPF(txtSearch.getSelectedText(), String.valueOf(typeComboBox.getSelectedItem()), String.valueOf(categoryComboBox.getSelectedItem()));
                }
            }
        });
    }

    public void updateSearchGuideList(DefaultTableModel update) {
        table.setModel(update);
    }



    public void updateUserSearchGuideList(DefaultTableModel update) {
        table.setModel(update);
    }

    public int getGuideId() {
        int guideId = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
        return guideId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        } else if (e.getSource() == btnLogin) {
            controller.btnHomePageFrameLogin();
            dispose();
        } else if (e.getSource() == btnShowGuides) {
            int row = table.getSelectedRow();
            int guideId = controller.getGuideId(table.getModel().getValueAt(row, 0).toString());
            controller.homeOpenGuide(
                    guideId,
                    table.getModel().getValueAt(row, 0).toString(),
                    table.getModel().getValueAt(row, 1).toString(),
                    table.getModel().getValueAt(row, 2).toString(),
                    controller.getGuideDescription(guideId));


        } else if (e.getSource() == btnSearch) {
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        }
    }
}
