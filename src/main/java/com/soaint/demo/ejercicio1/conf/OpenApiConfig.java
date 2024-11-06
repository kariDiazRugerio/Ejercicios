package com.soaint.demo.ejercicio1.conf;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
            title = "ejercicios 3 APIS",
            version = "1.0.0",
            description = "Ejercicio con 3 APIS, 2 rest y 1 post"
    )
)
public class OpenApiConfig {
}
