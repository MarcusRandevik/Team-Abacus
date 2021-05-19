package com.example.changeit.ui.favorites;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Advertisement;

import java.util.List;

/**
 * view model for the favorite view
 *
 * @author Marcus Randevik
 * @since 2021-03-22
 */
public class FavoritesViewModel extends AndroidViewModel {

    private AppRepository repository;

    public FavoritesViewModel(@NonNull Application application) {
        super(application);

        repository = ((ChangeItApp)application).getRepository();
    }

    public LiveData<List<Advertisement>> getFavouriteAdvertisements() {
        return repository.getFavourites();
    }

    public void changeFavourite(Advertisement advertisement) {
        repository.changeFavourite(advertisement);
    }

}