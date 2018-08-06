package com.corejavapractice;

//2. Write a Java program to print the sum of two numbers
public class SumofTwoNum {
	
	int a ;
	int b;
	int c;
	public SumofTwoNum() {
		// TODO Auto-generated constructor stub
	}
	
	public SumofTwoNum(int a, int b){
		this.a=a;
		this.b=b;
		this.c =a+b;
	}
	public static void main(String[] args) {
		SumofTwoNum sum =new SumofTwoNum(5,10);
		
		System.out.println("A Value is :"+ sum.a);
		System.out.println("B Value is :"+ sum.b);
		System.out.println("Sum of A and B  :"+ sum.c);
	}

}
