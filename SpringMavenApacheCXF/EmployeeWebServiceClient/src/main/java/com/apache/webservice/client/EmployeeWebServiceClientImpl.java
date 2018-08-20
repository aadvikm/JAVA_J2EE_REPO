package com.apache.webservice.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.webservice.tutorial.webservice.Department;
import com.apache.webservice.tutorial.webservice.EmployeeDetail;
import com.apache.webservice.tutorial.webservice.EmployeeWebService;
import com.apache.webservice.tutorial.webservice.Manager;

@Service
public class EmployeeWebServiceClientImpl implements EmployeeWebServiceClient {

	@Autowired
	private EmployeeWebService employeeWebService;

	public EmployeeDetail saveEmployee(EmployeeDetail employeeDetail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDetail updateEmployee(EmployeeDetail employeeDetail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmployee(Long empId) throws Exception {
		// TODO Auto-generated method stub

	}

	public EmployeeDetail getEmployeeDetail(Long empId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Manager> getManagerList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Department> getDeptList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EmployeeDetail> getEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
