package org.sambasoft.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sambasoft.entities.Menu;
import org.sambasoft.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class MenuController {

	private static final Logger LOGGER = LogManager.getLogger(MenuController.class);

	
	@Autowired
	private MenuRepository menuRepository;

	@GetMapping("/menuList")
	public List<Menu> getMenu() {
		return menuRepository.findAll();
	}
	 @GetMapping("/menu/{id}") 
	 public Menu getMenu(@PathVariable Long id) { 
		return  menuRepository.findById(id).get();
	}
	
	@PostMapping("/menu")
	public Menu createMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}

}
