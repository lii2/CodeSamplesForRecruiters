package com.promptous.controller;

import com.promptous.agent.UserAdministrator;
import com.promptous.json.request.LoginRequest;
import com.promptous.json.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAdministrator userAdministrator;

    @PostMapping(value = "/login", name = "Takes a username and password and returns a JWT access token")
    public LoginResponse login(
            @Validated @RequestBody final LoginRequest request) {
        return new LoginResponse(userAdministrator.signIn(request.getUsername(), request.getPassword()));
    }


}
