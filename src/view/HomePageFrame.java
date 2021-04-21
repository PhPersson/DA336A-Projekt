package view;


import controller.Controller;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Philip Persson
 * @version 1.0
 */

public class HomePageFrame extends JFrame implements ActionListener {

    private JButton btnLogin,btnSearch,btnShowGuides;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JLabel lblLogo,lblSearchResult;
    private JTextField txtSearch;
    private Controller controller;

    public HomePageFrame(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        setTitle("SupportME");
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
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        lblSearchResult = new JLabel();
        btnShowGuides = new JButton();
        btnLogin = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        txtSearch.setFont(new Font("Tahoma", 0, 14));


        btnSearch.setFont(new Font("Tahoma", 0, 14));
        btnSearch.setText("Sök");

        table.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Title", "Username", "Date", "Ratings"
                }
        ));
        jScrollPane1.setViewportView(table);

        lblSearchResult.setFont(new Font("Tahoma", 0, 14));
        lblSearchResult.setText("Sökresultat:");

        btnShowGuides.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnShowGuides.setText("Visa");

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnLogin.setText("Logga in");

        table.setDefaultEditor(Object.class, null);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtSearch)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnSearch))
                                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(lblSearchResult)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblLogo)
                                                                                .addGap(350, 350, 350)
                                                                                .addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addGap(1, 1, 1)))))
                                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblLogo)
                                                .addGap(0, 23, Short.MAX_VALUE))
                                        .addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSearchResult)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

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
    }

    public void addListeners() {
        btnLogin.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuides.addActionListener(this);
    }

    public void updateSearchGuideList(DefaultTableModel update) {
        table.setModel(update);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        } else if (e.getSource() == btnLogin) {
            controller.btnHomePageFrameLogin();
        } else if (e.getSource() == btnShowGuides){ // Visa den markerade guiden // Baserat på vilket index man står på i raden.
            int guideId = (int) table.getModel().getValueAt(table.getSelectedRow(),0);
            int row = table.getSelectedRow();

            controller.openGuide(
                    guideId,
                    table.getModel().getValueAt(row,1).toString(),
                    table.getModel().getValueAt(row,2).toString(),
                    table.getModel().getValueAt(row,3).toString(),
                    table.getModel().getValueAt(row,5).toString());

        } else if (e.getSource() == btnSearch){
            controller.btnNoLoginSearchGuide(txtSearch.getText());
        }
    }


}
