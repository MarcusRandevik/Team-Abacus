package com.example.changeit.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Apartment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> maxRooms = new MutableLiveData<>(5);
    private LiveData<List<Apartment>> apartments;

    private AppRepository repository;

    public HomeViewModel(@NonNull Application application,
                         @NonNull SavedStateHandle savedStateHandle) {
        super(application);

        repository = ((ChangeItApp) application).getRepository();

        apartments = Transformations.switchMap(maxRooms, integer -> repository.getApartments(integer));

    }

    public LiveData<List<Apartment>> getApartments() {
        return apartments;
    }

    public Integer getMaxRooms() {
        return maxRooms.getValue();
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms.setValue(maxRooms);
    }
}