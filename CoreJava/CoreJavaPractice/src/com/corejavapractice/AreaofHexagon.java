package com.corejavapractice;

import java.util.Scanner;

/*
 * 34. Write a Java program to compute the area of a hexagon. Go to the editor
Area of a hexagon = (6 * s^2)/(4*tan(π/6))
where s is the length of a side
Input Data:
Input the length of a side of the hexagon: 6*/
public class AreaofHexagon {

	public AreaofHexagon() {
		// TODO Auto-generated constructor stub
	}
	
	public static double areaHexgon(double d){
		return (6*(d*d))/(4*Math.tan(Math.PI/6));
	}

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Input Data :");
		double d =scan.nextDouble();
		System.out.println("Area of Hexagon :"+ areaHexgon(d));

	}

}
