package com.city.CityServiceApp.dto;

public class State {

	private long id;
	private String stateCode;
	private String name;
	private long count;
	
	public State() {
		
	}
	public State(long id, String stateCode, String name, long count) {
		super();
		this.id = id;
		this.stateCode = stateCode;
		this.name = name;
		this.count = count;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	

}
