package com.package1;

public class Students implements Cloneable {
	
	private String name;
	private int id;
	private Address add;
	
	public Students() {
		
	}
	public Students(String name, int id, Address add) {
		this.name =name;
		this.id =id;
		this.add=add;
	}
	
	/*Shallow Cloning.
	public Object clone() throws CloneNotSupportedException{
	System.out.println("Shallow Cloning");
		return super.clone();
	}*/
	
	public Object clone()throws CloneNotSupportedException{
		System.out.println("Deep Cloning..!");
		Students stud =(Students)super.clone();
		String n=this.name;
		int i=this.id;
		Address ad = (Address) this.add.clone();
		stud.setId(i);
		stud.setName(n);
		stud.setAdd(ad);
		return stud;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", id=" + id + ", add DoorNo=" + add.doorNo +", add streetName=" + add.streetName;
	}
	

}
