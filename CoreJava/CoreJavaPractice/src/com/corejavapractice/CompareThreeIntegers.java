package com.corejavapractice;

import java.util.Scanner;

/*53. Write a Java program that accepts three integers from the user and return true if the second number is greater than first number and third number is greater than second number. If "abc" is true second number does not need to be greater than first number. Go to the editor
Sample Output:

Input the first number : 5                                             
Input the second number: 10                                            
Input the third number : 15                                            
The result is: true */
public class CompareThreeIntegers {

	public CompareThreeIntegers() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean abc(int i, int j, int k, boolean abc){
		if(abc){
			return(k>j);
		}
		return(j>i && k>j);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("1st Input: ");
        int i = in.nextInt();  
		System.out.print("2nd Input: ");
		int j = in.nextInt(); 
		System.out.print("3rd Input: ");
        int k = in.nextInt(); 
        System.out.print("The result is: "+abc(i, j, k,true));
		System.out.print("\n");

	}

}
