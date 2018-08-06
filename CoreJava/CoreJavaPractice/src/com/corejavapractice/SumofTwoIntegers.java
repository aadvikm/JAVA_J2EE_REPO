package com.corejavapractice;

import java.util.Scanner;

/*52. Write a Java program to calculate the sum of two integers and return true if the sum is equal to a third integer. Go to the editor
Sample Output:

Input the first number : 5                                             
Input the second number: 10                                            
Input the third number : 15                                            
The result is: true*/
public class SumofTwoIntegers {

	public SumofTwoIntegers() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean sumOfTwo(int i, int j, int k){
		return (((i+j)==k) ||((i+k)==j) ||((j+k)==i));
	}

	public static void main(String[] args) {
		Scanner a =new Scanner(System.in);
		System.out.println("1st Input :");
		int i =a.nextInt();
		System.out.println("2nd Input :");
		int j =a.nextInt();
		System.out.println("3rd Input :");
		int k =a.nextInt();
		System.out.println("The Result is :"+ sumOfTwo(i,j,k));
		
	}

}
