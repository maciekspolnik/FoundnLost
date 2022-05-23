package com.example.foundnlost.util;

import java.util.regex.Pattern;

public abstract class Const {


    // Validation

    public static final String DIGIT_REGEX = ".*\\d.*";
    public static final String WHITESPACE_REGEX = "\\s";
    public static final String LOWER_CASE_REGEX = ".*[a-z].*";
    public static final String UPPER_CASE_REGEX = ".*[A-Z].*";
    public static final String SPECIAL_CHARACTER_REGEX = ".*[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-].*";
    public static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(
            "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);

    public static final Integer MIN_PASSWORD_LENGTH = 8;
    public static final Integer MAX_PASSWORD_LENGTH = 32;

    public static final String DIALING_PREFIX = "tel:";
    public static final String EMPTY_STRING = "";
    public static final String API_SUCCESS = "SUCCESS";

}
