package com.javaexercise2;

public class Manager {
	static int x;
	final int MAX_SAL_ALLOWED =10000;
	private int salary;
	
	public Manager() throws TooManyObjectCreation {
		x=x+1;
		if(x>1){
			TooManyObjectCreation tMany =new TooManyObjectCreation();
			throw tMany;
		}
	}
	
	public int getSalary()throws MaxSalaryExceeded{
		if(this.salary >this.MAX_SAL_ALLOWED){
			throw new MaxSalaryExceeded("Salary is more than MAX_SAL_ALLOWED :"+MAX_SAL_ALLOWED);
		}
		else
			return salary;
	}
	
	public void setSalary(int salary)throws MaxSalaryExceeded{
		if(salary >this.MAX_SAL_ALLOWED){
			throw new MaxSalaryExceeded("Salary is more than MAX_SAL_ALLOWED :"+MAX_SAL_ALLOWED);
		}
		else{
			this.salary =salary;
		}
	}
	
	public void setSalary(Integer salary)throws NullPointerException, MaxSalaryExceeded{
		if(salary ==null){
			throw new NullPointerException();
		}
		else if(salary >this.MAX_SAL_ALLOWED){
			throw new MaxSalaryExceeded("Salary is more than MAX_SAL_ALLOWED :"+MAX_SAL_ALLOWED);
		}
		else{
			this.salary =salary.intValue();
		}
	}

}
