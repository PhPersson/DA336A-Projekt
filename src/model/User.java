package model;

public class User {

    private String Username;
    private String email;
    private String password;
    private int role;

    public User(){}

    public User(String username, String email, String password, int role) {
        this.Username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
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
                "fName='" + Username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
