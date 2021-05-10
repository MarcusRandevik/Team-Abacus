package com.example.changeit.model;
/**
 * @author Moa Berglund, Noa Tholén, Lisa Samuelsson
 * Uses UserHandler
 * Represents an start up service for the application. Initializes hard coded values to the applicatione
 * @since 2020-04-13
 */
public class StartUpService {
    private static StartUpService single_instance=null;

    public static StartUpService getInstance() {
        if (single_instance == null)
            single_instance = new StartUpService();
        return single_instance;
    }
    public static void loadPackage() { //kalla på i "main"
        UserHandler userHandler= UserHandler.getInstance();
        userHandler.createUser("Moas", "mob@mail.com", "0701615552", "password123");
        userHandler.createUser("Moaz", "mos@mail.com", "0727615552", "password123");
        userHandler.createUser("Moac", "mow@mail.com", "0717615552", "password123");
        userHandler.createUser("Moaw", "moq@mail.com", "07076315552", "password123");
        userHandler.createUser("Moar", "moa@mail.com", "07076155452", "password123");
        userHandler.createUser("Moae", "moau@mail.com", "07076155552", "password123");
        userHandler.createUser("Moad", "moaå@mail.com", "07076155562", "password123");
        userHandler.createUser("Moah", "moax@mail.com", "07076155532", "password123");
        userHandler.createUser("Moap", "moal@mail.com", "07076155522", "password123");
        User user = userHandler.getUserByEmail("moa@mail.com");
        userHandler.setCurrentUser(user);
    }
}
