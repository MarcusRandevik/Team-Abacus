package com.example.changeit;

import androidx.lifecycle.LiveData;

import com.example.changeit.db.AppDatabase;
import com.example.changeit.db.FilterValues;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.example.changeit.model.User;

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

    public LiveData<List<Advertisement>> getAdvertisements(FilterValues values) {
        return appDatabase.advertisementsDao().getAllApartments(values.getRooms(), values.getRent(), values.getSqm());
    }

    public LiveData<List<Advertisement>> getUserAdvertisements(String currentUserEmail ) {
        return appDatabase.advertisementsDao().getUserApartments(currentUserEmail);
    }

    public void addAdvertisement(Advertisement advertisement) {
        appDatabase.advertisementsDao().insert(advertisement);
    }

    public void update(Advertisement advertisement) {
        appDatabase.advertisementsDao().update(advertisement);
    }

    public void changeFavourite(Advertisement advertisement) {
        appDatabase.advertisementsDao().changeFavourite(advertisement.getId());
    }

    public LiveData<List<Advertisement>> getFavourites() {
        return appDatabase.advertisementsDao().getFavourites();
    }

    public Advertisement getAdvertisementFromId(int id) {
        return appDatabase.advertisementsDao().getAdvertisementFromId(id);
    }

    public void deleteUserAdvertisement (String currentUserEmail) {
        appDatabase.advertisementsDao().deleteUserAdvertisement(currentUserEmail);
    }

}
