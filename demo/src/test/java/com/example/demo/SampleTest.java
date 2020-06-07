package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleTest {

	@Test
	void test() {

		int expected=7;
		
		Calculator cl=new Calculator();
		int actual=cl.addition(5, 3);
		
		assertEquals(expected, actual);
		
	System.out.println("Sample Test ");
	}

}
