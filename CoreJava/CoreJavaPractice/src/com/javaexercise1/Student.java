package com.javaexercise1;

/*1. Create a class Student (int id, String name, int age); 
Add necessary constructor, equals, hasCode and toString.*/
public class Student implements Comparable {
	
	int id;
	String name;
	int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return 2*id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student s =(Student)obj;
			if(s.id == this.id){
				return true;
			}
			else 
				return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	public int compareTo(Object obj){
		if(obj instanceof Student){
			Student a = (Student)obj;
			if(this.id<a.id){
				return -1;
			}
			else if(this.id>a.id){
				return 1;
			}
			else
				return 0;
		}
		return 0;
		
		/*if(obj instanceof Student){
			Student a = (Student)obj;
			s=this.name.compareTo(a.name);
		}
		return s;*/
	}
	
}
