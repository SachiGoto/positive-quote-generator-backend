package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.LoginUserDto;
import com.example.app.dto.RegisterUserDto;
import com.example.app.entity.User;
import com.example.app.service.AuthenticationService;
import com.example.app.service.JwtService;

import Response.LoginResponse;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
    	 User authenticatedUser = authenticationService.authenticate(loginUserDto);

    	    String jwtToken = jwtService.generateToken(authenticatedUser); // Assuming generateToken expects a User object
    	    long expirationTime = jwtService.getExpirationTime();

    	    LoginResponse loginResponse = new LoginResponse()
    	            .setToken(jwtToken)
    	            .setExpiresIn(expirationTime);

    	    return ResponseEntity.ok(loginResponse);
    }
}
