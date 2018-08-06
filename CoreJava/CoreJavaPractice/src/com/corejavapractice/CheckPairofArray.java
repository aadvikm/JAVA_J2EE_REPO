package com.corejavapractice;
/*99. Write a Java program to check if a specified number appears in 
 * every pair of adjacent element of a given array of integers.*/
public class CheckPairofArray {

	public CheckPairofArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr= {10, 20, 10, 20, 40, 20, 50};
		int result = 0;	
		int x = 20;
		for(int i = 0; i < arr.length - 1; i++) {
	        if(arr[i] != x && arr[i + 1] != x){
	              result = 1;	
			}        
	    }                                   
	    if (result==0) {
	     	 System.out.printf(String.valueOf(true));	         
		  }
	    else{
	     	 System.out.printf(String.valueOf(false));	         
		  }		
	    

	}

}
