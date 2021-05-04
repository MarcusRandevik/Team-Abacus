package com.example.changeit.ui.ad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.databinding.FragmentAdBinding;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.Apartment;
import com.example.changeit.ui.ad.AdFragmentDirections;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AdFragment extends Fragment {

    // Databinding motavarar allt vi ser i fragment_ad.xml
    private FragmentAdBinding binding;

    private AdViewModel adViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflatea med databinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad, container, false);

        // Få en ny viewmodel som är vid "liv" så länge som detta fragment
        adViewModel = new ViewModelProvider(requireActivity()).get(AdViewModel.class);

        //Lägg till viewmodel i fragment_ad.xml
        binding.setViewModel(adViewModel);


        /**
         * Checks if all the required fields are filled out. If not, a message will appear
         * asking the user to fill in all fields. If everything is filled out the user will be taken
         * to the next part of create ad.
         * @param v -
         */
         binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adViewModel.getDescriptionOffered().getValue() == null || adViewModel.getDescriptionOffered().getValue().equals("")  ||
                        adViewModel.getRentOffered().getValue() == null  || adViewModel.getRentOffered().getValue().equals("") ||
                adViewModel.getRoomsOffered().getValue() == null || adViewModel.getRoomsOffered().getValue().equals("") ||
                adViewModel.getSqmOffered().getValue() == null || adViewModel.getSqmOffered().getValue().equals(""))
                        {
                    Toast toast = Toast.makeText(getContext(),"Fill out all text fields to continue",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    NavDirections action = AdFragmentDirections.actionAdToCreateAdP2Fragment();
                    Navigation.findNavController(v).navigate(action);
                }
            }
        });

                //
        // Log.i("waow", "hej");
        // Log.i("waow", adViewModel.getDescriptionOffered().getValue());

        return binding.getRoot();
    }
}