package com.example.nadahassanplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.OAuth2ResourceServerSecurityMarker;

@EnableCaching
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NadaHassanPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(NadaHassanPlatformApplication.class, args);
	}

}
