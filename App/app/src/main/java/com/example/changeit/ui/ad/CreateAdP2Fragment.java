package com.example.changeit.ui.ad;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.changeit.R;
import com.example.changeit.databinding.CreateAdP2FragmentBinding;
import com.example.changeit.databinding.FragmentProfileBinding;

/**
 * @author Noa Tholén, Izabell Arvidsson,  Amanda Styff, Lisa Samuelsson
 * @since 2020-04-26
 * Fragment which is the second part of creating an advertisement. This includes what the user is searching for.
 */
public class CreateAdP2Fragment extends Fragment {

    private AdViewModel mViewModel;
    private FragmentProfileBinding profileBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

                mViewModel =
                new ViewModelProvider(requireActivity()).get(AdViewModel.class);
        CreateAdP2FragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.create_ad_p2_fragment, container, false);

        profileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);

        binding.setViewModel(mViewModel);
        Button publishButton =  binding.publishButton;
        publishButton.setOnClickListener(new View.OnClickListener(){


            /* Checks if all the required fields are filled out. If not, a message will appear
             asking the user to fill in all fields. If everything is filled out the ad is saved and added to the
             list of apartments
             */
            @Override
            public void onClick(View v) {

                if(mViewModel.getRentWanted().getValue() == null || mViewModel.getRentWanted().getValue().equals("") ||
                        mViewModel.getRoomsWanted().getValue() == null || mViewModel.getRoomsWanted().getValue().equals("")||
                        mViewModel.getSqmWanted().getValue() == null || mViewModel.getSqmWanted().getValue().equals("")){
                    Toast toast = Toast.makeText(getContext(),"Fill out all text fields to continue",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    AsyncTask.execute(() -> {
                        mViewModel.saveApartment();
                    });
                    NavDirections action = CreateAdP2FragmentDirections.actionCreateAdP2FragmentToNavigationProfile();
                    profileBinding.materialCardView.setVisibility(View.VISIBLE);
                    profileBinding.deletebutton.setVisibility(View.VISIBLE);
                    Navigation.findNavController(v).navigate(action);
                    Toast toast = Toast.makeText(getContext(), "Apartment saved", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        return binding.getRoot();
    }

    //Makes sure that the view model is still active while being on this fragment.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(AdViewModel.class);
    }
}
