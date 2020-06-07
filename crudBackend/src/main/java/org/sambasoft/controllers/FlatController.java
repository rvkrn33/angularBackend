package org.sambasoft.controllers;

import java.util.List;

import org.sambasoft.entities.FlatDtls;
import org.sambasoft.repositories.FlatDtlsRepository;
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
public class FlatController {

	@Autowired
	private FlatDtlsRepository flatRepository;

	@GetMapping("/flats")
	public List<FlatDtls> getFlatDtls() {
		return flatRepository.findAll();
	}
	 @GetMapping("/flat/{id}") 
	 public FlatDtls getFlat(@PathVariable Long id) { 
		return  flatRepository.findById(id).get();
	}
	@DeleteMapping("/flat/{id}")
	public boolean deleteFlat(@PathVariable Long id) {
		flatRepository.deleteById(id);
		return true;
	}

	@PutMapping("/flat")
	public FlatDtls updateUser(@RequestBody FlatDtls flat) {
		return flatRepository.save(flat);
	}

	@PostMapping("/flat")
	public FlatDtls createUser(@RequestBody FlatDtls flat) {
		return flatRepository.save(flat);
	}
	
	 @GetMapping("/flatName/{name}") 
	 public FlatDtls getFlatOwner(@PathVariable String name) { 
		 System.out.println("Name :: "+name);
		return  flatRepository.findByownerName(name);
	}

}
