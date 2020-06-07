package com.example.demo;

public class Test {

	static String originalString="abcabc";
	
	private static int operationCount(String word,int input1, int input2) {
		
		String temp=word;
		String latest="";
		int globalCounter=0;
		int firstSub=temp.length()-input1;
		int secondSub=temp.length()-input2;
		
			for(int a=temp.length()-1; a>=0; a--) {
						latest=temp.substring(firstSub);
						temp=latest+temp.substring(0,firstSub);
						globalCounter++;
					
					if(temp.equals(word)) {
						break;
					}
				
						latest=temp.substring(secondSub);
						temp=latest+temp.substring(0,secondSub);
						globalCounter++;
					
				if(temp.equals(word)) {
					break;
				}
			}
			
		
		return globalCounter;	
		
	}
	public static void main(String args[]) {
		int i=operationCount("ravikiran",1,3);
	}
}
