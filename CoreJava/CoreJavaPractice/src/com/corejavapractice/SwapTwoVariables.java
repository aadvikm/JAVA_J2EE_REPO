package com.corejavapractice;

/*
 * 15. Write a Java program to swap two variables*/
public class SwapTwoVariables {
	int a;
	int b;
	
	public SwapTwoVariables() {
		// TODO Auto-generated constructor stub
	}
	
	public SwapTwoVariables(int a, int b) {
		this.a=a;
		this.b=b;
	}
	

	public static void main(String[] args) {
		SwapTwoVariables swap =new SwapTwoVariables(10, 15);
		System.out.println("Before Swapping :");
		System.out.println("A value is :"+swap.a +" B value is :"+swap.b);
		
		int temp =swap.a;
		swap.a=swap.b;
		swap.b=temp;
	
		System.out.println("After Swapping :");
		System.out.println("A value is :"+ swap.a +" B value is :"+swap.b);
		

	}

}
