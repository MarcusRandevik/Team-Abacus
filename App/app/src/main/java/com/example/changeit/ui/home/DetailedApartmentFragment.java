package com.example.changeit.ui.home;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.changeit.R;
import com.example.changeit.databinding.DetailedApartmentBinding;
import com.example.changeit.model.Apartment;

public class DetailedApartmentFragment extends Fragment {

    private DetailedApartmentViewModel mViewModel;

    public static DetailedApartmentFragment newInstance() {
        return new DetailedApartmentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Apartment apartment = DetailedApartmentFragmentArgs.fromBundle(getArguments()).getApartment();

        // Denna bindingklassen motsvarar allt som finns i detailed_apartment.xml
        DetailedApartmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.detailed_apartment, container, false);

        binding.setApartment(apartment);
        binding.setMyAppartment(apartment);
        binding.apartmentImageDetailed.setImageResource(R.drawable.apartment_example);

        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailedApartmentViewModel.class);
        // TODO: Use the ViewModel
    }

}