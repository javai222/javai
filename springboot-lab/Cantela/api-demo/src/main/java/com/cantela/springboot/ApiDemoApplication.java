/*
*Created by Cantela, Chris Nelson B.


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
