package com.javaexercise4;

import java.io.Serializable;

public class Employee implements UserEdit, Cloneable, Comparable<Employee>, Serializable {
	
	int id;
	String name;
	double salary;
	String address;
	transient int k;
	static int count=0;
	Phone phone;
	
	public Employee() {
		count =count+1;
	}

	public Employee(int id, String name, double salary, String address, int k, Phone phone) {
		count =count+1;
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.k = k;
		this.phone = phone;
	}
	
	/*public Object clone() throws CloneNotSupportedException{ //Shallow Cloning
		System.out.println("Shallow Cloning.!");
		return super.clone();
	}*/

	public Object clone() throws CloneNotSupportedException{ 
		System.out.println("Deep Cloning.!");
		Employee employee =(Employee)super.clone();
		System.out.println("The value of phone instance variable is "+this.phone);
		Phone p =(Phone)this.phone.clone();
		employee.phone = p;
		return employee;
		
	}
	public double updateEmpSalary(double salary) throws OperationNotAllowed{
		if((this.id%2)!=0){
			throw new OperationNotAllowed();
		}
		else{
			this.salary =salary;
		}
		return this.salary;
	}

	public String updateAddress(String address) throws OperationNotAllowed{
		if((this.id%2)!=0){
			throw new OperationNotAllowed();
		}
		else{
			this.address =address;
		}
		return this.address;
	}

	public String toString(){
		return "Emp Id :"+this.id+" ||Emp Name :"+this.name+" ||Emp Salary :"+this.salary+" ||Emp Address :"+this.address+" ||k value :"+this.k+"||PhoneNum :"+this.phone.phoneNo;
	}

	public int compareTo(Employee e){
		
		if(this.id<e.id){
			return -1;
		}
		else if(this.id>e.id){
			return 1;
		}
		else
			return 0;
	}

	public static void test(){
		System.out.println("Employee Class staic method..!");
	}
		

}
