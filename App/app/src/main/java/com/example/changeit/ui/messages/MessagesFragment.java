package com.example.changeit.ui.messages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentMessagesBinding;
import com.example.changeit.model.Advertisement;
import com.example.changeit.model.User;
import com.example.changeit.ui.home.DetailedApartmentFragment;

/**
 * logic for the message view
 * @author Marcus Randevik, Moa Berglund, Izabell Arvidsson
 * @since 2021-03-22
 */
public class MessagesFragment extends Fragment {
    public static MessagesFragment newInstance() {
        return new MessagesFragment();
    }

    /**
     * Sets the user to chat with to the user that is sent from the detailed apartment view (button contact owner)
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        User user = MessagesFragmentArgs.fromBundle(getArguments()).getUser();
        FragmentMessagesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_messages, container, false);
        binding.setUser(user);

        return binding.getRoot();
    }
}