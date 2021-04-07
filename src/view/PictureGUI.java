package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureGUI extends JFrame implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JPanel centerPanel, southPanel;
    private JLabel lblPicture;

    private JButton btnNext, btnBack;

    public PictureGUI() {

        frame = new JFrame();
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS));
        frame.setLayout(new BorderLayout());

        centerPanel = new JPanel();
        southPanel = new JPanel(new FlowLayout());

       // lblPicture.setIcon();

        lblPicture = new JLabel();
        lblPicture.setPreferredSize(new Dimension(500,400));
        lblPicture.setText("sadasdasd");

        btnBack = new JButton("back");
        btnNext = new JButton("next");

        centerPanel.add(lblPicture);
        Border b2 = BorderFactory.createTitledBorder("Feta brudar och feta mopeder");

        centerPanel.setBorder(b2);


        southPanel.add(btnBack);
        southPanel.add(btnNext);


        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);


        frame.setSize(800,800);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        addListners();
    }

    public void addListners(){
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack){
            System.out.println("bajs");
        } else if (e.getSource() == btnNext){
            System.out.println("Kiss");
        }

    }
}
