package com.example.changeit.ui.ad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreateAdP2ViewModel extends ViewModel {
    private MutableLiveData<String> description;
    private MutableLiveData<Boolean> valid;
    private MutableLiveData<String> mText;


    public CreateAdP2ViewModel() {
        description = new MutableLiveData<>();
        description.setValue("This is adPart2 fragment");
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void setDescription(MutableLiveData<String> description) {
        this.description = description;
    }
}