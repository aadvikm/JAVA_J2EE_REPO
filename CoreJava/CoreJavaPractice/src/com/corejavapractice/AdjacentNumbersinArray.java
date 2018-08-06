package com.corejavapractice;

import java.util.Arrays;

/*107. Write a Java program to check if an array of integers
 *  contains three increasing adjacent numbers.*/
public class AdjacentNumbersinArray {

	public AdjacentNumbersinArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr= {11, 12, 13, 14, 45, 20};
	    System.out.println("Original Array: "+Arrays.toString(arr)); 
	    int count=1;
	    for(int i=0; i<=arr.length-3;i++){
	    	if(arr[i]+1 ==arr[i+1] && arr[i+1]+1 == arr[i+2]){
	    		count=0;
	    	}
	    }
	    if (count==1)
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
