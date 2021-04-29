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
import com.example.changeit.model.Apartment;

import java.util.Random;

public class AdViewModel extends AndroidViewModel {

        private MutableLiveData<String> descriptionOffered;
        private MutableLiveData<String> descriptionWanted;
        private MutableLiveData<Boolean> valid;
        private MutableLiveData<String> rentOffered;
        private MutableLiveData<String> roomsOffered;
        private MutableLiveData<String> rentWanted;
        private MutableLiveData<String> sqmWanted;
        private MutableLiveData<String> sqmOffered;
        private MutableLiveData<String> roomsWanted;

        private AppRepository repository;



    public AdViewModel(@NonNull Application application,
                           @NonNull SavedStateHandle savedStateHandle) {
            super(application);
            descriptionOffered = new MutableLiveData<>();
            descriptionWanted = new MutableLiveData<>();
            rentOffered = new MutableLiveData<>();
            roomsOffered = new MutableLiveData<>();
            sqmOffered = new MutableLiveData<>();

            rentWanted = new MutableLiveData<>();
            sqmWanted = new MutableLiveData<>();
            roomsWanted = new MutableLiveData<>();
            repository = ((ChangeItApp) application).getRepository();
        }

    public MutableLiveData<String> getSqmOffered() {
        return sqmOffered;
    }

    public void setSqmOffered(MutableLiveData<String> sqmOffered) {
        this.sqmOffered = sqmOffered;
    }

    public MutableLiveData<String> getRoomsOffered() {
        return roomsOffered;
    }

    public void setRoomsOffered(MutableLiveData<String> roomsOffered) {
        this.roomsOffered = roomsOffered;
    }

    public MutableLiveData<String> getRentOffered() {
        return rentOffered;
    }

    public void setRentOffered(MutableLiveData<String> rentOffered) {
        this.rentOffered = rentOffered;
    }

    public MutableLiveData<String> getDescriptionOffered() {
        return descriptionOffered;
    }

    public void setDescriptionOffered(MutableLiveData<String> description) {
        this.descriptionOffered = description;
    }

    public MutableLiveData<String> getRoomsWanted() {
        return roomsWanted;
    }

    public void setRoomsWanted(MutableLiveData<String> roomsWanted) {
        this.roomsWanted = roomsWanted;
    }

    public MutableLiveData<String> getDescriptionWanted() {
        return descriptionWanted;
    }

    public void setDescriptionWanted(MutableLiveData<String> descriptionWanted) {
        this.descriptionWanted = descriptionWanted;
    }

    public MutableLiveData<String> getRentWanted() {
        return rentWanted;
    }

    public void setRentWanted(MutableLiveData<String> rentWanted) {
        this.rentWanted = rentWanted;
    }

    public MutableLiveData<String> getSqmWanted() {
        return sqmWanted;
    }

    public void setSqmWanted(MutableLiveData<String> sqmWanted) {
        this.sqmWanted = sqmWanted;
    }

    //Listan krånglar (?)

    public void saveApartment(){
        repository.addAppartment(new Apartment( new Random().nextInt(),
                Integer.parseInt(getRentOffered().getValue()),
                Integer.parseInt(getRoomsOffered().getValue()),
                Integer.parseInt(getRentWanted().getValue()),
                Integer.parseInt(getSqmWanted().getValue()),
                Integer.parseInt(getSqmOffered().getValue()),
                getDescriptionOffered().getValue(),
                getDescriptionWanted().getValue(),
                Integer.parseInt(getRentWanted().getValue()))); //Ej rum över 10
    }
}
