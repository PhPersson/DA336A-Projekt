package controller;

import model.*;
import view.*;

import java.sql.SQLException;
import java.util.ArrayList;


public class Controller {
    private User user;
    private Guide guide;
    private UserHomepageFrame userHomePageFrame;
    private MainFrame view;
    private DbCon con;
    private GuiUtilities util;
    private AdminFrame adminFrame;
    private HomePageFrame homePageFrame;
    private MakeGuideGui makeGuideGui;
    private UserSettings userSettings;
    private EditGuideGUI editGuideGUI;

    /**
     *
     */
    public Controller() {
        view = new MainFrame(this);
        con = new DbCon(this);
        util = new GuiUtilities();
        user = new User();
        guide = new Guide();

    }

    // Kanske skapa ett helt User objekt istället?

    /**
     * Registrera en ny användare.
     * Första IF-satsen: Hämtar alla användarnamn i databasen och tittar om det nya användarnamnet är unikt.
     * Andra IF-satsen kontrollerar om emailadressen är en giltig email. Kollar t.ex. om "@" finns med.
     * Om det är valid så läggs den nya användare in i databasen med parapetrar: Username, Email, Password.
     */
    public void btnRegisterClicked() {

        if (con.getAllUsernames(view.getTxtUsername())) {
            util.showDialog("TAKEN!!!!!");
        } else {
            if (Email.isValidEmailAddress(view.getTxtEmail())) {
                Email.sendMail(view.getTxtEmail(), view.getTxtUsername());
                con.registerNewCustomer(new User(view.getTxtUsername(), view.getTxtEmail(), view.getTxtUsername(), 0));

                util.showDialog("Registration OK \nYou can now log in");
                view.getRegisterFrame().setVisible(false);
            } else {
                util.showErrorDialog("The email is not valid");
            }
        }
    }

    /**
     * Kollar om inloggning lyckas.
     * Första IF-satsen: Hämtar alla användare och lösenord rad för rad i databasen. Tittar om det finns match med användarnamn och lösenord. Annars: felmedelande om att användarnamn eller lösenord är fel.
     * Andra IF-satsen: Om användaren inte har en roll satt i databasen så körs userHomePageFrame. Annars: Användaren har en roll, vilket betyder att det är en admin. adminFrame körs.
     */
    public void btnLoginClicked() {

        if (con.getAllUserAndPass(view.getLoginUsername(), view.getLoginPassword())) {
            if (!con.getRole(view.getLoginUsername(), view.getLoginPassword())) {
                user.setUsername(view.getLoginUsername());
                //user.setEmail();
                view.getLoginFrame().setVisible(false);
                userHomePageFrame = new UserHomepageFrame(this);
                System.out.println(user.getUsername());
                userHomePageFrame.setLblloginUser(user.getUsername());
                userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
                userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
            } else {
                view.getLoginFrame().setVisible(false);
                adminFrame = new AdminFrame(this);
                adminFrame.updateUserList(con.getUsersAndEmail());
                adminFrame.updateGuideList(con.getAllGuides());
                adminFrame.setLblLoginAdmin(view.getLoginUsername());
            }
        } else {
            util.showErrorDialog("Fel användarnamn eller lösenord!");
        }

    }

    /**
     * Användare väljer att starta programmet utan att logga in. homePageFrame körs.
     */
    public void btnNoLoginClicked() {
        view.getLoginFrame().setVisible(false);
        homePageFrame = new HomePageFrame(this);
        homePageFrame.updateSearchGuideList(con.getAllGuides());
    }

    /**
     * AdminFrame stängs ner och en ny LoginFrame körs.
     */
    public void btnLoggOffAdmin() {
        adminFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     * Admin tar bort en användare i databasen.
     *
     * @param username Användarnamn för raden man vill ta bort.
     */
    public void btnAdminDeleteUser(String username) {
        if (con.checkIfUserHaveGuides(username)) {
            if (util.showConfirmationDialog("Användaren har fortfarande aktiva guider! \nVill du ta bort alla guider också?") == 1) {
                con.deleteGuideBasedOnUsername(username);
                con.deleteAUser(username);
            }
        }
        else {
            con.deleteGuideBasedOnUsername(username);
            con.deleteAUser(username);
        }
        adminFrame.updateUserList(con.getUsersAndEmail());
        adminFrame.updateGuideList(con.getAllGuides());
    }

    /**
     * Admin söker efter användare.
     *
     * @param soktext input av sträng man vill söka med.
     */
    public void btnAdminSearchUser(String soktext) {
        adminFrame.updateUserList(con.searchUser(soktext));
    }

    /**
     * Admin söker efter guider.
     *
     * @param soktext input av sträng man vill söka med.
     */
    public void btnAdminSearchGuide(String soktext) {
        adminFrame.updateGuideList(con.searchGuide(soktext));
    }

    /**
     * Admin tar bort guide i databasen.
     *
     * @param indexToRemove input av sträng som är Guide_ID i databasen.
     */
    public void btnAdminDeleteGuide(String indexToRemove) {
        con.deleteGuideAdmin(indexToRemove);
        adminFrame.updateGuideList(con.getAllGuides());
    }

    /**
     * @param text
     */
    public void btnSearchGuideNotLoggedInPressed(String text) {
        con.searchGuide(text);
    }

    /**
     * Visa guide för användare som inte loggat in.
     *
     * @param indexGuide
     */
    public void btnShowGuide(String indexGuide, String titleString, String dateString, String authorString) {

    }

    /**
     * Användare loggar in från homePageFrame
     */
    public void btnHomePageFrameLogin() {
        homePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     * Användare loggar ut, Ny loginFrame öppnas
     */
    public void btnUserLoggOff() {
        userHomePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
    }

    /**
     * @param soktext
     */
    public void btnUserSearchGuide(String soktext) {
        userHomePageFrame.updateUserSearchGuideList(con.searchGuide(soktext));
    }

    /**
     * @param soktext
     */
    public void btnNoLoginSearchGuide(String soktext) {
        homePageFrame.updateSearchGuideList(con.searchGuide(soktext));
    }

    /**
     * @return
     */
    public ArrayList<String> getUsersFromDb() {
        return con.getAllUsers();
    }

    /**
     *
     */
    public void btnOpenCreateGuideFrame() {
        makeGuideGui = new MakeGuideGui(this);
        makeGuideGui.setVisible(true);
    }

    /**
     *
     */
    public void btnAvbrytGuide() {
        makeGuideGui.setVisible(false);
        System.out.println(user.getUsername());
    }

    /**
     *
     */

    public void btnCreateGuide() {
        con.createGuide(guide = new Guide(makeGuideGui.getTitelGuide(), makeGuideGui.getDescriptionField(), user.getUsername()));
        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
    }

    /**
     * @return
     */
    public GuiUtilities getUtil() {
        return util;
    }


    public void btnUserSettings() {
        userSettings = new UserSettings(this);
        userSettings.setVisible(true);
        userSettings.setLblUsername(user.getUsername());
        userSettings.setlblEmail(con.getUserEmail(user.getUsername()));
    }

    public void changePasswordUser() {
        con.updateUserPassword(userSettings.getPassField1(), user.getUsername());
    }

    public void changeEmailUser() {
        con.updateUserEmail(userSettings.getEmailField(), user.getUsername());
        userSettings.setlblEmail(con.getUserEmail(user.getUsername()));
    }

    public void btnSaveGuidesHP() throws SQLException {
        if (adminFrame.isVisible()) {
            int row = adminFrame.getGuideTable().getSelectedRow();
            con.updateGuide(editGuideGUI.getTitleEdit(), editGuideGUI.getDescription(),
                    adminFrame.getGuideTable().getModel().getValueAt(row, 1).toString());
            adminFrame.updateGuideList(con.getAllGuides());
        }
        else {
            System.out.println("2");
            int row = userHomePageFrame.getTableLow().getSelectedRow();
            con.updateGuide(editGuideGUI.getTitleEdit(), editGuideGUI.getDescription(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 0).toString());

            userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
            userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        }

//        int row = guideTable.getSelectedRow();
//        String indexGuide = guideTable.getModel().getValueAt(row, column).toString();
    }
//    public void btnSaveGuidesAdmin() throws SQLException {
//        int row = adminFrame.getGuideTable().getSelectedRow();
//        System.out.println(adminFrame.getGuideTable().getModel().getValueAt(row, 0).toString());
//        con.updateGuide(editGuideGUI.getTitleEdit(), editGuideGUI.getDescription(),
//                adminFrame.getGuideTable().getModel().getValueAt(row, 0).toString());
//        userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
//        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
//    }

    public void editGuide() {
        int row = userHomePageFrame.getTableLow().getSelectedRow();

        String titleString = userHomePageFrame.getTableLow().getModel().getValueAt(row, 0).toString();
        String authorString = userHomePageFrame.getTableLow().getModel().getValueAt(row, 1).toString();
        String dateString = userHomePageFrame.getTableLow().getModel().getValueAt(row, 2).toString();
        String descriptionString = userHomePageFrame.getTableLow().getModel().getValueAt(row, 4).toString();

        editGuideGUI = new EditGuideGUI(this, titleString, authorString, dateString, descriptionString);
    }

    public void editGuideAdmin() {
        int row = adminFrame.getGuideTable().getSelectedRow();

        String titleString = adminFrame.getGuideTable().getModel().getValueAt(row, 1).toString();
        String authorString = adminFrame.getGuideTable().getModel().getValueAt(row, 2).toString();
        String dateString = adminFrame.getGuideTable().getModel().getValueAt(row, 3).toString();
        String descriptionString = adminFrame.getGuideTable().getModel().getValueAt(row, 5).toString();

        editGuideGUI = new EditGuideGUI(this, titleString, authorString, dateString, descriptionString);
    }

    public void btnDeleteGuide(String titleToRemove) {
        con.deleteGuide(titleToRemove);
        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());

    }
}
