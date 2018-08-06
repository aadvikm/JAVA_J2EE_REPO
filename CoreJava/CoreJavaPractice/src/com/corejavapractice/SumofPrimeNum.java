package com.corejavapractice;
/*66. Write a Java program to compute the sum of the first 100 prime numbers. Go to the editor
Sample Output:

Sum of the first 100 prime numbers: 24133 
*/
public class SumofPrimeNum {

	public SumofPrimeNum() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean is_Prime(int n) {
		for (int i = 3; i * i <= n; i+= 2) {
			if (n % i == 0) {
				return false; 
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int sum = 1;
		int ctr = 0; 
		int n = 0; 
			while (ctr < 100) {
				n++; 
				if (n % 2 != 0) { 
					if (is_Prime(n)) {
						sum += n; 
						ctr++; 
					}
				}	
			}
			System.out.println("\nSum of the first 100 prime numbers: "+sum); 	
	}

}
