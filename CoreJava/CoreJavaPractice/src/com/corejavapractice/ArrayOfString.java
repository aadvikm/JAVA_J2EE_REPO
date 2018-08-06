package com.corejavapractice;

import java.util.Arrays;
import java.util.Scanner;

/*95. Write a Java program to create an array (length # 0) of string values.
 *  The elements will contain "0", "1", "2" … through ... n-1. */
public class ArrayOfString {

	public ArrayOfString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		System.out.println("Pls Enter a Value :");
		int a =s.nextInt();
		String[] arr =new String[a];
		
		for(int i=0; i<a;i++){
			arr[i]=String.valueOf(i);
			
		}
		System.out.println("New Array :"+Arrays.toString(arr));
	}

}
