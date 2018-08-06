package com.javaexercise3;

public class Phone implements Cloneable{
	
	private int phoneNo;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(int phoneNo) {
		super();
		this.phoneNo = phoneNo;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Phone [phoneNo=" + phoneNo + "]";
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
