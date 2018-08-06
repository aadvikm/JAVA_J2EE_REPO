package com.javaexercise1;

import java.util.Comparator;

public class StudentIdComparator implements Comparator{

	public StudentIdComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Object o1, Object o2){
		if(o1 instanceof Student && o2 instanceof Student){
			Student s5 =(Student)o1;
			Student s6 =(Student)o2;
			if(s5.id<s6.id){
				return -1;
			}
			else if(s5.id>s6.id){
				return 1;
			}
			else 
				return 0;
		}
		return 0;
	}
}
