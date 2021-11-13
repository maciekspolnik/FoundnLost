package com.example.foundnlost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foundnlost.util.CSVReader;
import com.example.foundnlost.util.ValidationUtil;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TestFragment extends Fragment {

    private TextInputLayout phoneNumberLayout;
    private TextInputLayout nameLayout;
    private TextInputLayout vulgaritiesLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        phoneNumberLayout = view.findViewById(R.id.phoneNumberInputLayout);
        vulgaritiesLayout = view.findViewById(R.id.wulgaritiesInputLayout);
        nameLayout = view.findViewById(R.id.nameInputLayout);
        PhoneNumberFormattingTextWatcher phoneNumberWatcher = new PhoneNumberFormattingTextWatcher();
        phoneNumberLayout.getEditText().addTextChangedListener(phoneNumberWatcher);
        nameLayout.getEditText().setFilters(new InputFilter[] {ValidationUtil.getWhitespaceFilter()});
        vulgaritiesLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    private boolean validateEmail(){
        return false;
    }
    private boolean validatePassword(){
        return false;
    }
    private boolean validateName(){
        return false;
    }
    private boolean validateVulgarities(){
        TextInputLayout text = requireView()
        String rawText = text.getEditText().getText().toString();
        ArrayList<String> list = CSVReader.readList(getResources().openRawResource(R.raw.vulgarities));
        for (String s: list) {
            if(rawText.contains(s)){
                return false;
            }
        }
        return true;
    }
    private boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.replaceAll("\\n","").length()>7;
    }





}