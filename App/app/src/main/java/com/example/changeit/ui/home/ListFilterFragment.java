package com.example.changeit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.changeit.R;
import com.example.changeit.databinding.FragmentFilterBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ListFilterFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentFilterBinding fragmentFilterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false);
        return fragmentFilterBinding.getRoot();
    }
}
