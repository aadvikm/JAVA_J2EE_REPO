package com.corejavapractice;

import java.util.Arrays;

/*78. Write a Java program to test that a given array of integers of length 2 contains a 4 or a 7. Go to the editor
Sample Output:

Original Array: [5, 7]                                                 
true */
public class CheckingArrayElements {

	public CheckingArrayElements() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {5, 7};
		System.out.println("Original Array: "+Arrays.toString(arr));
		if(arr[0] == 4 || arr[0] == 7){
			System.out.println("True");
		}
		else if(arr[1] == 4 || arr[1] == 7){
			System.out.println("True");
	    }

	}

}
