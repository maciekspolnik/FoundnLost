package com.example.foundnlost.util;

import android.text.Editable;
import android.text.TextWatcher;

import com.example.foundnlost.util.interfaces.OnTextChangedListener;

public class TextChangedWatcher implements TextWatcher {

    private final OnTextChangedListener listener;

    public TextChangedWatcher(OnTextChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        listener.onTextChanged(charSequence, i, i1, i2);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
