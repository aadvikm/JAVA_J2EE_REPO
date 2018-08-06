package com.corejavapractice;

import java.util.Scanner;

/*49. Write a Java program to accept a number and check the number is even or not. Prints 1 if the number is even or 0 if the number is odd. Go to the editor
Sample Output:

Input a number: 20                                                     
1*/
public class EvenOrOdd {

	public EvenOrOdd() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the Number :");
		
		int i =scan.nextInt();
		
		if((i%2) !=0){
			System.out.println("Output :0 "+i+" is an odd Number");
		}
		else{
			System.out.println("Output :1 "+i+" is an even Number");
		}

	}

}
