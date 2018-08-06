package com.package1;

public class Apple extends Fruit{
	
//	String name ="Apple";

	public Apple() {
		// TODO Auto-generated constructor stub
	}
	
	public void fruitName(){
		System.out.println("Fruit Name is "+name);
	}
	public static void main(String[] args) {
		Fruit f =new Apple();
		f.fruitName();

	}

}
