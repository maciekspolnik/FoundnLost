package com.example.foundnlost.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.R;

import java.util.Date;

public class DatePickingDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        return builder.setView(inflater.inflate(R.layout.fragment_date_picking_dialog,null))
                .setPositiveButton("OK",(dialog, which) -> dismiss())
                .setNegativeButton("Nie ok",(dialog, which) -> dismiss())
                .create();
    }

}