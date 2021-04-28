package com.example.changeit.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;


@Entity(tableName = "apartments")
public class Apartment implements Serializable {
    @PrimaryKey
    private int id;
    private int rent;
    private int rooms;
    private int sqm;
    private String address;
    private boolean balcony;
    private boolean wifi;
    private boolean pets;
    private boolean electricity;

    public Apartment(int id, int rent, int rooms) {
        this.id = id;
        this.rent = rent;
        this.rooms = rooms;
        this.balcony = true;
        this.sqm=40;
        this.address="Åke Falcks gata";
        this.wifi=true;
        this.pets=false;
        this.electricity=false;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Apartment " + id + ", with " + rooms + " rooms and a rent of " + rent + "kr";
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
        return id == apartment.id &&
                rent == apartment.rent &&
                rooms == apartment.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rent, rooms);
    }
}

