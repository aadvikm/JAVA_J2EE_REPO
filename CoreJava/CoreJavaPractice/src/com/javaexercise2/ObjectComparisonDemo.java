package com.javaexercise2;

public class ObjectComparisonDemo {

	public ObjectComparisonDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Student s1 =new Student(101,"Aadvik");
		Student s2 =new Student(102,"Brindha");
		Student s3 =new Student(102,"Muthu");
		
		System.out.println("s1 equals s2 :"+s1.equals(s2));
		System.out.println("s1 equals s3 :"+s1.equals(s3));
		System.out.println("s2 equals s3 :"+s2.equals(s3));
		
		System.out.println("s1 hashCode() :"+s1.hashCode());
		System.out.println("s2 hashCode() :"+s2.hashCode());
		System.out.println("s3 hashCode() :"+s3.hashCode());

	}

}
