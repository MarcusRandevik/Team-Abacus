package com.example.changeit.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;

/**
        * logic for the profile view
        * @author Izabell Arvidsson, Amanda Styff, Kerstin Wadman. Edited by Moa Berglund, Lisa Samuelsson
        * @since 2021-04-13
        */
public class ProfileViewModel extends AndroidViewModel {

    private String userEmail;

    /**
     * An instance of the app repository.
     */
    private AppRepository repository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);

        repository = ((ChangeItApp) application).getRepository();

        UserHandler userHandler = UserHandler.getInstance();
        User currentUser = userHandler.getCurrentUser();
        userEmail = currentUser.getEmail();

    }


    public LiveData<Advertisement> getAdvertisement() {
        return repository.getUserAdvertisements(userEmail);
    }

    public void changeFavourite(Advertisement advertisement) {
        repository.changeFavourite(advertisement);
    }

    public void deleteUserAdvertisement (){
        repository.deleteUserAdvertisement(userEmail);
    }
}
