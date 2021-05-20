package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Philip Persson
 * @author Alexander Olsson
 * @author
 * @version 1.0
 */

public class PictureGUI extends JFrame implements ActionListener {

    private final JPanel centerPanel;
    private final JPanel southPanel;



    private JLabel lblPicture;
    private final JButton btnNext;
    private final JButton btnBack;
    private final Controller controller;
    private int width = 500;
    private int height = 400;

    public PictureGUI(Controller controller) {
        this.controller = controller;

        setTitle("SupportME");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        southPanel = new JPanel(new FlowLayout());

        lblPicture = new JLabel("",SwingConstants.CENTER);

        lblPicture.setPreferredSize(new Dimension(500,400));
        lblPicture.setIcon(controller.getPicture());



        btnBack = new JButton("Föregående bild");
        btnNext = new JButton("Nästa bild");

        centerPanel.add(lblPicture);

        Border b2 = BorderFactory.createTitledBorder("Visa bilder");

        centerPanel.setBorder(b2);

        southPanel.add(btnBack);
        southPanel.add(btnNext);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setSize(800, 800);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        addListeners();

    }

    public void addListeners() {
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            System.out.println("1");
        } else if (e.getSource() == btnNext) {
            System.out.println("2");
        }
    }


    public void showPic(ImageIcon picture) {
        int original_width = picture.getIconWidth();
        int original_height = picture.getIconHeight();
        int bound_width = 500;
        int bound_height = 400;
        int new_width = original_width;
        int new_height = original_height;

        if (original_width > bound_width) {
            new_width = bound_width;
            new_height = (new_width * original_height) / original_width;
        }

        if (new_height > bound_height) {
            new_height = bound_height;
            new_width = (new_height * original_width) / original_height;
        }

        Image image = picture.getImage();
        Image newimg = image.getScaledInstance(new_width,new_height, Image.SCALE_SMOOTH);
        ImageIcon a = new ImageIcon(newimg);
        lblPicture.setIcon(a);
    }
}
