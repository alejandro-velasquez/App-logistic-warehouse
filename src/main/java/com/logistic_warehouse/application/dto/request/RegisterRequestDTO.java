package com.logistic_warehouse.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDTO {

    @NotBlank(message = "required password")
    private String username;
    @NotBlank(message = "required password")
    private String password;
}
