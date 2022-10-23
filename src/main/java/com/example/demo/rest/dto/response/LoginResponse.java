package com.example.demo.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponse {

    private String token;
    private String username;
    private String role;
    private String message;


}
