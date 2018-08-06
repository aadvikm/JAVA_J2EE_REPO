package com.corejavapractice;

//1. Write a Java program to print 'Hello' on screen and then print your name on a separate line
public class HelloWorld {
	
	String name ="Brindha";
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Hello World..!!");
		
		HelloWorld hw =new HelloWorld();
		System.out.print("I am " + hw.name +"..:)");
	}

}
