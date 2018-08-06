package com.corejavapractice;

import java.util.Scanner;

/*109. Write a Java program to form a staircase shape of
 *  n coins where every k-th row must have exactly k coins.*/
public class StaircaseShape {

	public StaircaseShape() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);	
	     System.out.print("Input a positive integer: ");
	        int n = in.nextInt(); 
	        if (n>0){
	           System.out.println("Number of rows: "+((int)((Math.sqrt(8 * (long)n + 1) - 1) / 2)));	
			}       	

	}

}
