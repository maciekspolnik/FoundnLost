package com.example.foundnlost.ui.fragment.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

public class DatePickingDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener {

    @Getter
    private String date;
    @Setter
    private DialogInterface.OnDismissListener onDismissListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
        super.onDismiss(dialog);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        date = String.format(Locale.getDefault(), "%d-%d-%d", day, month, year);
    }

}