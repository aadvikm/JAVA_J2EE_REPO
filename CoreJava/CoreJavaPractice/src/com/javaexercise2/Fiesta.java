package com.javaexercise2;

import java.util.ArrayList;

public class Fiesta extends Car{

	public Engine engine;
	public ArrayList<Wheel> objWheel;
	
	public Fiesta(){
		engine = new Engine();
		objWheel = new ArrayList<Wheel>();
	}
	
	public Fiesta(Engine engine, ArrayList<Wheel> wheel){
		this.engine=engine;
		this.objWheel=wheel;
	}
	
	public void drive(){
		System.out.println("Driving the Car..");
	}
}
