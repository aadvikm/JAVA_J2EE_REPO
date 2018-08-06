package com.javaexercise4;

import java.util.Comparator;

public class ComparatorBySalary implements Comparator<Employee>{

	public ComparatorBySalary() {
		// TODO Auto-generated constructor stub
	}
	
	public int compare(Employee e1, Employee e2){
		if(e1.salary <e2.salary){
			return -1;
		}
		else if(e1.salary >e2.salary){
			return 1;
		}
		else
			return 0;
		
	}

}
