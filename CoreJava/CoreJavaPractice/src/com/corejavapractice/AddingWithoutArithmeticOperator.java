package com.corejavapractice;

import java.util.Scanner;

/*111. Write a Java program to add two numbers without using any arithmetic operators*/
public class AddingWithoutArithmeticOperator {

	public AddingWithoutArithmeticOperator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int x, y ;
		   Scanner in = new Scanner(System.in);	
		   System.out.print("Input first number: ");
		   x = in.nextInt(); 
		   System.out.print("Input second number: ");
		   y = in.nextInt(); 
	      while(y != 0){
	            int carry = x & y;
	            x = x ^ y;
	            y = carry << 1;
	        }
	        System.out.print("Sum: "+x); 
			System.out.print("\n");     	

	}

}
