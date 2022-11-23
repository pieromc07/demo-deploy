package com.nocontry.ecommerce.rest.controller;

import com.nocontry.ecommerce.persistence.model.User;
import com.nocontry.ecommerce.persistence.repository.UserRepository;
import com.nocontry.ecommerce.rest.dto.request.RegisterRequest;
import com.nocontry.ecommerce.rest.dto.response.RegisterResponse;
import com.nocontry.ecommerce.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {
    @Autowired
    private IRegisterService RegisterService;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
        RegisterResponse registerResponse = RegisterService.createUser(registerRequest);
        return new ResponseEntity<>(registerResponse,HttpStatus.OK);
    }
}
