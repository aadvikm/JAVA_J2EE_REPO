package com.javaexercise3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class JavaPractice {

	public JavaPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	try{
		Manager m = new Manager();
		Employee e1 =new Employee();
			e1.setId(101);
			e1.setName("Aadvik");
			e1.setSalary(5000.00);
			e1.setDOB("25/01/2017");
			e1.setAdd(new Address(2024, "Coolidge Hwy"));
			e1.setPh(new Phone(7609769));
		Employee e2 =new Employee();
			e2.setId(102);
			e2.setName("Muthu");
			e2.setSalary(7000.00);
			e2.setDOB("19/04/1987");
			e2.setAdd(new Address(2024, "Coolidge Hwy"));
			e2.setPh(new Phone(1234567));
		Employee e3 =new Employee();
			e3.setId(103);
			e3.setName("Brindha");
			e3.setSalary(6000.00);
			e3.setDOB("13/08/1991");
			e3.setAdd(new Address(2024, "Coolidge Hwy"));
			e3.setPh(new Phone(8438702));
		m.addEmployee(e1);
		m.addEmployee(e2);
		m.addEmployee(e3);
		m.printAllEmployees();
		m.printEmployeeBySalary();
		Employee eCloneObj =(Employee)e1.clone();
		JavaPractice.compareEmployees(e1,e2);
		JavaPractice.compareEmployees(e1,eCloneObj);
		
		HashSet<Employee> hs =new HashSet<Employee>();
		hs.add(e1);
		hs.add(eCloneObj);
		hs.add(e2);
		hs.add(e3);
		hashIterator(hs);
		hashForEach(hs);
		
		Stack<Employee> st =new Stack<Employee>();
		st.push(e1);
		st.push(eCloneObj);
		st.push(e2);
		st.push(e3);
		System.out.println("Reading last object in the stack :"+ st.peek());
		System.out.println("Removing last object from the stack :"+st.pop());
		
		Vector<Employee> vec =new Vector<Employee>();
		vec.add(e1);
		vec.add(eCloneObj);
		vec.add(e2);
		vec.add(e3);
		System.out.println("Vector Elements.. iterating thru Enumeration");
		Enumeration e =vec.elements();
		while(e.hasMoreElements()){
			Employee empl=(Employee)e.nextElement();
			System.out.println("Emp id :"+empl.getId()+"|| Emp name :"+ empl.getName()+"|| Emp Sal :"+empl.getSalary()+"|| Emp DOB :"+empl.getDOB()+"|| Emp Address :"+ empl.getAdd()+"|| Emp Phone No :"+ empl.getPh());
		}
		
		Queue<Employee> qe = new PriorityQueue<Employee>();
		qe.add(e1);
		qe.add(eCloneObj);
		qe.add(e2);
		qe.add(e3);
		System.out.println("Reading first object in the Queue :"+ qe.peek());
		System.out.println("Removing first object from the Queue :"+qe.remove());
		
		Hashtable<Integer,Employee> ht =new Hashtable<Integer,Employee>();
		ht.put(1001,e1);
		ht.put(1002,eCloneObj);
		ht.put(1003,e2);
		ht.put(1004,e3);
		System.out.println("Hashtable elements :");
		Set<Map.Entry<Integer, Employee>> eset =ht.entrySet();
		for(Map.Entry<Integer, Employee> ens :eset){
			System.out.println(ens.getKey() +" : " + ens.getValue());
		}
		
		m.sortAndPrintEmployeeByDOB();
		
		File f =new File("Employee.txt");
		FileOutputStream fos =new FileOutputStream(f);
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(e1);
		oos.writeObject(eCloneObj);
		oos.writeObject(e2);
		oos.writeObject(e3);
		oos.flush();
		System.out.println("Serilaization Done..!!");
		
		FileInputStream fis =new FileInputStream(f);
		ObjectInputStream ois =new ObjectInputStream(fis);
		Employee employeeObj1 =(Employee)ois.readObject();
		Employee employeeObj2 =(Employee)ois.readObject();
		Employee employeeObj3 =(Employee)ois.readObject();
		Employee employeeObj4 =(Employee)ois.readObject();
		//Employee employeeObj5 =(Employee)ois.readObject();
		//System.out.println(employeeObj5);      --> EOF Exception will be thrown when we try to call an object which is not in the file.
		ArrayList<Employee> arrEmpList = new ArrayList<Employee>();
		arrEmpList.add(employeeObj1);
		arrEmpList.add(employeeObj2);
		arrEmpList.add(employeeObj3);
		arrEmpList.add(employeeObj4);
		Iterator iter = arrEmpList.iterator();
		while(iter.hasNext()){
			Employee s =(Employee)iter.next();
			System.out.println("Emp id :"+s.getId()+"|| Emp name :"+ s.getName()+"|| Emp Sal :"+s.getSalary()+"|| Emp DOB :"+s.getDOB()+"|| Emp Address :"+ s.getAdd()+"|| Emp Phone No :"+ s.getPh());
		}
		
		m.sayHi();
		Employee eMan =new Manager();
		//eMan.getArrayList(); -->not accessiable, because using parent class reference we can not call child class fields, methods, etc. because only child has the behaviours of parent, not parent.
		//eMan.add(45, 80);
		//eMan.addEmployee(e1);
		
	}
	catch(NullPointerException ne){
		ne.printStackTrace();
		System.out.println("NullPointerException :"+ne);
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception :"+e);
	}
	finally{
		System.out.println("Finally Block..!");
	}
}

public static void compareEmployees(Employee e1, Employee e2){
	boolean result =e1.equals(e2);
	System.out.println("Employee "+e1 +" and "+ e2 +"is same or not :"+result);
}

public static void hashIterator(HashSet<Employee> hspara){
	System.out.println("Using Iterator..!");
	Iterator i =hspara.iterator();
		while(i.hasNext()){
			Employee e =(Employee)i.next();
			System.out.println("Emp id :"+e.getId()+"|| Emp name :"+ e.getName()+"|| Emp Sal :"+e.getSalary()+"|| Emp DOB :"+e.getDOB()+"|| Emp Address :"+ e.getAdd()+"|| Emp Phone No :"+ e.getPh());

		}
}

public static void hashForEach(HashSet<Employee> hspara){
	System.out.println("Using For Each..!");
	for(Employee e :hspara){
		System.out.println("Emp id :"+e.getId()+"|| Emp name :"+ e.getName()+"|| Emp Sal :"+e.getSalary()+"|| Emp DOB :"+e.getDOB()+"|| Emp Address :"+ e.getAdd()+"|| Emp Phone No :"+ e.getPh());
	}
}

}
