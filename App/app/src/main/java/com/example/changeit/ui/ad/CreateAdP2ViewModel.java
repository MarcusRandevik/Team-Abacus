package com.example.changeit.ui.ad;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;

public class CreateAdP2ViewModel extends AndroidViewModel {
    private MutableLiveData<String> description;
    private MutableLiveData<Boolean> valid;

    private AppRepository repository;


    public CreateAdP2ViewModel(@NonNull Application application,
                               @NonNull SavedStateHandle savedStateHandle) {
        super(application);

        repository = ((ChangeItApp) application).getRepository();

        description = new MutableLiveData<>();
        description.setValue("This is adPart2 fragment");

    }

    public MutableLiveData<String> getDescription() {
        return description;
    }


    public void setDescription(MutableLiveData<String> description) {
        this.description = description;
    }
}