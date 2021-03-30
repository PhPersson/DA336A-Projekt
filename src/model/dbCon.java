package model;

import controller.Controller;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Philip Persosn
 * @author
 */
public class dbCon {

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
    public dbCon(Controller controller) {
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

    // Hämtar alla användare baserat på sökresultat
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
            return true;
        }
    }

    // Anänvds för att gå igenom alla användare för att kontrollera så användaren matar in ett unikt användarnamn
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
            return true;
        }
    }

    // Hämtar rollen av användaren som loggar in. Kontrollerar om det är en administratör som loggar in eller inte.
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

    //  Retunerar alla användare som finns registrerade i databasen.
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

    // Registrerar en ny användare i databasen.
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

    // Raderar den valda användaren från databasen
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

    // En administratör kan ta bort en guide via denna metoden
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

    // Populerar UserTable med användarenamn och tillhörande epostadress.
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

    // Populerar GuideTable med alla guider samt deras Titel, skapare och vilket datum guiden skapades.
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
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"Title", "Created by:", "Date", "Rating"}, 0);
        try {
            String strGetUsers = "Select * FROM GUIDE ORDER BY username ASC";
            PreparedStatement statement = connection.prepareStatement(strGetUsers);
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


    // Söker efter den valda användaren via GUI i databasen
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

    // Söker efter en guide i databasen.
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
}

// Delete a guide query delete from Guide where title = ?

// DBCC CHECKIDENT (Guide, RESEED, 0) Återställer Guideid == 0;

// DBCC CHECKIDENT (mytable) Kolla vad increment value ligger på för just den tabellen
