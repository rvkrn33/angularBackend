package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/abc")
	String getMessage() {
		return "Hello Message from Spring Boot project";
	}
}
