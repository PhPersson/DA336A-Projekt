package controller;

import model.*;
import view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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

                con.registerNewCustomer(view.getTxtUsername(), view.getTxtEmail(), view.getTxtPassword());
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
     * Användare väljer att starta programmet utan att logga in. homePageFrame körs.
     */
    public void btnNoLoginClicked() {
        view.getLoginFrame().setVisible(false);
        homePageFrame = new HomePageFrame(this);
        homePageFrame.updateSearchGuideList(con.getAllGuidesUserSearch());
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
     * @param username Användarnamn för raden man vill ta bort.
     */
    public void btnAdminDeleteUser(String username) {
        con.deleteAUser(username);
        adminFrame.updateUserList(con.getUsersAndEmail());
    }

    /**
     * Admin söker efter användare.
     * @param soktext input av sträng man vill söka med.
     */
    public void btnAdminSearchUser(String soktext) {
        adminFrame.updateUserList(con.searchUser(soktext));
    }

    /**
     * Admin söker efter guider.
     * @param soktext input av sträng man vill söka med.
     */
    public void btnAdminSearchGuide(String soktext) {
        adminFrame.updateGuideList(con.searchGuide(soktext));
    }

    /**
     * Admin tar bort guide i databasen.
     * @param indexToRemove input av sträng som är Guide_ID i databasen.
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
     * Visa guide för användare som inte loggat in.
     * @param indexGuide
     */
    public void btnShowGuideNotLoggedInPressed(String indexGuide, String titleString, String dateString, String ratingString) {
        JFrame frame = new JFrame("Current guide");

        JTextArea area = new JTextArea();
        JLabel title, author, date, rating;

        title = new JLabel(titleString);
        author = new JLabel();
        date = new JLabel(dateString);
        rating = new JLabel(ratingString);

        area.setText(indexGuide);
        area.setEditable(false);
        area.setPreferredSize(new Dimension(300,300));

        GridLayout layout = new GridLayout(4,4);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(title);
        frame.add(author);
        frame.add(date);
        frame.add(rating);
        frame.add(scroll);

        frame.setLayout(layout);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);
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
