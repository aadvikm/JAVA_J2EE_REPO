package com.corejavapractice;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;

/*61. Write a Java program to reverse a word. Go to the editor
Sample Output:

Input a word: dsaf
Reverse word: fasd*/
public class ReverseWord {

	public ReverseWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Pls Enter a word :");
		char []a =scan.nextLine().toCharArray();
		System.out.println("Reverse Word :");
		for(int i=a.length-1; i>=0; i--){
			System.out.print(a[i]);
		}
		

	}

}
