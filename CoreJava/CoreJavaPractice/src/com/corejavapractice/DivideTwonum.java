package com.corejavapractice;

//3. Write a Java program to divide two numbers and print on the screen. 
public class DivideTwonum {
	
	int a;
	int b;
	double c;
	public DivideTwonum() {
		// TODO Auto-generated constructor stub
	}
	
	public DivideTwonum(int a, int b){
		this.a=a;
		this.b=b;
		this.c=a/b;
		
	}
	public static void main(String[] args) {
		
		DivideTwonum div =new DivideTwonum(50,3);
		
		System.out.println("A Value is :"+ div.a);
		System.out.println("B Value is :"+ div.b);
		System.out.println("Divided value of A and B  :"+ div.c);
	}

}
