package com.javaexercise2;

public abstract class Car {

	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void start(){
		System.out.println("Starting the Car..");
	}
	
	public void stop(){
		System.out.println("Stoping the Car..");
	}
	
	public abstract void drive();
}
