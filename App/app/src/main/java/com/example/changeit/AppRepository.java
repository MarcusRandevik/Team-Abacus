package com.example.changeit;

import androidx.lifecycle.LiveData;

import com.example.changeit.db.AppDatabase;
import com.example.changeit.model.Advertisement;
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

    public LiveData<List<Advertisement>> getAdvertisements(int maxRooms) {
        return appDatabase.advertisementsDao().getAllApartments(maxRooms);
    }

    public void addAdvertisement(Advertisement advertisement) {
        appDatabase.advertisementsDao().insert(advertisement);
    }

}
