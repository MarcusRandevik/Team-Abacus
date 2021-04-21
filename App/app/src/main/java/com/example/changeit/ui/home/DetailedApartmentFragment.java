package com.example.changeit.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.changeit.R;

public class DetailedApartmentFragment extends Fragment {

    private DetailedApartmentViewModel mViewModel;

    public static DetailedApartmentFragment newInstance() {
        return new DetailedApartmentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(DetailedApartmentViewModel.class);
        View root = inflater.inflate(R.layout.detailed_apartment, container, false);


        final ImageView imageview = root.findViewById(R.id.apartment_image_detailed); //denna är inte med i observe
        imageview.setImageDrawable(mViewModel.getImage().getDrawable());


        final TextView textViewRooms = root.findViewById(R.id.textViewRooms);
        mViewModel.getTextRoom().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewRooms.setText(s);
            }
        });

        final TextView textViewSqm = root.findViewById(R.id.textViewSqm);
        mViewModel.getTextSqm().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewSqm.setText(s);
            }
        });

        final TextView textViewOwner = root.findViewById(R.id.textViewOwner);
        mViewModel.getTextOwner().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewOwner.setText(s+"'s apartment");
            }
        });


        final TextView textViewRent = root.findViewById(R.id.textViewRent);
        mViewModel.getTextRent().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewRent.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailedApartmentViewModel.class);
        // TODO: Use the ViewModel
    }

}