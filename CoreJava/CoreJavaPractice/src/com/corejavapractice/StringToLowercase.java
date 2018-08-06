package com.corejavapractice;

import java.util.Scanner;

/*59. Write a Java program to convert a given string into lowercase. Go to the editor
Sample Output:

Input a String: THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.           
the quick brown fox jumps over the lazy dog.*/
public class StringToLowercase {

	public StringToLowercase() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Pls enter the Sentence :");
		String i =scan.nextLine();
		String a =i.toLowerCase();
		System.out.println(a);

	}

}
