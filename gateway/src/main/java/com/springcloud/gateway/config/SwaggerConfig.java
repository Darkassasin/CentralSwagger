package com.springcloud.gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Gateway Service API",
                version = "1.0",
                description = "REST API for managing service routes and fallbacks"
        )
)
public class SwaggerConfig {

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
        return new SwaggerUiConfigParameters(
                new SwaggerUiConfigProperties()
        );
    }

    @Bean
    @Primary
    public SwaggerUiConfigProperties swaggerUiConfigProperties(RouteDefinitionLocator locator) {
        SwaggerUiConfigProperties config = new SwaggerUiConfigProperties();

        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();

        // Add Gateway's own API docs
        AbstractSwaggerUiConfigProperties.SwaggerUrl gatewayUrl =
                new AbstractSwaggerUiConfigProperties.SwaggerUrl();
        gatewayUrl.setName("gateway-service");
        gatewayUrl.setUrl("/v3/api-docs");
        urls.add(gatewayUrl);

        // Add microservice API docs
        locator.getRouteDefinitions().subscribe(routeDefinition -> {
            String routeId = routeDefinition.getId();
            if (!routeId.contains("swagger") && !routeId.contains("api-docs")) {
                AbstractSwaggerUiConfigProperties.SwaggerUrl url =
                        new AbstractSwaggerUiConfigProperties.SwaggerUrl();
                url.setName(routeId);
                url.setUrl("/v3/api-docs/" + routeId.replace("-service", ""));
                urls.add(url);
            }
        });

        config.setUrls(urls);
        return config;
    }
}