package com.corejavapractice;

public class Calculator extends InheritanceExample {
	 int a;
	 int b;
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	public Calculator(int a,int b) {
		this.a=a;
		this.b=b;
	}
	
	
	public void multiply(int a, int b){
		System.out.println("Multiplied Value is :"+(a*b));
	}

	public static void main(String[] args) {
		
		Calculator cal =new Calculator();
		cal.multiply(10, 15);
		cal.setA(10);
		cal.setB(20);
		cal.add(cal.getA(), cal.getB());
		cal.sub(cal.getA(), cal.getB());
		
		
	}

}
