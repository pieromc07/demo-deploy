package com.example.demo.service;

import com.example.demo.rest.dto.request.LoginRequest;
import com.example.demo.rest.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {

    LoginResponse login(LoginRequest loginRequest);

}
