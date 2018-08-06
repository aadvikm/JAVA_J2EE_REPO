package com.corejavapractice;

import java.util.Scanner;

//5. Write a Java program that takes two numbers as input and display the product of two numbers. 
public class MulitipicationOfTwonum {

	public MulitipicationOfTwonum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("First Input :");
		int a =scan.nextInt();
		System.out.println("Second Input :");
		int b =scan.nextInt();
		
		System.out.println(a +" X " + b + " = " + (a*b));
		

	}

}
