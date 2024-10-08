package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.LoginRequestDTO;
import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.application.dto.response.LoginResponseDTO;
import com.logistic_warehouse.application.dto.response.RegisterResponseDTO;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.domain.imodel.IModelAuth;
import com.logistic_warehouse.infrastructure.mappers.UserMapper;
import com.logistic_warehouse.infrastructure.persistence.UserRepository;
import com.logistic_warehouse.utils.enu.Role;
import com.logistic_warehouse.utils.enu.helpers.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
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
        userSave.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userSave.setEmail(registerRequestDTO.getEmail());

        userRepository.save(userSave);

        return RegisterResponseDTO.builder()
                .message("register successful")
                .username(registerRequestDTO.getUsername())
                .role(role)
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(authentication.isAuthenticated()){
            UserEntity user = userRepository.findByUsername(loginRequestDTO.getUsername());
            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
                    .message("login successfull")
                    .role(user.getRole())
                    .token(jwtService.getToken(user))
                    .build();

            return loginResponseDTO;
        }
        throw new RuntimeException("failed");

    }
}

