package com.package1;
import com.corejavapractice.EncapsulationExample;
public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EncapsulationExample ee =new EncapsulationExample();
		ee.setName("Aadvik Muthukumaran");
		ee.setAge(1);
		System.out.println("Name :"+ ee.getName()+ " "+"Age :"+ee.getAge());
		ee.setName("Brindha Damodaran");
		ee.setAge(26);
		System.out.println("Name :"+ ee.getName()+ " "+"Age :"+ee.getAge());
		ee.setName("Muthukumaran Natarajan");
		ee.setAge(30);
		System.out.println("Name :"+ ee.getName()+ " "+"Age :"+ee.getAge());
		
	}

}
