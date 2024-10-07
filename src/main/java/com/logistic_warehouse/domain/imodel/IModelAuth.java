package com.logistic_warehouse.domain.imodel;

import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.application.dto.response.RegisterResponseDTO;
import com.logistic_warehouse.utils.enu.Role;

public interface IModelAuth {
    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role);
}
