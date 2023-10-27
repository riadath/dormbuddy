package com.dormbuddy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@RestController
public class DormbuddyApplication {
	public static void main(String[] args) {
		SpringApplication.run(DormbuddyApplication.class, args);
	}

	@GetMapping("/test_main")
	public String testMain() {
		return "get main page";
	}
}
