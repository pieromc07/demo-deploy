package com.nocontry.ecommerce.rest.dto.response;

import com.nocontry.ecommerce.persistence.model.AccountState;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private String username;
    private String email;
    private AccountState status;
}
