package com.logistic_warehouse.application.service;

import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.application.dto.response.RegisterResponseDTO;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.domain.imodel.IModelAuth;
import com.logistic_warehouse.infrastructure.mappers.UserMapper;
import com.logistic_warehouse.infrastructure.persistence.UserRepository;
import com.logistic_warehouse.utils.enu.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;
    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Role role) {


        UserEntity user = userRepository.findByUsername(registerRequestDTO.getUsername());
        if(user != null){
            throw new IllegalArgumentException("user exist");
        }

        UserEntity userSave = userMapper.registerRequestDTOToUserEntity(registerRequestDTO);
        userSave.setRole(role);

        userRepository.save(userSave);

        return RegisterResponseDTO.builder()
                .message("register successful")
                .username(registerRequestDTO.getUsername())
                .role(role)
                .build();
    }
}
