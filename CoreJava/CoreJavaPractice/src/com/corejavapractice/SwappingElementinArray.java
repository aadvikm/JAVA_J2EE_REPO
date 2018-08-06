package com.corejavapractice;

import java.util.Arrays;

/*81. Write a Java program to swap the first and last elements of an array (length must be at least 1) and create a new array. Go to the editor
Sample Output:

Original Array: [20, 30, 40]                                           
New array after swaping the first and last elements: [40, 30, 20] */
public class SwappingElementinArray {

	public SwappingElementinArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] arr = {20, 30, 40};
		System.out.println("Before Swapping :"+Arrays.toString(arr));
		int temp =arr[0];
		arr[0]=arr[arr.length-1];
		arr[arr.length-1]=temp;
		System.out.println("After Swapping :"+Arrays.toString(arr));
		

	}

}
