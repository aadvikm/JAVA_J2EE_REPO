package com.corejavapractice;

import java.util.Scanner;

/*57. Write a Java program to accepts an integer and count the factors of the number.*/
public class CountTheFactor {

	public CountTheFactor() {
		// TODO Auto-generated constructor stub
	}
	public static int result(int n) {	
		int ctr = 0;
        for(int i=1; i<=(int)Math.sqrt(n); i++) {
            if(n%i==0 && i*i!=n) {
                ctr+=2;
            } else if (i*i==n) {
                ctr++;
            }
        }
        return ctr;
	}
	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	      System.out.print("Input Data: ");
	      int i = in.nextInt(); 

			System.out.println(result(i));

	}

}
