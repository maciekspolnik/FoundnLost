package com.example.foundnlost.ui.fragment.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.foundnlost.R;
import com.example.foundnlost.data.network.dto.Resource;
import com.example.foundnlost.databinding.FragmentLoginBinding;
import com.example.foundnlost.ui.activity.MainActivity;
import com.example.foundnlost.ui.fragment.FlowFragment;
import com.example.foundnlost.ui.fragment.dialog.ForgotPasswordDialog;
import com.example.foundnlost.util.Const;
import com.example.foundnlost.util.TextChangedWatcher;
import com.example.foundnlost.util.ValidationUtil;
import com.example.foundnlost.viewModel.LoginViewModel;
import com.example.foundnlost.viewModel.factory.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends FlowFragment {

    private LoginViewModel viewModel;
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireContext())).get(LoginViewModel.class);
        binding.loginButton.setOnClickListener(view -> onLoginClicked());

        binding.appHeader.setBackClickedListener(view -> requireActivity().onBackPressed());
        binding.forgotPasswordTextButton.setOnClickListener(view -> new ForgotPasswordDialog().
                show(requireActivity().getSupportFragmentManager(), Const.EMPTY_STRING));

        binding.loginEmailEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> isNotEmpty(binding.loginEmailTextInputLayout)));
        binding.loginPasswordEditText.addTextChangedListener(new TextChangedWatcher((s, start, before, count) -> isNotEmpty(binding.loginPasswordTextInputLayout)));

        return binding.getRoot();
    }

    private void onLoginClicked() {
        if (isNotEmpty(binding.loginEmailTextInputLayout)
                && isNotEmpty(binding.loginPasswordTextInputLayout)
                && ValidationUtil.isEmailValid(extractText(binding.loginEmailTextInputLayout))) {
            viewModel.setLoginDetails(extractText(binding.loginEmailTextInputLayout), extractText(binding.loginPasswordTextInputLayout));
            viewModel.login().observe(getViewLifecycleOwner(), this::handleResponse);
        }
    }

    private void handleResponse(Resource<String> response) {




        switch ((response.getMessage())) {
            case "SUCCESS":
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                return;
            case "UNAUTHORISED":
                binding.loginEmailTextInputLayout.setError(" ");
                binding.loginPasswordTextInputLayout.setError(getString(R.string.wrong_login_credentials));
                return;
            default:
                Snackbar.make(requireView(), getText(R.string.error_api), Snackbar.LENGTH_LONG).show();

        }
    }
}