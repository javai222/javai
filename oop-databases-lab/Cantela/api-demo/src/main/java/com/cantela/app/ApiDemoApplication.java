/*
*Created by Cantela, Chris Nelson B.

*SPRINGBOOT
*How did you create your Spring Boot project?
->Used Spring Initializr to generate a Maven project with Spring Web dependency.

*What is the purpose of the @RestController annotation?
->Marks the class as a REST controller that handles HTTP requests and returns data directly.

*What does the @GetMapping("/me") annotation do?
->Maps GET requests to "/me" endpoint to the method.

*Why did you change from returning a String to a Map?
->To return structured JSON data instead of plain text.

*How does Spring Boot handle JSON responses automatically?
->Uses Jackson library to convert objects to JSON.


* DATABASE
*What changed from previous lab?
-> Replaced hardcoded/in-memory data from the previous lab with JPA entities, added repositories, service layer,
 full CRUD endpoints for User and Product, H2 then PostgreSQL persistence, validation, and exception handling.

*Why database is better?
-> Hardcoded data is lost on app restart, cannot handle concurrent access, and lacks data integrity. Databases persist
  data across restarts, support concurrent users, enforce data integrity, and enable complex querying for real-world use.

*How JPA helped?
-> Eliminated boilerplate SQL code. Spring Data JPA provided built-in CRUD methods via JpaRepository, handled object-relational
  mapping via annotations (@Entity, @Id), and abstracted database dialect differences to ease switching databases.

*What changed when switching DB?
-> Switched from H2 (in-memory, volatile, dev-only) to PostgreSQL (persistent, production-ready). Commented out H2 config
  (preserved per instructions), updated properties to PostgreSQL, changed JPA dialect from H2Dialect to PostgreSQLDialect, and data is now stored persistently.

 */

package com.cantela.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
