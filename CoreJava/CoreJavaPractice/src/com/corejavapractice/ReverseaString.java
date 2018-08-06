package com.corejavapractice;

import java.util.Scanner;

/*37. Write a Java program to reverse a string. Go to the editor
Input Data:
Input a string: The quick brown fox */
public class ReverseaString {

	public ReverseaString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("Input Data :");
		char[] a =scan.nextLine().toCharArray();
		System.out.println("Reverse of data..!");
		for(int i =a.length-1; i>=0; i--){
			System.out.print(a[i]);
		}
		
		
		

	}

}
