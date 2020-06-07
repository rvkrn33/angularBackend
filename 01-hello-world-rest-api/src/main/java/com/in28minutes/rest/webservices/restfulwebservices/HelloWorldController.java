package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	 private AppProperties app;

	    @Autowired
	    public void setApp(AppProperties app) {
	        this.app = app;
	    }

	   
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> "+app.getMenus());
		
		for (Menu menu: app.getMenus()) {
			System.out.println(menu.toString());
			System.out.println(menu.getName());
		}
		return "Hello World - V2 - Green";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
		return new HelloWorldBean("Hello World");
	}
	
	///hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World -v2 mainfest , %s", name));
	}
	
}
