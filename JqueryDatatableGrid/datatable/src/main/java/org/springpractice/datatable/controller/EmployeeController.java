package org.springpractice.datatable.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springpractice.datatable.domain.Employee;
import org.springpractice.datatable.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private static Logger LOG = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "emppage";
	}
	
	@RequestMapping(value="/getmanagers", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Employee> getManagers() {
		try{
			return employeeService.getEmployees();
		}
		catch(Exception exception){
			LOG.error("Error occurred in getManagers", exception);
			return null;
		}
	}
	
	@RequestMapping(value="/getManagers", method=RequestMethod.GET)
	public ArrayList<Employee> getEmployees(){
		try{
			return null;
		}
		catch(Exception exception){
			LOG.error("Error occurred in getEmployees", exception);
			return null;
		}
	}
	

}
