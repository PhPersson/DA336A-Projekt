package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.String.valueOf;

public class dbCon {

    private User user;
    private String dbUrl;
    private Connection connection;
    private String sqlURL = "jdbc:sqlserver://supportme.duckdns.org;databaseName=support_me;";
    private String sqlUsername = "supportmeadmin";
    private String sqlPassword = "hejsanhoppsan";
    private FileInputStream fis;

    public dbCon() {
        connectToDatabase();
    }


    public void connectToDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(sqlURL, sqlUsername, sqlPassword);
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
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

/*
    public ArrayList<String> getAllGuides() {
        ArrayList<String> user = new ArrayList<String>();
        String query = "SELECT * FROM [User]";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.add(rs.getString("username") + ", " + (rs.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

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

    public DefaultTableModel getAllGuides() {
        DefaultTableModel guideModel = new DefaultTableModel(new String[]{"GuideId","Title", "Created by:", "Date", "Rating"}, 0);
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
                guideModel.addRow(new Object[]{guideId, title, username, date, rating});            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return guideModel;
    }


                // Behövs ej längre??
//    public int getGuideId() {
//        String query = "SELECT guideId FROM GUIDE";
//        int temp = 1000;
//        try {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            //preparedStatement.setInt(1, guideId);
//
//            while (rs.next()) {
//                int guideId = rs.getInt("guideId");
//                temp = guideId;
//                if(guideId > temp){
//                    temp = guideId;
//                }
//            }
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        temp++;
//        return temp;
//    }


        // Söker efter den valda användaren via GUI i databasen
        public DefaultTableModel searchUser (String soktext){
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
        public DefaultTableModel searchGuide (String soktext){
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

        public void createGuide (String title, String description, String filepath ){
            try {
                fis = new FileInputStream(filepath);
                connection.setAutoCommit(false);

                String createGuide = "INSERT INTO [Guide] ( title, description, date, picture)" + " VALUES (?,?,?,?)";
                PreparedStatement create = connection.prepareStatement(createGuide);

                create.setString(1, title);
                create.setString(2, description);
                create.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                create.setBinaryStream(4,fis);
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
