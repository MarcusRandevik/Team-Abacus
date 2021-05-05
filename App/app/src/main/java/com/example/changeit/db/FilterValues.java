package com.example.changeit.db;

public class FilterValues {
    /**
     * @author Marcus Randevik, Lisa Samuelsson, Amanda Styff, Noa Tholén
     * @since 2021-05-04
     */

    private int rooms;
    private int rent;
    private int sqm;

    /**
     * The constructor for the FilterValues class, that combines all three filters into one.
     * @param rooms  Maximum amount of rooms the user has filtered by.
     * @param rent Maximum rent the user has filtered by.
     * @param sqm Maximum amount of sqm the user has filtered by.
     */
    public FilterValues(int rooms, int rent, int sqm) {
        this.rooms = rooms;
        this.rent = rent;
        this.sqm = sqm;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getSqm() {
        return sqm;
    }

    public void setSqm(int sqm) {
        this.sqm = sqm;
    }
}
