package com.package2;

public class Employee implements Comparable {
	
	private String name;
	private int id;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public int compareTo(Object obj){
		if(obj instanceof Employee){
			Employee e=(Employee)obj;
			if(e.getId()< this.getId()){
				return -1;
			}
			else if(e.getId()> this.getId()){
				return 1;
			}
			else 
				return 0;
		}
		return 0;
	}
	
}
