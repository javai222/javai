package com.grasp.cantela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// GRASP: Pure Fabrication - Entry point class for Spring Boot application
// SOLID: DIP — Composition root: Spring container wires interface-to-implementation mappings across packages.
@SpringBootApplication
public class CantelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CantelaApplication.class, args);
	}

}
