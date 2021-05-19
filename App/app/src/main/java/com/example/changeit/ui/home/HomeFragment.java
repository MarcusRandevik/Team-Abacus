package com.example.changeit.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentHomeBinding;

/**
 * logic for the start(home) page
 * has a homeViewModel to be able to get all saved advertisements and to connect the filters
 * has a apartmentAdapter for the logic connected to the advertisement list
 * has a fragmentHomeBinding to connect to the xml file
 *
 * @author Marcus Randevik. Edited by Izabell Arvidsson, Moa Berglund
 * @since 2021-03-22
 */

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private FragmentHomeBinding fragmentHomeBinding;

    private ApartmentAdapter apartmentAdapter;

    /**
     * Shows a list of advertisements that is able to click on and navigate to a detailed information view
     * The list is able to filter
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        apartmentAdapter = new ApartmentAdapter(advertisement -> {
            Navigation.findNavController(fragmentHomeBinding.getRoot())
                  .navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetailedApartment(advertisement.getId()));
        }, advertisement -> {
            AsyncTask.execute(() -> homeViewModel.changeFavourite(advertisement));
        });

        fragmentHomeBinding.floatingActionButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavigationHomeToListFilterFragment());
        });

        fragmentHomeBinding.apartmentList.setAdapter(apartmentAdapter);

        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Updates the list of advertisements when new ads is created
        homeViewModel.getAdvertisements().observe(getViewLifecycleOwner(), advertisements -> {
            apartmentAdapter.setAdvertisements(advertisements);
        });
    }
}