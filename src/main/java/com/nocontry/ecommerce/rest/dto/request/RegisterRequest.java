package com.nocontry.ecommerce.rest.dto.request;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    @Size(min = 4, message = "el nombre debe tener al menos 4 caracteres")
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 6, max = 8,message = "la contraseña debe tener entre 6 y 8 caracteres")
    private String password;

}
