package com.example.changeit.ui.home;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.changeit.R;
import com.example.changeit.model.Apartment;

public class DetailedApartmentViewModel extends ViewModel {
    private MutableLiveData<String> mTextRoom, mTextSqm, mTextRent, mTextOwner, mTextRoomLookingFor, mTextSqmLookingFor, mTextRentLookingFor;

    private ImageView detailedApartmentView;

    public DetailedApartmentViewModel(Apartment apartment) {
        mTextRent = new MutableLiveData<>();
        mTextRent.setValue(Integer.toString(apartment.getRent()));
        mTextRoom = new MutableLiveData<>();
        mTextRoom.setValue(Integer.toString(apartment.getRooms()));
        mTextSqm = new MutableLiveData<>();
        mTextSqm.setValue(Integer.toString(apartment.getSqm()));
        mTextOwner = new MutableLiveData<>();
        mTextOwner.setValue(apartment.getOwner()+"'s apartment");

        //dessa tre ska fixas när vi gör "skapa annons (söker)"
        mTextRentLookingFor = new MutableLiveData<>();
        mTextRentLookingFor.setValue("R");
        mTextRoomLookingFor = new MutableLiveData<>();
        mTextRoomLookingFor.setValue("R");
        mTextSqmLookingFor = new MutableLiveData<>();
        mTextSqmLookingFor.setValue("R");



        detailedApartmentView.setImageResource(R.drawable.apartment_example); //ska ej vara exemplet föralltid
    }

    public LiveData<String> getTextRoom() {
        return mTextRoom;
    }
    public  LiveData<String> getTextOwner(){ return mTextOwner;}
    public LiveData<String> getTextRent() {
        return mTextRent;
    }

    public LiveData<String> getTextSqm() {
        return mTextSqm;
    }

    public ImageView getImage(){
        return detailedApartmentView;
    }
}