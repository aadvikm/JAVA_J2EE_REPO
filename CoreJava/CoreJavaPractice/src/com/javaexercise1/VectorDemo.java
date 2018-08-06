package com.javaexercise1;

import java.util.Enumeration;
import java.util.Vector;

/*Creat a Vector using Student, perform below operations
1) Add Students, iterate, and remove all. */

/*Write down key differnce between Stack, Vector, Queue, List, and Set.
Ans: Stack :its a legacy collection,data structure of stack is LILO.
 vector : its also legacy Collection, we need to iterator thru enumeration.
 Queue : its an interface which extends collection,Priority Queue is the class which implements the Queue.
		we can't insert null into the Queue. Data Structure of Queue is FIFO.
 List : List is an interface which extends collection and ArrayList, linkedList, stack, vector these are the classes implements List interface., and it allows duplicate values.
 Set : set is an interface which extends collection, HashSet, LinkedHashSet, which implements set and SortedSet extends set and treeset implements SortedSet. 
		And it does not allow the duplicate values.*/
public class VectorDemo {

	public VectorDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Student s1 =new Student(100,"Brindha", 7);
		Student s2 =new Student(101,"Aadvik", 26);
		Student s3 =new Student(102,"Muthu", 30);
		
		Vector<Student> vec =new Vector<Student>();
		vec.add(s1);
		vec.add(s2);
		vec.add(s3);
		vectorIterator(vec);
		System.out.println("to remove one object in the vector :"+vec.remove(s1));
		vec.removeAllElements();//to remove all the object in the vector 
		System.out.println("Size of the vector :"+vec.size());
		
	}
	
	public static void vectorIterator(Vector<Student> vecPara){
		Enumeration e = vecPara.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}
}
