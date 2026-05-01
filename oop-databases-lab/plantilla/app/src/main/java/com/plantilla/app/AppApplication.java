/*
*What changed from previous lab?
	- It starts from a simple API with fixed data then it became a structured app with layers and database connection
*Why database is better?
	- It allows data to be stored properly and reused anytime
*How JPA helped?
	- It simplified database operations by letting us use Java code instead of manual SQL
*What changed when switching DB?
	- The system moved from temporary storage to a database that keeps data even after exit
*/

package com.plantilla.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
