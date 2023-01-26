package com.bookdekho.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SpringFoxConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("bookDekho").version("1.0"));
    }
}
