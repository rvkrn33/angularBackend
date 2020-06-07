package com.city.CityServiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CityServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityServiceAppApplication.class, args);
	}

}
