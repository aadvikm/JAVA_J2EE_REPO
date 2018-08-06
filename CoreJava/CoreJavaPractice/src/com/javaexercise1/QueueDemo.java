package com.javaexercise1;

import java.util.PriorityQueue;
import java.util.Queue;

/*Create a Queue (PriorityQueue), and insert Student objects. Perform below operations.
1) Explain the difference between add, remove, poll, element, peek, and offer operation in Queue with example for each operation.*/
public class QueueDemo {

	public QueueDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Queue qe =new PriorityQueue<Student>();
		
		Student s1 =new Student(100,"Brindha", 7);
		Student s2 =new Student(101,"Aadvik", 26);
		Student s3 =new Student(102,"Muthu", 30);
		Student s4 = new Student(104, "Tintu", 3);
		qe.add(s1);// add the object in the Queue (FIFO)
		qe.add(s2);
		qe.add(s3);
		queueIterator(qe);
		System.out.println("After removed object from the Queue :"+ qe.remove()); // remove object from the queue
		queueIterator(qe);
		System.out.println("to read object from the Queue :"+ qe.peek());//to read the first object in the queue.
		System.out.println(qe.poll());//removes the Last object from the queue
		System.out.println(qe.element()); //to read the Last object in the queue.
		qe.offer(s4); //The offer method inserts an element if possible, otherwise returning false.
		queueIterator(qe);

	}
	
	public static void queueIterator(Queue<Student> qePara){
		for(Student k :qePara){
			System.out.println(k);
		}
	}

}
