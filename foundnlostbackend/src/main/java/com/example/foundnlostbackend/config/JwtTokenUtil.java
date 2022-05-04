package com.example.foundnlostbackend.config;

import com.example.foundnlostbackend.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static com.example.foundnlostbackend.Const.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.example.foundnlostbackend.Const.SIGNING_KEY;

@Component
public class JwtTokenUtil implements Serializable {

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String generateToken(Users user) {

        Claims claims = Jwts.claims().setSubject("verification_token");
        claims.put("scopes", List.of(new SimpleGrantedAuthority("ROLE_USER")));
        claims.put("email", user.getEmail());
        claims.put("uuid",user.getUsersId());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("foundnlost")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(Claims claims, String email) {
        return (email.equals(claims.get("email").toString()) && !isTokenExpired(claims.getExpiration()));
    }

}
