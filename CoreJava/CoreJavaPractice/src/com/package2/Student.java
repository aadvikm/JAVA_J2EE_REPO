package com.package2;

import java.io.Serializable;

public class Student implements Serializable, Comparable{
	
	private String name;
	private int rollNo;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String name, int rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int compareTo(Object obj){
		if(obj instanceof Student){
			Student stu =(Student)obj;
			if(stu.getRollNo()<this.getRollNo()){
				return -1;
			}
			else if(stu.getRollNo()>this.getRollNo()){
				return 1;
			}
			else
				return 0;
		}
		return 0;
	}

	public boolean equals(Object obj1){
		if(obj1 instanceof Student){
			Student s =(Student)obj1;
			if(this.getName().equals(s.getName())){
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	public int hashCode(){
		return 2*this.getRollNo();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
	
}
