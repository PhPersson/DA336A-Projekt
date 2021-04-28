package model;


/**
 * @version 1.0
 * @author Philip Persson
 * @author Alexander Olsson
 * @author
 */
public class User { // TODO KOMMENTERA DENNA KLASSEN

    private String username;
    private String email;
    private String password;
    private int role;

    public User(){}

    /**
     * Konstruktor för att lägga till en ny användare.
     * @param username
     * @param email
     * @param password
     * @param role
     */

    public User(String username, String email, String password, int role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole(){
        return role;
    }

    public void setRole(){
        this.role=role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
