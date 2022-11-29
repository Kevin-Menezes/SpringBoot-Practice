package com.jwtauth.JWTAuthentication.controllers;

import com.jwtauth.JWTAuthentication.helpers.JwtUtil;
import com.jwtauth.JWTAuthentication.model.JwtRequest;
import com.jwtauth.JWTAuthentication.model.JwtResponse;
import com.jwtauth.JWTAuthentication.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager aManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println("Request object : "+jwtRequest);

        try{
            this.aManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }
        catch (UsernameNotFoundException e ){
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }

        // This will run if the credentials are proper
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);

        System.out.println("JWT Token : "+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
