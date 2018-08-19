package com.apache.webservice.tutorial.webservice;

import com.apache.webservice.tutorial.domain.EmployeeDetail;

public class EmployeeInputData {
	
	private Long empId;
	private EmployeeDetail employeeDetail;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}
	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	
	

}
