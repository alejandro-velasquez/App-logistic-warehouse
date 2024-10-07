package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.utils.enu.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterResponseDTO {

    private String message;
    private String username;
    private Role role;
}
