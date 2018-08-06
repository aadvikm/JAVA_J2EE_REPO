package com.javaexercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/*2. Create a class ArrayListDemo; inside the main method, 
 	*create arraylist variable of Student type. 
 	*Create three Student object and add each to the arraylist variable.
 *3.Itergate though the arraylist variable and print the student detail. Use iterator. Ensure the insertion order is maintained.
  4.Itergate though the arraylist variable and print the student detail. Use For Each now.
  5.Itergate though the arraylist variable and print the student detail. Use tradional / regular for loop.
  6.Using list iterator iterate the arraylist in reverse.
  7.Using list iterator remove the object with id as 100 or pick an id that have used to create a Student.
  8.Using Collections interface, sort the arraylist. 
  	If works, print and see how the objects have been sorted by printing it.
  9.Now, implement Comparable interface, override the method, put in the logic to compare using Student id.
  10.Now, sort arraylist, and print the objects. Ensure it's sorted based on student id. 
  11.Now, modify the compare logic to campare using Student name. 
  12.Now, sort arraylist, and print the objects. Ensure it's sorted based on student name.
  13.Now, write a Comparator and compare using student age. 
  14.Now, sort arraylist using Comparator, print the details. Ensure it's sorted based on comparator logic, not what is in the compareTo method of Student class.
  15.Insert null in arraylist and see it works by iterating and printing it.  
  16.Using contains method, check if Student object is there in arraylist or not. 
  17.Create another arrayList variable. Using addAll method load all the Student object from old variable to new variable. 
  18.Create two new Student objects with same details (id, name, and age). Add it to arraylist variable and iterate and print the details.
 	See if arraylist accecpted duplicates.*/
public class ArrayListDemo {

	public ArrayListDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<Student> arrList =new ArrayList<Student>();
		
		Student s1 = new Student(1100,"Aadvik", 01);
		Student s2 = new Student(1200,"Eshwar", 03);
		Student s3 = new Student(1300, "Harshini", 02);
		
		arrList.add(s1);
		arrList.add(s2);
		arrList.add(s3);
		
		arrListIteration(arrList);
		arrListForEach(arrList);
		arrListForLoop(arrList);
		arrayListIterator(arrList);
		
		System.out.println("Before Sorting :");
		arrListIteration(arrList);
		Collections.sort(arrList);
		System.out.println("After Sorting :");
		arrListIteration(arrList);
		
		System.out.println("Using Comparator..!!");
		Collections.sort(arrList, new StudentIdComparator());
		System.out.println("After Sorting :");
		arrListIteration(arrList);
		System.out.println(arrList.contains(s1));
		
		Student s4 = new Student(1400, "Aadvik", 1);
		Student s5 = new Student(1400, "Aadvik", 1);
		ArrayList<Student> arL = new ArrayList<Student>();
		arL.add(s4);
		arL.add(s5);
		arrList.addAll(arL);
		arrListIteration(arrList);
	}
	
	public static void arrListIteration(ArrayList<Student> arrPara){
		System.out.println("Using Iterator..!!!!");
		Iterator i =arrPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public static void arrListForEach(ArrayList<Student> arrlistPara){
		System.out.println("Using For Each...!!!!");
		for(Student stu : arrlistPara){
			System.out.println(stu);
		}
	}
	public static void arrListForLoop(ArrayList<Student> arrlist){
		System.out.println("Using Regular For Loop..!!!!");
		for(int i=0; i<arrlist.size(); i++){
			System.out.println(arrlist.get(i));
		}
	}
	public static void arrayListIterator(ArrayList<Student> arrListIterator){
		System.out.println("Using List Iterator..!!!!");
		
		ListIterator listIterator =arrListIterator.listIterator();
		while(listIterator.hasNext()){
			
			Student s=(Student)listIterator.next();
			if(s.id ==1100){
				listIterator.remove();
				System.out.println("Removed.!");
				System.out.println(listIterator.next());
			}
		}
		System.out.println("In Reverse..!");
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
	}
}
