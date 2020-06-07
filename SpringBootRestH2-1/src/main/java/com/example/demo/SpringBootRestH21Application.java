package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.User;
import com.repositories.UserRepository;

@SpringBootApplication
public class SpringBootRestH21Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestH21Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("u1","pass1","Admin"));
		userRepository.save(new User("u2","pass2","Other"));
		userRepository.save(new User("u3","pass3","User"));
	}

}
