package com.corejavapractice;

/*13. Write a Java program to print the area and perimeter of a rectangle. Go to the editor
Test Data:
Width = 5.5 Height = 8.5*/
public class PrimeterOfRect {
	
		double width =5.5;
		double height=8.5;
	public PrimeterOfRect() {
		// TODO Auto-generated constructor stub
	}
	
	double perimeter = 2*(width+height);
	double area =width +height;
	public static void main(String[] args) {
		PrimeterOfRect peri =new PrimeterOfRect();
		
		System.out.println("Perimeter of the rectangle is :"+peri.perimeter);
		System.out.println("Area of the rectangle is :"+peri.area);

	}

}
