package com.example.foundnlost.data;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class PreferencesHelper {

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences("pref_file", Context.MODE_PRIVATE);
    }
}


