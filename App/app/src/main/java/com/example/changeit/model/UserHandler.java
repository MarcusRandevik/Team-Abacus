package com.example.changeit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A static class that handles the users. Has a list of users
 * Uses user
 *
 * @author Moa Berglund, Noa Tholén, Lisa Samuelsson
 * @since 2020-04-13
 */

public class UserHandler {
    private static UserHandler single_instance=null;
    private List<User> allUsers;
    private User currentUser;

    /**
     * should not be able to create more than one userhandler (singleton)
     * @return the one and only userhandler
     */
    public static UserHandler getInstance() {
        if (single_instance == null)
            single_instance = new UserHandler();
        return single_instance;
    }

    private UserHandler(){
        this.allUsers=new ArrayList<>();
    }

    /**
     * creates a user if the email and phone number is not found in the already created users
     * @param name name of the new user that wants to be created
     * @param email mail of the new user that wants to be created
     * @param phoneNumber phoneNumber of the new user that wants to be created
     * @param password  password of the new user that wants to be created
     */
    public void createUser(String name, String email, String phoneNumber, String password){
       if(!checkDuplicates(email, phoneNumber)) {
           User newUser = new User(name, email, phoneNumber, password);
           addUser(newUser);
       }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * add a created user to the UserHandler's list of valid users
     * @param newUser the user to add
     */
    public void addUser(User newUser){
        allUsers.add(newUser);
    }

    /**
     * checks if there are any users with a specific email or phonenumber
     * @param email the email to look for among the users
     * @param phoneNumber the phonenumber to look for among the users
     * @return true if the specifik email or phonenumber is used by a user of the application
     */
    public boolean checkDuplicates(String email, String phoneNumber){
        for (User user: allUsers) {
            if(user.getEmail().equals(email) || user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers(){
        return allUsers;
    }

    /**
     * gives an user with a specific email
     * @param email the email connected to a user
     * @return the user with the specific email
     */
    // kan användas vid inloggning, när användaren har skrivit in sin email
    public User getUserByEmail(String email) {
        for (User u : allUsers ) {
            if(email.equals(u.getEmail())) {
                return u;
            }
        }
        return null;
    }

}
