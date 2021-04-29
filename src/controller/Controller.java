package controller;

import model.*;
import view.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Philip Persson
 * @author Simon Pizevski
 * @author Måns Olsson
 * @author Alexander Olsson
 */

public class Controller { // TODO KOMMENTERA HELA DENNA KLASSEN OCKSÅ
    private User user;
    private Guide guide;
    private UserHomepageFrame userHomePageFrame;
    private MainFrame view;
    private DbCon con;
    private GuiUtilities util;
    private AdminFrame adminFrame;
    private HomePageFrame homePageFrame;
    private MakeGuideGui makeGuideGUI;
    private UserSettings userSettings;
    private EditGuideGUI editGuideGUI;
    private PictureGUI pictureGUI;
    private ShowGuideGUI showGuideGUI;
    private int guidenum;

    /**
     *
     */
    public Controller() {
        view = new MainFrame(this);
        util = new GuiUtilities();
        con = new DbCon(this);
        user = new User();
        guide = new Guide();
    }

    /**
     * Registrera en ny användare.
     * Första IF-satsen: Hämtar alla användarnamn i databasen och tittar om det nya användarnamnet är unikt.
     * Andra IF-satsen kontrollerar om emailadressen är en giltig email. Kollar t.ex. om "@" finns med.
     * Om det är valid så läggs den nya användare in i databasen med parapetrar: Username, Email, Password.
     */
    public void btnRegisterClicked() {
        if (con.getAllUsernames(view.getTxtUsername())) {
            util.showDialog("Detta användarnam finns redan, vänligen ange ett nytt");
        } else {
            if (Email.isValidEmailAddress(view.getTxtEmail())) {
                Email.sendMail(view.getTxtEmail(), view.getTxtUsername());
                con.registerNewCustomer(new User(view.getTxtUsername().substring(0, 1).toUpperCase() + view.getTxtUsername().substring(1), view.getTxtEmail(), Hash.hashPass(view.gettxtPassword()), 0));

                util.showDialog("Registreringen OK \nDu kan nu återgå och logga in");
                view.getRegisterFrame().setVisible(false);
            } else {
                util.showErrorDialog("Det är ingen gilltig e-postadress! \nAnge en gilltig e-postadress och försök igen!");
            }
        }
    }

    /**
     * Kollar om inloggning lyckas.
     * Första IF-satsen: Hämtar alla användare och lösenord rad för rad i databasen. Tittar om det finns match med användarnamn och lösenord. Annars: felmedelande om att användarnamn eller lösenord är fel.
     * Andra IF-satsen: Om användaren inte har en roll satt i databasen så körs userHomePageFrame. Annars: Användaren har en roll, vilket betyder att det är en admin. adminFrame körs.
     */
    public void btnLoginClicked() {
        try {
            if (con.getUserAndPass(view.getLoginUsername(), view.getLoginPassword())) {
                if (!con.getRole(view.getLoginUsername())) {
                    user.setUsername(view.getLoginUsername());
                    view.getLoginFrame().dispose();
                    userHomePageFrame = new UserHomepageFrame(this);
                    userHomePageFrame.setLblLoginUser(user.getUsername());
                    userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
                    userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
                } else {
                    view.getLoginFrame().dispose();
                    adminFrame = new AdminFrame(this);
                    adminFrame.updateUserList(con.getUsersAndEmail());
                    adminFrame.updateGuideList(con.getAllGuides());
                    adminFrame.setLblLoginAdmin(view.getLoginUsername());
                }
            } else {
                util.showErrorDialog("Fel användarnamn eller lösenord!");
            }
        } catch (NullPointerException exception) {
            util.showErrorDialog("Verkar om du inte har någon internetanslutning. \nKvarstår problemet kontakta systemadministratören!");
            exception.printStackTrace();
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
        try {
            editGuideGUI.getFrame().dispose();
        } catch (NullPointerException e) {
        }
    }

    /**
     * Admin tar bort en användare i databasen.
     * @param username Användarnamn för raden man vill ta bort.
     * If-satsen: Kollar om användaren har aktiva guider, då kan man välja att ta bort guiderna.
     * Annars: Behåller guiderna kopplade till den användaren.
     */
    public void btnAdminDeleteUser(String username) {
        if (con.checkIfUserHaveGuides(username)) {
            if (util.showConfirmationDialog("Användaren har fortfarande aktiva guider! \nVill du ta bort alla guider också?") == 1) {
                con.deleteGuideBasedOnUsername(username);
                con.deleteAUser(username);
            }
        } else {
            con.deleteGuideBasedOnUsername(username);
            con.deleteAUser(username);
        }
        adminFrame.updateUserList(con.getUsersAndEmail());
        adminFrame.updateGuideList(con.getAllGuides());
    }

    /**
     * Admin söker efter användare.
     *
     * @param searchText input av sträng man vill söka med.
     */
    public void btnAdminSearchUser(String searchText) {
        adminFrame.updateUserList(con.searchUser(searchText));
    }

    /**
     * Admin söker efter guider.
     *
     * @param searchText input av sträng man vill söka med.
     */
    public void btnAdminSearchGuide(String searchText, String type, String category) {
        adminFrame.updateGuideList(con.searchGuideAdmin(searchText, type, category));
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
     * Användare öppnar in från homePageFrame utan att logga in med ett konto.
     */
    public void btnHomePageFrameLogin() {
        homePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
        try {
            showGuideGUI.getFrame().dispose();
        } catch (NullPointerException e) {

        }
    }

    /**
     * Inloggad användare loggar ut, ny loginFrame öppnas.
     */
    public void btnUserLoggOff() {
        userHomePageFrame.setVisible(false);
        view.getLoginFrame().setVisible(true);
        try {
            editGuideGUI.getFrame().dispose();
        } catch (NullPointerException e) {
        }
        try {
            showGuideGUI.getFrame().dispose();
        } catch (NullPointerException e) {
        }
    }

    /**
     * Inloggad användare kan söka på guider efter användarnamn och titel i sökfältet.
     * @param searchText input av sträng man vill söka med.
     */
    public void btnUserSearchGuide(String searchText) {
        userHomePageFrame.updateUserSearchGuideList(con.searchGuide(searchText));
    }

    /**
     * Ej inloggad användare kan söka på guider efter användarnamn och titel i sökfältet.
     * @param searchText input av sträng man vill söka med.
     */
    public void btnNoLoginSearchGuide(String searchText) {
        homePageFrame.updateSearchGuideList(con.searchGuide(searchText));
    }

    /**
     * @return
     */
    public ArrayList<String> getUsersFromDb() {
        return con.getAllUsers();
    }

    /**
     * Användare väljer att påbärja skapandet av en guide.
     */
    public void btnOpenCreateGuideFrame() {
        makeGuideGUI = new MakeGuideGui(this);
        makeGuideGUI.setVisible(true);
    }

    /**
     * Användare väljer att avbryta skapandet av en guide.
     */
    public void btnCancelGuide() {
        makeGuideGUI.setVisible(false);
    }

    /**
     * Användare skapar en guide.
     */

    public void btnCreateGuide(String picture) {
        con.createGuide(guide = new Guide(makeGuideGUI.getTitleGuide(), makeGuideGUI.getDescriptionField(), user.getUsername().substring(0, 1).toUpperCase() + user.getUsername().substring(1), makeGuideGUI.getTypeString(), makeGuideGUI.getCategoryString()));
        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());

    }

    /**
     * @return referens till GuiUtilities objektet.
     */
    public GuiUtilities getUtil() {
        return util;
    }

    /**
     * Användare väljer att öppna användarinställningar.
     */
    public void btnUserSettings() {
        userSettings = new UserSettings(this);
        userSettings.setVisible(true);
        userSettings.setLblUsername(user.getUsername());
        userSettings.setlblEmail(con.getUserEmail(user.getUsername()));
    }

    /**
     * Användare ändrar lösenordet kopplat till sitt konto.
     */
    public void changePasswordUser() {
        con.updateUserPassword(userSettings.getFieldPass1(), user.getUsername());
    }

    /**
     * Användare ändrar email-konto kopplat till sitt konto.
     */
    public void changeEmailUser() {
        con.updateUserEmail(userSettings.getFieldEmail(), user.getUsername());
        userSettings.setlblEmail(con.getUserEmail(user.getUsername()));
    }

    /**
     * Användare eller Admin sparar en guide efter att ha valt att redigera en guide.
     * If-satsen avgör om AdminFrame eller UserHomePageFrame.
     */
    public void btnSaveGuide() {
        if (adminFrame != null || userHomePageFrame == null) {
            int row = adminFrame.getGuideTable().getSelectedRow();
            con.updateGuide(
                    editGuideGUI.getTitleEdit(),
                    editGuideGUI.getDescription(),
                    editGuideGUI.getTypeString(),
                    editGuideGUI.getCategoryString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row, 0).toString());

            adminFrame.updateGuideList(con.getAllGuides());
        } else {
            int row = userHomePageFrame.getTableLow().getSelectedRow();
            con.updateGuide(
                    editGuideGUI.getTitleEdit(),
                    editGuideGUI.getDescription(),
                    editGuideGUI.getTypeString(),
                    editGuideGUI.getCategoryString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 0).toString());

            userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
            userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        }
    }

    /**
     * Användare eller Admin väljer att redigera en guide. Innehållet från guiden hämtas till EditGuideGUI.
     * If-satsen avgör om AdminFrame eller UserHomePageFrame är öppen.
     */
    public void editGuide() {

        if (adminFrame != null || userHomePageFrame == null) {
            int row = adminFrame.getGuideTable().getSelectedRow();
            editGuideGUI = new EditGuideGUI(this,
                    adminFrame.getGuideTable().getModel().getValueAt(row, 1).toString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row, 2).toString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row, 3).toString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row, 5).toString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row,7).toString(),
                    adminFrame.getGuideTable().getModel().getValueAt(row,8).toString());
        } else {

            int row = userHomePageFrame.getTableLow().getSelectedRow();
            editGuideGUI = new EditGuideGUI(this,
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 1).toString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 2).toString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 3).toString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row, 5).toString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row,7).toString(),
                    userHomePageFrame.getTableLow().getModel().getValueAt(row,8).toString());
        }
    }

    /**
     * Användare väljer att kolla på bilderna som finnns kopplade till en guide.
     */
    public void pictureGUI () {
        pictureGUI = new PictureGUI(this);
        pictureGUI.setVisible(true);
    }

    /**
     * Användare väljer att ta bort en egen guide.
     */
    public void btnDeleteGuide (String titleToRemove){
        con.deleteGuide(titleToRemove);
        userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
        userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
    }

    /**
     * Inloggad Användare eller ej inloggad Användaren väljer att öppna o kolla på en guide.
     */
    public void openGuide(int guideId, String title, String author, String date, String description) {
        showGuideGUI = new ShowGuideGUI(this, title,author,date,description);
        con.addView(guideId);
        setGuideId(guideId);

        try {
            userHomePageFrame.updateUserGuideList(con.getAllGuidesUser(user.getUsername()));
            userHomePageFrame.updateUserSearchGuideList(con.getAllGuidesUserSearch());
            homePageFrame.updateSearchGuideList(con.getAllGuides());
        } catch (NullPointerException e) {
            util.showErrorDialog("Visa");
        }
    }

    public void setGuideId(int guideId) {
        this.guidenum = guideId;
    }
//    public int getGuidenum(){
//        System.out.println(guidenum);
//        return this.guidenum;
//    }

    public void addPicturesToDb(String selectedFile) {
        con.addPictureToGuide(selectedFile);
    }

//  public void addPicturesToDb(String selectedFile) {
//      con.addPictureToGuide(selectedFile)


    public void downloadGuide(){
        try {
            File file = new File("src/files");
            file.setWritable(true);
            file.setReadable(true);

            FileWriter myWriter = new FileWriter("filename.txt");

            myWriter.write("Hejsanhoppsan");
            myWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }



//    public void addPicturesToDb(String selectedFile) {
//        con.addPictureToGuide(selectedFile)

//    }

}
