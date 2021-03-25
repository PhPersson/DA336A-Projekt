package controller;

import model.*;
import view.*;



public class Controller {
    private User user;
    private UserManager userManager;
    private HomePageFrame homePageFrame;
    private MainFrame view;
    private dbCon con;
    private GuiUtilities util;
    private AdminFrame adminFrame;

    //test test

    public Controller() {

        view = new MainFrame(this);
        con = new dbCon();
        util = new GuiUtilities();
    }

    public void btnRegisterClicked() {

        if (con.getAllUsernames(view.getTxtUsername())) {
            util.showDialog("TAKEN!!!!!");
        } else {
            if (email.isValidEmailAddress(view.getTxtEmail())) {
                email.sendMail(view.getTxtEmail(), view.getTxtUsername());
                con.registerNewCustomer(view.getTxtUsername(), view.getTxtEmail(), view.getTxtPassword());
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
                new HomePageFrame(this);
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
        new HPFrameNotLoggedIn(this);
    }

    public void btnLoggOffAdmin() {
        adminFrame.setVisible(false);
        new LoginFrame(this);
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
}
