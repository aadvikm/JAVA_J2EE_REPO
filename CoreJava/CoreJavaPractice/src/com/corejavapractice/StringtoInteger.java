package com.corejavapractice;

import java.util.Scanner;

/*51. Write a Java program to convert a string to an integer in Java. */
public class StringtoInteger {

	public StringtoInteger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Pls Enter the number :");
		
		String s =scan.nextLine();
		int i =Integer.parseInt(s);
		System.out.println("integer i value is :"+i);

	}

}
