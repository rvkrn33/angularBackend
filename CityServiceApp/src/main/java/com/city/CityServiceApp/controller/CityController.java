package com.city.CityServiceApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.city.CityServiceApp.dto.City;
import com.city.CityServiceApp.dto.Configuration;
import com.city.CityServiceApp.dto.State;

@RestController
public class CityController {

	
	 @Autowired
	 private AppProperties app;

	
	@GetMapping(path="/getCity/{state}/{city}")
	public City getState(@PathVariable String state, @PathVariable String city){
		
		System.out.println("Size -- >"+app.getMap().size());
		String stateCode=state;
		
		List<City> cityList=app.getCityList();
		System.out.println("Size city List -- >"+cityList.size());
		
		City cityObj=cityList.stream().filter(a->a.getCityName().equals(city)).collect(Collectors.toList()).get(0); 
		
		System.out.println("city detais : "+cityObj.getCityName()+", "+cityObj.getStateCode()+", "+cityObj.getId());
		
		  Map<String, String> uriVariable= new HashMap<>();
		  uriVariable.put("state",state);
		  
		  ResponseEntity<State> responseEntity=new  RestTemplate().getForEntity("http://localhost:8200/getState/{state}",State.class,uriVariable);
		  
		  State response=responseEntity.getBody();
		
		  long count=-1;
			
		  if(cityObj!=null) {
			  
			  if(response.getStateCode().equals(cityObj.getStateCode())) 
			  {
				  if(!response.getName().equals("unknown"))
				  {
					  if(app.getMap().containsKey(city)) 
							 count=app.getMap().get(city);
				  }
				  else
					  state="Invalid state";
			  }else
				  state="Invalid state";
		  }
		  
		  cityObj.setCount(count);
		  cityObj.setZone(cityStatus(count));
		  cityObj.setCount(count);
		  
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+response.getStateCode());
		 
		return cityObj;
	}
	
	public String cityStatus(long count) {
		
		String status=count == 0? "GREEN ZONE":count >50 ? "RED ZONE":"ORANGE ZONE";
		if(count < 0)
			status="unknown status";
		return status;
	}
}
