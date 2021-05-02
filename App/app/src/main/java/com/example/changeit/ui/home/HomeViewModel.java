package com.example.changeit.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> maxRooms = new MutableLiveData<>(5);
    private LiveData<List<Advertisement>> advertisements;

    private AppRepository repository;

    public HomeViewModel(@NonNull Application application,
                         @NonNull SavedStateHandle savedStateHandle) {
        super(application);

        repository = ((ChangeItApp) application).getRepository();

        advertisements = Transformations.switchMap(maxRooms, integer -> repository.getAdvertisements(integer));

    }

    public LiveData<List<Advertisement>> getAdvertisements() {
        return advertisements;
    }

    public Integer getMaxRooms() {
        return maxRooms.getValue();
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms.setValue(maxRooms);
    }
}