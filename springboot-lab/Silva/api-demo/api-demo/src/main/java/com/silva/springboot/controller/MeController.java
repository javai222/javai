/* 
- How did you create your Spring Boot project?
I created this by using spring initializer and do the packages and commands to make it work.
Also, with the help of AI and my teammates, I am able to navigate it correctly.
- What is the purpose of the `@RestController` annotation?
@RestController is used to designate a class as a REST API controller in Spring. It indicates
 that the class will process HTTP requests, and any values returned by its methods will be aut
 omatically converted (typically into JSON) and included in the HTTP response body.
- What does the `@GetMapping("/me")` annotation do?
This tells Spring boot that this method will handle HTTP request and sent it ro me/URL
- Why did you change from returning a String to a Map?
Because a map have this ability to return a structure data thats why it changes from string to map
- How does Spring Boot handle JSON responses automatically?
Spring boot has a built in library that coverts it into json
*/

package com.silva.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Vinz Joseph R. Silva");
        response.put("studentId", "12025-1025218");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}

