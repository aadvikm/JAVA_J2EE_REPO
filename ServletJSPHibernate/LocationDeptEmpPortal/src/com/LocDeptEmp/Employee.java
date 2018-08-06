package com.LocDeptEmp;

public class Employee {
	private Long empId;
	private String empName;
	
	public Employee() {
		super();
	}

	public Employee(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

}
