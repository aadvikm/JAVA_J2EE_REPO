package com.package1;

public abstract class CellPhone implements Phone {

	public CellPhone() {
		// TODO Auto-generated constructor stub
	}
	
	public void dial(){
		System.out.println("Dialing..!!");
		
	}
	
	public void ring(){
		System.out.println("Ringing.>!");
	}
	
	public abstract void answer();
}
