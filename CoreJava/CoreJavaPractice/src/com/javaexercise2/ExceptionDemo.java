package com.javaexercise2;

public class ExceptionDemo {

	public ExceptionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Manager m =new Manager();
			System.out.println(m.x);
			Manager m1 =new Manager(); //:TooManyObjectCreation:
			m.setSalary(5000);
			System.out.println("Current Sal :"+m.getSalary());
			m.setSalary(10006); // :MaxSalaryExceeded:
			m.setSalary(null); //java.lang.NullPointerException
		
		}
		catch(TooManyObjectCreation te){
			System.out.println("Exception :"+te);
		}
		catch(NullPointerException ne){
			System.out.println("Exception :"+ne);
		}
		catch(MaxSalaryExceeded me){
			System.out.println("Exception :"+me);
		}
		catch(Exception e){
			System.out.println("Exception :"+ e);
		}

	}

}
