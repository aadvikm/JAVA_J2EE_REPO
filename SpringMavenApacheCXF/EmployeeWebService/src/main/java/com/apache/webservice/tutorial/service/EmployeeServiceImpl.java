package com.apache.webservice.tutorial.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.webservice.tutorial.dao.EmployeeDao;
import com.apache.webservice.tutorial.domain.Department;
import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.domain.EmployeeEntity;
import com.apache.webservice.tutorial.domain.Manager;
import com.apache.webservice.tutorial.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	private static Logger LOG = Logger.getLogger(EmployeeServiceImpl.class);
	
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public EmployeeServiceImpl() {
	}

	public EmployeeEntity saveEmp(EmployeeDetail employeeDetail) throws EmployeeException {
		try {
			EmployeeEntity employeeEntity = convertEmpDetailToEntity(employeeDetail);
			return employeeDao.saveEmployeeEntity(employeeEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in save employee...", exception);
			throw new EmployeeException(exception);
		}
	}

	public EmployeeEntity updateEmp(EmployeeDetail employeeDetail) throws EmployeeException {
		try {
			EmployeeEntity employeeEntity = employeeDao.getEmployeeEntity(employeeDetail.getEmpId());
			employeeEntity = convertEmpDetailToEntity(employeeEntity, employeeDetail);
			return employeeDao.updateEmployeeEntity(employeeEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in update emp...", exception);
			throw new EmployeeException(exception);
		}
	}

	public void deleteEmp(Long empId) throws EmployeeException {
		try {
			EmployeeEntity employeeEntity = employeeDao.getEmployeeEntity(empId);
			employeeDao.deleteEmployeeEntity(employeeEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in delete emp...", exception);
			throw new EmployeeException(exception);
		}
	}

	public EmployeeDetail getEmployeeDetail(Long empId) throws EmployeeException {
		try {
			EmployeeDetail employeeDetail = employeeDao.getEmpDetail(empId);
			employeeDetail.setManagerList(getManagerList());
			employeeDetail.setDeptList(getDeptList());
			return employeeDetail;
		} catch (Exception exception) {
			LOG.error("Error occurred in get emp detail...", exception);
			throw new EmployeeException(exception);
		}
	}

	public ArrayList<EmployeeDetail> getEmployees() throws EmployeeException {
		try {
			return (ArrayList) employeeDao.getEmployees();
		} catch (Exception exception) {
			LOG.error("Error occurred in get Employee list...", exception);
			throw new EmployeeException(exception);
		}
	}

	public ArrayList<Manager> getManagerList() throws EmployeeException {
		try {
			return (ArrayList) employeeDao.getManagerList();
		} catch (Exception exception) {
			LOG.error("Error occurred in get manager list...", exception);
			throw new EmployeeException(exception);
		}
	}

	public ArrayList<Department> getDeptList() throws EmployeeException {
		try {
			return (ArrayList) employeeDao.getDeptList();
		} catch (Exception exception) {
			LOG.error("Error occurred in get department list...", exception);
			throw new EmployeeException(exception);
		}
	}

	public EmployeeDetail getManagerAndDeptDetail() throws EmployeeException {
		try {
			EmployeeDetail employeeDetail = new EmployeeDetail();
			employeeDetail.setManagerList(getManagerList());
			employeeDetail.setDeptList(getDeptList());
			return employeeDetail;
		} catch (Exception exception) {
			LOG.error("Error occurred in getManagerAndLocationDetail.", exception);
			throw new EmployeeException(exception);
		}
	}

	private EmployeeEntity convertEmpDetailToEntity(EmployeeDetail employeeDetail) throws Exception {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmpId(employeeDetail.getEmpId());
		return convertEmpDetailToEntity(employeeEntity, employeeDetail);
	}

	private EmployeeEntity convertEmpDetailToEntity(EmployeeEntity employeeEntity, EmployeeDetail employeeDetail)
			throws Exception {
		employeeEntity.setFirstName(employeeDetail.getFirstName());
		employeeEntity.setLastName(employeeDetail.getLastName());
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(employeeDetail.getHireDate());
		employeeEntity.setHireDate(d);
		employeeEntity.setSalary(employeeDetail.getSalary());
		employeeEntity.setCommissionPct("0.3");
		employeeEntity.setDeptId(employeeDetail.getDeptId());
		employeeEntity.setManagerId(employeeDetail.getManagerId());
		employeeEntity.setPhoneNumber("8939252828");
		employeeEntity.setEmail(Math.random() + "_");
		employeeEntity.setJobId("IT_PROG");
		return employeeEntity;
	}
}