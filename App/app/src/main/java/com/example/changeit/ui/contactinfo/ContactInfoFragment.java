package com.example.changeit.ui.contactinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentContactinfoBinding;
import com.example.changeit.model.User;

/**
 * logic for the contact info view.
 * @author Marcus Randevik, Moa Berglund, Izabell Arvidsson
 * @since 2021-03-22
 */
public class ContactInfoFragment extends Fragment {
    /**
     * Sets the user to show contact info about to the user that is sent from the detailed apartment view (button contact owner)
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        User user = ContactInfoFragmentArgs.fromBundle(getArguments()).getUser();
        FragmentContactinfoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contactinfo, container, false);
        binding.setUser(user);

        return binding.getRoot();
    }
}