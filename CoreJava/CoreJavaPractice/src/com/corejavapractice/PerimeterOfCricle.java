package com.corejavapractice;

/*11. Write a Java program to print the area and perimeter of a circle.
 * Test Data:
Radius = 7.5 */
public class PerimeterOfCricle {
	
	private static double r =7.5;
	
	public PerimeterOfCricle() {
		// TODO Auto-generated constructor stub
	}
	
	double perimeter =2* Math.PI *r;
	double area =Math.PI *r*r;

	public static void main(String[] args) {
		
		PerimeterOfCricle peri =new PerimeterOfCricle();
		
		System.out.println("Radius of the Circle :"+r);
		System.out.println("Perimeter of the Circle :" +peri.perimeter);
		System.out.println("Area of the Circle :" +peri.area);
	}

}
