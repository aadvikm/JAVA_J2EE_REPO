package com.apache.webservice.client;

import java.util.ArrayList;

import com.apache.webservice.tutorial.webservice.Department;
import com.apache.webservice.tutorial.webservice.EmployeeDetail;
import com.apache.webservice.tutorial.webservice.Manager;

public interface EmployeeWebServiceClient {
	
	public EmployeeDetail saveEmployee(EmployeeDetail employeeDetail) throws Exception;

	public EmployeeDetail updateEmployee(EmployeeDetail employeeDetail) throws Exception;

	public void deleteEmployee(Long empId) throws Exception;

	public EmployeeDetail getEmployeeDetail(Long empId) throws Exception;

	public ArrayList<Manager> getManagerList() throws Exception;

	public ArrayList<Department> getDeptList() throws Exception;

	public ArrayList<EmployeeDetail> getEmployees() throws Exception;
}
