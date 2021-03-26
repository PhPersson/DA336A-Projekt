package controller;

import model.*;
import view.*;

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
    private SkapaGuideGui SkapaGuideGui;


    public Controller() {

        view = new MainFrame(this);
        con = new dbCon(this);
        util = new GuiUtilities();
        user = new User();
    }

    // Kanske skapa ett helt User objekt istället?
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
                user.setUsername(view.getLoginUsername());
                System.out.println(user.getUsername());

                view.getLoginFrame().setVisible(false);
                homePageFrame =new HomePageFrame(this);
                homePageFrame.setLblloginUser(user.getUsername());
                homePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
                homePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
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
        homePageFrameNotLoggedIn.updateSearchGuideList(con.getAllGuidesUserSearch());
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

    public void btnUserLoggOff(){
        homePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }
    public void btnUserSearchGuide(String soktext) {
        homePageFrame.updateUserSearchGuideList(con.searchGuide(soktext));
    }

    public void btnNoLoginSearchGuide(String soktext) {
        homePageFrameNotLoggedIn.updateSearchGuideList(con.searchGuide(soktext));
    }
    public ArrayList <String> getUsersFromDb(){
        return con.getAllUsers();
    }

    public void btnCreateGuide(){
        SkapaGuideGui = new SkapaGuideGui(this);
        SkapaGuideGui.setVisible(true);
    }
    public void btnAvbrtyGuide(){
        SkapaGuideGui.setVisible(false);
        System.out.println(user.getUsername());
    }

    public void btnSkapaGuide(){
        con.createGuide(SkapaGuideGui.getTitelGuide(),SkapaGuideGui.getDescriptionField(), user.getUsername(),"files/Gubbe.jpg");
        homePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        // con.createGuide("asda","asdasd", null);
    }

    public GuiUtilities getUtil() {
        return util;
    }
}
