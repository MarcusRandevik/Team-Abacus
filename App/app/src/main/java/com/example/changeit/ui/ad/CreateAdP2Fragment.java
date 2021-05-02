package com.example.changeit.ui.ad;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.databinding.CreateAdP2FragmentBinding;
import com.example.changeit.model.Apartment;
import com.example.changeit.ui.profile.ProfileFragmentDirections;
import com.example.changeit.ui.profile.ProfileViewModel;

public class CreateAdP2Fragment extends Fragment {



    private AdViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

                mViewModel =
                new ViewModelProvider(requireActivity()).get(AdViewModel.class);
        CreateAdP2FragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.create_ad_p2_fragment, container, false);

        binding.setViewModel(mViewModel);
        Button publishButton =  binding.publishButton;
        publishButton.setOnClickListener(new View.OnClickListener(){

            /**
             * Publish the newly created apartment.
             * @param v
             */
            @Override
            public void onClick(View v) {
                AsyncTask.execute(() -> {
                   // mViewModel.saveApartment();

                });
                Toast toast = Toast.makeText(getContext(),"Apartment saved", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(AdViewModel.class);
    }

}