package model;

import controller.Controller;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;


/**
 * @author Philip Persson
 */
public class DbCon {

    private User user;
    private Connection connection;
    private String sqlURL = "jdbc:sqlserver://supportme.duckdns.org;databaseName=support_me;";
    private String sqlUsername = "supportmeadmin";
    private String sqlPassword = "hejsanhoppsan";
    private FileInputStream fis;
    private Controller controller;


    /**
     *
     * @param controller Tar emot ett controller objekt för att kunna komunicera tillbaka till controller klassen.
     * Konstruktorn som även öppnar en anslutning till databasen.
     */
    public DbCon(Controller controller) {

        this.controller = controller;
        connectToDatabase();
    }

    /**
     * Ansluter till den fastställda databsen. Om databasen inte går att ansluta till visas ett felmeddelande.
     */
    public void connectToDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(sqlURL, sqlUsername, sqlPassword);
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            controller.getUtil().showErrorDialog("Couldn't connect to the database. \n Please contact the systemadministrator");
        }
    }

    /**
     *
     * @param username Anänvdarnamet tas emot som en paramter. Söker sedan igenom hela databsen.
     * @return om användaren finns i databasen retuneras true, annars retuneras false.
     */
    public boolean getAllUsernames(String username) {

        String query = "SELECT username FROM [User] WHERE username = ?";  //get username
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Kontrollerar om användaren redan finns i databasen eller inte.
     * @param username Användarnamnet som användaren skriver inte
     * @param password Lösenordet som användaren matar in vid
     * @return retunerar true om användaren finns. Annars retuneras false.
     */
    public boolean getAllUserAndPass(String username, String password) {

        String query = "SELECT username FROM [User] WHERE username = ? AND password = ?";  //get username
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Hämtar vilken roll användaren har i databsen. Om rollen är 1 räknas detta som att användaren är en administratör.
     * @param username Användarnamet att kolla upp i databsen
     * @param password Lösenorder att kolla upp i databasen,
     * @return Om användaren är administratör så retuneras true.
     */
    public boolean getRole(String username, String password) {
        String query = "SELECT role FROM [User] WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int role = rs.getInt("role");
                if (role == 1) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * Hämtar alla alla användare som finns registrerade i databsen.
     * @return Retunerar alla användare i en lista.
     */
    public ArrayList<String> getAllUsers() {
        ArrayList<String> user = new ArrayList<String>();
        String query = "SELECT * FROM [User]";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.add(rs.getString("username") + ", " + (rs.getString("email")));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }


    /**
     * Registrear en ny användare i databasen.
     * @param username Det användarnamn som användaren väljer att ha.
     * @param password Lösenordet som användare väljer att ha
     * @param email e-postadressen användaren väljer att registrera till systemet
     */
    public void registerNewCustomer(String username, String password, String email) {
        try {
            connection.setAutoCommit(false);

            String registerCustomer = "INSERT INTO [User] (username, password, email, role)" + " VALUES (?,?,?,?)";

            PreparedStatement register = connection.prepareStatement(registerCustomer);

            register.setString(1, username);
            register.setString(3, password);
            register.setString(2, email);
            register.setInt(4, 0);
            register.execute();
            connection.commit();
            register.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Raderar en användaren från databsen. Detta kan enbart göras av de som är administratörer.
     * @param username Användarnamnet på den användaren som skall tas bort från databsen
     */
    public void deleteAUser(String username) {
        try {
            connection.setAutoCommit(false);

            String deleteUser = "Delete from [User] WHERE username = ?";

            PreparedStatement delete = connection.prepareStatement(deleteUser);
            delete.setString(1, username);
            delete.execute();
            connection.commit();
            delete.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * En administratör kan ta bort en hel guide via administratörs GUI
     * @param guideId Baserat på GuidId vet databsen vilken guide om skall raderas.
     */
    public void deleteGuideAdmin(String guideId) {
        try {
            connection.setAutoCommit(false);

            String deleteUser = "Delete from GUIDE WHERE guideId = ?";

            PreparedStatement delete = connection.prepareStatement(deleteUser);
            delete.setString(1, guideId);
            delete.execute();
            connection.commit();
            delete.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Populerar UserTable i GUI med användare och dess tillhörande epostadress.
     * @return Ett helt DefaultTableModel objekt som innehåller användarens Användarnamn och email.
     */
    public DefaultTableModel getUsersAndEmail() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Username", "Email"}, 0);
        try {
            String strGetUsers = "Select * FROM [USER] ORDER BY username ASC";
            PreparedStatement statement = connection.prepareStatement(strGetUsers);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                model.addRow(new Object[]{username, email});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return model;
    }


    /**
     * Populerar GuideTable med alla guider samt deras Titel, skapare och vilket datum guiden skapades.
     * @return Ett helt DefaultTableModel objekt som innehåller alla guider med tillhörande Titel på guiden, vem som skapade guiden och vilket datum guiden skapades.
     */
    public DefaultTableModel getAllGuides() {
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"GuideId", "Title", "Created by:", "Date", "Rating"}, 0);
        try {
            String strGetUsers = "Select * FROM GUIDE ORDER BY username ASC";
            PreparedStatement statement = connection.prepareStatement(strGetUsers);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int guideId = rs.getInt("guideId");
                String title = rs.getString("title");
                String username = rs.getString("username");
                Date date = rs.getDate("date");
                int rating = rs.getInt("rating");
                guideModel.addRow(new Object[]{guideId, title, username, date, rating});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return guideModel;
    }

    //
    public DefaultTableModel getAllGuidesUserSearch() {
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"Title", "Created by:", "Date", "Rating", "Description"}, 0);
        try {
            String strGetUsers = "Select * FROM GUIDE ORDER BY username ASC";
            PreparedStatement statement = connection.prepareStatement(strGetUsers);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String username = rs.getString("username");
                Date date = rs.getDate("date");
                int rating = rs.getInt("rating");
                String description = rs.getString("description");
                guideModel.addRow(new Object[]{title, username, date, rating, description});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return guideModel;
    }


    public DefaultTableModel getAllGuidesUser(String user) {
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"Title", "Created by:", "Date", "Rating"}, 0);
        try {
            String strGetUsers = "Select * FROM GUIDE WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(strGetUsers);
            statement.setString(1, user);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String username = rs.getString("username");
                Date date = rs.getDate("date");
                int rating = rs.getInt("rating");
                guideModel.addRow(new Object[]{title, username, date, rating});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return guideModel;
    }


    /**
     * Söker igeon databasen efter en specefik användare baserat på användarnamnet.
     * @param soktext Sträng som innehåller ord som databasen ska söka på.
     * @return Ett helt DefaultTableModel objekt som innehåller alla namnet på den sökta användaren och tillhörande e-postaddress.
     */
    public DefaultTableModel searchUser(String soktext) {
        DefaultTableModel userModel = new DefaultTableModel(new String[]{"Username", "Email"}, 0);
        try {
            String query = "SELECT username, email FROM [User] WHERE username LIKE '%" + soktext + "%' OR email LIKE '%" + soktext + "%' ";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                userModel.addRow(new Object[]{username, email});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return userModel;
    }

    /**
     * Söker igeon databasen efter en specefik guide baserat på vem som skapade den eller titlen på guide.
     * @param soktext Sträng som innehåller ord som databasen ska söka på.
     * @return Ett helt DefaultTableModel objekt som innehåller alla namnet på den sökta guiden med tillhörande användare som skapade guiden, när guiden skapades och vilket omdöme guiden har.
     */
    public DefaultTableModel searchGuide(String soktext) {
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"Title", "Created by:", "Date", "Rating"}, 0);
        try {
            String query = "SELECT title, username, date, rating FROM Guide WHERE title LIKE '%" + soktext + "%' OR username LIKE '%" + soktext + "%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String username = rs.getString("username");
                Date date = rs.getDate("date");
                int rating = rs.getInt("rating");

                guideModel.addRow(new Object[]{title, username, date, rating});
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return guideModel;

    }

    // Skapar en guide och lagrar denna i databasen

    /**
     * Skapar en guide i databasen
     * @param title Den titeln som användare väljer att sätta på sin guide.
     * @param description Förklaringen till guiden. Hur man ska gå tillväga bland annat.
     * @param username Användarnamnet på vem det var som skapade guiden.
     * @param filepath Sökvägen till bild/bilder användaren väljer att lägga in i guiden.
     */
    public void createGuide(String title, String description, String username, String filepath) {
        try {
            fis = new FileInputStream(filepath);
            connection.setAutoCommit(false);

            String createGuide = "INSERT INTO [Guide] ( title, description, date, picture, username)" + " VALUES (?,?,?,?,?)";
            PreparedStatement create = connection.prepareStatement(createGuide);

            create.setString(1, title);
            create.setString(2, description);
            create.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            create.setBinaryStream(4, fis);
            create.setString(5, username);
            System.out.println("Created a Guide");
            create.execute();
            connection.commit();
            create.close();


        } catch (SQLException | FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public boolean checkIfUserHaveGuides(String username){
        boolean userHaveGuides = false;
        try {
            connection.setAutoCommit(false);
            String query = "SELECT COUNT(guide.guideId) FROM Guide WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count >= 1) {
                    userHaveGuides = true;
                } else {
                    userHaveGuides = false;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userHaveGuides;
    }

    public void deleteGuideBasedOnUsername(String username) {
        try {
            connection.setAutoCommit(false);
            String deleteGuide = "DELETE FROM GUIDE WHERE username = ?";

            PreparedStatement ps = connection.prepareStatement(deleteGuide);
            ps.setString(1,username);
            ps.execute();
            connection.commit();
            ps.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

//    public void deleteGuideAdmin(String guideId) {
//        try {
//            connection.setAutoCommit(false);
//
//            String deleteUser = "Delete from GUIDE WHERE guideId = ?";
//
//            PreparedStatement delete = connection.prepareStatement(deleteUser);
//            delete.setString(1, guideId);
//            delete.execute();
//            connection.commit();
//            delete.close();
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//    }

// Delete a guide query delete from Guide where title = ?

// DBCC CHECKIDENT (Guide, RESEED, 0) Återställer Guideid == 0;

// DBCC CHECKIDENT (mytable) Kolla vad increment value ligger på för just den tabellen
