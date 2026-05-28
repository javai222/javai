/*
1. What changed from previous lab?
The previous lab used hardcoded data, while this lab used a real database with CRUD operations.

2. Why database is better?
Data remains saved even after restarting application.

3. How JPA helped?
JPA automatically handled SQL operations and table mapping.

4. What changed when switching DB?
Only database configuration changed.

*/

package com.deleon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}

}
