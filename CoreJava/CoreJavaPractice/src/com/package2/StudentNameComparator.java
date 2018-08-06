package com.package2;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	public StudentNameComparator() {
		super();
	}
	
	public int compare(Student s1, Student s2){
		return s1.getName().compareTo(s2.getName());
	}

}
