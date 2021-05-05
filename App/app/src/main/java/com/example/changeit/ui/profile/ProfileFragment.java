package com.example.changeit.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentMessagesBinding;
import com.example.changeit.databinding.FragmentProfileBinding;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;
import com.example.changeit.ui.messages.MessagesFragmentArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/**
 * logic for the message view
 * @author Izabell Arvidsson, Amanda Styff, Kerstin Wadman, Moa Berglund, Lisa Samuelsson
 * @since 2021-04-13
 */
public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    /**
     * Sets the inlogged user to be the one to be shown in the profile view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        binding.setUser(UserHandler.getInstance().getCurrentUser());

        FloatingActionButton button = binding.profilebutton;
        button.setOnClickListener(new View.OnClickListener() {

            /**
             * Navigates to the ad fragment when a user clicks on the button on the profile page.
             * @param v
             */
            @Override
            public void onClick(View v) {
                NavDirections action = ProfileFragmentDirections.actionNavigationProfileToAd();
                Navigation.findNavController(v).navigate(action);
            }
        });
        return binding.getRoot();
    }
}
