package com.example.foundnlost.util;

import com.auth0.android.jwt.JWT;

public abstract class JwtUtil {

    public static Integer decodeUserInfo(String token) {
        JWT jwt = new JWT(token);
        return jwt.getClaim("uuid").asInt();
    }

}
