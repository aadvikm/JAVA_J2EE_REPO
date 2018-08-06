package com.package1;

public class Manager {
	static int x;
	private int salary;
	final int MAXSAL =15000;
	
	public Manager() throws TwoManyObject {
		x=x+1;
		if(x>1){
			TwoManyObject too =new TwoManyObject("Sorry, you can not create more than one object.! ");
			throw too;
		}
	}


	public int getSalary() throws MaxSalaryAllowed {
		if(this.salary >this.MAXSAL){
			MaxSalaryAllowed maxSal =new MaxSalaryAllowed("Max Allowed Salary is :"+ MAXSAL);
			throw maxSal;
		}
		else
			return salary;
	}

	public void setSalary(int salary) throws MaxSalaryAllowed {
		if(this.salary >this.MAXSAL){
			MaxSalaryAllowed maxSal =new MaxSalaryAllowed("Max Allowed Salary is :"+ MAXSAL);
			throw maxSal;
		}
		else
			this.salary = salary;
	}



	public static void main(String[] args) {
		try{
			Manager m = new Manager();
			//Manager m1 =new Manager();(Exception ex: com.package1.TwoManyObject: Sorry, you can not create more than one object.! )
			
			//m.setSalary(16000);//(Exception ex: com.package1.MaxSalaryAllowed: Max Allowed Salary is :15000)
			m.setSalary(13000);
			System.out.println("Salary :"+ m.getSalary());
			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception ex: "+ex);
		}

	}

}
