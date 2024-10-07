package com.logistic_warehouse.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDTO {

    @NotBlank(message = "required username")
    private String username;
    @Email(message = "required email")
    private String email;
    @NotBlank(message = "required password")
    private String password;
}
