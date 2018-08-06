package com.corejavapractice;
/*48. Write a Java program to print the odd numbers from 1 to 99. Prints one number per line*/
public class OddNumbers {

	public OddNumbers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Odd Numbers from 1 to 99...,");
		for(int i=1; i<100; i++){
			if((i%2)!=0){
				System.out.println(i);
			}
		}

	}

}
