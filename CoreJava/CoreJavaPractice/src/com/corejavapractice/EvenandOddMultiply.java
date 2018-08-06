package com.corejavapractice;

import java.util.Scanner;

/*86. Write a Java program start with an integer n, divide n 
 * by 2 if n is even or multiply by 3 and add 1 if n is odd,
 *  repeat the process until n = 1. */
public class EvenandOddMultiply {

	public EvenandOddMultiply() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Input Data :");
		int c =0;
		int n =scan.nextInt();
		while(n!=1){
			if((n%2)==0){
				n =(n/2);
				c+=1;
			}else{
				n=(3*n+1)/2;
				c+=1;
			}
			
		}
		System.out.println("C value is :"+c);
		System.out.println("n value is :"+n);
	}

}
