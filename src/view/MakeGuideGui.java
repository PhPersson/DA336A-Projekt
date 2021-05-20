package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    private JPanel top,middle,lower, text, middlePanel, lbl;

    private JButton btnCancel,btnMakeGuide,btnAddPicture;
    private JTextArea textAreaInput;
    private JComboBox<String> categoryComboBox;
    private JLabel lblMakeGuide, lblType, lblCategory, lblPicture;
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

        GridLayout layoutTop = new GridLayout(2,1,20,10);
        GridLayout layoutMiddleLbl = new GridLayout(1,3,20,0);

        GridLayout layoutMiddle = new GridLayout(2,3,20,0);
        GridLayout layoutLower = new GridLayout(1,2,150,0);
        GridLayout LayoutMiddlePanel = new GridLayout(2,1,0,0);


        Border topBorder = BorderFactory.createEmptyBorder(10, 60, 10, 60);
        Border middleBorder = BorderFactory.createEmptyBorder(10, 60, 10, 60);


        top = new JPanel();
        top.setLayout(layoutTop);
        top.setBorder(topBorder);

        lbl = new JPanel();
        lbl.setLayout(layoutMiddleLbl);
        lbl.setBorder(topBorder);

        middle = new JPanel();
        middle.setLayout(layoutMiddle);
        middle.setBorder(middleBorder);

        lower = new JPanel();
        lower.setLayout(layoutLower);
        lower.setBorder(middleBorder);

        text = new JPanel();
        text.setBorder(middleBorder);

        middlePanel = new JPanel();
        middlePanel.setLayout(LayoutMiddlePanel);

        textAreaInput = new JTextArea(20,40);
        jScrollPane1 = new JScrollPane(textAreaInput);
        textAreaInput.setText("Lägg till titel på din guide här...");
        textAreaInput.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textAreaInput.setText("");
            }
        });

        typeComboBox = new JComboBox<>();
        categoryComboBox = new JComboBox<>();
        fieldTitle = new JTextField();
        btnMakeGuide = new JButton();
        btnAddPicture = new JButton();
        lblMakeGuide = new JLabel();
        lblCategory = new JLabel();
        lblType = new JLabel();
        lblPicture = new JLabel();
        btnCancel = new JButton();


        typeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Mjukvara", "Hårdvara", "Snabbguide"}));

        categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "Internet", "Dator", "Mobil", "Övrigt"}));

        fieldTitle.setText("Lägg till beskrivning på din guide här...");
        fieldTitle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                fieldTitle.setText("");
            }
        });

        btnMakeGuide.setText("Skapa guide");

        btnAddPicture.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        btnAddPicture.setText("Lägg till bild");
        btnAddPicture.setSize(new Dimension(10,10));

        lblMakeGuide.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblMakeGuide.setText("Skapa ny guide");

        lblType.setFont(new Font("Tahoma", 1, 11));
        lblType.setText("Typ av guide");

        lblCategory.setFont(new Font("Tahoma", 1, 11));
        lblCategory.setText("Kategori av guide");

        lblPicture.setFont(new Font("Tahoma", 1, 11));
        lblPicture.setText("Bifoga bilder i guide");

        btnCancel.setText("Stäng");




        top.add(lblMakeGuide, BorderLayout.NORTH);
        top.add(fieldTitle, BorderLayout.SOUTH);


        middle.add(lblType);
        middle.add(lblCategory);
        middle.add(lblPicture);
        middle.add(typeComboBox);
        middle.add(categoryComboBox);
        middle.add(btnAddPicture);



        text.add(jScrollPane1);
        lower.add(btnCancel);
        lower.add(btnMakeGuide);

        middlePanel.add(top, BorderLayout.NORTH);

        middlePanel.add(middle, BorderLayout.SOUTH);

        add(text, BorderLayout.CENTER);

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
