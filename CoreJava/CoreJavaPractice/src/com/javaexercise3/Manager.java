package com.javaexercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Manager extends Employee {
	
	
	private ArrayList<Employee> employeeList;
	
	public Manager() {
		super();
		this.employeeList =new ArrayList<Employee>();
	}

	public Manager(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public void addEmployee(Employee e){
		this.employeeList.add(e);
	}
	
	public void addEmployee(ArrayList<Employee> empList){
		this.employeeList.addAll(empList);
	}
	
	public void printEmployeeBySalary(){
		System.out.println("Printing Employees By Salary..");
		Collections.sort(employeeList);
		Iterator i =employeeList.iterator();
		while(i.hasNext()){
			Employee empRefObj =(Employee)i.next();
			System.out.println("Emp id :"+empRefObj.getId()+"|| Emp name :"+ empRefObj.getName()+"|| Emp Sal :"+empRefObj.getSalary()+"|| Emp DOB :"+empRefObj.getDOB()+"|| Emp Address :"+ empRefObj.getAdd()+"|| Emp Phone No :"+ empRefObj.getPh());
		}
		
	}
	public void printAllEmployees(){
		Iterator i =employeeList.iterator();
		while(i.hasNext()){
			Employee empRefObj =(Employee)i.next();
			System.out.println("Emp id :"+empRefObj.getId()+"|| Emp name :"+ empRefObj.getName()+"|| Emp Sal :"+empRefObj.getSalary()+"|| Emp DOB :"+empRefObj.getDOB()+"|| Emp Address :"+ empRefObj.getAdd()+"|| Emp Phone No :"+ empRefObj.getPh());
		}
	}
	
	public boolean hasEmployee(Employee e){
		boolean result =employeeList.contains(e);
		return result;
		
	}
	
	public void sortAndPrintEmployeeByDOB(){
		System.out.println("Sort and Printing Employees By DOB..!");
		Collections.sort(employeeList,new DOBComparator());
		Iterator i =employeeList.iterator();
		while(i.hasNext()){
			Employee empRefObj =(Employee)i.next();
			System.out.println("Emp id :"+empRefObj.getId()+"|| Emp name :"+ empRefObj.getName()+"|| Emp Sal :"+empRefObj.getSalary()+"|| Emp DOB :"+empRefObj.getDOB()+"|| Emp Address :"+ empRefObj.getAdd()+"|| Emp Phone No :"+ empRefObj.getPh());
		}
	}
	
	public void sayHi(){
		System.out.println("Manager class sayHi Method..!");
		super.sayHi();
	}
	
	public void sayBi(){
		System.out.println("Byeee..:)");
	}
}
