package com.eidiko.supermarket_integration_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class SupermarketIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketIntegrationServiceApplication.class, args);
	}

}
