package com.exmple.demo;

import org.springframework.web.client.RestTemplate;

//import com.journaldev.spring.controller.EmpRestURIConstants;
//import com.journaldev.spring.model.Employee;
import com.model.User;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/api";
	
	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		User user = new User("pass123", "Admin", "u001");
		User response = restTemplate.postForObject(SERVER_URI+"/user", user, User.class);
		printEmpData(response);
		System.out.println("sent...");
	}

	
	public static void main(String args[]){
		
		/*
		 * testGetDummyEmployee(); System.out.println("*****");
		 */
		testCreateEmployee();
		System.out.println("*****");
		/*
		 * testGetEmployee(); System.out.println("*****"); testGetAllEmployee();
		 */
	}

	/*
	 * private static void testGetAllEmployee() { RestTemplate restTemplate = new
	 * RestTemplate(); //we can't get List<Employee> because JSON convertor doesn't
	 * know the type of //object in the list and hence convert it to default JSON
	 * object type LinkedHashMap List<LinkedHashMap> emps =
	 * restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.GET_ALL_EMP,
	 * List.class); System.out.println(emps.size()); for(LinkedHashMap map : emps){
	 * System.out.println("ID="+map.get("id")+",Name="+map.get("name")+
	 * ",CreatedDate="+map.get("createdDate"));; } }
	 * 
	 * 
	 * private static void testGetEmployee() { RestTemplate restTemplate = new
	 * RestTemplate(); Employee emp =
	 * restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Employee.class);
	 * printEmpData(emp); }
	 * 
	 * private static void testGetDummyEmployee() { RestTemplate restTemplate = new
	 * RestTemplate(); Employee emp =
	 * restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.DUMMY_EMP,
	 * Employee.class); printEmpData(emp); }
	 * 
	 *
	 */
	
	 public static void printEmpData(User user){
		 System.out.println("ID="+user.getPass()); 
	 }
}
