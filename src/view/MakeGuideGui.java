package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alexander Olsson
 */

public class MakeGuideGui extends JFrame implements ActionListener{

    private Controller controller;
    private JButton btnCancel,btnMakeGuide,btnAddPicture;
    private JTextArea textAreaInput;
    private JComboBox<String> categoryComboBox;
    private JLabel lblMakeGuide;
    private JTextField fieldTitle;
    private JComboBox<String> typeComboBox;
    private JInternalFrame jInternalFrame1;
    private JInternalFrame jInternalFrame2;
    private JScrollPane jScrollPane1;
    private MakeGuideGui makeGuideGui;

    public MakeGuideGui(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        jInternalFrame1 = new JInternalFrame();
        jInternalFrame2 = new JInternalFrame();
        jScrollPane1 = new JScrollPane();
        textAreaInput = new JTextArea();
        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();
        fieldTitle = new JTextField();
        btnMakeGuide = new JButton();
        btnAddPicture = new JButton();
        lblMakeGuide = new JLabel();
        btnCancel = new JButton();

        jInternalFrame1.setVisible(true);
        setTitle("Skapa guide");
        GroupLayout jInternalFrame1Layout = new GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        GroupLayout jInternalFrame2Layout = new GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
                jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
                jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        textAreaInput.setColumns(20);
        textAreaInput.setRows(5);
        textAreaInput.setText("Beskrivning.");
        jScrollPane1.setViewportView(textAreaInput);

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));


        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        fieldTitle.setText("Titel");


        btnMakeGuide.setText("Skapa Guide");


        btnAddPicture.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        btnAddPicture.setText("Lägg till Bild");


        lblMakeGuide.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblMakeGuide.setText("Skapa ny Guide");

        btnCancel.setText("Avbryt");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnMakeGuide, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(fieldTitle, GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                                        .addComponent(btnAddPicture, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING))
                                        .addComponent(lblMakeGuide, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblMakeGuide, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddPicture, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMakeGuide, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );

        SwingUtilities.getRootPane(btnMakeGuide).setDefaultButton(btnMakeGuide);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
    }

    public void addListeners() {
        btnCancel.addActionListener(this);
        btnMakeGuide.addActionListener(this);
        btnAddPicture.addActionListener(this);
    }

    public String getTitleGuide() {
        return fieldTitle.getText();
    }

    public String getDescriptionField() {
        return textAreaInput.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            controller.btnCancelGuide();
        } else if (e.getSource() == btnMakeGuide) {
            controller.btnCreateGuide();
            dispose();
        } else if (e.getSource() == btnAddPicture) {
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setMultiSelectionEnabled(true);
//            fileChooser.setFileFilter(new FileNameExtensionFilter("Pictures","jpg","png"));
//            int result = fileChooser.showSaveDialog(null);
//            File[] files = fileChooser.getSelectedFiles();
        }
    }
}
