package com.example.changeit.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailedApartmentViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DetailedApartmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Detailed Test");
    }

    public LiveData<String> getText() {
        return mText;
    }
}