package com.javaexercise4;

public class ExceptionDemo {

	public ExceptionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Employee emp1 = new Employee(104,"Aadvik",10000.00,"2024,Coolidge Hwy", 10, new Phone(245));
			/*System.out.println("Before Updating Salary & Address of Employee_id :"+emp1.id);
			System.out.println(emp1.toString());
			emp1.updateEmpSalary(11500.00);
			emp1.updateAddress("204, ZIP#_48084");
			System.out.println("After Updating Salary & Address of Employee_id :"+emp1.id);
			System.out.println(emp1.toString());
			
			Employee emp2 = new Employee(111,"Brindha",9000.00,"2020,Coolidge Hwy",20, new Phone(248));
			System.out.println("Before Updating Salary & Address of Employee_id :"+emp2.id);
			System.out.println(emp2.toString());
			emp2.updateEmpSalary(10500.00);
			emp2.updateAddress("205, ZIP#_48084");
			System.out.println("After Updating Salary & Address of Employee_id :"+emp1.id);
			System.out.println(emp2.toString());*/
			
			System.out.println("Parent Class Address :"+ emp1);
			System.out.println("Employee phone address :"+ emp1.phone);
			Employee e1=(Employee)emp1.clone();
			System.out.println("Cloned Class Address :"+ e1);
			emp1.phone.phoneNo=420;
			System.out.println("After the change of phone no!!");
			System.out.println("Parent Class Address :"+ emp1);
			System.out.println("Parent Class_Phone Address :"+ emp1.phone);
			System.out.println("Cloned Class Address :"+ e1);
			System.out.println("Cloned Class_Phone Address :"+ e1.phone);
		}
		catch(Exception e){
		e.printStackTrace();
			System.out.println("Exception :"+e);
		}
		

	}

}
