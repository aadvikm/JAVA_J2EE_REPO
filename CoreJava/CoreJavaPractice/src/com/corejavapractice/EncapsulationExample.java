package com.corejavapractice;

import java.util.ArrayList;
import java.util.Iterator;

public class EncapsulationExample {
	
	private String name;
	private int age;
	
	public EncapsulationExample() {
		// TODO Auto-generated constructor stub
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
