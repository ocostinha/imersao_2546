package com.fiap.imersao_2546;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.fiap.imersao_2546"})
public class Imersao2546Application {

	public static void main(String[] args) {
		SpringApplication.run(Imersao2546Application.class, args);
	}

}
