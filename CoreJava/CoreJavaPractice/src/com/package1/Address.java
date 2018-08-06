package com.package1;

public class Address implements Cloneable {
	
	int doorNo;
	String streetName;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(int doorNo, String streetName) {
		this.doorNo=doorNo;
		this.streetName=streetName;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
