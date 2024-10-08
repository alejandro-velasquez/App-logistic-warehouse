package com.logistic_warehouse.infrastructure.configuration.security;

import com.logistic_warehouse.utils.enu.helpers.JWTFilter;
import com.logistic_warehouse.utils.enu.helpers.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JWTFilter jwtFilter;

    private final String[] ADMIN_SOURCES = {"/api/pallets/**","/auth/**","/api/loads/**","/swagger-ui/**","v3/api-docs/**","/v3/api-docs.yaml",
            "/swagger-ui.html"};

    private final String[] CARRIER_SOURCES = {"auth/**"};

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF por ahora
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ADMIN_SOURCES).hasAuthority("ADMIN")
                        .requestMatchers(CARRIER_SOURCES).hasAuthority("CARRIER")// Permitir el acceso a /login sin autenticación
                        .anyRequest().authenticated())        // Cualquier otra solicitud debe estar autenticada
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)// Stateless (sin sesión)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());  // No necesitas JWT por ahora, usas autenticación básica por POST

        return http.build();
    }




}
