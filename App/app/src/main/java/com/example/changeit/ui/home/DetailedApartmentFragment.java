package com.example.changeit.ui.home;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.changeit.R;
import com.example.changeit.databinding.DetailedApartmentBinding;
import com.example.changeit.model.Apartment;
/**
 * Represents the view that shows detailed information about an apartment
 *   @author Izabell Arvidsson, Marcus Randevik, Moa Berglund, Amanda Styff
 *   @since 2021-04-20
 *
 */
public class DetailedApartmentFragment extends Fragment {

    public static DetailedApartmentFragment newInstance() {
        return new DetailedApartmentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Apartment apartment = DetailedApartmentFragmentArgs.fromBundle(getArguments()).getApartment();

        // Denna bindingklassen motsvarar allt som finns i detailed_apartment.xml
        DetailedApartmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.detailed_apartment, container, false);

        binding.setOwnerApartment(apartment);
        binding.setOwnerLookingForApartment(apartment);

        binding.detailedApartmentImageViewpager.setAdapter(new ApartmentImageViewAdapter());

        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}