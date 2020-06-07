package com.state.StateServiceApp.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.state.StateServiceApp.dto.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// By default, Spring boot it loads property from application.properties, we can use @PropertySource to load other .properties files.
//@PropertySource("classpath:custom.properties")
@Component
@ConfigurationProperties("state-config")
public class AppProperties {

    private List<State> stateList = new ArrayList<>();
    
    private Map<String, Integer> mapStateCount;
    
	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public Map<String, Integer> getMapStateCount() {
		return mapStateCount;
	}

	public void setMapStateCount(Map<String, Integer> mapStateCount) {
		this.mapStateCount = mapStateCount;
	}
}
