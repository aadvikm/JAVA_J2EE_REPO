package org.springpractice.datatable.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springpractice.datatable.dao.EmployeeDao;
import org.springpractice.datatable.domain.Employee;
import org.springpractice.datatable.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static Logger LOG = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getManagers() throws EmployeeException{
		try{
			return employeeDao.getManagers();
		}
		catch(Exception exception){
			LOG.error("Error occured in getManagers..", exception);
			throw new EmployeeException(exception);
		}
	}

	public ArrayList<Employee> getEmployees() throws EmployeeException {
		try{
			return employeeDao.getEmployees();
		}
		catch(Exception exception){
			LOG.error("Error occured in getEmployees..", exception);
			throw new EmployeeException(exception);
		}
	}

}
