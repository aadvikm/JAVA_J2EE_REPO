package com.corejavapractice;

import java.util.Scanner;

/*108. Write a Java program to add all the digits of a given positive 
 * integer until the result has a single digit*/
public class SingleDigitOutput {

	public SingleDigitOutput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);	
			System.out.print("Input a positive integer: ");
	        int n = in.nextInt(); 
			if (n>0){
				 System.out.print("The single digit number is: "+(n == 0 ? 0 : (n % 9 == 0 ? 9 : n % 9)));
	          
			}
			System.out.println("\n");  
	}

}
