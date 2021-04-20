package com.example.changeit.ui.ad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdViewModel extends ViewModel {

        private MutableLiveData<String> mText;

        public AdViewModel() {
            mText = new MutableLiveData<>();
            mText.setValue("This is ad fragment");
        }

        public LiveData<String> getText() {
            return mText;
        }

}
