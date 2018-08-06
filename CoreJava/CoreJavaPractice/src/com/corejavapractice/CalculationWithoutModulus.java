package com.corejavapractice;

import java.util.Scanner;

/*65. Write a Java program to calculate the modules of two numbers without using any inbuilt modulus operator. Go to the editor
Sample Output:

Input the first number : 19                                            
Input the second number: 7                                             
5   */
public class CalculationWithoutModulus {

	public CalculationWithoutModulus() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("1st Input : ");
        int a = in.nextInt();  
		System.out.print("2nd Input: ");
		int b = in.nextInt(); 
		int div = a / b;
		int c = a - (div * b);
		System.out.println(div); 
		System.out.println(c); 

	}

}
