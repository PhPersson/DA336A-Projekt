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

    private JButton AvbrytButton;
    private JButton BildButton;
    private JTextArea InputTextArea;
    private JComboBox<String> KategoriComboBox;
    private JButton SkapaGuideButton;
    private JLabel SkapaguideLabel;
    private JTextField TitelField;
    private JComboBox<String> TypComboBox;
    private JInternalFrame jInternalFrame1;
    private JInternalFrame jInternalFrame2;
    private JScrollPane jScrollPane1;
    private MakeGuideGui skapaGuideGui;


    public MakeGuideGui(Controller controller) {
        this.controller = controller;
        initComponents();
    }


    private void initComponents() {

        jInternalFrame1 = new JInternalFrame();
        jInternalFrame2 = new JInternalFrame();
        jScrollPane1 = new JScrollPane();
        InputTextArea = new JTextArea();
        TypComboBox = new JComboBox<>();
        KategoriComboBox = new JComboBox<>();
        TitelField = new JTextField();
        SkapaGuideButton = new JButton();
        BildButton = new JButton();
        SkapaguideLabel = new JLabel();
        AvbrytButton = new JButton();

        jInternalFrame1.setVisible(true);

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

        InputTextArea.setColumns(20);
        InputTextArea.setRows(5);
        InputTextArea.setText("Beskrivning.");
        jScrollPane1.setViewportView(InputTextArea);

        TypComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Hardware guide", "Software guide"}));


        KategoriComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        TitelField.setText("Titel");


        SkapaGuideButton.setText("Skapa Guide");


        BildButton.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        BildButton.setText("Lägg till Bild");


        SkapaguideLabel.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        SkapaguideLabel.setText("Skapa ny Guide");

        AvbrytButton.setText("Avbryt");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(AvbrytButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(SkapaGuideButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(TitelField, GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypComboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(KategoriComboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                                        .addComponent(BildButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING))
                                        .addComponent(SkapaguideLabel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(SkapaguideLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TitelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TypComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KategoriComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BildButton, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(SkapaGuideButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AvbrytButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );

        setVisible(true);
        pack();
        addListeners();


    }

    public void addListeners() {
        AvbrytButton.addActionListener(this);
        SkapaGuideButton.addActionListener(this);
    }

    //public void getUserGuide(String titel, String description, )

    public String getTitelGuide() {
        return TitelField.getText();
    }
    public String getDescriptionField() {
        return InputTextArea.getText();
    }


    public void setSkapaguideLabel() {
        SkapaguideLabel.setText("Skapa Guide");
    }
    public void setRedigeraGuideLabel(){
        SkapaguideLabel.setText("Redigera din guide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AvbrytButton) {
            controller.btnAvbrtyGuide();
        } else if (e.getSource() == SkapaGuideButton) {
            controller.btnSkapaGuide();
            System.out.println("hej");
        }

    }


}
