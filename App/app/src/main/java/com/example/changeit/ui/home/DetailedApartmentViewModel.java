package com.example.changeit.ui.home;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.changeit.R;
import com.example.changeit.model.Apartment;

public class DetailedApartmentViewModel extends ViewModel {
    private MutableLiveData<String> mTextRent, mTextSqm, mTextRoom, mTextOwner, mTextRoomLookingFor,
            mTextSqmLookingFor, mTextRentLookingFor;

    private ImageView detailedApartmentView;

    public DetailedApartmentViewModel() { // Tänkte skicka in Apartments
        mTextRent = new MutableLiveData<>();
        mTextRent.setValue(Integer.toString(3));

        mTextSqm = new MutableLiveData<>();
        mTextSqm.setValue(Integer.toString(3));

        mTextRoom = new MutableLiveData<>();
        mTextRoom.setValue(Integer.toString(3));

        mTextOwner = new MutableLiveData<>();
        mTextOwner.setValue("Lisa");

        //dessa tre ska fixas när vi gör "skapa annons (söker)"
        mTextRentLookingFor = new MutableLiveData<>();
        mTextRentLookingFor.setValue("R");
        mTextRoomLookingFor = new MutableLiveData<>();
        mTextRoomLookingFor.setValue("R");
        mTextSqmLookingFor = new MutableLiveData<>();
        mTextSqmLookingFor.setValue("R");




        //detailedApartmentView.setImageResource(R.drawable.apartment_example); //påbörjad lösning men fungerar ej
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