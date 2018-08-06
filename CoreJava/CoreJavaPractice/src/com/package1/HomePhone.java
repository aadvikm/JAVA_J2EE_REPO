package com.package1;

public class HomePhone extends CellPhone{

	public HomePhone() {
		// TODO Auto-generated constructor stub
	}

	
	public void dial(){
		System.out.println("Dialing..!!");
		
	}
	
	public void ring(){
		System.out.println("Ringing.>!");
	}
	
	public  void answer(){
		System.out.println("Answering..!!");
	}
	
	public static void main(String[] args) {
		CellPhone cp =new HomePhone();//Dynamic Method Dispatch\\
		cp.dial();
		cp.ring();
		cp.answer();

	}
}
