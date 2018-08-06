package com.package2;

import java.util.PriorityQueue;

public class QueueDemo {

	public QueueDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Employee e1 =new Employee("Aadvik", 1002);
		Employee e2 =new Employee("Muthu", 1004);
		Employee e3 =new Employee("Brindha", 1006);
		Employee e4 =new Employee("Brindha", 1008);
		
		PriorityQueue<Employee> pQue =new PriorityQueue<Employee>();
		pQue.add(e1);
		pQue.add(e2);
		pQue.add(e3);
		queueIterator(pQue);
		
		System.out.println("After removed object from the Queue :"+ pQue.remove()); // remove object from the queue
		queueIterator(pQue);
		System.out.println("to read object from the Queue :"+ pQue.peek());//to read the first object in the queue.
		System.out.println(pQue.poll());//removes the Last object from the queue
		System.out.println(pQue.element()); //to read the Last object in the queue.
		pQue.offer(e4); //The offer method inserts an element if possible, otherwise returning false.
		queueIterator(pQue);
	}
	
	public static void queueIterator(PriorityQueue<Employee> qePara){
		for(Employee k :qePara){
			System.out.println(k);
		}
	}

}
