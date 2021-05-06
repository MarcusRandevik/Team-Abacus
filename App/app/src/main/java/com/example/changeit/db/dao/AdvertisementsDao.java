package com.example.changeit.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.List;

/**
 * @author Marcus Randevik. Also edited by Lisa Samuelsson, Amanda Styff and Noa Tholén.
 * @since 2021-04-04
 */

@Dao
public interface AdvertisementsDao {

    /**
     * This query collects all apartments where the different filtration parameters are true.
     * For example: if you have filtered a max of 3 rooms, then the Advertisement list will
     * only contain those who match this criteria
     * @param maxRooms Maximum amount of rooms the user has filtered by.
     * @param maxRent  Maximum rent the user has filtered by.
     * @param maxSqm  Maximum amount of sqm the user has filtered by.
     * @return A list of advertisements which fulfills the criteria.
     */
    @Query("SELECT * FROM advertisements WHERE rooms <= :maxRooms AND rent <= :maxRent AND sqm <= :maxSqm")
    LiveData<List<Advertisement>> getAllApartments(int maxRooms, int maxRent, int maxSqm);

    /**
     * Replaces previous database if there is a conflict.
     * @param Advertisement the list of advertisements that are replacing the previous ones.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Advertisement> Advertisement);

    /**
     * Used to add an advertisement to the app database.
     * @param advertisement the advertisement that is added.
     */
    @Insert()
    void insert(Advertisement advertisement);
}
