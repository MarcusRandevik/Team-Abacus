package com.example.changeit.ui.profile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentHomeBinding;
import com.example.changeit.databinding.FragmentMessagesBinding;
import com.example.changeit.databinding.FragmentProfileBinding;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;
import com.example.changeit.ui.home.AdvertisementClickCallback;
import com.example.changeit.ui.home.ApartmentAdapter;
import com.example.changeit.ui.home.HomeFragmentDirections;
import com.example.changeit.ui.home.HomeViewModel;
import com.example.changeit.ui.messages.MessagesFragmentArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * logic for the message view
 * @author Izabell Arvidsson, Amanda Styff, Kerstin Wadman, Moa Berglund, Lisa Samuelsson
 * @since 2021-04-13
 */

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    private ApartmentAdapter apartmentAdapter;

   // private final ProfileClickCallback profileClickCallback;

    private FragmentProfileBinding binding;


    /**
     * Sets the inlogged user to be the one to be shown in the profile view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        binding.setUser(UserHandler.getInstance().getCurrentUser());

        profileViewModel.getAdvertisements().observe(getViewLifecycleOwner(),advertisements -> {
            if(advertisements.size() > 0) {
                binding.setAdvertisement(advertisements.get(0));
                Advertisement advertisement = advertisements.get(0);
                binding.apartmentImage.setImageURI(advertisement.getPictures().get(0));

                binding.setCallback(advertisement1 -> {
                    Navigation.findNavController(binding.getRoot()).navigate(ProfileFragmentDirections.actionNavigationProfileToNavigationDetailedApartment(advertisement1.getId()));
                });

            binding.setFavouriteCallBack(advertisement1 -> profileViewModel.changeFavourite(advertisement1));
        }
        });



        AsyncTask.execute(() -> setUpBindings());
        return binding.getRoot();
    }

    public void setUpBindings(){
        FloatingActionButton button = binding.profilebutton;
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Navigates to the ad fragment when a user clicks on the button on the profile page.
             * @param v
             */
            @Override
            public void onClick(View v) {
                profileViewModel.getAdvertisements().observe(getViewLifecycleOwner(),advertisements -> {
                    if(advertisements.get(0) == null){
                        NavDirections action = ProfileFragmentDirections.actionNavigationProfileToAd();
                        Navigation.findNavController(v).navigate(action);
                    }
                    else {
                        Toast toast = Toast.makeText(getContext(),"You already have one advertisement",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

            }

        });

        binding.deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(()->profileViewModel.deleteUserAdvertisement());
            }
        });
    }

}
