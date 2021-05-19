package com.example.changeit.ui.favorites;

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
import com.example.changeit.databinding.FragmentFavoritesBinding;
import com.example.changeit.ui.home.AdvertisementAdapter;

/**
 * logic for the favorite view
 *
 * @author Marcus Randevik. Also edited by Izabell Arvidsson, Amanda Styff och Kerstin Wadman.
 * @since 2021-03-22
 */
public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;

    private FragmentFavoritesBinding binding;

    private AdvertisementAdapter advertisementAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);

        advertisementAdapter = new AdvertisementAdapter(advertisement -> {
            Navigation.findNavController(binding.getRoot()).navigate(FavoritesFragmentDirections.actionNavigationFavoritesToNavigationDetailedApartment(advertisement.getId()));
        }, advertisement -> {
            AsyncTask.execute(() -> favoritesViewModel.changeFavourite(advertisement));
        });

        binding.apartmentListFavourite.setAdapter(advertisementAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favoritesViewModel.getFavouriteAdvertisements().observe(getViewLifecycleOwner(), advertisements -> {
            advertisementAdapter.setAdvertisements(advertisements);
        });
    }

}