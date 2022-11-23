package com.nocontry.ecommerce.rest.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class LoginRequest {

    @NotBlank(message = "El email no puede estar vacio.")
    @Email(message = "el email debe ser valido.")
    private String email;

    @NotBlank(message = "la contraseña no puede estar vacia.")
    @Size(min = 6, max = 8,message = "la contraseña debe tener entre 6 y 8 caracteres.")
    private String password;

}
