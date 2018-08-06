package com.javaexercise4;

import java.io.Serializable;

public class Phone implements Cloneable, Serializable{
	
	int phoneNo;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
