package com.example.changeit.ui.home;

import com.example.changeit.model.Apartment;

@FunctionalInterface
public interface ApartmentClickCallback {

    void onClick(Apartment apartment);
}
