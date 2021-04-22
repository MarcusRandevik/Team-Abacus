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
    //private int sqm;
    //private String owner;

    public Apartment(int id, int rent, int rooms) {
        this.id = id;
        this.rent = rent;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    //public int getSqm(){ return sqm;}

    //public String getOwner(){return owner;}

    //public void setSqm(int sqm){ this.sqm=sqm;}

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

