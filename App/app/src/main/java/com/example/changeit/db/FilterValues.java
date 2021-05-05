package com.example.changeit.db;

public class FilterValues {

    private int rooms;
    private int rent;
    private int sqm;

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
