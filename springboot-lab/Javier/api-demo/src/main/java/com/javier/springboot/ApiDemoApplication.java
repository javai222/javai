package com.javier.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}

/*
 * LAB REFLECTION QUESTIONS
 *
 * 1. How did you create your Spring Boot project?
 *    I created the project using Spring Initializr (start.spring.io), which
 *    generates a pre-configured Maven project with dependencies like
 *    spring-boot-starter-web already set up in the pom.xml.
 *
 * 2. What is the purpose of the @RestController annotation?
 *    It marks the class as a controller where every method returns data
 *    directly to the HTTP response body instead of rendering a web page.
 *    It is a combination of @Controller and @ResponseBody.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 *    It maps HTTP GET requests to the /me URL path to that specific method.
 *    When someone visits http://localhost:8080/me, Spring Boot calls the
 *    getMe() method and returns its result.
 *
 * 4. Why did you change from returning a String to a Map?
 *    A Map lets you return structured data with multiple key-value pairs
 *    (e.g. name, course, year) instead of a single plain text string,
 *    which is more useful for real APIs.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 *    Spring Boot includes the Jackson library by default. When a method in
 *    a @RestController returns an object or a Map, Jackson automatically
 *    serializes it into JSON format before sending it in the HTTP response,
 *    so no manual conversion code is needed.
 */