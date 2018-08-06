package com.EmployeePortal;

import java.math.BigDecimal;

public class Employee{
	

	private String name;
	
	private String mgrName;
	
	private String location;
	
	private BigDecimal salary;
	
	private Long id;

	public Employee() {
		super();
	}

	public Employee(String name, String mgrName, String location, BigDecimal salary, Long id) {
		super();
		this.name = name;
		this.mgrName = mgrName;
		this.location = location;
		this.salary = salary;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	
	

	
}