package com.nocontry.ecommerce.rest.controller;

import com.nocontry.ecommerce.rest.dto.request.LoginRequest;
import com.nocontry.ecommerce.rest.dto.response.LoginResponse;
import com.nocontry.ecommerce.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    IAuthenticationService authenticationService;

    @CrossOrigin
    @PostMapping(value = "/login",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginReq) {
        LoginResponse response = authenticationService.login(loginReq);
        return ResponseEntity.ok(response);
    }
}
