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

import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.databinding.FragmentAdBinding;
import com.example.changeit.model.Apartment;
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


        // Lägga en onclick listener på continue
        binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("waow", "hej");
                Log.i("waow", adViewModel.getDescription().getValue());
                NavDirections action = AdFragmentDirections.actionAdToCreateAdP2Fragment();
                Navigation.findNavController(v).navigate(action);
            }
        });

        return binding.getRoot();
    }
}