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
import com.example.changeit.model.Advertisement;
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
    private MutableLiveData<Boolean> balconyOffered;
    private MutableLiveData<Boolean> wifiOffered;
    private MutableLiveData<Boolean> electricityOffered;
    private MutableLiveData<Boolean> petsOffered;

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
        balconyOffered = new MutableLiveData<>(false);
        wifiOffered = new MutableLiveData<>(false);
        electricityOffered = new MutableLiveData<>(false);
        petsOffered = new MutableLiveData<>(false);


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

    public MutableLiveData<Boolean> getBalconyOffered() {
        return balconyOffered;
    }

    public MutableLiveData<Boolean> getWifiOffered() {
        return wifiOffered;
    }

    public MutableLiveData<Boolean> getElectricityOffered() {
        return electricityOffered;
    }

    public MutableLiveData<Boolean> getPetsOffered() {
        return petsOffered;
    }

    public void setBalconyOffered(MutableLiveData<Boolean> balconyOffered) {
        this.balconyOffered = balconyOffered;
    }

    public void setWifiOffered(MutableLiveData<Boolean> wifiOffered) {
        this.wifiOffered = wifiOffered;
    }

    public void setElectricityOffered(MutableLiveData<Boolean> electricityOffered) {
        this.electricityOffered = electricityOffered;
    }

    public void setPetsOffered(MutableLiveData<Boolean> petsOffered) {
        this.petsOffered = petsOffered;
    }

    //Listan krånglar (?)

    /**
     * saveApartment() saves all specifics that are filled in when creating an ad and add the apartment
     * to the list of apartments.
     */

    public void saveApartment() {
        repository.addAdvertisement(new Advertisement(new Random().nextInt(),
                new Apartment(Integer.parseInt(getRentOffered().getValue()),
                        Integer.parseInt(getRoomsOffered().getValue()),
                        Integer.parseInt(getSqmOffered().getValue()),
                        getWifiOffered().getValue(),
                        getPetsOffered().getValue(),
                        getBalconyOffered().getValue(),
                        getElectricityOffered().getValue(), getDescriptionOffered().getValue()),
                        Integer.parseInt(getRentWanted().getValue()),
                        Integer.parseInt(getRoomsWanted().getValue()),
                        Integer.parseInt(getSqmWanted().getValue()))); //Ej rum över 10
    }
}
