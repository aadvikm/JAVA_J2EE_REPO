package com.corejavapractice;

import java.nio.charset.Charset;

//40. Write a Java program to list the available character sets in charset objects
public class CharacterSet {

	public CharacterSet() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("List of available character Set in charset Objects");
		for(String s : Charset.availableCharsets().keySet()){
			System.out.println(s);
			
		}

	}

}
