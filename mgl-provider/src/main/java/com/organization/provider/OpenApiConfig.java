package com.organization.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API through Swagger UI")
                .version("1.0")
                .description("List of all the APIs of Application App through Swagger UI")
                .license(new License().name("(C) Copyright Test"))
            );
    }
}
