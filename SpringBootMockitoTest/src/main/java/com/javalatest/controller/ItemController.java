package com.javalatest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalatest.controller.entity.Item;

@RestController
public class ItemController {
	
	
	@GetMapping("/items")
	public Item retrieveAllItems() {
		return new Item(1,"Ball",10,100);
	}

}
