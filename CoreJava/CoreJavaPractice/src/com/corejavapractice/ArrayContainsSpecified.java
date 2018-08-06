package com.corejavapractice;
/*97. Write a Java program to check if an array of integers contains a specified number next to each other 
 * or there are two same specified numbers separated by one element.*/
public class ArrayContainsSpecified {

	public ArrayContainsSpecified() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {10, 20, 10, 50, 20, 13, 50};
		int a=arr[0];
		int x=0;
		boolean b=false;
		
		for(int i = 0; i < arr.length - 1; i++) {
	        if(arr[i] == a && arr[i+1] == a)
	            {
	         System.out.printf( String.valueOf(true));	
	         x = 1 ;
			}
	                  
	        if(i <= arr.length - 3 && arr[i] == a && arr[i+2] == a)
	           {
	         System.out.printf( String.valueOf(true));	
	         x = 1 ;
			}
	    }
		if(x==0){
			 System.out.println(String.valueOf(false));
		}
		  System.out.println("\n");
	}

}
