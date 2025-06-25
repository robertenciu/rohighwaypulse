package com.enciu.rohighwaypulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RohighwaypulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RohighwaypulseApplication.class, args);
	}
	@GetMapping("/")
	public String root() {
		return "RoHighway Pulse";
	}
}
