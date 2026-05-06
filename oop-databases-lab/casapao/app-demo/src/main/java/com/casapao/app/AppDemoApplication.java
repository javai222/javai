package com.casapao.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}

}
/*
* What changed from previous lab?
* I switched from using in-memory data structures to using a database for data persistence.
* Why database is better?
* A database allows for better data management, scalability, and persistence compared to in-memory data structures.
* How JPA helped?
* JPA (Java Persistence API) provides a standardized way to interact with databases, making it easier to perform CRUD operations and manage data.
* What changed when switching DB?
* When switching to a database, I had to set up a data source, configure JPA entities, and use repositories to interact with the database instead of using simple collections.
*/
