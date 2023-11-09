package com.asigestudiantes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsigEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsigEstudiantesApplication.class, args);
	}

}
