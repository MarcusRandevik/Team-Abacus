package com.example.changeit.ui.home;

import com.example.changeit.model.Advertisement;

@FunctionalInterface
public interface AdvertisementClickCallback {

    void onClick(Advertisement advertisement);
}
