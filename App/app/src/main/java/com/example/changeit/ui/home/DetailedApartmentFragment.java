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
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * Represents the view that shows detailed information about an advertisement
 *   @author Izabell Arvidsson, Marcus Randevik, Moa Berglund, Amanda Styff
 *   @since 2021-04-20
 *
 */
public class DetailedApartmentFragment extends Fragment {

    public static DetailedApartmentFragment newInstance() {
        return new DetailedApartmentFragment();
    }

    /**
     * sets the advertisement to show detailed information about to the one that is sent from the home page list
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Advertisement advertisement = DetailedApartmentFragmentArgs.fromBundle(getArguments()).getAdvertisement();

        // Denna bindingklassen motsvarar allt som finns i detailed_apartment.xml
        DetailedApartmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.detailed_apartment, container, false);

        binding.setAdvertisement(advertisement);

        binding.detailedApartmentImageViewpager.setAdapter(new ApartmentImageViewAdapter());
        TabLayoutMediator mediator = new TabLayoutMediator(binding.imageTab, binding.detailedApartmentImageViewpager, true, (tab, position) -> {
            // We don't need to do anything, just need to link viewpager with tablayout
        });
        mediator.attach();

        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}