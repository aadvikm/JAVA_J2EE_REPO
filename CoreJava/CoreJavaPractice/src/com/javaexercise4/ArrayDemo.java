package com.javaexercise4;

public class ArrayDemo {

	public ArrayDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		System.out.println("Single Dimentional Array..!!");
		
		int a[] ={1,2,3,4,5,6};
		for(int b :a){
			System.out.println(b);
		}
		
		System.out.println("Two Dimentional Array..!!");
		
		int x [] [] = new int [2][2];
		x[0][0] =7;
		x[0][1] =8;
		x[1][0] =9;
		x[1][1] =10;
		
		for(int i=0; i<x.length; i++){
			for(int j =0; j<x.length; j++){
				System.out.println(x[i][j]);
			}
		}
		
		System.out.println("Multi Dimentional Array..!!");
		
		int [][] c =new int[3][2];
		c[0][0]=11;
		c[0][1]=12;
		c[1][0]=13;
		c[1][1]=14;
		c[2][0]=15;
		c[2][1]=16;
			
		for(int i=0; i<c.length; i++){
			for(int j=0; j<c[i].length; j++){
				System.out.println(c[i][j]);
			}
		}
		
		c[2][2] = 20;
		
		for(int i=0; i<c.length; i++){
			for(int j=0; j<c[i].length; j++){
				System.out.println(c[i][j]);
			}
		}

	}

}
