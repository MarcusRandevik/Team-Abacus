package com.example.changeit.ui.ad;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.changeit.model.Apartment;

public class AdViewModel extends ViewModel {

        private MutableLiveData<String> description;
        private MutableLiveData<Boolean> valid;

        public AdViewModel() {
            description = new MutableLiveData<>();
            description.setValue("This is ad fragment");
        }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public void setDescription(MutableLiveData<String> description) {
        this.description = description;
    }
}
