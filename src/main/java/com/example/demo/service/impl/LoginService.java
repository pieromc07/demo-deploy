package com.example.demo.service.impl;

import com.example.demo.persistence.model.User;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.rest.dto.request.LoginRequest;
import com.example.demo.rest.dto.response.LoginResponse;
import com.example.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return LoginResponse.builder().message("User not found").build();
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return LoginResponse.builder().message("Wrong password").build();
        }
        return LoginResponse.builder()
                .token("token")
                .username(user.getUsername())
                .role(user.getRole().getName())
                .build();
    }

}
