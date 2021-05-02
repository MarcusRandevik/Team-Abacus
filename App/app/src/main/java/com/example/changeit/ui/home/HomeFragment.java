package com.example.changeit.ui.home;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private FragmentHomeBinding fragmentHomeBinding;

    private ApartmentAdapter apartmentAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        apartmentAdapter = new ApartmentAdapter(advertisement -> {

            Navigation.findNavController(fragmentHomeBinding.getRoot())
                  .navigate(HomeFragmentDirections.actionNavigationHomeToNavigationDetailedApartment(advertisement));
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


        homeViewModel.getAdvertisements().observe(getViewLifecycleOwner(), advertisements -> {
            apartmentAdapter.setAdvertisements(advertisements);
            fragmentHomeBinding.apartmentList.setAdapter(apartmentAdapter);
        });
    }
}