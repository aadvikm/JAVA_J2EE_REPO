package com.corejavapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*113. Write a Java program to merge two given sorted array of integers and create 
 * a new sorted array. Go to the editor
array1 = [1,2,3,4]
array2 = [2,5,7, 8]
result = [1,2,2,3,4,5,7,8] */
public class MergingTwoArrays {

	public MergingTwoArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] array1 = {1,2,3,4};
		int [] array2 = {2,5,7, 8};
		System.out.println("Array1: "+Arrays.toString(array1));  
	    System.out.println("Array2: "+Arrays.toString(array2));
	    
	    int [] result =new int[array1.length+array2.length];
	    int count=0;
	    
	    for(int i=0; i<array1.length; i++){
	    	result[i]=array1[i];
	    	count++;
	    }
	    for(int j = 0;j<array2.length;j++) { 
	         result[count++] = array2[j];
	    }
	 
	    System.out.println("Result: "+Arrays.toString(result));
	}

}
