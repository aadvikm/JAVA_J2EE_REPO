package com.corejavapractice;

import java.util.Arrays;

/*100. Write a Java program to count the two elements differ by 1 or 
 * less of two given arrays of integers with same length.*/
public class SubtractTwoArrays {

	public SubtractTwoArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr1 = {10, 11, 10, 20, 43, 20, 50};
		int[] arr2 = {10, 13, 11, 20, 44, 30, 50};
		System.out.println("Array1: "+Arrays.toString(arr1)); 
		System.out.println("Array2: "+Arrays.toString(arr2)); 
		int ctr = 0;
	    
	    for(int i = 0; i < arr1.length; i++) {
	        if(Math.abs(arr1[i] - arr2[i]) <= 1 && arr1[i] != arr2[i])
	            ctr++;
	    }
	                    
	    System.out.printf("Number of elements: "+ctr);
		System.out.printf("\n");	 

	}

}
