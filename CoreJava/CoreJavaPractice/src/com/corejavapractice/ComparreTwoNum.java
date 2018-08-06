package com.corejavapractice;

import java.util.Scanner;

/*32. Write a Java program to compare two numbers
 * Input Data:
Input first integer: 25
Input second integer: 39*/
public class ComparreTwoNum {

	public ComparreTwoNum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("1st Input :");
		int a =scan.nextInt();
		System.out.println("2nd Input :");
		int b =scan.nextInt();
		
		if(a==b){
			System.out.println("A and B values are equal..!");
		}
		else if(a>b){
			System.out.println("A value is greater than B..!");
		}
		else {
			System.out.println("A value is lesser than B..!");
		}

	}

}
