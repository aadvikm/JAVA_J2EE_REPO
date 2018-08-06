package com.corejavapractice;

import java.util.Scanner;

/*6. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.
 * Test Data:
Input first number: 125
Input second number: 24*/
public class ArithmeticOperUsingInput {

	public ArithmeticOperUsingInput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("First Input :");
		int a =scan.nextInt();
		System.out.println("Second Input :");
		int b =scan.nextInt();
		System.out.println("Addision :"+(a+b));
		System.out.println("Multiplication :"+(a*b));
		System.out.println("Subtraction :"+(a-b));
		System.out.println("Division :"+(a/b));
		System.out.println("Modulus :"+(a%b));
		
	}

}
