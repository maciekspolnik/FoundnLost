package com.example.foundnlost.ui.fragment.authorisation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.R;
import com.example.foundnlost.databinding.FragmentRegisterBinding;
import com.example.foundnlost.ui.activity.StartActivity;
import com.example.foundnlost.util.TextChangedWatcher;
import com.example.foundnlost.viewModel.RegisterViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    private RegisterViewModel viewModel;
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory(requireContext())).get(RegisterViewModel.class);

        binding.appHeader3.setBackClickedListener(view -> requireActivity().onBackPressed());
        binding.registerNextButton.setOnClickListener(view -> {
            viewModel.setLoginDetails(
                    extractText(binding.registerEmailInputLayout),
                    extractText(binding.registerPasswordInputLayout));
            ((StartActivity) requireActivity()).displayFragment(new RegisterDetailsFragment());
        });

        binding.registerEmailEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> validateLength(binding.registerEmailInputLayout)));
        binding.registerPasswordEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> validateLength(binding.registerPasswordInputLayout)));
        binding.registerPasswordConfirmEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> validateLength(binding.registerPasswordConfirmInputLayout)));

        return binding.getRoot();
    }

    private String extractText(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText() != null) {
            return textInputLayout.getEditText().getText().toString();
        }
        return "";
    }

    private boolean validateLength(TextInputLayout layout) {
        if (extractText(layout).isEmpty()) {
            layout.setError(getText(R.string.field_cannot_be_empty));
            return false;
        }
        layout.setError(null);
        return true;
    }
}