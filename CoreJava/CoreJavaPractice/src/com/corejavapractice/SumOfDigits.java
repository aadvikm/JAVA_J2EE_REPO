package com.corejavapractice;

import java.util.Scanner;

/*
 * 33. Write a Java program and compute the sum of the digits of an integer. Go to the editor
Input Data:
Input an integer: 25*/
public class SumOfDigits {
	
	public SumOfDigits() {
		// TODO Auto-generated constructor stub
	}
	
	public static int sumDigits(long n){
		int sum =0;
				while(n!=0){
					sum+=n%10;
					n/=10;
				}
				return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Input data :");
		long n =scan.nextLong();
		System.out.println("The Sum of the digits is :"+ sumDigits(n));

	}

}
