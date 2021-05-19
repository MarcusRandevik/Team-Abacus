package com.example.changeit.ui.ad;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
/**
 * Fragment which is the first part of creating an advertisement. This includes what the user is offering
 *
 * @author Kerstin Wadman, Noa Tholén, Lisa Samuelsson, Moa Berglund, Izabell Arvidsson, Marcus Randevik, Amanda Styff
 * @since 2020-04-20
 */
public class AdFragment extends Fragment {
    /**
     * Data binding is used to combine the user input with the xml file.
     */
    private FragmentAdBinding binding;

    /**
     * An instance of AdViewModel
     */
    private AdViewModel adViewModel;

    ActivityResultLauncher<String> getPicture = registerForActivityResult(new ActivityResultContracts.GetMultipleContents(),
            new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> result) {
            adViewModel.setPictures(result);
            binding.apartmentImage.setImageURI(Uri.parse(result.get(0).toString()));
        }
    });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad, container, false);

        // Få en ny viewmodel som är vid "liv" så länge som detta fragment
        adViewModel = new ViewModelProvider(requireActivity()).get(AdViewModel.class);

        //Lägg till viewmodel i fragment_ad.xml
        binding.setViewModel(adViewModel);

         /* Checks if all the required fields are filled out. If not, a message will appear
         * asking the user to fill in all fields. If everything is filled out the user will be taken
         * to the next part of create ad.
         */
         binding.continueButton.setOnClickListener(v -> {
             if(adViewModel.getDescriptionOffered().getValue() == null || adViewModel.getDescriptionOffered().getValue().equals("")  ||
                     adViewModel.getRentOffered().getValue() == null  || adViewModel.getRentOffered().getValue().equals("") ||
             adViewModel.getRoomsOffered().getValue() == null || adViewModel.getRoomsOffered().getValue().equals("") ||
             adViewModel.getSqmOffered().getValue() == null || adViewModel.getSqmOffered().getValue().equals("") ||
             adViewModel.getAddressOffered().getValue() == null || adViewModel.getAddressOffered().equals(""))
                     {
                 Toast toast = Toast.makeText(getContext(),"Fill out all text fields to continue",
                         Toast.LENGTH_SHORT);
                 toast.show();
             }else {
                 NavDirections action = AdFragmentDirections.actionAdToCreateAdP2Fragment();
                 Navigation.findNavController(v).navigate(action);
             }
         });

        binding.apartmentImage.setOnClickListener(v -> getPicture.launch("image/*"));

        return binding.getRoot();
    }
}
