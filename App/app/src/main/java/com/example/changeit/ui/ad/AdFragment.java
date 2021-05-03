package com.example.changeit.ui.ad;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentAdBinding;

import java.net.URI;
import java.util.List;


public class AdFragment extends Fragment {

    // Databinding motavarar allt vi ser i fragment_ad.xml
    private FragmentAdBinding binding;

    private AdViewModel adViewModel;
    private List<Uri> pictures;
    ActivityResultLauncher<String> getPicture = registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> result) {
            Log.i("waaow", "onActivityResult: ");
            result.stream().forEach(uri -> Log.i("tagged", String.format("image %s", uri.toString())));

            binding.apartmentImage.setImageURI(Uri.parse(result.get(0).toString()));
        }
    });

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
                Log.i("waow", adViewModel.getDescriptionOffered().getValue());
                NavDirections action = AdFragmentDirections.actionAdToCreateAdP2Fragment();
                Navigation.findNavController(v).navigate(action);
            }
        });

        binding.apartmentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPicture.launch("image/*");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}