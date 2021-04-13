package com.example.changeit.model;

public class StartUpService {

    public static void loadPackage() { //kalla på i "main"

        UserHandler userHandler= UserHandler.getInstance();
        userHandler.createUser("Moa", "moa@mail.com", "0707615552", "password123");

    }
}
