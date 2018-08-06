package com.corejavapractice;

import java.util.Arrays;

/*105. Write a Java program to check if a group of numbers
 *  (l) at the start and end of a given array are same*/
public class SameGroupofElementsinArray {

	public SameGroupofElementsinArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {11, 15, 13, 10, 45, 20, 11, 15};
	    System.out.println("Original Array: "+Arrays.toString(arr)); 
		
		int result = 0;
		int start =0;
		int end=arr.length-2;
		for(int i=2; i>0; i--){
			if(arr[start] !=arr[end]){
				result=1;
			}else{
				start++;
				end++;
			}
		}
		 if (result==1)
		 {
		  System.out.printf(String.valueOf(false));
		 }
		else
		 {
		   System.out.printf(String.valueOf(true));
		 }
		 System.out.printf("\n");	

	}

}
