package com.corejavapractice;

import java.util.Scanner;

/*38. Write a Java program to count the letters, spaces, numbers and other characters of an input string. Go to the editor
Expected Output

The string is :  Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33
letter: 23                                               
space: 9                                                 
number: 10                                               
other: 6*/
public class CountingLetterSpace {

	public CountingLetterSpace() {
		// TODO Auto-generated constructor stub
	}
	
	public static void count(String a){
		char[] b =a.toCharArray();
		int letter =0;
		int space =0;
		int num =0;
		int other=0;
		
		for(int i=0; i<a.length(); i++){
			if(Character.isLetter(b[i])){
				letter++;
			}
			else if(Character.isDigit(b[i])){
				num++;
			}
			else if(Character.isSpaceChar(b[i])){
				space++;
			}
			else{
				other++;
			}
		}
		
		System.out.println("The String is :"+a);
		System.out.println("No.of letters : "+letter);
		System.out.println("No.of space : "+space);
		System.out.println("No.of num : "+num);
		System.out.println("No.of other : "+other);
	}
	public static void main(String[] args) {
		String a ="Hello World..!! I am Brindha..!!,";
		count(a);
		

	}

}
