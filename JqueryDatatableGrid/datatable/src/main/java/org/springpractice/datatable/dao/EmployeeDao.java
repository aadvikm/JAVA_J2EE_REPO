package org.springpractice.datatable.dao;

import java.util.ArrayList;

import org.springpractice.datatable.domain.Employee;

public interface EmployeeDao {

	public ArrayList<Employee> getManagers() throws Exception;
	
	public ArrayList<Employee> getEmployees(Long mgrId) throws Exception;
	
}
