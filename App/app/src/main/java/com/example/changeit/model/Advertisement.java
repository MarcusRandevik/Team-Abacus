package com.example.changeit.model;

import android.net.Uri;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.changeit.db.DataConverter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * POJO class representing an ad.
 * @author Marcus Randevik
 * @since 2021-04-10
 */

@Entity(tableName = "advertisements")
@TypeConverters({DataConverter.class})
public class Advertisement implements Serializable {
    @PrimaryKey
    private int id;
    @Embedded
    private User user;
    @Embedded
    private Apartment apartment;
    private List<Uri> pictures;
    private int seekingRent;
    private int seekingRoom;
    private int seekingSqm;

    /**
     * Constructor for creating an advertisement
     * @param id A random id-number to identify each advertisement as a unique one
     * @param apartment The apartment that is advertised
     * @param seekingRent The amount of rent the user is looking for
     * @param seekingRoom The amount of rooms the user is looking for
     * @param seekingSqm The amount of sqm the user is looking for
     * @param user the user that posts the advertisement
     */
    public Advertisement(int id, Apartment apartment, List<Uri> pictures, int seekingRent, int seekingRoom, int seekingSqm, User user) {
        this.id = id;
        this.apartment = apartment;
        this.pictures = pictures;
        this.seekingRent = seekingRent;
        this.seekingRoom = seekingRoom;
        this.seekingSqm = seekingSqm;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Uri> getPictures() {
        return pictures;
    }

    public void setPictures(List<Uri> pictures) {
        this.pictures = pictures;
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

    /**
     * In order to compare different advertisements
     * @param o The advertisement in question
     * @return true if advertisements are the same, false otherwise
     */
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

    /**
     * Creates a hashcode for an apartment for the database to function
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, apartment, seekingRent, seekingRoom, seekingSqm);
    }
}
