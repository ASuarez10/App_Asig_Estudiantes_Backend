package com.asigestudiantes.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
	
	@Bean
	public OpenAPI api() {
		return new OpenAPI().info(new Info().title("API REST para asignación de estudiantes con Spring-boot y Oracle").description("API encargada de la gestión del sistema de asignación de estudiantes de la Universidad MAS."));
	}

}
