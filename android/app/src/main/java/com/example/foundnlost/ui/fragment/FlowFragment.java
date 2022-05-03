package com.example.foundnlost.ui.fragment;

import androidx.fragment.app.Fragment;

import lombok.Setter;

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
}