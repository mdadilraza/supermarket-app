package com.eidiko.supermarket_action_service.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Super market Action Service",
                description = "This is the API documentation for Action service",
                version = "v1",
                contact = @Contact(name = "Channanagouda", email = "channanagouda.aralahalli@eidiko-india.com", url = "http://localhost:8081/swagger-ui/index.html")
        ))
public class SwaggerConfig {


}
