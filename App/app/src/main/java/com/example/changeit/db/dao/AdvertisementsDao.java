package com.example.changeit.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.List;

@Dao
public interface AdvertisementsDao {

    @Query("SELECT * FROM advertisements WHERE rooms <= :maxRooms AND rent <= :maxRent AND sqm <= :maxSqm")
    LiveData<List<Advertisement>> getAllApartments(int maxRooms, int maxRent, int maxSqm);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Advertisement> Advertisement);

    @Insert()
    void insert(Advertisement advertisement);
}
