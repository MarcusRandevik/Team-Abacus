package com.example.changeit.model;

import java.io.Serializable;
import java.util.Objects;

public class Apartment implements Serializable {
    private int rent;
    private int rooms;
    private int sqm;
    private String address;
    private boolean balcony;
    private boolean wifi;
    private boolean pets;
    private boolean electricity;
    private String description;

    public Apartment(int rent, int rooms, int sqm, boolean wifi, boolean pets, boolean balcony, boolean electricity, String description) {
        this.rent = rent;
        this.rooms = rooms;
        this.balcony = balcony;
        this.sqm = sqm;
        this.address = "Åke Falcks gata";
        this.wifi = wifi;
        this.pets = pets;
        this.electricity = electricity;
        this.description = description;
    }


    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean getPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public int getSqm(){ return sqm;}

    public String getAddress(){return address;}

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSqm(int sqm){ this.sqm=sqm;}

    public boolean getBalcony(){return balcony;}

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Apartment with " + rooms + " rooms and a rent of " + rent + "kr";
    }

    /**
     * states if a specifik specifikation is fulfilled in a apartment
     * @param specifikation the specifik specifikation
     * @return yes or no if it is fulfilled
     */
    public String isIncluded(boolean specifikation) {
        if(specifikation){
            return "Yes";
        } else {
            return "No";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return rent == apartment.rent &&
                rooms == apartment.rooms &&
                sqm == apartment.sqm &&
                balcony == apartment.balcony &&
                wifi == apartment.wifi &&
                pets == apartment.pets &&
                electricity == apartment.electricity &&
                Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rent, rooms, sqm, address, balcony, wifi, pets, electricity);
    }
}

