package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.config.JwtTokenUtil;
import com.example.foundnlostbackend.data.LoginRequest;
import com.example.foundnlostbackend.data.Response;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.Users;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.foundnlostbackend.Const.RESPONSE_SUCCESS;
import static com.example.foundnlostbackend.Const.RESPONSE_UNAUTHORISED;

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
            return new Response<>(HttpStatus.UNAUTHORIZED.value(), RESPONSE_UNAUTHORISED, null);
        }
        return new Response<>(HttpStatus.OK.value(), RESPONSE_SUCCESS, jwtTokenUtil.generateToken(userData));
    }

    @RequestMapping(value = "/isEmailAvailable", method = RequestMethod.GET)
    public Response<Boolean> isEmailAvailable(@RequestParam String email) {
        return new Response<>(HttpStatus.OK.value(), RESPONSE_SUCCESS, userManager.isEmailAvailable(email));
    }

    @RequestMapping(value = "/token/valid", method = RequestMethod.GET)
    public Response<Boolean> isTokenValid(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "token") String token) {

        Claims tokenClaims = jwtTokenUtil.getAllClaimsFromToken(token);

        return new Response<>(HttpStatus.OK.value(), RESPONSE_SUCCESS, jwtTokenUtil.validateToken(tokenClaims, email));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response<String> register(@RequestBody Users user) {
        if (user == null) {
            return new Response<>(HttpStatus.UNAUTHORIZED.value(), RESPONSE_UNAUTHORISED, null);
        }
        userManager.addUser(user);
        return new Response<>(HttpStatus.OK.value(), RESPONSE_SUCCESS, null);
    }

}
