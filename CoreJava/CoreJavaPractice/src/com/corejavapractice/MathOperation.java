package com.corejavapractice;

/*9. Write a Java program to compute the specified expressions and print the output. 
 * Test Data:
((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5))

*10. Write a Java program to compute a specified formula. 
*Specified Formula : 
4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))*/
public class MathOperation {

	public MathOperation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)) :" + ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
		System.out.println(" 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11) :"+ (4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))));
	}

}
