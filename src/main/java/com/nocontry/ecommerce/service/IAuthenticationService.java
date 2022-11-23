package com.nocontry.ecommerce.service;

import com.nocontry.ecommerce.rest.dto.request.LoginRequest;
import com.nocontry.ecommerce.rest.dto.response.LoginResponse;

public interface IAuthenticationService {

    LoginResponse login(LoginRequest loginRequest);
}
