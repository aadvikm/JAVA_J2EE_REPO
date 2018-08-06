package com.corejavapractice;

import java.util.Scanner;

/*58. Write a Java program to capitalize the first letter of each word in a sentence. Go to the editor
Sample Output:

Input a Sentence: the quick brown fox jumps over the lazy dog.         
The Quick Brown Fox Jumps Over The Lazy Dog.*/
public class CapitalizeTheFirstLetter {

	public CapitalizeTheFirstLetter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	     System.out.print("Input a Sentence: ");
		 String l = in.nextLine();
		 String s = ""; 
	       Scanner scan = new Scanner(l); 
	         while(scan.hasNext()) {
	             String i = scan.next(); 
	             s += Character.toUpperCase(i.charAt(0)) + i.substring(1) + " "; 
	         }
	      System.out.println(s.trim()); 
	    }

	

}
