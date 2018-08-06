package com.EmpDept;

import java.math.BigDecimal;

public class Employee {
	
	private String name;
	
	private Long mgrId;
	
	private BigDecimal salary;
	
	private Long empId;
		
	public Employee() {
		super();
	}

	public Employee(String name, Long mgrId, BigDecimal salary, Long empId ) {
		super();
		this.name = name;
		this.mgrId = mgrId;
		this.salary = salary;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", mgrId=" + mgrId + ", salary=" + salary + ", empId=" + empId +  "]";
	}

	
	
	
}