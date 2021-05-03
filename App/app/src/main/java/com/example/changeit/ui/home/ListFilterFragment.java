package com.example.changeit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentFilterBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.slider.Slider;

/**
 * Skriv javadoc!!
 */
public class ListFilterFragment extends BottomSheetDialogFragment {

    private HomeViewModel homeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        FragmentFilterBinding fragmentFilterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false);

        fragmentFilterBinding.slider.setValue(homeViewModel.getMaxRooms());

        fragmentFilterBinding.slider.addOnChangeListener((slider, value, fromUser) -> {
            homeViewModel.setMaxRooms(Math.round(value));
        });

        fragmentFilterBinding.sliderRent.setValue(homeViewModel.getMaxRent());

        fragmentFilterBinding.sliderRent.addOnChangeListener((slider, value, fromUser) -> {
            homeViewModel.setMaxRent(Math.round(value));
        });

        fragmentFilterBinding.sliderSqm.setValue(homeViewModel.getMaxSqm());

        fragmentFilterBinding.sliderSqm.addOnChangeListener((slider, value, fromUser) -> {
            homeViewModel.setMaxSqm(Math.round(value));
        });


        return fragmentFilterBinding.getRoot();
    }
}
