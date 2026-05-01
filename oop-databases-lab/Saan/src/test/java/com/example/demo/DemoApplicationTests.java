package com.example.demo;

/**
 * REFLECTION
 *
 * What changed from the previous lab?
 * Data is now stored in a real database instead of hardcoded lists.
 * Records persist even after the app restarts.
 *
 * Why is a database better?
 * It allows real users to add, update, and delete data at runtime
 * without touching the source code.
 *
 * How did JPA help?
 * It auto-created tables from entities and provided built-in CRUD
 * methods, so no SQL had to be written manually.
 *
 * What changed when switching from H2 to PostgreSQL?
 * Only application.properties changed. No Java code was modified,
 * proving that JPA abstracts the database layer completely.
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
