package com.example.changeit;

import androidx.lifecycle.LiveData;

import com.example.changeit.db.AppDatabase;
import com.example.changeit.model.Apartment;

import java.util.List;

public class AppRepository {

    private static AppRepository instance;

    private final AppDatabase appDatabase;

    private AppRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public static AppRepository getInstance(final AppDatabase appDatabase) {
        if (instance == null) {
            synchronized (AppRepository.class) {
                if (instance == null) {
                    instance = new AppRepository(appDatabase);
                }
            }
        }
        return instance;
    }

    public LiveData<List<Apartment>> getApartments(int maxRooms) {
        return appDatabase.apartmentDao().getAllApartments(maxRooms);
    }
}
