package com.corejavapractice;

/*4. Write a Java program to print the result of the following operations. Go to the editor
Test Data:
a. -5 + 8 * 6
b. (55+9) % 9 
c. 20 + -3*5 / 8 
d. 5 + 15 / 3 * 2 - 8 % 3 */
public class ArithmeticOperation {

	public ArithmeticOperation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("-5 + 8 * 6 :" +(-5 + 8 * 6));
		System.out.println("(55+9) % 9 :" +(55+9) % 9 );
		System.out.println("20 + -3*5 / 8 :" + (20 + -3*5 / 8 ));
		System.out.println("5 + 15 / 3 * 2 - 8 % 3 :" + (5 + 15 / 3 * 2 - 8 % 3 ));
	}

}
