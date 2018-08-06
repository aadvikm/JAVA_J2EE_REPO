package com.corejavapractice;

import java.util.Scanner;

/*115. Write a Java program to check if a positive number is a palindrome or not. Go to the editor
Input a positive integer: 151 
Is 151 is a palindrome number? 
true*/
public class PalindromeorNot {

	public PalindromeorNot() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Input Number:");
		 int n= scan.nextInt();
		 int r,sum=0,temp;    
		  temp=n;    
		  while(n>0){    
		   r=n%10; 
		   sum=(sum*10)+r;    
		   n=n/10;    
		  }    
		  if(temp==sum)    
		   System.out.println("palindrome number ");    
		  else    
		   System.out.println("not palindrome");    
	}

}
