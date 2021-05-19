package com.example.changeit.ui.profile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentProfileBinding;
import com.example.changeit.model.UserHandler;

/**
 * logic for the profile view
 * @author Izabell Arvidsson, Amanda Styff, Kerstin Wadman, Moa Berglund, Lisa Samuelsson
 * @since 2021-04-13
 */
public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    private FragmentProfileBinding binding;


    /**
     * Sets the logged in user to be the one to be shown in the profile view
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

        profileViewModel.getAdvertisement().observe(getViewLifecycleOwner(),advertisement -> {
            if(advertisement!=null) {
                binding.materialCardView.setVisibility(View.VISIBLE);
                binding.setAdvertisement(advertisement);
                binding.apartmentImage.setImageURI(advertisement.getPictures().get(0));
                binding.deletebutton.setVisibility(View.VISIBLE);
                binding.setCallback(advertisement1 -> {
                    Navigation.findNavController(binding.getRoot()).navigate(ProfileFragmentDirections.actionNavigationProfileToNavigationDetailedApartment(advertisement1.getId()));
                });

                binding.setFavouriteCallBack(advertisement1 -> AsyncTask.execute(() -> profileViewModel.changeFavourite(advertisement1)));
            }
        });


        AsyncTask.execute(() -> setUpBindings());
        return binding.getRoot();
    }

    public void setUpBindings(){
        //shows the advertisement card created by the logged in user in his profile

        //Navigates to the ad fragment when a user clicks on the "+" button on the profile page, only if the user does not already has an advertisement.
        binding.profilebutton.setOnClickListener(v -> profileViewModel.getAdvertisement().observe(getViewLifecycleOwner(), advertisements -> {
            if(advertisements == null){
                NavDirections action = ProfileFragmentDirections.actionNavigationProfileToAd();
                Navigation.findNavController(v).navigate(action);
            }
            else {
                Toast toast = Toast.makeText(getContext(),"You already have one advertisement",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }));

        //asks a confirm question with yes/no-buttons when trying to delete your advertisement
        binding.deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.deleteno.setVisibility(View.VISIBLE);
                binding.deleteyes.setVisibility(View.VISIBLE);
                binding.deleteQuestion.setVisibility(View.VISIBLE);
            }
        });
        //deletes the advertisement if clicked "yes" after the confirm question
        binding.deleteyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(()->profileViewModel.deleteUserAdvertisement());
                binding.deleteno.setVisibility(View.INVISIBLE);
                binding.deleteyes.setVisibility(View.INVISIBLE);
                binding.materialCardView.setVisibility(View.INVISIBLE);
                binding.deletebutton.setVisibility(View.INVISIBLE);
                binding.deleteQuestion.setVisibility(View.INVISIBLE);

            }
        });

        //if the user chose not to delete the confirm question and yes/no-buttons disappears
        binding.deleteno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.deleteno.setVisibility(View.INVISIBLE);
                binding.deleteyes.setVisibility(View.INVISIBLE);
                binding.deleteQuestion.setVisibility(View.INVISIBLE);
            }
        });
    }

}
