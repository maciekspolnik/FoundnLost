package com.example.foundnlost.util;

import android.text.InputFilter;

import java.util.regex.Pattern;

public abstract class ValidationUtil {



    public static boolean isEmailValid(String email) {
        return Const.EMAIL_REGEX_PATTERN.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        return password.length() >= Const.MIN_PASSWORD_LENGTH &&
                password.length() <= Const.MAX_PASSWORD_LENGTH &&
                password.matches(Const.DIGIT_REGEX) &&
                password.matches(Const.LOWER_CASE_REGEX) &&
                password.matches(Const.UPPER_CASE_REGEX) &&
                password.matches(Const.SPECIAL_CHARACTER_REGEX);
    }

    public static InputFilter getWhitespaceFilter() {
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
