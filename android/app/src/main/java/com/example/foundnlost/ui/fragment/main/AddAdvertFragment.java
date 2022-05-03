package com.example.foundnlost.ui.fragment.main;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.foundnlost.R;
import com.example.foundnlost.commons.AdvertType;
import com.example.foundnlost.databinding.AddAdvertDialogBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.viewModel.AddAdvertDialogViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.textfield.TextInputLayout;

public class AddAdvertFragment extends FlowFragment {

    private AddAdvertDialogViewModel viewModel;
    private AddAdvertDialogBinding binding;
    private AdvertType whichCheckbox;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AddAdvertDialogBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(AddAdvertDialogViewModel.class);
        binding.closeButton.setOnClickListener(
                view -> new AlertDialog.Builder(requireContext())
                        .setMessage(getString(R.string.cancel_adding_confirm))
                        .setPositiveButton(getString(R.string.confirm), (dialog, arg1) -> {
                            dialog.cancel();
                            requireActivity().onBackPressed();
                        })
                        .setNegativeButton(getString(R.string.cancel), null)
                        .show());

        binding.foundRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                whichCheckbox = AdvertType.FOUND;
                binding.lostRadioButton.setChecked(false);
            }
        });
        binding.lostRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                whichCheckbox = AdvertType.LOST;
                binding.foundRadioButton.setChecked(false);
            }
        });
        return binding.getRoot();
    }
}