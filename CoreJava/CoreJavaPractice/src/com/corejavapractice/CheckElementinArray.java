package com.corejavapractice;
/*96. Write a Java program to check if there is a 10 in a given array of integers
 *  with a 20 somewhere later in the array. */
public class CheckElementinArray {

	public CheckElementinArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {10, 70, 80, 50, 20, 13, 50};
	      boolean value = false;
	      int a=10;
	      int b=20;
	      int x =0;
	      
	      for(int i=0; i<arr.length;i++){
	    	  if(arr[i]==a){
	    		  value=true;
	    	  }
	    	  if(true && arr[i]==20){
	    		  System.out.println(String.valueOf(true));
	    		  x=1;
	    	  }
	      }
	      if(x==0){
	    	  System.out.println(String.valueOf(false));
	      }
	      System.out.println("\n");
	      
	      
	}

}
