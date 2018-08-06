package com.corejavapractice;
/*56. Write a Java program to find the number of integers within the range of two specified numbers and that are divisible by another number. Go to the editor
For example x = 5, y=20 and p =3, find the number of integers within the range x..y and that are divisible by p i.e. { i :x ≤ i ≤ y, i mod p = 0 }
Sample Output:

5*/
public class TwoSpecifiedNumber {

	public TwoSpecifiedNumber() {
		// TODO Auto-generated constructor stub
	}
	
	public static int result(int x, int y, int p) {	
		if (x%p == 0)
			return( y/p - x/p + 1);
		return(y/p - x/p);
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 20;
		int c = 3;
		System.out.println(result(a,b,c));
	}

}
