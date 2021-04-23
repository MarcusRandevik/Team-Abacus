package com.example.changeit.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.changeit.model.Apartment;

import java.util.List;

@Dao
public interface ApartmentDao {

    @Query("SELECT * FROM apartments WHERE rooms <= :maxRooms")
    LiveData<List<Apartment>> getAllApartments(int maxRooms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Apartment> apartments);
}
