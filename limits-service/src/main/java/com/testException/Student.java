package com.testException;

public class Student {

	private int id;
	private String name;
	
	Student(){
		System.out.println("student");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	  @Override public int hashCode() { System.out.println("Hascode calls ..");
	  final int prime = 31; int result = 1; result = prime * result + id; result =
	  prime * result + ((name == null) ? 0 : name.hashCode()); return result; }
	 
	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals  calls ..");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
