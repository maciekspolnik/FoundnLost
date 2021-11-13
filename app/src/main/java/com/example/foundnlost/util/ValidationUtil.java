package com.example.foundnlost.util;

import android.text.InputFilter;

public abstract class ValidationUtil {

    public static InputFilter getWhitespaceFilter(){
        return (source, start, end, dest, dstart, dend) -> {
            for (int i = start; i < end; i++) {
                if (Character.isSpaceChar(source.charAt(i))) {
                    return "";
                }
            }
            return null;
        };
    }


}
