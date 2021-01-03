package com.prova.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.prova")
@EntityScan("com.prova")
@EnableJpaRepositories("com.prova")
public class ProgettoIdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoIdsApplication.class, args);
	}
}
