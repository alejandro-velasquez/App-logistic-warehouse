package com.logistic_warehouse.domain.imodel;

import com.logistic_warehouse.application.dto.response.CarrierLoadsAssignedResponseDTO;
import com.logistic_warehouse.application.service.generic.ReadById;

public interface IModelUser {
    CarrierLoadsAssignedResponseDTO readById(Long id);
}
