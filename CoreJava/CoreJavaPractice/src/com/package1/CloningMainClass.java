package com.package1;

public class CloningMainClass {

	public CloningMainClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Students s =new Students();
			s.setId(101);
			s.setName("Aadvik");
			s.setAdd(new Address(204, "Coolidge Hwy"));
			Students s1 =(Students)s.clone();
			
			System.out.println("Before Cloning :"+s.toString());
			System.out.println("After Cloning :"+s1.toString());
			s.setId(102);
			System.out.println("After the Change Original Obj :"+s.toString());
			System.out.println("After the Change Cloned Obj :"+s1.toString());
		}
		catch(CloneNotSupportedException e){
			System.out.println("Exception :"+e);
				
		}
	}
}
