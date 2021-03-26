package view;

import controller.Controller;
import view.HomePage.HPFrameNotLoggedIn;
import view.HomePage.HomePageFrame;
import view.LoginFrames.LoginFrame;
import view.LoginFrames.RegisterFrame;

import javax.swing.*;

public class MainFrame extends JFrame {
    private int width = 1000;
    private int height = 600;
    private int margin = 5;

    private LoginFrame loginFrame;
    private HomePageFrame hpf;
    private HPFrameNotLoggedIn hpFrameNotLoggedIn;

    private Controller controller;
    private GuiUtilities util;

    public MainFrame(Controller controller) {
        this.controller = controller;
        util = new GuiUtilities();
        loginFrame = new LoginFrame(controller);
    }

    public void setupPanel(int userStatus) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getTxtUsername() {
        return loginFrame.getRegisterFrame().getTxtUsername();
    }

    public String getTxtEmail() {
        return loginFrame.getRegisterFrame().getTxtEmail();
    }

    public String gettxtPassword() {
        return loginFrame.getRegisterFrame().getTxtPassword();
    }


    public String getTxtPassword() {
        return loginFrame.getRegisterFrame().getTxtConPassword();
    }

    public String getLoginUsername() {
        return loginFrame.getLoginUsername();
    }

    public String getLoginPassword() {
        return loginFrame.getLoginPassword();
    }

    public void setOptionPane(String message) {
        util.showDialog(message);
    }

    public LoginFrame getLoginFrame() {return loginFrame;}

    public RegisterFrame getRegisterFrame() {return loginFrame.getRegisterFrame();}

    public HomePageFrame getHomepageFrame(){
        return getHomepageFrame();
    }

    //public HPFrameNotLoggedIn getHPFrameNotLoggedIn(){ return HPFrameNotLoggedIn.getHPFrameNotLoggedIn();}


}