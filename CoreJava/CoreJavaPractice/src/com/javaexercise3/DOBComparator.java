package com.javaexercise3;

import java.util.Comparator;

public class DOBComparator implements Comparator{

	public DOBComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Object o1, Object o2){
		if(o1 instanceof Employee && o2 instanceof Employee){
			Employee e1 =(Employee)o1;
			Employee e2 =(Employee)o2;
			if(e1.getDOB().before(e2.getDOB())){
				return 1;
			}
			else if(e1.getDOB().after(e2.getDOB())){
				return -1;
			}
			else{
				return 0;
			}
		}
		return 0;
	}
}
