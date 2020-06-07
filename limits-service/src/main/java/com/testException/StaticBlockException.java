package com.testException;

public class StaticBlockException {
	
	
	StaticBlockException(){
		new Student();
	}
	 void abc(int a) {
		System.out.println("int "+a);
	}
	
	private final void abc(int a, int b) {
		System.out.println("second  "+a+b);
	}


public static void main(String[] args) {
		new StaticBlockException();
		/*
		 * Student s=new Student(); s.setId(12); s.setName("Ravi");
		 * 
		 * 
		 * Student s1=new Student(); s1.setId(12); s1.setName("Ravi");
		 * 
		 * System.out.println("Result hash ----> "+(s==s1)
		 * +" >>>  "+s.hashCode()+" >> "+s1.hashCode());
		 * System.out.println("Result ----> "+s.equals(s1));
		 */
	}
	
}
