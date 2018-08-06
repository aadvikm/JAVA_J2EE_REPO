package com.package1;

public class Car {
	
	Engine eng;
	Wheels wheel;
		public Car(){
		this.eng =new Engine();
		this.wheel =new Wheels();
	}
	
	public static void main(String []args){
		Car c =new Car();
		//System.out.println("c.eng"+c.eng);
		System.out.println("Car Engine Model:"+c.eng.engModel);
		c.eng.engFun();
		System.out.println("Car Wheel Size: "+c.wheel.wheelSize);
		c.wheel.wheelFun();
	}

}
