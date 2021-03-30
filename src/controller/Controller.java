package controller;

import model.*;
import view.*;

import java.util.ArrayList;


public class Controller {
    private User user;
    private UserManager userManager;
    private UserHomepageFrame userHomePageFrame;
    private MainFrame view;
    private DbCon con;
    private GuiUtilities util;
    private AdminFrame adminFrame;

    private HomePageFrame homePageFrame;
    private MakeGuideGui SkapaGuideGui;


    /**
     * 
     */

    public Controller() {

        view = new MainFrame(this);
        con = new DbCon(this);
        util = new GuiUtilities();
        user = new User();
    }

    // Kanske skapa ett helt User objekt istället?

    /**
     *
     */

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

    /**
     *
     */

    public void btnLoginClicked() {

        if (con.getAllUserAndPass(view.getLoginUsername(), view.getLoginPassword())) {
            if (!con.getRole(view.getLoginUsername(), view.getLoginPassword())) {
                user.setUsername(view.getLoginUsername());
                System.out.println(user.getUsername());

                view.getLoginFrame().setVisible(false);
                userHomePageFrame =new UserHomepageFrame(this);
                userHomePageFrame.setLblloginUser(user.getUsername());
                userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
                userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
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

    /**
     *
     */

    public void btnNoLoginClicked() {
        view.getLoginFrame().setVisible(false);
        homePageFrame = new HomePageFrame(this);
        homePageFrame.updateSearchGuideList(con.getAllGuidesUserSearch());
    }

    /**
     *
     */

    public void btnLoggOffAdmin() {
        adminFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     *
     * @param username
     */

    public void btnAdminDeleteUser(String username) {
        con.deleteAUser(username);
        adminFrame.updateUserList(con.getUsersAndEmail());
    }

    /**
     *
     * @param soktext
     */

    public void btnAdminSearchUser(String soktext) {
        adminFrame.updateUserList(con.searchUser(soktext));
    }

    /**
     *
     * @param soktext
     */

    public void btnAdminSearchGuide(String soktext) {
        adminFrame.updateGuideList(con.searchGuide(soktext));
    }

    /**
     *
     * @param indexToRemove
     */

    public void btnAdminDeleteGuide(String indexToRemove) {
        con.deleteGuideAdmin(indexToRemove);
        adminFrame.updateGuideList(con.getAllGuides());
    }

    /**
     *
     * @param text
     */

    public void btntSearchGuideNotLoggedInPressed(String text) {
        con.searchGuide(text);
    }

    /**
     *
     * @param indexGuide
     */

    public void btnShowGuideNotLoggedInPressed(String indexGuide) {

    }

    /**
     *
     */

    public void btnNoLoginTryLogin() {
        homePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     *
     */

    public void btnUserLoggOff(){
        userHomePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     *
     * @param soktext
     */

    public void btnUserSearchGuide(String soktext) {
        userHomePageFrame.updateUserSearchGuideList(con.searchGuide(soktext));
    }

    /**
     *
     * @param soktext
     */

    public void btnNoLoginSearchGuide(String soktext) {
        homePageFrame.updateSearchGuideList(con.searchGuide(soktext));
    }

    /**
     *
     * @return
     */

    public ArrayList <String> getUsersFromDb(){
        return con.getAllUsers();
    }

    /**
     *
     */

    public void btnCreateGuide(){
        SkapaGuideGui = new MakeGuideGui(this);
        SkapaGuideGui.setVisible(true);
    }

    /**
     *
     */

    public void btnAvbrtyGuide(){
        SkapaGuideGui.setVisible(false);
        System.out.println(user.getUsername());
    }

    /**
     *
     */

    public void btnSkapaGuide(){
        con.createGuide(SkapaGuideGui.getTitelGuide(),SkapaGuideGui.getDescriptionField(), user.getUsername(),"files/Gubbe.jpg");
        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        // con.createGuide("asda","asdasd", null);
    }

    /**
     *
     * @return
     */

    public GuiUtilities getUtil() {
        return util;
    }
}
