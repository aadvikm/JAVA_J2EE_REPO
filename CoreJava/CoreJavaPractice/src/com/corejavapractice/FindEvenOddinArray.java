package com.corejavapractice;
/*92. Write a Java program to count the number of even and odd elements in a given array of integers*/
public class FindEvenOddinArray {

	public FindEvenOddinArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] arr1 ={4,6,7,9,11,14};
		int even=0;
		int odd=0;
		for(int i=0; i<arr1.length; i++){
			if(arr1[i]%2==0){
				even++;
			}else{
				odd++;
			}
		}
		System.out.println("Count of Even numbers :"+even);
		System.out.println("Count of Odd numbers :"+odd);

	}

}
