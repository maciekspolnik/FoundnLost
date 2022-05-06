package com.example.foundnlost.ui.fragment.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.R;
import com.example.foundnlost.commons.AdvertType;
import com.example.foundnlost.databinding.DialogAddAdvertBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.DatePickingDialog;
import com.example.foundnlost.viewModel.AddAdvertDialogViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class AddAdvertFragment extends FlowFragment {

    private AddAdvertDialogViewModel viewModel;
    private DialogAddAdvertBinding binding;
    private AdvertType whichCheckbox;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogAddAdvertBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(AddAdvertDialogViewModel.class);

        binding.closeButton.setOnClickListener(view -> showConfirmationAlert());
        binding.dateButton.setOnClickListener(view -> showDatePickingDialog());

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

    private void showConfirmationAlert(){
        new AlertDialog.Builder(requireContext())
                .setMessage(getString(R.string.cancel_adding_confirm))
                .setPositiveButton(getString(R.string.confirm), (dialog, arg) -> {
                    dialog.cancel();
                    requireActivity().onBackPressed();
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }

    private void showDatePickingDialog() {
        DatePickingDialog dialog = new DatePickingDialog();
        dialog.setOnDismissListener(dialogInterface -> binding.dateEditText.setText(dialog.getDate()));
        dialog.show(requireActivity().getSupportFragmentManager(), "DatePickingDialog");
    }

}