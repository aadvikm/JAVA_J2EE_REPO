package com.javaexercise1;

import java.util.Iterator;
import java.util.Stack;

/*Create a Stack using Student, perform below operations	
1) Demonstrate following operation with proper examples; push, peek, pop, search and empty.*/
public class StackDemo {

	public StackDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Student s1 =new Student(100,"Brindha", 7);
		Student s2 =new Student(101,"Aadvik", 26);
		Student s3 =new Student(102,"Muthu", 30);
		
		Stack<Student> st = new Stack<Student>(); //LILO
		st.push(s1);
		st.push(s2);
		st.push(s3);
		stackIteration(st);
		System.out.println("To read the last object in the stack :"+ st.peek());
		System.out.println("To remove the last object in the stack :"+ st.pop());
		System.out.println("To check stack is empty or not :"+ st.isEmpty());
		System.out.println(st.search(s3));//Returns the 1-based position where an object is on this stack. 
		System.out.println(st.search(s2));
		System.out.println(st.search(s1));
	}
	
	public static void stackIteration(Stack<Student> stPara){
			System.out.println("Using Iterator");
			Iterator i =stPara.iterator();
			while(i.hasNext()){
				System.out.println(i.next());
			}
			
		}


}
