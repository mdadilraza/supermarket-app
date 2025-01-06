package com.eidiko.query.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Supermarket Query Service",
                description = "API for supermarket query service where only get api calls are made",
                summary = "API for supermarket query service",
                version = "v1.0",
                contact = @Contact(
                        name = "Sanketh Shinde",
                        email = "sankethshinde99@gmail.com"
                )
        )
)
public class SwaggerConfig {
}
