package com.javaexercise2;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Camry c =new Camry();
		System.out.println("Car :"+ c);
		c.start();
		c.drive();
		c.stop();
		
		Fiesta f =new Fiesta();
		System.out.println("Car :"+ f);
		f.start();
		f.drive();
		f.stop();
	}

}
