package view;

import controller.Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HPFrameNotLoggedIn extends JFrame implements ActionListener{


    private Controller controller;
    private JButton btnLogIn;
    private JButton btnSearch;
    private JButton btnShowGuides;
    private JScrollPane jScrollPane1;
    private JTable table;
    private JLabel lblSearchResult;
    private JTextField txtSearch;


    public HPFrameNotLoggedIn(Controller controller) {
        this.controller = controller;
        initComponents();
    }


    private void initComponents() {

        txtSearch = new JTextField();
        btnSearch = new JButton();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        lblSearchResult = new JLabel();
        btnShowGuides = new JButton();
        btnLogIn = new JButton();

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

        btnShowGuides.setFont(new Font("Tahoma", 0, 14));
        btnShowGuides.setText("Visa");

        btnLogIn.setFont(new Font("Tahoma", 0, 14));
        btnLogIn.setText("Logga in");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblSearchResult)
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnLogIn))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSearch, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSearch, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSearchResult)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnShowGuides, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        this.setLocationRelativeTo(null);
        setVisible(true);
        pack();
        addListeners();
    }
    public void addListeners() {
        btnLogIn.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowGuides.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            controller.btntSearchGuideNotLoggedInPressed(txtSearch.getText());
        } else if (e.getSource() == btnLogIn) {
            controller.btnLoginClicked();
        } else if (e.getSource() == btnShowGuides);{ // Visa den markerade guiden // Baserat på vilket index man står på i raden.
            int column = 0;
            int row = table.getSelectedRow();
            String indexGuide = table.getModel().getValueAt(row, column).toString();
            controller.btnShowGuideNotLoggedInPressed(indexGuide);
        }
    }
}
