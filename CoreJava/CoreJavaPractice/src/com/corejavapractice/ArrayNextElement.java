package com.corejavapractice;

import java.util.Arrays;

/*93. Write a Java program to test if an array of integers contains an element 10 next to 10 
 * or an element 20 next to 20, but not both. */
public class ArrayNextElement {

	public ArrayNextElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {10, 10, 2, 4, 20, 20};
		System.out.println("Original Array: "+Arrays.toString(arr)); 
		
		boolean foundTen = false;
	    boolean foundTwenty = false;
	    
	    for(int i = 0; i < arr.length - 1; i++) {
	        if(arr[i] == 10 && arr[i+1] == 10)
	            foundTen = true;
	                        
	        if(arr[i] == 20 && arr[i+1] == 20)
	            foundTwenty = true;
	    }
	   
		System.out.printf( String.valueOf(foundTen != foundTwenty));	
		System.out.printf("\n");

	}

}
