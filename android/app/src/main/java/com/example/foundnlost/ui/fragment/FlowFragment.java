package com.example.foundnlost.ui.fragment;

import androidx.fragment.app.Fragment;

import com.example.foundnlost.R;
import com.example.foundnlost.util.Const;
import com.example.foundnlost.util.ValidationUtil;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FlowFragment extends Fragment {

    protected OnFragmentChangeRequest onFragmentChangeRequestListener;

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentChangeRequestListener = null;
    }

    public void setOnFragmentChangeRequestListener(OnFragmentChangeRequest listener) {
        onFragmentChangeRequestListener = listener;
    }

    public interface OnFragmentChangeRequest {
        void onFragmentChangeRequest(Fragment fragment);
    }

    protected String extractText(TextInputLayout textInputLayout) {
        if (textInputLayout.getEditText() != null) {
            return textInputLayout.getEditText().getText().toString();
        }
        return Const.EMPTY_STRING;
    }

    protected boolean isNotEmpty(TextInputLayout layout) {
        if (extractText(layout).isEmpty()) {
            layout.setError(getText(R.string.field_cannot_be_empty));
            return false;
        }
        layout.setError(null);
        return true;
    }

    protected boolean isEmailValid(TextInputLayout layout) {
        if (extractText(layout).isEmpty()) {
            layout.setError(getText(R.string.field_cannot_be_empty));
            return false;
        }
        if (ValidationUtil.isEmailValid(extractText(layout))) {
            layout.setError(getText(R.string.invalid_email_format));
            return false;
        }
        layout.setError(null);
        return true;
    }

}