package com.tp4.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.tp4")
@EntityScan(basePackages = "com.tp4.models")
public class TpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}

}
