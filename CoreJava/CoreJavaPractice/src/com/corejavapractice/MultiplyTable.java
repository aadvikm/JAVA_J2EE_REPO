package com.corejavapractice;

import java.util.Scanner;

//7. Write a Java program that takes a number as input and prints its multiplication table upto 10.
public class MultiplyTable {

	public MultiplyTable() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("Input :");
		int a =scan.nextInt();
		
		for(int i =1; i<=10 ; i++){
			System.out.println(a +" X " + i +" = "+ (a*i));
		}

	}

}
