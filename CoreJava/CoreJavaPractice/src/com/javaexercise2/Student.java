package com.javaexercise2;

public class Student {
	int id;
	String name;
	
	public Student(){
	
	}
	
	public Student(int id, String name){
		this.id =id;
		this.name=name;
	}
	/*
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student s = (Student) obj;
			if(this.name.equals(s.name)){
				return true;
			}
			else
				return false;
		}
		return false;
	}*/
	
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student s = (Student)obj;
			if(this.id==s.id){
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	
	
	public int hashCode(){
		return 2*name.hashCode();
	}
}
