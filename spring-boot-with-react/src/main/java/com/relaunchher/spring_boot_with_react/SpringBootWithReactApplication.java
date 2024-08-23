package com.relaunchher.spring_boot_with_react;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWithReactApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithReactApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DB_URL: " + System.getenv("DB_URL"));
		System.out.println("DB_USERNAME: " + System.getenv("DB_USERNAME"));
		System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));
	}
}
