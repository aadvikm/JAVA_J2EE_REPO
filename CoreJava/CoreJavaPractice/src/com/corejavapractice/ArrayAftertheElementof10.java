package com.corejavapractice;

import java.util.Arrays;

/*103. Write a Java program to create a new array from a given array of integers, new array will 
 * contain the elements from the given array after the last element value 10. */
public class ArrayAftertheElementof10 {

	public ArrayAftertheElementof10() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr= {11, 10, 13, 10, 45, 20, 33, 53};
	    int result = 0; 
		System.out.println("Original Array: "+Arrays.toString(arr)); 
		
		int l = arr.length - 1;
		int[] arr1;
		while(arr[l] != 10)
			l--;
		arr1 = new int[arr.length - 1 - l];
		for(int i = l + 1; i < arr.length; i++)
			arr1[i - l - 1] = arr[i];
		System.out.println("New Array: "+Arrays.toString(arr1));

	}

}
