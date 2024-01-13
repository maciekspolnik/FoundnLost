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
import com.example.foundnlost.data.network.dto.AdvertDto;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.databinding.DialogAddAdvertBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.DatePickingDialog;
import com.example.foundnlost.util.Const;
import com.example.foundnlost.viewModel.AddAdvertDialogViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

public class AddAdvertFragment extends FlowFragment {

    private AddAdvertDialogViewModel viewModel;
    private DialogAddAdvertBinding binding;
    private String whichCheckbox = Const.EMPTY_STRING;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogAddAdvertBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(AddAdvertDialogViewModel.class);

        binding.closeButton.setOnClickListener(view -> showConfirmationAlert());
        binding.dateButton.setOnClickListener(view -> showDatePickingDialog());

        binding.foundRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                whichCheckbox = "FOUND";
                binding.lostRadioButton.setChecked(false);
            }
        });
        binding.lostRadioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                whichCheckbox = "LOST";
                binding.foundRadioButton.setChecked(false);
            }
        });

        binding.saveAdvertButton.setOnClickListener(view -> {
            if(whichCheckbox.isEmpty()){
                return;
            }
            viewModel.setData(
                    whichCheckbox,
                    extractText(binding.titleInputLayout),
                    extractText(binding.descInputLayout),
                    extractText(binding.dateInputLayout),
                    extractText(binding.locationInputLayout)
            );
            viewModel.addNewAdvert().observe(getViewLifecycleOwner(), this::consumeResponse);
        });


        return binding.getRoot();
    }

    private void consumeResponse(Resource<AdvertDto> response) {
        if(response.getMessage().equals("SUCCESS")){
            requireActivity().onBackPressed();
        }
    }

    private void showConfirmationAlert() {
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