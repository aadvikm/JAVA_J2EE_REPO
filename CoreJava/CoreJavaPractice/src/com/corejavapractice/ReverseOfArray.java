package com.corejavapractice;

import java.util.Arrays;

/*79. Write a Java program to rotate an array (length 3) of integers in left direction. Go to the editor
Sample Output:

Original Array: [20, 30, 40]                                           
Rotated Array: [30, 40, 20]*/
public class ReverseOfArray {

	public ReverseOfArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr1 = {20, 30, 40};
		System.out.println("Original Array :"+Arrays.toString(arr1));
		System.out.println("Rotated array :");
		for(int i=arr1.length-1; i>=0; i--){
			System.out.print(arr1[i]+",");
			
		}
		
	}

}
