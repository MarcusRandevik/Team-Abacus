package com.example.changeit.ui.home;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.changeit.R;

public class DetailedApartmentViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    private ImageView detailedApartmentView;

    public DetailedApartmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Detailed Test");
        detailedApartmentView.setImageResource(R.drawable.apartment_example);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ImageView getImage(){
        return detailedApartmentView;
    }
}