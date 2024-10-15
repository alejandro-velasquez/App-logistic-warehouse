package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.response.CarrierLoadsAssignedResponseDTO;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.domain.imodel.IModelUser;
import com.logistic_warehouse.infrastructure.mappers.UserMapper;
import com.logistic_warehouse.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IModelUser {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public CarrierLoadsAssignedResponseDTO readById(Long id) {

       Optional<UserEntity> userId = userRepository.findById(id);

       if(userId.isEmpty()){
           throw  new UsernameNotFoundException("User not found");
       }

       return userMapper.userToCarrierLoadsAssignedDTO(userId.get());

    }
}

