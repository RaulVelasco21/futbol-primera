package com.futbol.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API LaLiga Primera División 2025/26")
                        .version("1.0")
                        .description("API REST para gestionar equipos, estadios, jugadores y partidos de la primera división española.")
                        .contact(new Contact()
                                .name("Proyecto futbol-primera")
                                .email("admin@futbol.com")));
    }
}
