package com.example.changeit.model;
/**
 * @author Moa Berglund, Noa Tholén, Lisa Samuelsson
 * Uses UserHandler
 * Represents an start up service for the application. Initializes hard coded values to the applicatione
 * @since 2020-04-13
 */
public class StartUpService {

    public static void loadPackage() { //kalla på i "main"

        UserHandler userHandler= UserHandler.getInstance();
        userHandler.createUser("Moa", "moa@mail.com", "0707615552", "password123");

    }
}
