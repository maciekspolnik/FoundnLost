package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.config.JwtTokenUtil;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.LoginRequest;
import com.example.foundnlostbackend.model.Response;
import com.example.foundnlostbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersManager userManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<String> login(@RequestBody LoginRequest loginRequest) {
        Users userData = userManager.findByUsernameAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (userData == null) {
            return new Response<>(400, "no_user_found", null);
        }
        return new Response<>(200, "successfully_logged_in", jwtTokenUtil.generateToken(userData));

    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public Response<String> register(@RequestBody Users loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
        final Users user = userManager.findByUsernameAndPassword(loginUser.getEmail(),"");
        final String token = jwtTokenUtil.generateToken(user);
        return new Response<>(200, "success", "");
    }

}
