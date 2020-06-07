package org.sambasoft.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sambasoft.entities.User;
import org.sambasoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/sample")
	public String getSamples() {
		return "samples";
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	
	@GetMapping("/user/{id}") public User getUser(@PathVariable Long id) { 
		return  userRepository.findById(id).get();
	}
	 

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("/login") 
	public User validateLogin(@RequestBody User user) { 
		
		LOGGER.info("Url >> /login ");

		LOGGER.info(user.getUserId()+" >> "+user.getPass()+" >>"+user.getUserType());
		
		User userLogin=userRepository.findUserByParams(user.getUserId(),user.getPass(),user.getUserType());
		
		boolean loginFlag=false;
		String remarks="";
		if(userLogin!=null) {
			if(userLogin.getUserId().equalsIgnoreCase(user.getUserId())) {
				
				if(userLogin.getPass().equals(user.getPass())) {
					
					if(userLogin.getUserType().equalsIgnoreCase(user.getUserType())){
						loginFlag=true;
						remarks="User Login Successful";
						userLogin.setLoginFlag(loginFlag);
						userLogin.setUserRemark(remarks);
						
					}else 
						remarks="Invalid user type";
				}else
					remarks="Invalid password please correct";
			}else
				remarks="Invalid user id";
		
		}else {
			LOGGER.info("User Not Exist");
			userLogin=new User();
			userLogin.setLoginFlag(loginFlag);
			userLogin.setUserRemark(remarks);
		}
		
		LOGGER.info("[loginFlag,remarks] : ["+String.valueOf(userLogin.isLoginFlag())+","+userLogin.getUserRemark()+"]");
		
		
		return  userLogin;
	}
		
	
}
