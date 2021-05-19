package com.example.changeit.model;
/**
 *
 * Represents a start up service for the application. Initializes hard coded users to the application and sets one as default logged in
 * Uses UserHandler
 *
 * @author Moa Berglund, Noa Tholén, Lisa Samuelsson, Amanda Styff
 * @since 2020-04-13
 */
public class StartUpService {
    private static StartUpService single_instance=null;

    public static StartUpService getInstance() {
        if (single_instance == null)
            single_instance = new StartUpService();
        return single_instance;
    }
    public static void loadPackage() {
        UserHandler userHandler= UserHandler.getInstance();
        userHandler.createUser("Moa Berglund", "moa@mail.com", "0701615552", "password123");
        userHandler.createUser("Amanda Styff", "amanda@mail.com", "0727615552", "password123");
        userHandler.createUser("Noa Tholén", "noa@mail.com", "0717615552", "password123");
        userHandler.createUser("Marcus Randevik", "marcus@mail.com", "07076315552", "password123");
        userHandler.createUser("Kerstin Wadman", "Kerstin@mail.com", "07076155452", "password123");
        userHandler.createUser("Izabell Arvidsson", "Izabell@mail.com", "07076155552", "password123");
        userHandler.createUser("Lisa Samuelsson", "Lisa@mail.com", "07076155562", "password123");
        userHandler.createUser("Martin Andersson", "martin@mail.com", "07076155532", "password123");
        userHandler.createUser("Sofia Berg", "sofia@mail.com", "07076155522", "password123");
        userHandler.createUser("Hannes Feldt", "hannes@mail.com", "070768155522", "password123");
        User user = userHandler.getUserByEmail("moa@mail.com");
        userHandler.setCurrentUser(user);
    }
}
