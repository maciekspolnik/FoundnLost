package com.example.foundnlost.ui.fragment.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.databinding.FragmentRegisterBinding;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.util.TextChangedWatcher;
import com.example.foundnlost.viewModel.RegisterViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;

public class RegisterFragment extends FlowFragment {

    private RegisterViewModel viewModel;
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity(), new ViewModelFactory(requireContext())).get(RegisterViewModel.class);

        binding.registerAppHeader.setBackClickedListener(view -> requireActivity().onBackPressed());
        binding.registerNextButton.setOnClickListener(view -> {
            if (!isNotEmpty(binding.registerEmailInputLayout) || !isValidPassword())
                viewModel.setLoginDetails(
                        extractText(binding.registerEmailInputLayout),
                        extractText(binding.registerPasswordInputLayout));
            onFragmentChangeRequestListener.onFragmentChangeRequest(new RegisterDetailsFragment());
        });

        binding.registerEmailEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> isNotEmpty(binding.registerEmailInputLayout)));
        binding.registerPasswordEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> isNotEmpty(binding.registerPasswordInputLayout)));
        binding.registerPasswordConfirmEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> isNotEmpty(binding.registerPasswordConfirmInputLayout)));

        return binding.getRoot();
    }

    private boolean isValidPassword() {
        if (!isNotEmpty(binding.registerPasswordInputLayout)) {
            return false;
        }
        if (!isNotEmpty(binding.registerPasswordConfirmInputLayout)) {
            return false;
        }
        return extractText(binding.registerPasswordInputLayout).equals(extractText(binding.registerPasswordConfirmInputLayout));
    }
}