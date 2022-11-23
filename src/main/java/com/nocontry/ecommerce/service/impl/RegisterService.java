package com.nocontry.ecommerce.service.impl;

import com.nocontry.ecommerce.exception.UserAlreadyExistsException;
import com.nocontry.ecommerce.mapper.IUserMapper;
import com.nocontry.ecommerce.persistence.model.User;
import com.nocontry.ecommerce.persistence.repository.UserRepository;
import com.nocontry.ecommerce.rest.dto.request.RegisterRequest;
import com.nocontry.ecommerce.rest.dto.response.RegisterResponse;
import com.nocontry.ecommerce.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    private IUserMapper IUserMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse createUser(RegisterRequest registerRequest) {

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            throw new UserAlreadyExistsException(
                    "Email : " + registerRequest.getEmail() + " Ya esta en uso.");
        }
        User user = IUserMapper.mapRegisterEntity(registerRequest);
        userRepository.save(user);
        return IUserMapper.mapRegisterResponseDTO(registerRequest);
    }
}

