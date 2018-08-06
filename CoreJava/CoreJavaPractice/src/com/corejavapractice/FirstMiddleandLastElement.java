package com.corejavapractice;

import java.util.Arrays;

/*82. Write a Java program to find the largest element between first, last, and middle values from an array of integers (even length). Go to the editor
Sample Output:

Original Array: [20, 30, 40, 50, 67]                                   
Largest element between first, last, and middle values: 67*/
public class FirstMiddleandLastElement {

	public FirstMiddleandLastElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr [] ={20, 30, 50, 60, 90};
		System.out.println("Original Array :"+ Arrays.toString(arr));
		
		int max =arr[0];
		if(max <=arr[arr.length-1]){
			max=arr[arr.length-1];
		}
		if(max <=arr[arr.length/2]){
			max =arr[arr.length/2];
		}
		
		System.out.println("First Element :"+arr[0] +" Mid Element :"+arr[arr.length/2]+" Last Element :"+ arr[arr.length-1]);
		System.out.println("Max Element between 1st, mid & last is :"+ max);

	}

}
