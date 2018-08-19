package com.apache.webservice.tutorial.webservice;

import javax.jws.WebService;

import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.exception.EmployeeException;

@WebService
public interface EmployeeWebService {
	
	public EmployeeOutputData saveEmployee(EmployeeInputData employeeInputData);

	public EmployeeOutputData updateEmployee(EmployeeInputData employeeInputData);

	public EmployeeOutputData deleteEmployee(EmployeeInputData employeeInputData);

	public EmployeeOutputData getEmployeeDetail(EmployeeInputData employeeInputData);

	public EmployeeOutputData getManagerList(EmployeeInputData employeeInputData);

	public EmployeeOutputData getEmployees(EmployeeInputData employeeInputData);

	public EmployeeOutputData getDeptList(EmployeeInputData employeeInputData);
	
}
