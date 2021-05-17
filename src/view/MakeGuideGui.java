package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author Alexander Olsson
 * @author Philip Persson
 * @author
 * @version 1.0
 *
 */

public class MakeGuideGui extends JFrame implements ActionListener {

    private Controller controller;

    private JPanel top,combo,middle,lower, text, middlePanel;

    private JButton btnCancel,btnMakeGuide,btnAddPicture;
    private JTextArea textAreaInput;
    private JComboBox<String> categoryComboBox;
    private JLabel lblMakeGuide;
    private JTextField fieldTitle;
    private JComboBox<String> typeComboBox;

    private JScrollPane jScrollPane1;
    private String selectedFile;

    public MakeGuideGui(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        setSize(800,800);

        setTitle("Skapa guide");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        GridLayout layoutTop = new GridLayout(1,1,20,10);
        GridLayout layoutMiddle = new GridLayout(1,3,20,0);
        GridLayout layoutLower = new GridLayout(1,2,100,0);
        GridLayout LayoutMiddlePanel = new GridLayout(3,1,0,0);


        Border topBorder = BorderFactory.createEmptyBorder(10, 60, 10, 60);
        Border middleBorder = BorderFactory.createEmptyBorder(10, 60, 10, 60);


        top = new JPanel();
        top.setLayout(layoutTop);
        top.setBorder(topBorder);

        combo = new JPanel();
        combo.setLayout(layoutMiddle);
        combo.setBorder(topBorder);

        middle = new JPanel();
        middle.setLayout(layoutMiddle);
        middle.setBorder(middleBorder);
        middle.setSize(100,100);
        //middle.setPreferredSize(new Dimension(200,40));

        lower = new JPanel();
        lower.setLayout(layoutLower);
        lower.setBorder(middleBorder);

        text = new JPanel();
        text.setBorder(middleBorder);

        middlePanel = new JPanel();
        middlePanel.setLayout(LayoutMiddlePanel);

        textAreaInput = new JTextArea(20,40);
        jScrollPane1 = new JScrollPane(textAreaInput);
        textAreaInput.setText("Beskrivning");

        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();
        fieldTitle = new JTextField();
        btnMakeGuide = new JButton();
        btnAddPicture = new JButton();
        lblMakeGuide = new JLabel();
        btnCancel = new JButton();



        //jScrollPane1.setViewportView(textAreaInput);

        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Mjukvara", "Hårdvara", "Snabbguide"}));

        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Internet", "Dator", "Mobil", "Övrigt"}));

        fieldTitle.setText("Titel");

        btnMakeGuide.setText("Skapa guide");

        btnAddPicture.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        btnAddPicture.setText("Lägg till bild");
        btnAddPicture.setSize(new Dimension(10,10));

        lblMakeGuide.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblMakeGuide.setText("Skapa ny guide");

        btnCancel.setText("Avbryt");



        // SwingUtilities.getRootPane(btnMakeGuide).setDefaultButton(btnMakeGuide);

        top.add(lblMakeGuide);
        combo.add(fieldTitle);

        middle.add(typeComboBox);
        middle.add(categoryComboBox);
        middle.add(btnAddPicture);

        //text.add(textAreaInput);
        text.add(jScrollPane1);
        lower.add(btnCancel);
        lower.add(btnMakeGuide);

        middlePanel.add(top, BorderLayout.NORTH);
        middlePanel.add(combo, BorderLayout.CENTER);
        middlePanel.add(middle, BorderLayout.SOUTH);
        //middlePanel.add(text, BorderLayout.SOUTH);

        add(text, BorderLayout.CENTER);
        //add(top, BorderLayout.NORTH);

        //add(middle, BorderLayout.CENTER);

        //add(text, BorderLayout.CENTER);

        add(middlePanel, BorderLayout.NORTH);

        add(lower, BorderLayout.SOUTH);

        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
        pack();
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

    public String getTypeString(){
        return typeComboBox.getSelectedItem().toString();
    }

    public String getCategoryString(){
        return categoryComboBox.getSelectedItem().toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            controller.btnCancelGuide();
        } else if (e.getSource() == btnMakeGuide) {
            controller.btnCreateGuide(selectedFile);
            dispose();
        } else if (e.getSource() == btnAddPicture) {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Bilder", "jpg", "png"));
            fileChooser.showOpenDialog(null);
            if (JFileChooser.APPROVE_OPTION == 0) {
                selectedFile = fileChooser.getSelectedFile().getPath();
                controller.addPicturesToDb(selectedFile);
                System.out.println(selectedFile);
            }
        }

    }
}
