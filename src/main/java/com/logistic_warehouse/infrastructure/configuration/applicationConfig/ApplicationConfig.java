package com.logistic_warehouse.infrastructure.configuration.applicationConfig;

import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Permite el manejo del usuario que va estar autenticado, dice que puede y que no puede hacer el usuario
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authentication) throws Exception{
        return authentication.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());

        return daoAuthenticationProvider;
    }

    //Metodo para cargar los detalles del usuario mediante la autenticacion
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserEntity user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return user;
        };
    }
}
