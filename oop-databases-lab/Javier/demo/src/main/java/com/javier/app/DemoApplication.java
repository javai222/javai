package com.javier.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/**
 *
 * WHAT CHANGED FROM PREVIOUS LAB?
 * - Before: data was stored only in memory (lost when app stopped)
 * - Now: data is saved in a real database (H2 then PostgreSQL) so it persists
 *
 * WHY IS DATABASE BETTER?
 * - Data is not lost when the app restarts
 * - Can store large amounts of data
 * - Multiple users can access it at the same time
 * - Data can be searched and filtered easily
 *
 * HOW JPA HELPED?
 * - No need to write SQL manually
 * - Just use @Entity and it automatically creates the table
 * - Methods like save(), findAll(), deleteById() work out of the box
 * - Switching databases is easy because JPA handles the difference
 *
 * WHAT CHANGED WHEN SWITCHING DB?
 * - Only 2 things changed:
 *   1. application.properties - updated the URL, username, and password
 *   2. pom.xml - swapped H2 dependency for PostgreSQL
 * - No Java code was changed at all - that's the power of JPA!
 */