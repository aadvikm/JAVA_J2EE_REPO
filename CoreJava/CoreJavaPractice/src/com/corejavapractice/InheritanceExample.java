package com.corejavapractice;

public class InheritanceExample {
	private int a;
	private int b;
	
	public InheritanceExample() {
		// TODO Auto-generated constructor stub
	}
	public InheritanceExample(int a, int b) {//Constructor Overloading
		this.a=a;
		this.b=b;
	}
	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}

	
	public void add(int a, int b){
		System.out.println("Added Value is :"+(a+b));
	}
	
	public void sub(int a, int b){
		System.out.println("Subtracted Value is :"+(a-b));
	}
	
}
