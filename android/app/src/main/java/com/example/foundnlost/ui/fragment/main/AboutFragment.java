package com.example.foundnlost.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.foundnlost.databinding.AboutFragmentBinding;

public class AboutFragment extends Fragment {

    private AboutFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AboutFragmentBinding.inflate(inflater, container, false);
        binding.appHeader3.setBackClickedListener(view -> requireActivity().onBackPressed());
        return binding.getRoot();
    }

}