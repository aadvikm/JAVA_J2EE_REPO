package com.javaexercise3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends JobDuty implements Comparable, Cloneable, Serializable, Externalizable, SayHiInterface{
	private int id;
	private String name;
	private Double salary;
	private Date dateOfBirth;
	transient private Address add;
	transient private Phone ph;
	
	public Employee() {
		
	}

	public Employee(int id, String name, Double salary, Date dateOfBirth, Address add, Phone ph) throws NullPointerException {
		super();
		this.id = id;
		this.name = name;
		if(this.salary ==null){
			throw new NullPointerException();
		}
		this.dateOfBirth = dateOfBirth;
		this.add =add;
		this.ph =ph;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public Phone getPh() {
		return ph;
	}

	public void setPh(Phone ph) {
		this.ph = ph;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDOB() {
		return dateOfBirth;
	}

	public void setDOB(String dateOfBirth) throws Exception {
		SimpleDateFormat sd =new SimpleDateFormat("dd/MM/yyyy");
		this.dateOfBirth =sd.parse(dateOfBirth);
	}
	
	public void jobDuty(){
		System.out.println("Job Duty is Testing..!");
	}
	public Double salary(Double increSal)throws SalaryExceededMaxAllowedSalary{
		if(increSal ==null){
			System.out.println("Incorrrect amount passed.");
		}
		else{
			this.salary = this.salary+increSal;
			if (this.salary >10000){
				throw new SalaryExceededMaxAllowedSalary();
			}
		}
		return this.salary;
	}
	
	
	public int compareTo(Object o1){
		if(o1 instanceof Employee){
			Employee empObj =(Employee)o1;
			if(this.salary<empObj.salary){
				return -1;
			}
			else if(this.salary>empObj.salary){
				return 1;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	
	public boolean equals(Object o1){
		if(o1 instanceof Employee){
			Employee emp =(Employee)o1;
			if(this.id ==emp.id && this.name.equals(emp.name)){
				return true;
			}
			else 
			return false;
		}
		return false;
	}
	
	public int hashCode(){
		return 2*this.id;
	}
	
	public Object clone()throws CloneNotSupportedException{
		Employee em =(Employee) super.clone();
		int id =this.id;
	    String name =this.name;
		Double salary =this.salary;
		Date dob=this.dateOfBirth;
		Address ad =(Address)this.add.clone();
		Phone phN =(Phone)this.ph.clone();
		em.id =id;
		em.name=name;
		em.salary =salary;
		em.dateOfBirth =dob;
		em.add =ad;
		em.ph=phN;
		return em;
	}

	public String toString(){
		return "Emp id :"+this.id+"||Emp name :"+this.name+" ||Emp Sal :"+this.salary+"|| Emp DOB :"+this.dateOfBirth+"|| Emp Address :"+ this.getAdd()+"|| Emp Phone No :"+ this.getPh();
	}
	
	public void writeExternal(ObjectOutput oo)throws IOException{
		System.out.println("writeExternal Block..!");
			oo.writeInt(this.id);
			oo.writeObject(this.name);
			oo.writeObject(this.salary);
			oo.writeObject(this.dateOfBirth);
			
	}
	public void readExternal(ObjectInput oi)throws IOException, ClassNotFoundException{
			System.out.println("readExternal Block..!");
			this.id=oi.readInt();
			this.name=(String)oi.readObject();
			this.salary=(Double)oi.readObject();
			this.dateOfBirth=(Date)oi.readObject();
		
	}
	
	public void sayHi(){
		System.out.println("Hiiiiii...:)");
	}
	
	
	

}
