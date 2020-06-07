package com.state.StateServiceApp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.state.StateServiceApp.dto.State;

@RestController
class StateController {

	 @Autowired
	 private AppProperties app;

	@GetMapping(path="/getState/{stateCode}")
	public State getState(@PathVariable String stateCode){
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> "+app.getStateList());
		
		for (State menu: app.getStateList()) {
			System.out.println(menu.toString());
			System.out.println(menu.getName());
		}
		
		  List<State> cityList=app.getStateList();
		  System.out.println("--> "+cityList); 
		  State state=cityList.stream().filter(a->a.getStateCode().equals(stateCode)).collect(Collectors.toList()).get(0);
		  
		  System.out.println("state --> "+state.getStateCode());
		  System.out.println("Name  --> "+state.getName());
		  System.out.println("Count  --> "+state.getCount());
		  
		  long count=-1; String name="unknown"; long id=0;
		  
		  if(state.getStateCode().equals(stateCode)) {
			  if(app.getMapStateCount().containsKey(stateCode))
				  count=app.getMapStateCount().get(stateCode); 
		  }
		  state.setCount(count);
		  
		  System.out.println("Count  --> "+state.getCount());
		 	
		return state;
	}
	
}
