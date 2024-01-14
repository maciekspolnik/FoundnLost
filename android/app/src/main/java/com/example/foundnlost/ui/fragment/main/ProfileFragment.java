package com.example.foundnlost.ui.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.databinding.FragmentProfileBinding;
import com.example.foundnlost.ui.activity.MainActivity;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.ChangeProfileDataDialog;
import com.example.foundnlost.util.Const;
import com.example.foundnlost.viewModel.ProfileViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class ProfileFragment extends FlowFragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(ProfileViewModel.class);

        binding.editDataButton.setOnClickListener(view -> new ChangeProfileDataDialog().show(requireActivity().getSupportFragmentManager(), Const.EMPTY_STRING));
        binding.aboutAppButton.setOnClickListener(view -> onFragmentChangeRequestListener.onFragmentChangeRequest(new AboutFragment()));

        binding.logoutButton.setOnClickListener(view -> {
            ((MainActivity) requireActivity()).logout();
        });

        return binding.getRoot();
    }
}