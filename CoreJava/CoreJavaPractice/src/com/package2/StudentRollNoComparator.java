package com.package2;

import java.util.Comparator;

public class StudentRollNoComparator implements Comparator {

	public StudentRollNoComparator() {
		super();
	}
	
	public int compare(Object obj1, Object obj2){
		if(obj1 instanceof Student && obj2 instanceof Student){
			Student stu1 =(Student)obj1;
			Student stu2 =(Student)obj2;
			if(stu1.getRollNo()<stu2.getRollNo()){
				return -1;
			}else if(stu1.getRollNo()>stu2.getRollNo()){
				return 1;
			}
			else 
				return 0;
		}
		else return 0;
	}

}
