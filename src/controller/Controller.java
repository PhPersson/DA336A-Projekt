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
        if (con.checkIfUserHaveGuides(username)) {
            if (util.showConfirmationDialog("User have still active guides \n Do you want to remove all guides to?") == 1) {
                con.deleteGuideBasedOnUsername(username);
                con.deleteAUser(username);
            }
        }
        adminFrame.updateUserList(con.getUsersAndEmail());
        adminFrame.updateGuideList(con.getAllGuides());
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
        frame.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout());
        JPanel southPanel = new JPanel(new BorderLayout());

        JTextArea area = new JTextArea();
        JLabel titleTxt, authorTxt, dateTxt, ratingTxt, titleLbl, authorLbl, dateLbl, ratingLbl;

        titleTxt = new JLabel(titleString);
        titleTxt.setFont(new Font("Verdana", Font.PLAIN,18));
        titleLbl = new JLabel("Title: ");
        titleLbl.setFont(new Font("Verdana", Font.BOLD,18));
        authorTxt = new JLabel();
        authorLbl = new JLabel("Author: ");
        authorLbl.setFont(new Font("Verdana", Font.BOLD,18));
        dateTxt = new JLabel(dateString);
        dateTxt.setFont(new Font("Verdana", Font.PLAIN,18));
        dateLbl = new JLabel("Date: ");
        dateLbl.setFont(new Font("Verdana", Font.BOLD,18));
        ratingTxt = new JLabel(ratingString);
        ratingTxt.setFont(new Font("Verdana", Font.PLAIN,18));
        ratingLbl = new JLabel("Rating: ");
        ratingLbl.setFont(new Font("Verdana", Font.BOLD,18));

        area.setText(indexGuide);
        area.setEditable(false);
        area.setPreferredSize(new Dimension(500,400));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);

        northPanel.add(titleLbl);
        northPanel.add(titleTxt);
        //northPanel.add(authorLbl);
        //northPanel.add(authorTxt, BorderLayout.WEST);
        northPanel.add(dateLbl);
        northPanel.add(dateTxt);
        northPanel.add(ratingLbl);
        northPanel.add(ratingTxt);
        southPanel.add(scroll);

        northPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.pack();
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
