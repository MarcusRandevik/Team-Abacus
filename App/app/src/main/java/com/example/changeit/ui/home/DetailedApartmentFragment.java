package com.example.changeit.ui.home;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.changeit.R;
import com.example.changeit.databinding.DetailedApartmentBinding;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;
import com.example.changeit.ui.ad.AdFragmentDirections;
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

        binding.detailedApartmentImageViewpager.setAdapter(new ApartmentImageViewAdapter(advertisement.getPictures()));
        TabLayoutMediator mediator = new TabLayoutMediator(binding.imageTab, binding.detailedApartmentImageViewpager, true, (tab, position) -> {
            // We don't need to do anything, just need to link viewpager with tablayout
        });
        mediator.attach();
        binding.contactbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = DetailedApartmentFragmentDirections.actionNavigationDetailedApartmentToNavigationMessages(UserHandler.getInstance().getCurrentUser()); //här ska inte currentuser skickas in (det är den inloggade) utan den usern som äger lägenheten du är inne på
                Navigation.findNavController(v).navigate(action);
            }
        });
        return binding.getRoot();
    }

}