package com.example.changeit.ui.ad;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.example.changeit.model.UserHandler;
import com.example.changeit.util.AppUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

/**
 * @author Kerstin Wadman, Noa Tholén, Lisa Samuelsson, Moa Berglund, Izabell Arvidsson, Marcus Randevik, Amanda Styff
 * @since 2020-04-20
 *
 * View model which is shared between AdFragment and CreateAdP2Fragment.
 * This is because these fragments are connected and should be saved together in the advertisement.
 *
 */
public class AdViewModel extends AndroidViewModel {
    UserHandler userhandler=UserHandler.getInstance();
    /**
     * An instance of the app repository,
     */
    private AppRepository repository;

    /**
     * The description for the offered apartment.
     */
    private MutableLiveData<String> descriptionOffered;

    /**
     * The description for the wanted apartment.
     */
    private MutableLiveData<String> descriptionWanted;

   // private MutableLiveData<Boolean> valid; TODO - remove?

    /**
     * The rent for the offered apartment.
     */
    private MutableLiveData<String> rentOffered;

    /**
     * The rent for the wanted apartment.
     */
    private MutableLiveData<String> rentWanted;

    /**
     * The number of rooms in the offered apartment.
     */
    private MutableLiveData<String> roomsOffered;

    /**
     * The number of rooms in the wanted apartment.
     */
    private MutableLiveData<String> roomsWanted;

    /**
     * The number of sqm in the offered apartment.
     */
    private MutableLiveData<String> sqmOffered;

    private MutableLiveData<List<Uri>> pictures;

    /**
     * The number of sqm in the wanted apartment.
     */
    private MutableLiveData<String> sqmWanted;

    /**
     * True if balcony is included in offered apartment, false otherwise.
     */
    private MutableLiveData<Boolean> balconyOffered;

    /**
     * True if wifi is included in offered apartment, false otherwise.
     */
    private MutableLiveData<Boolean> wifiOffered;

    /**
     * True if electricity is included in offered apartment, false otherwise.
     */
    private MutableLiveData<Boolean> electricityOffered;

    /**
     * The address of the offered apartment.
     */

    private MutableLiveData<String> addressOffered;

    /**
     * True if pets are allowed in offered apartment, false otherwise.
     */
    private MutableLiveData<Boolean> petsOffered;

    /**
     * True if wifi is included in wanted apartment, false otherwise.
     */
    private MutableLiveData<Boolean> wifiWanted;

    /**
     * True if electricity is included in wanted apartment, false otherwise.
     */
    private MutableLiveData<Boolean> electricityWanted;

    /**
     * True if pets are allowed in wanted apartment, false otherwise.
     */
    private MutableLiveData<Boolean> petsWanted;

    /**
     * True if balcony is included in wanted apartment, false otherwise.
     */
    private MutableLiveData<Boolean> balconyWanted;



    /**
     * The constructor for AdViewModel
     * @param application
     * @param savedStateHandle
     */
    public AdViewModel(@NonNull Application application,
                       @NonNull SavedStateHandle savedStateHandle) {
        super(application);
        repository = ((ChangeItApp) application).getRepository();

        descriptionOffered = new MutableLiveData<>();
        descriptionWanted = new MutableLiveData<>();

        rentOffered = new MutableLiveData<>();
        rentWanted = new MutableLiveData<>();

        roomsOffered = new MutableLiveData<>();
        roomsWanted = new MutableLiveData<>();

        sqmOffered = new MutableLiveData<>();
        sqmWanted = new MutableLiveData<>();

        balconyOffered = new MutableLiveData<>(false);
        wifiOffered = new MutableLiveData<>(false);
        electricityOffered = new MutableLiveData<>(false);
        petsOffered = new MutableLiveData<>(false);

        addressOffered = new MutableLiveData<>();

        balconyWanted = new MutableLiveData<>(false);
        wifiWanted = new MutableLiveData<>(false);
        electricityWanted = new MutableLiveData<>(false);
        petsWanted = new MutableLiveData<>(false);

        pictures = new MutableLiveData<>(Arrays.asList(AppUtil.uriFromResourceId(application.getResources(), R.drawable.apartment_example)));

    }

    public MutableLiveData<String> getAddressOffered() {
        return addressOffered;
    }


    public void setAddressOffered(MutableLiveData<String> addressOffered) {
        this.addressOffered = addressOffered;
    }

    //Listan krånglar (?) TODO - ?
    /**
     * saveApartment() saves all specifics that are filled in when creating an ad and add the apartment
     * to the list of apartments.
     */

    public void saveApartment() {
        Apartment apartment = new Apartment(parseInt(rentOffered.getValue()),
                parseInt(roomsOffered.getValue()),
                parseInt(sqmOffered.getValue()),
                wifiOffered.getValue(),
                petsOffered.getValue(),
                balconyOffered.getValue(),
                electricityOffered.getValue(),
                descriptionOffered.getValue(),
                addressOffered.getValue());

        Advertisement advertisement = new Advertisement(new Random().nextInt(),
                apartment,
                pictures.getValue(),
                parseInt(rentWanted.getValue()),
                parseInt(roomsWanted.getValue()),
                parseInt(sqmWanted.getValue()),
                userhandler.getCurrentUser(), balconyWanted.getValue(),
                electricityWanted.getValue(),
                wifiWanted.getValue(),
                petsWanted.getValue());

        repository.addAdvertisement(advertisement);

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
    public void setPictures(List<Uri> pictures) {
        this.pictures.setValue(pictures);
    }

    //Listan krånglar (?)

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

    public MutableLiveData<Boolean> getWifiWanted() {
        return wifiWanted;
    }

    public void setWifiWanted(MutableLiveData<Boolean> wifiWanted) {
        this.wifiWanted = wifiWanted;
    }

    public MutableLiveData<Boolean> getElectricityWanted() {
        return electricityWanted;
    }

    public void setElectricityWanted(MutableLiveData<Boolean> electricityWanted) {
        this.electricityWanted = electricityWanted;
    }

    public MutableLiveData<Boolean> getPetsWanted() {
        return petsWanted;
    }

    public void setPetsWanted(MutableLiveData<Boolean> petsWanted) {
        this.petsWanted = petsWanted;
    }

    public MutableLiveData<Boolean> getBalconyWanted() {
        return balconyWanted;
    }

    public void setBalconyWanted(MutableLiveData<Boolean> balconyWanted) {
        this.balconyWanted = balconyWanted;
    }
}
