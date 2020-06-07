package com.example.demo;

import java.io.IOException;

class StaticNonStaticOverloading {

	
	public void disp() throws IOException {
		System.out.println("ch");
		
		try {
			abc();
			}
		catch(Exception e){
			System.out.println("catch ");
		}finally {
				System.out.println("finally ....");
			}
	}
	
	private void abc() throws IOException {
		System.out.println("abc");
		try {
		throw new IOException();
		}finally {
			System.out.println("finally abc");
		}
	}



	public static void main(String[] args) throws IOException {
		StaticNonStaticOverloading s=new StaticNonStaticOverloading();
		s.disp();
		
		//new StaticNonStaticOverloading();
	}
}


class Sample{
	
	protected static void disp() {
		System.out.println("Parent");
	}
}

