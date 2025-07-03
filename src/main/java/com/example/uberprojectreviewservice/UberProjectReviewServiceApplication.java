package com.example.uberprojectreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.uberprojectentityservice.models")

public class UberProjectReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberProjectReviewServiceApplication.class, args);
	}

}
