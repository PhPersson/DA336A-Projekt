package model;
import controller.Controller;
import model.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private User user;
    private List<User> userList;
    private Controller controller;


    public UserManager(Controller controller) {
        this.controller = controller;
        userList = new ArrayList<>();

    }

    public void addNewUser(String username, String email, String password){
        //addNewUserToList(new User(username, email, password));

    }

    public String[] getUserList(){

        ArrayList<String> user = controller.getUsersFromDb();

        String[] InfoStrings = new String[user.size()];
        for(int i =0; i < InfoStrings.length;i++) {
            if (user != null){
                InfoStrings[i] = user.toString();
            }
        }
        return InfoStrings;
    }

    public void addNewUserToList(User user){
        userList.add(user);
    }
    public void removeUser(int index){
        userList.remove(index);

    }
    public User getUser(int index){
        return userList.get(index);
    }

    public User getAllUsers(){
        return null;
    }


}
