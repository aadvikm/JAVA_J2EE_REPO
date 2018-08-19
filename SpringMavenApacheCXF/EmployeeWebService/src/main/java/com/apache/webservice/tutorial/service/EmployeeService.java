package com.apache.webservice.tutorial.service;

import java.util.ArrayList;

import com.apache.webservice.tutorial.domain.Department;
import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.domain.EmployeeEntity;
import com.apache.webservice.tutorial.domain.Manager;
import com.apache.webservice.tutorial.exception.EmployeeException;

public interface EmployeeService {
	public EmployeeEntity saveEmp(EmployeeDetail paramEmployeeDetail) throws EmployeeException;

	public EmployeeEntity updateEmp(EmployeeDetail paramEmployeeDetail) throws EmployeeException;

	public void deleteEmp(Long paramLong) throws EmployeeException;

	public EmployeeDetail getEmployeeDetail(Long paramLong) throws EmployeeException;

	public ArrayList<EmployeeDetail> getEmployees() throws EmployeeException;

	public ArrayList<Manager> getManagerList() throws EmployeeException;

	public ArrayList<Department> getDeptList() throws EmployeeException;

	public EmployeeDetail getManagerAndDeptDetail() throws EmployeeException;
}