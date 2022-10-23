package com.example.demo.rest.controller;

import javax.validation.Valid;
import com.example.demo.rest.dto.request.LoginRequest;
import com.example.demo.rest.dto.response.LoginResponse;
import com.example.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @CrossOrigin
    @PostMapping(value = "/login",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse response = loginService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

}
