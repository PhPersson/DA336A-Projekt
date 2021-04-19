package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureGUI extends JFrame implements ActionListener {

    private JPanel centerPanel, southPanel;
    private JLabel lblPicture;
    private JButton btnNext, btnBack;

    public PictureGUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        southPanel = new JPanel(new FlowLayout());

        //lblPicture.setIcon();

        lblPicture = new JLabel();
        lblPicture.setPreferredSize(new Dimension(500,400));
        lblPicture.setText("Bild");

        btnBack = new JButton("Föregående bild");
        btnNext = new JButton("Nästa bild");

        centerPanel.add(lblPicture);

        Border b2 = BorderFactory.createTitledBorder("Visa bilder");

        centerPanel.setBorder(b2);

        southPanel.add(btnBack);
        southPanel.add(btnNext);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setSize(800,800);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();
    }

    public void addListeners(){
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack){
            System.out.println("1");
        } else if (e.getSource() == btnNext){
            System.out.println("2");
        }
    }
}
