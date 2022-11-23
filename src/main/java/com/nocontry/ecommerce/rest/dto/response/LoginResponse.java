package com.nocontry.ecommerce.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {

    private String username;
    private String email;
    private String token;
}
