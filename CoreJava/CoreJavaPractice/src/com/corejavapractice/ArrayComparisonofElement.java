package com.corejavapractice;

import java.util.Arrays;

/*101. Write a Java program to check if the number of 10 is
 *  greater than number to 20's in a given array of integers. */
public class ArrayComparisonofElement {

	public ArrayComparisonofElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr1 = {10, 11, 10, 30, 45, 20, 33, 53};
	    int result = 0; 
		System.out.println("Original Array: "+Arrays.toString(arr1)); 
	    
		int ctr1 = 0;
	    int ctr2 = 0;
	      
	    for(int i = 0; i < arr1.length; i++) {
	        if(arr1[i] == 10)
	            ctr1++;
	                        
	        if(arr1[i] == 20)
	            ctr2++;
	    }                                      
	    System.out.printf(String.valueOf(ctr1 > ctr2));
		System.out.printf("\n");
	  

	}

}
