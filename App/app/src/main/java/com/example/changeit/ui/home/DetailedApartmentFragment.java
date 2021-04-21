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


        final ImageView imageview = root.findViewById(R.id.apartment_image_detailed);
        imageview.setImageDrawable(mViewModel.getImage().getDrawable());


        final TextView textView = root.findViewById(R.id.textViewTest);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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