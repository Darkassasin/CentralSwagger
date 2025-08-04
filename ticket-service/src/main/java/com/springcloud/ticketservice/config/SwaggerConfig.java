package com.springcloud.ticketservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    @Configuration
    @OpenAPIDefinition(
            info = @Info(
                    title = "Ticket Service API",
                    version = "1.0",
                    description = "REST API for managing tickets on application"
            )
    )
    public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("ticket")
                .packagesToScan("com.springcloud.ticketservice.controller")
                .build();
    }

}