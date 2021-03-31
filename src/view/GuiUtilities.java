package view;

import javax.swing.*;

public class GuiUtilities {


    public void showDialog(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    public void showErrorDialog(String message) {JOptionPane.showMessageDialog(null,message,"ERROR",JOptionPane.ERROR_MESSAGE);}

    public int showConfirmationDialog(String message) {
        int reply = JOptionPane.showConfirmDialog(null,message);
        if (reply == JOptionPane.YES_OPTION) {
            reply = 1;
        }
        return reply;
    }



}
