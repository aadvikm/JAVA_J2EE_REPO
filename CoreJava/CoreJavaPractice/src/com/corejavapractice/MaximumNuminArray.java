package com.corejavapractice;
/*80. Write a Java program to get the larger value between first and last element of an array (length 3) of integers . Go to the editor
Sample Output:

Original Array: [20, 30, 40]                                           
Larger value between first and last element: 40 */
public class MaximumNuminArray {

	public MaximumNuminArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] arr1 ={20,30,40};
		int max =arr1[0];
		
		for(int i=1; i<arr1.length; i++){
			if(max <=arr1[i]){
				max = arr1[i];
			}
		}
		System.out.println("The Largest Number in the given array is :"+max);

	}

}
