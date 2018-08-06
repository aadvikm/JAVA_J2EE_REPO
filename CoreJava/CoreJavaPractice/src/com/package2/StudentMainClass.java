package com.package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StudentMainClass {

	public StudentMainClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Student s1 =new Student("Aadvik", 1100);
		Student s2 =new Student("Brindha", 1200);
		Student s3 =new Student("Muthu", 1300);
		
		ArrayList<Student> arrStu =new ArrayList<Student>();
		arrStu.add(s1);
		arrStu.add(s2);
		arrStu.add(s3);
		System.out.println("Before Sorting..!!");
		arrayListIteration(arrStu);
		System.out.println("After Sorting.>!!");
		Collections.sort(arrStu);
		arrayListIteration(arrStu);
		
		System.out.println("ArrayList Contains s3 :"+arrStu.contains(s3));
		
		
		System.out.println("Using RollNo Comparator..!!!");
		System.out.println("Before Sorting..!!");
		arrayListIteration(arrStu);
		System.out.println("After Sorting.>!!");
		Collections.sort(arrStu, new StudentRollNoComparator());
		arrayListIteration(arrStu);
		
		System.out.println("Using Name Comparator..!!!");
		System.out.println("Before Sorting..!!");
		arrayListIteration(arrStu);
		System.out.println("After Sorting.>!!");
		Collections.sort(arrStu, new StudentNameComparator());
		arrayListIteration(arrStu);
		
	}
	public static void arrayListIteration(ArrayList<Student> arPara){
		System.out.println("Using Iterator");
		Iterator i =arPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
}
