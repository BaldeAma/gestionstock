package com.obi.gestiondesstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestiondesstockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiondesstockApplication.class, args);
	}

}
