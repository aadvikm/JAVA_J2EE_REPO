package com.corejavapractice;

import java.util.Arrays;

/*104. Write a Java program to create a new array from a given array of integers, new array will 
 * contain the elements from the given array before the last element value 10.*/
public class ArrayBeforetheElement10 {

	public ArrayBeforetheElement10() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {11, 15, 13, 10, 45, 20, 33, 53};
	    int result = 0; 
		System.out.println("Original Array: "+Arrays.toString(arr)); 
		
		int l = 0;
		int[] arr1;
		while(arr[l] != 10)
		  l++;
		arr1 = new int[l];
		for(int i = 0; i < l; i++)
			arr1[i] = arr[i];
		System.out.println("New Array: "+Arrays.toString(arr1)); 

	}

}
