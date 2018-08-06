package com.corejavapractice;

import java.util.Arrays;

/*83. Write a Java program to multiply corresponding elements of two arrays of integers. Go to the editor
Sample Output:

Array1: [1, 3, -5, 4]                                                  
                                                                       
Array2: [1, 4, -5, -2]                                                 
                                                                       
Result: 1 12 25 -8*/
public class MultiplyTwoArrays {

	public MultiplyTwoArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr1[]={1,3,-5,4};
		int arr2[]={1,4,-5,-2};
		System.out.println("Array 1 :"+ Arrays.toString(arr1));
		System.out.println("Array 2 :"+ Arrays.toString(arr2));
		System.out.println("Multiplied Values are:");
		for(int i=0; i<arr1.length; i++){
			int mul =arr1[i]*arr2[i];
			System.out.print(mul+",");
		}
		System.out.print("\n");
	}

}
