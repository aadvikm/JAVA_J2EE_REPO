package com.apache.webservice.tutorial.webservice;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.apache.webservice.tutorial.domain.EmployeeEntity;
import com.apache.webservice.tutorial.exception.EmployeeException;
import com.apache.webservice.tutorial.service.EmployeeService;

@WebService(endpointInterface = "com.apache.webservice.tutorial.webservice.EmployeeWebService", serviceName = "employeeWebServiceImpl")

public class EmployeeWebServiceImpl implements EmployeeWebService{
	
	private static Logger LOG = Logger.getLogger(EmployeeWebServiceImpl.class);
	
	private EmployeeService employeeService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public EmployeeOutputData saveEmployee(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			EmployeeEntity employeeEntity = employeeService.saveEmp(employeeInputData.getEmployeeDetail());
			outputData.setEmployeeDetail(employeeService.getEmployeeDetail(employeeEntity.getEmpId()));
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public EmployeeOutputData updateEmployee(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			EmployeeEntity employeeEntity = employeeService.updateEmp(employeeInputData.getEmployeeDetail());
			outputData.setEmployeeDetail(employeeService.getEmployeeDetail(employeeEntity.getEmpId()));
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public EmployeeOutputData deleteEmployee(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			employeeService.deleteEmp(employeeInputData.getEmpId());
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	
	}

	public EmployeeOutputData getEmployeeDetail(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setEmployeeDetail(employeeService.getEmployeeDetail(employeeInputData.getEmpId()));
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public EmployeeOutputData getManagerList(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setManagerList(employeeService.getManagerList());
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public EmployeeOutputData getEmployees(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setEmployeeDetailList(employeeService.getEmployees());
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public EmployeeOutputData getDeptList(EmployeeInputData employeeInputData) {
		try{
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setDeptList(employeeService.getDeptList());
			return outputData;
		}
		catch(EmployeeException employeeException){
			LOG.error("Error Occured...", employeeException);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(employeeException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			EmployeeOutputData outputData = new EmployeeOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}
	
	@PostConstruct
	public void init() {
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
