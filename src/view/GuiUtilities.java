package view;

import javax.swing.*;
import java.util.Locale;

/**
 * @author Philip Persson
 * @author
 * @author
 * @version 1.0
 */

public class GuiUtilities { // TODO KOMMENTERA KLASSEN

    public void showDialog(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    public void showErrorDialog(String message) {JOptionPane.showMessageDialog(null,message,"VARNING",JOptionPane.ERROR_MESSAGE);}

    public int showConfirmationDialog(String message) {
        int reply = JOptionPane.showConfirmDialog(null,message);
        if (reply == JOptionPane.YES_OPTION) {
            reply = 1;
        }
        else if (reply == JOptionPane.NO_OPTION) {
            reply = 0;
        }
        return reply;
    }


}
