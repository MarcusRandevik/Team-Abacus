package com.example.changeit.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.model.Apartment;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private LiveData<List<Apartment>> apartments;

    public HomeViewModel(@NonNull Application application,
                         @NonNull SavedStateHandle savedStateHandle) {
        super(application);

        AppRepository repository = ((ChangeItApp) application).getRepository();

        apartments = repository.getApartments();
    }

    public LiveData<List<Apartment>> getApartments() {
        return apartments;
    }
}