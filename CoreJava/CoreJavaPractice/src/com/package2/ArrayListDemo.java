package com.package2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

public class ArrayListDemo {

	public ArrayListDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ArrayList<Employee> arEmp =new ArrayList<Employee>();
		
		Employee e1 =new Employee("Aadvik", 1002);
		Employee e2 =new Employee("Muthu", 1004);
		Employee e3 =new Employee("Brindha", 1006);
		
		arEmp.add(e1);
		arEmp.add(e2);
		arEmp.add(e3);
		
		listIterator(arEmp);
		listForEachLoop(arEmp);
		listForLoop(arEmp);
		arrayListIterator(arEmp);
		
		Vector<Employee> vec =new Vector<Employee>();
		
		vec.add(e1);
		vec.add(e2);
		vec.add(e3);
		
		vectorEnum(vec);
		
		Stack<Employee> stkEmp =new Stack<Employee>();
		stkEmp.push(e1);
		stkEmp.push(e2);
		stkEmp.push(e3);
		
		stackIteration(stkEmp);
		System.out.println("To read the last object in the stack :"+ stkEmp.peek());
		System.out.println("To remove the last object in the stack :"+ stkEmp.pop());
		System.out.println("To check stack is empty or not :"+ stkEmp.isEmpty());
		System.out.println(stkEmp.search(e3));//Returns the 1-based position where an object is on this stack. 
		System.out.println(stkEmp.search(e2));
		System.out.println(stkEmp.search(e1));
		
	}
	public static void listIterator(ArrayList<Employee> para){
		System.out.println("Using Iterator.!");
		Iterator i = para.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public static void listForEachLoop(ArrayList<Employee> param){
		System.out.println("Using For EachLoop..!");
		for(Employee e :param){
			System.out.println(e);
		}
	}
	public static void listForLoop(ArrayList<Employee> parame){
		System.out.println("Using For Loop.>!!");
		for(int i =0; i<parame.size(); i++){
			System.out.println(parame.get(i));
		}
	}
	public static void arrayListIterator(ArrayList<Employee> arPara){
		System.out.println("Using List Iterator");
		ListIterator li =arPara.listIterator();
		while(li.hasNext()){
			Employee emp = (Employee)li.next();
			if(emp.getId()==1006){
				li.remove();
				System.out.println("Removed");
			
			}
		}
		System.out.println("In Reverse..!");
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}
		
	}
	public static void vectorEnum(Vector<Employee> empVec){
		System.out.println("Vector using Enumeration..!");
		Enumeration eNum =empVec.elements();
		while(eNum.hasMoreElements()){
			System.out.println(eNum.nextElement());
		}
	}
	
	public static void stackIteration(Stack<Employee> empPara){
		System.out.println("Stack Using Iterator..!!");
		Iterator i =empPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
}
