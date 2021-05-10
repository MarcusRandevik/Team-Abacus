package com.example.changeit.model;

import java.io.Serializable;

/**
 * @author Lisa Samuelsson, Moa Berglund, Noa Tholén
 * @since 2021-04-13
 *
 *
 * User represents a user of the system.
 *
 */
public class User implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    // TODO en användare ska även ha profilbild

    /**
     * The constructor for the User class.
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param phoneNumber The phone number of the user.
     * @param password The password of the user.
     */
   public User(String name, String email, String phoneNumber, String password){
        this.name=name;
        this.email=email;
        this.phoneNumber= phoneNumber;
        this.password= password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
       return name;
    }

    public String getPhoneNumber(){
       return phoneNumber;
    }

    public String getEmail(){
       return email;
    }

    //setters,getters, ändra namn osv.... TODO

}
