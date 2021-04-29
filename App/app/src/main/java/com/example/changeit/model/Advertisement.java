package com.example.changeit.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO class representing an ad.
 */
@Entity(tableName = "advertisements")
public class Advertisement implements Serializable {
    @PrimaryKey
    private int id;
    @Embedded
    private Apartment apartment;
    private int seekingRent;
    private int seekingRoom;
    private int seekingSqm;

    public Advertisement(int id, Apartment apartment, int seekingRent, int seekingRoom, int seekingSqm) {
        this.id = id;
        this.apartment = apartment;
        this.seekingRent = seekingRent;
        this.seekingRoom = seekingRoom;
        this.seekingSqm = seekingSqm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getSeekingRent() {
        return seekingRent;
    }

    public void setSeekingRent(int seekingRent) {
        this.seekingRent = seekingRent;
    }

    public int getSeekingRoom() {
        return seekingRoom;
    }

    public void setSeekingRoom(int seekingRoom) {
        this.seekingRoom = seekingRoom;
    }

    public int getSeekingSqm() {
        return seekingSqm;
    }

    public void setSeekingSqm(int seekingSqm) {
        this.seekingSqm = seekingSqm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id == that.id &&
                seekingRent == that.seekingRent &&
                seekingRoom == that.seekingRoom &&
                seekingSqm == that.seekingSqm &&
                Objects.equals(apartment, that.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apartment, seekingRent, seekingRoom, seekingSqm);
    }
}
