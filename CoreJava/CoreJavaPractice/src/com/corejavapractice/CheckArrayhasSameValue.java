package com.corejavapractice;
/*98. Write a Java program to check if the value 20 appears 
 * three times and no 20's are next to each other in an given array of integers. */
public class CheckArrayhasSameValue {

	public CheckArrayhasSameValue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr= {10, 20, 10, 20, 40, 13, 20};
		
		int count = 0, result =0;
	    
	    if(arr.length >= 1 && arr[0] == 20)
	        count++;

	    for(int i = 1; i < arr.length; i++) {
	        if(arr[i - 1] == 20 && arr[i] == 20)
			{
	         System.out.printf(String.valueOf(false));	
	         result = 1;
			}                   
	        if(arr[i] == 20)
	            count++;
	    }
	                                          
	    if (result==0) {
	     	 System.out.printf(String.valueOf(count == 3));	         
		  }	
		  System.out.printf("\n");	
	    

	}

}
