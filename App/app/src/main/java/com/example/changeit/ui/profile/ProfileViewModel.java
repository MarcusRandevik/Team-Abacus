package com.example.changeit.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private MutableLiveData<String> mText;


    private List<Advertisement> userAdvertisements;



    /**
     * An instance of the app repository.
     */
    private AppRepository repository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);

        repository = ((ChangeItApp) application).getRepository();

        User currentUser = UserHandler.getInstance().getCurrentUser();

        userAdvertisements =  repository.getUserAdvertisements(currentUser.getEmail());

    }



    public List<Advertisement> getAdvertisements() {
        return userAdvertisements;
    }


}
