package com.example.changeit.ui.ad;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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

import com.example.changeit.AppRepository;
import com.example.changeit.ChangeItApp;
import com.example.changeit.R;
import com.example.changeit.ui.profile.ProfileFragmentDirections;
import com.example.changeit.ui.profile.ProfileViewModel;

public class CreateAdP2Fragment extends Fragment {



    private CreateAdP2ViewModel mViewModel;

   /* public static CreateAdP2Fragment newInstance() {
        return new CreateAdP2Fragment();
    }

    */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CreateAdP2ViewModel.class);

        mViewModel =
                new ViewModelProvider(this).get(CreateAdP2ViewModel.class);
        View root = inflater.inflate(R.layout.create_ad_p2_fragment, container, false);

        Button publishButton =  root.findViewById(R.id.publishButton);
        publishButton.setOnClickListener(new View.OnClickListener(){

            /**
             * Publish the newly created apartment.
             * @param v
             */
            @Override
            public void onClick(View v) {
                AppRepository repository = ((ChangeItApp)getActivity().getApplication()).getRepository();
               // repository.addAppartment();
            }
        });


        /*final TextView textView = root.findViewById(R.id.text_profile);
        mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CreateAdP2ViewModel.class);
    }

}