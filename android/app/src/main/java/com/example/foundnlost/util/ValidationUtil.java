package com.example.foundnlost.util;

import android.text.InputFilter;

import java.util.regex.Pattern;

public abstract class ValidationUtil {

    public static String DIGIT_REGEX = ".*\\d.*";
    public static String LOWER_CASE_REGEX = ".*[a-z].*";
    public static String UPPER_CASE_REGEX = ".*[A-Z].*";
    public static String SPECIAL_CHARACTER_REGEX = ".*[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-].*";
    static Pattern EMAIL_REGEX_PATTERN = Pattern.compile(
            "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b",Pattern.CASE_INSENSITIVE);

    public static boolean isEmailValid(String email) {
        return EMAIL_REGEX_PATTERN.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        return password.length() >= 8 &&
                password.length() <= 32 &&
                password.matches(DIGIT_REGEX) &&
                password.matches(LOWER_CASE_REGEX) &&
                password.matches(UPPER_CASE_REGEX) &&
                password.matches(SPECIAL_CHARACTER_REGEX);
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
