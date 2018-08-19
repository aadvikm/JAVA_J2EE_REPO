package com.apache.webservice.tutorial.dao;

import java.util.List;

import com.apache.webservice.tutorial.domain.Department;
import com.apache.webservice.tutorial.domain.EmployeeDetail;
import com.apache.webservice.tutorial.domain.EmployeeEntity;
import com.apache.webservice.tutorial.domain.Manager;

public interface EmployeeDao {
	public EmployeeEntity getEmployeeEntity(Long paramLong) throws Exception;

	public EmployeeEntity saveEmployeeEntity(EmployeeEntity paramEmployeeEntity) throws Exception;

	public EmployeeEntity updateEmployeeEntity(EmployeeEntity paramEmployeeEntity) throws Exception;

	public void deleteEmployeeEntity(EmployeeEntity paramEmployeeEntity) throws Exception;

	public EmployeeDetail getEmpDetail(Long paramLong) throws Exception;

	public List<Manager> getManagerList() throws Exception;

	public List<Department> getDeptList() throws Exception;

	public List<EmployeeDetail> getEmployees() throws Exception;
}