package com.hka.exitgame.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Exit-Game-HKA Backend")
                        .description("Backend-Anwendung für Exit-Game-HKA")
                        .version("1.0")
                );
    }
}
