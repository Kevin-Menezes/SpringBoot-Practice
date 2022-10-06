package com.csa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CarStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarStoreAppApplication.class, args);
	}

}
