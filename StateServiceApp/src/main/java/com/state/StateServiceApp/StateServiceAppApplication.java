package com.state.StateServiceApp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.state.StateServiceApp.dto.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(Configuration.class)
public class StateServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateServiceAppApplication.class, args);
	}
	
	@Bean
	ApplicationRunner applicationRunner(Configuration configuration) {
		return args->{
			System.out.println(configuration);
		};
	}

}
