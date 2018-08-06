package com.corejavapractice;

import java.util.Scanner;

/*35. Write a Java program to compute the area of a polygon.*/
public class AreaofPolygon {

	public AreaofPolygon() {
		// TODO Auto-generated constructor stub
	}
	
	public static double polygonArea(int n, double l){
		return (n * (l * l)) / (4.0 * Math.tan((Math.PI / n)));
	}
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("Enter the no.of sides of polygon :");
		int n=scan.nextInt();
		
		System.out.println("Enter the length of the side of the polygon:");
		double l=scan.nextDouble();
		
		System.out.println("Area of Polygon :"+polygonArea(n,l)+"\n");

	}

}
