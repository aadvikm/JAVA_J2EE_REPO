package com.corejavapractice;

import java.util.Arrays;

/*7. Write a Java program to create a new array of length 2 from two arrays of integers 
 * with three elements and the new array will contain the first and 
 * last elements from the two arrays*/
public class FirstandLastElementOfArray {

	public FirstandLastElementOfArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 int[] arr1 = {50, -20, 0};
		 int[] arr2 = {5, -50, 10};
		 int[] arr3= {arr1[0], arr2[2]};
		 
		 System.out.println("Array One :"+Arrays.toString(arr1));
		 System.out.println("Array Two :"+Arrays.toString(arr2));
		 System.out.println("New Array :"+Arrays.toString(arr3));

	}

}
