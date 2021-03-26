package controller;

import model.*;
import view.*;
import view.HomePage.HPFrameNotLoggedIn;
import view.HomePage.HomePageFrame;
import view.LoginFrames.LoginFrame;

import java.util.ArrayList;


public class Controller {
    private User user;
    private UserManager userManager;
    private HomePageFrame homePageFrame;
    private MainFrame view;
    private dbCon con;
    private GuiUtilities util;
    private AdminFrame adminFrame;
    private HPFrameNotLoggedIn homePageFrameNotLoggedIn;


    public Controller() {

        view = new MainFrame(this);
        con = new dbCon(this);
        util = new GuiUtilities();
    }

    public void btnRegisterClicked() {

        if (con.getAllUsernames(view.getTxtUsername())) {
            util.showDialog("TAKEN!!!!!");
        } else {
            if (email.isValidEmailAddress(view.getTxtEmail())) {
                email.sendMail(view.getTxtEmail(), view.getTxtUsername());
                user = new User(view.getTxtUsername(), view.getTxtEmail(), view.getTxtPassword());
                con.registerNewCustomer(user);
                util.showDialog("Registration OK \nYou can now log in");
                view.getRegisterFrame().setVisible(false);
            } else {
                util.showErrorDialog("The email is not valid");
            }
        }
    }

    public void btnLoginClicked() {

        if (con.getAllUserAndPass(view.getLoginUsername(), view.getLoginPassword())) {
            if (!con.getRole(view.getLoginUsername(), view.getLoginPassword())) {

                view.getLoginFrame().setVisible(false);
                homePageFrame =new HomePageFrame(this);
                homePageFrame.setLblloginUser(user.getUsername());
                homePageFrame.updateUserList(con.getAllGuides());
            } else {
                view.getLoginFrame().setVisible(false);
                adminFrame = new AdminFrame(this);
                adminFrame.updateUserList(con.getUsersAndEmail());
                adminFrame.updateGuideList(con.getAllGuides());
                adminFrame.setLblloginAdmin(view.getLoginUsername());
            }
        } else {
            util.showErrorDialog("Wrong username or password");
        }


    }

    public void btnNoLoginClicked() {
        view.getLoginFrame().setVisible(false);
        homePageFrameNotLoggedIn = new HPFrameNotLoggedIn(this);
    }

    public void btnLoggOffAdmin() {
        adminFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    public void btnAdminDeleteUser(String username) {
        con.deleteAUser(username);
        adminFrame.updateUserList(con.getUsersAndEmail());
    }

    public void btnAdminSearchUser(String soktext) {
        adminFrame.updateUserList(con.searchUser(soktext));
    }

    public void btnAdminSearchGuide(String soktext) {
        adminFrame.updateGuideList(con.searchGuide(soktext));
    }

    public void btnAdminDeleteGuide(String indexToRemove) {
        con.deleteGuideAdmin(indexToRemove);
        adminFrame.updateGuideList(con.getAllGuides());
    }

    public void btntSearchGuideNotLoggedInPressed(String text) {
        con.searchGuide(text);
    }

    public void btnShowGuideNotLoggedInPressed(String indexGuide) {

    }

    public void btnNoLoginTryLogin() {
        homePageFrameNotLoggedIn.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    public ArrayList<String> getUsersFromDb() {
        return con.getAllUsers();
    }

    public GuiUtilities getUtil() {
        return util;
    }

    public void btnMakeGuidePressed() {
    }

    public void btnChoosePicturePressed() {
    }
}
