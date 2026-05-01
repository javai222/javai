/*
*What changed from previous lab?
	- The springboot is has lesser folders and files to make it work. In this lab, it requires
	more folders such as : repository, service, and exception.
*Why database is better?
	- A database is much better because the files stored is well structured and easier to 
	modify.
*How JPA helped?
	- Automatically connects java objects to database tables.
*What changed when switching DB?
	- The saved data will be the same even after you reload the project.
*/

package com.silva.app.app_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}

}
