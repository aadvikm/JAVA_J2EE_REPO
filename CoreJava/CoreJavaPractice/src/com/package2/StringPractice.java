package com.package2;

public class StringPractice {

	public StringPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s =new String("Aadvik"); //it will create a new Object in th heap memory
		
		System.out.println("S value :"+s);
		
		String str =" Brindha";// its in the string literal memory
		System.out.println("str Value :"+str);
		
		boolean b =str.equals(s);
		System.out.println("B value :"+ b);
		
		StringBuffer strBuf =new StringBuffer(s);//Thread Safe and Synchronized
		strBuf.append(str);
		
		System.out.println("String Buffer :"+ strBuf);
		
		StringBuilder strBu =new StringBuilder(str);//Not Thread safe and Unsynchronized
		strBu.append(" Damodaran");
		System.out.println("String Builder :"+strBu);
		
		

	}

}
