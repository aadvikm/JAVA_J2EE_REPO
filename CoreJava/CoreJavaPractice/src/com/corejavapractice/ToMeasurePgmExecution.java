package com.corejavapractice;

import java.util.Scanner;

/*91. Write a Java program to measure how long some code 
 * takes to execute in nanoseconds. */
public class ToMeasurePgmExecution {

	public ToMeasurePgmExecution() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		long nanoTime1 =System.nanoTime();
		System.out.println("Starting  time :"+nanoTime1);
		//Given number is Even or Odd
		Scanner scan=new Scanner(System.in);
		System.out.println("Input Data :");
		int a =scan.nextInt();
		if(a%2==0){
			System.out.println("Even Number.!");
		}
		else {
			System.out.println("Odd Number.!");
		}
		
		long estimatedTime =System.nanoTime() -nanoTime1;
		System.out.println("Estimated time (in nanoseconds) to execute even or odd pgm :" +estimatedTime);
		

	}

}
