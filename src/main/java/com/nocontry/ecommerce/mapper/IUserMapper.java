package com.nocontry.ecommerce.mapper;

import com.nocontry.ecommerce.persistence.model.User;
import com.nocontry.ecommerce.rest.dto.request.LoginRequest;
import com.nocontry.ecommerce.rest.dto.request.RegisterRequest;
import com.nocontry.ecommerce.rest.dto.response.LoginResponse;
import com.nocontry.ecommerce.rest.dto.response.RegisterResponse;

public interface IUserMapper {

    public RegisterResponse mapRegisterResponseDTO(RegisterRequest registerRequest);

    public User mapRegisterEntity(RegisterRequest registerRequest);

    User mapLoginEntity(LoginRequest loginRequest);

    LoginResponse toLoginResponse(User user);

}
