package com.javaexercise3;

public class Address implements Cloneable {
	
	private int doorNo;
	private String streetName;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Address(int doorNo, String streetName) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
	}



	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public Object clone()throws  CloneNotSupportedException{
		return super.clone();
	}



	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + "]";
	}
	
	
	
	

}
