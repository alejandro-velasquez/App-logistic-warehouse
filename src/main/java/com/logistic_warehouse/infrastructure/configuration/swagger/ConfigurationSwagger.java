package com.logistic_warehouse.infrastructure.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(

        info = @Info(
                title = "Logistic Warehouse",
                description = "a platform used for stacking,\n" +
                        "store and transport goods.",
                version = "V1"
        ),
        security = {
                @SecurityRequirement(name = "jwt")
        }
)
@SecurityScheme(name = "jwt",description = "seguridad con jwt",type = SecuritySchemeType.HTTP,bearerFormat = "JWT",scheme = "bearer",in = SecuritySchemeIn.HEADER)
public class ConfigurationSwagger {
}
