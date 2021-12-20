package com.example.foundnlost.util;

public abstract class Const {

    public static final String WHITESPACE_REGEX = "\\s";

    // LOGIN & REGISTER

    public static Integer MIN_PASSWORD_LENGTH = 8;
    public static Integer MAX_PASSWORD_LENGTH = 32;

    public static String DIGIT_REGEX = ".*\\d.*";
    public static String LOWER_CASE_REGEX = ".*[a-z].*";
    public static String UPPER_CASE_REGEX = ".*[A-Z].*";
    public static String SPECIAL_CHARACTER_REGEX = ".*[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-].*";
    public static String EMAIL_REGEX = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";

}
