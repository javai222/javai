/*
*What changed from previous lab?
	- There are no entities, services, repositories and overall there are more dependencies
*Why database is better?
	- A database is better than storing data in memory or files because it is reliable and well structured
*How JPA helped?
	- It helped by acting as a bridge between objects and the database
*What changed when switching DB?
	- When the server reloads the previous saved data will still be saved
*/

package com.tismo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}

}
