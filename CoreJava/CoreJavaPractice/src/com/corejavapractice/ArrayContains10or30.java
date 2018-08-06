package com.corejavapractice;

import java.util.Arrays;

/*102. Write a Java program to check if a specified array of 
 * integers contains 10's or 30's.*/
public class ArrayContains10or30 {

	public ArrayContains10or30() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {11, 11, 13, 31, 45, 20, 30, 53};
	    int result = 1; 
		System.out.println("Original Array: "+Arrays.toString(arr)); 
		
		for(int i = 0; i < arr.length; i++)
	     {
	      	if(arr[i] == 10 || arr[i] == 30){	
	  		
			   result =0;
			}
	      }
		 if(result==0){
	 	   System.out.printf(String.valueOf(true));	 
		 }
	     else{
		   System.out.printf(String.valueOf(false));
	     }

	}

}
