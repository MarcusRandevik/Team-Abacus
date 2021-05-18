package com.example.changeit.ui.home;

import androidx.databinding.DataBindingUtil;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
import android.widget.Toast;

import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.databinding.DetailedApartmentBinding;
import com.example.changeit.model.Advertisement;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * Represents the view that shows detailed information about an advertisement
 *   @author Izabell Arvidsson, Marcus Randevik, Moa Berglund, Amanda Styff, Noa Tholén
 *   @since 2021-04-20
 *
 */
public class DetailedApartmentFragment extends Fragment {

    private DetailedApartmentBinding binding;

    private ClipData clipData;

    private ClipboardManager clipboardManager;


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

        binding = DataBindingUtil.inflate(inflater, R.layout.detailed_apartment, container, false);

        // We need to make database calls on a non-ui thread
        AsyncTask.execute(this::setupBindings);

        return binding.getRoot();
    }

    /**
     *
     * binding.contactbutton takes the user to where contact info about the owner
     *
     * binding.shareLinkFloatingButton copies the URL link
     *
     */
    private void setupBindings() {
        int advertisementId = DetailedApartmentFragmentArgs.fromBundle(getArguments()).getAdvertisement();

        Advertisement advertisement = ((ChangeItApp)getActivity().getApplication()).getRepository().getAdvertisementFromId(advertisementId);

        // Denna bindingklassen motsvarar allt som finns i detailed_apartment.xml

        binding.setAdvertisement(advertisement);

        binding.detailedApartmentImageViewpager.setAdapter(new ApartmentImageViewAdapter(advertisement.getPictures()));
        TabLayoutMediator mediator = new TabLayoutMediator(binding.imageTab, binding.detailedApartmentImageViewpager, true, (tab, position) -> {
            // We don't need to do anything, just need to link viewpager with tablayout
        });
        mediator.attach();
        binding.contactbutton.setOnClickListener(v -> {
            NavDirections action = DetailedApartmentFragmentDirections.actionNavigationDetailedApartmentToNavigationMessages(advertisement.getUser());
            Navigation.findNavController(v).navigate(action);
        });

        // Clipboardmanager cannot be created on a non-ui thread therefore we need this somewhat ugly fix
        getActivity().runOnUiThread(() -> {
            clipboardManager = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
            binding.shareLinkFloatingButton.setOnClickListener(v -> {
                String txtcopy = "https://www.changeit.com/advertisement/"+advertisementId;
                clipData = ClipData.newPlainText("text", txtcopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getContext(), "Link copied", Toast.LENGTH_SHORT).show();
            });
        });
    }
}
