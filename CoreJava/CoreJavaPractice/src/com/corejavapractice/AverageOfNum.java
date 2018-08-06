package com.corejavapractice;

import java.util.Scanner;

/*12. Write a Java program that takes three numbers as input to calculate and print the average of the numbers*/
public class AverageOfNum {

	public AverageOfNum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan  =new Scanner(System.in);
		
		System.out.println("1st Input :");
		int a = scan.nextInt();
		System.out.println("2nd Input :");
		int b = scan.nextInt();
		System.out.println("3rd Input :");
		int c = scan.nextInt();
		
		System.out.println("Average of the given numbers :"+ (a+b+c)/3);
		

	}

}
