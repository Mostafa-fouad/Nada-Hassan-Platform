package com.example.nadahassanplatform;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(
		info =
		@Info(
				title = "Nada Hassan Fashion Platform",
				version = "1.0",
				description = "Fashion Platform"))
public class NadaHassanPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(NadaHassanPlatformApplication.class, args);
	}

}
