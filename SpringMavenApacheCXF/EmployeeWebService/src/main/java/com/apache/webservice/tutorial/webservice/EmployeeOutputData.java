package com.apache.webservice.tutorial.webservice;

import java.util.ArrayList;

import com.apache.webservice.tutorial.domain.Department;
import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.domain.Manager;

public class EmployeeOutputData {
	
	private String errorMessage;
	private EmployeeDetail employeeDetail;
	private ArrayList<EmployeeDetail> employeeDetailList;
	private ArrayList<Manager> managerList;
	private ArrayList<Department> deptList;
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}
	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	public ArrayList<EmployeeDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}
	public void setEmployeeDetailList(ArrayList<EmployeeDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}
	public ArrayList<Manager> getManagerList() {
		return managerList;
	}
	public void setManagerList(ArrayList<Manager> managerList) {
		this.managerList = managerList;
	}
	public ArrayList<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(ArrayList<Department> deptList) {
		this.deptList = deptList;
	}
	
	
}
