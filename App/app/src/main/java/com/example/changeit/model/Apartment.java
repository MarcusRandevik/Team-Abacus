package com.example.changeit.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;


@Entity(tableName = "apartments")
public class Apartment implements Serializable {
    @PrimaryKey
    private int id;
    private int rentOffered;
    private int roomsOffered;
    private int sqmOffered;
    private int roomsWanted;
    private int rentWanted;
    private int sqmWanted;
    //private String owner;
    private String descriptionOffered;
    private String descriptionWanted;

    public Apartment(int id, int rentOffered, int roomsOffered, int rentWanted, int sqmWanted, int sqmOffered,
                     String descriptionOffered, String descriptionWanted, int roomsWanted) {
        this.id = id;
        this.rentOffered = rentOffered;
        this.roomsOffered = roomsOffered;
        this.sqmWanted = sqmWanted;
        this.rentWanted = rentWanted;
        this.sqmOffered = sqmOffered;
        this.descriptionOffered = descriptionOffered;
        this.descriptionWanted = descriptionWanted;
        this.roomsWanted = roomsWanted;
    }

    public String getDescriptionOffered() {
        return descriptionOffered;
    }

    public void setDescriptionOffered(String descriptionOffered) {
        this.descriptionOffered = descriptionOffered;
    }

    public int getSqmOffered() {
        return sqmOffered;
    }

    public void setSqmOffered(int sqmOffered) {
        this.sqmOffered = sqmOffered;
    }

    public String getDescriptionWanted() {
        return descriptionWanted;
    }

    public void setDescriptionWanted(String descriptionWanted) {
        this.descriptionWanted = descriptionWanted;
    }

    public int getRoomsWanted() {
        return roomsWanted;
    }

    public void setRoomsWanted(int roomsWanted) {
        this.roomsWanted = roomsWanted;
    }

    public int getRentWanted() {
        return rentWanted;
    }

    public void setRentWanted(int rentWanted) {
        this.rentWanted = rentWanted;
    }

    public int getSqmWanted() {
        return sqmWanted;
    }

    public void setSqmWanted(int sqmWanted) {
        this.sqmWanted = sqmWanted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentOffered() {
        return rentOffered;
    }

    public void setRentOffered(int rentOffered) {
        this.rentOffered = rentOffered;
    }

    public int getRoomsOffered() {
        return roomsOffered;
    }

    public void setRoomsOffered(int rooms) {
        this.roomsOffered = roomsOffered;
    }


    @Override
    public String toString() {
        return "Apartment " + id + ", with " + roomsOffered + " rooms and a rent of " + rentOffered + "kr";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return id == apartment.id &&
                rentOffered == apartment.rentOffered &&
                roomsOffered == apartment.roomsOffered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentOffered, roomsOffered);
    }
}

