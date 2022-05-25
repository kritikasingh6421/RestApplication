package com.nagarro.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRestApplication {

    int a = 1;
    int b=1;
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRestApplication.class, args);
	}

}
