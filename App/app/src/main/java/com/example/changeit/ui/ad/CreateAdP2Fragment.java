package com.example.changeit.ui.ad;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.changeit.R;
import com.example.changeit.ui.profile.ProfileViewModel;

public class CreateAdP2Fragment extends Fragment {

    private CreateAdP2ViewModel mViewModel;


    public static CreateAdP2Fragment newInstance() {
        return new CreateAdP2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CreateAdP2ViewModel.class);

        mViewModel =
                new ViewModelProvider(this).get(CreateAdP2ViewModel.class);
        View root = inflater.inflate(R.layout.create_ad_p2_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        /*Lägg till viewmodel i fragment_ad.xml
        binding.setViewModel(mViewModel);
        return inflater.inflate(R.layout.create_ad_p2_fragment, container, false);

         */
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateAdP2ViewModel.class);
        // TODO: Use the ViewModel
    }

}