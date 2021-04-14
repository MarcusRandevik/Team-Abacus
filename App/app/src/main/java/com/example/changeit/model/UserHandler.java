package com.example.changeit.model;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class UserHandler {
    private static UserHandler single_instance=null;
    private List<User> allUsers; //final?

    public static UserHandler getInstance() {
        if (single_instance == null)
            single_instance = new UserHandler();
        return single_instance;
    }

    private UserHandler(){
        this.allUsers=new ArrayList<>();
    }

    public void createUser(String name, String email, String phoneNumber, String password){
       if( checkDuplicates(email, phoneNumber)== false) {
           User newUser = new User(name, email, phoneNumber, password);
           addUser(newUser);
       }
       else{
           //inte ok att skapa användare TODO
       }
    }
    public void addUser(User newUser){
        allUsers.add(newUser);
    }

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
