package com.nocontry.ecommerce.service.impl;

import com.nocontry.ecommerce.exception.InvalidCredentialsException;
import com.nocontry.ecommerce.exception.NotFoundException;
import com.nocontry.ecommerce.mapper.IUserMapper;
import com.nocontry.ecommerce.persistence.model.User;
import com.nocontry.ecommerce.persistence.repository.UserRepository;
import com.nocontry.ecommerce.rest.dto.request.LoginRequest;
import com.nocontry.ecommerce.rest.dto.response.LoginResponse;
import com.nocontry.ecommerce.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticate(loginRequest);
        User user = getUserBy(loginRequest.getEmail());
        return userMapper.toLoginResponse(user);
    }

    private User getUserBy(String email) {
        User userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        return userEntity;
    }

    private void authenticate(LoginRequest user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword()));
        } catch (Exception e) {
            throw new InvalidCredentialsException("El email o la contraseña son incorrectos");
        }
    }
}
