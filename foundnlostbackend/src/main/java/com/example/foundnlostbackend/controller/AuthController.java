package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.config.JwtTokenUtil;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.LoginRequest;
import com.example.foundnlostbackend.model.Response;
import com.example.foundnlostbackend.model.Users;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersManager userManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<String> login(@RequestBody LoginRequest loginRequest) {
        Users userData = userManager.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (userData == null) {
            return new Response<>(HttpStatus.UNAUTHORIZED.value(), "no_user_found", null);
        }
        return new Response<>(HttpStatus.OK.value(), "successfully_logged_in", jwtTokenUtil.generateToken(userData));
    }

    @RequestMapping(value = "/isEmailAvailable", method = RequestMethod.GET)
    public Response<Boolean> isEmailAvailable(@RequestParam String email) {
        return new Response<>(HttpStatus.OK.value(), "email_availability_checked", userManager.isEmailAvailable(email));
    }

    @RequestMapping(value = "/token/valid", method = RequestMethod.GET)
    public Response<Boolean> isTokenValid(@RequestParam(name = "email") String email, @RequestParam(name = "token") String token) {

        Claims tokenClaims = jwtTokenUtil.getAllClaimsFromToken(token);
        System.out.println(tokenClaims.getExpiration());
        System.out.println(tokenClaims.get("email"));

        return new Response<>(HttpStatus.OK.value(), "token_checked", jwtTokenUtil.validateToken(tokenClaims, email));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<String> register(@RequestBody Users user) throws AuthenticationException {
        if (user == null) {
            return new Response<>(HttpStatus.UNAUTHORIZED.value(), "registration_data_incomplete", null);
        }
        userManager.addUser(user);
        return new Response<>(HttpStatus.OK.value(), "registered successfully", null);
    }

}
