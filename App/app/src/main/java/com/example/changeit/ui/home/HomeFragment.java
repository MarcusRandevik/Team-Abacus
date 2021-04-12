package com.example.changeit.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentHomeBinding;
import com.example.changeit.model.Apartment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private FragmentHomeBinding fragmentHomeBinding;

    private ApartmentAdapter apartmentAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        apartmentAdapter = new ApartmentAdapter(apartment -> {
            Toast toast = Toast.makeText(getContext(), "Du öppnade lägenhet nr: " + apartment.getId(), Toast.LENGTH_SHORT);
            toast.show();
        });

        fragmentHomeBinding.apartmentList.setAdapter(apartmentAdapter);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        homeViewModel.getApartments().observe(getViewLifecycleOwner(), apartments -> {
            apartmentAdapter.setApartments(apartments);
            fragmentHomeBinding.apartmentList.setAdapter(apartmentAdapter);
        });
    }
}