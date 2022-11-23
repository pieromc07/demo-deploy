package com.nocontry.ecommerce.service;

import com.nocontry.ecommerce.rest.dto.request.RegisterRequest;
import com.nocontry.ecommerce.rest.dto.response.RegisterResponse;

public interface IRegisterService {

    public RegisterResponse createUser(RegisterRequest registerRequest);
}
