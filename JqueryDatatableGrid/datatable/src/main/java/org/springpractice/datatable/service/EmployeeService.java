package org.springpractice.datatable.service;

import java.util.ArrayList;
import java.util.List;

import org.springpractice.datatable.domain.Employee;
import org.springpractice.datatable.exception.EmployeeException;

public interface EmployeeService {

	public List<Employee> getManagers() throws EmployeeException;
	
	public ArrayList<Employee> getEmployees() throws EmployeeException;

}
