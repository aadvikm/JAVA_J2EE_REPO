package org.springpractice.service;

import java.util.ArrayList;
import org.springpractice.domain.DepartmentDetail;
import org.springpractice.domain.DepartmentEntity;
import org.springpractice.domain.Employee;
import org.springpractice.domain.Location;
import org.springpractice.exception.DepartmentException;

public abstract interface DepartmentService {
	public abstract DepartmentEntity saveDept(DepartmentDetail paramDepartmentDetail) throws DepartmentException;

	public abstract DepartmentEntity updateDept(DepartmentDetail paramDepartmentDetail) throws DepartmentException;

	public abstract void deleteDept(Long paramLong) throws DepartmentException;

	public abstract DepartmentDetail getDeptDetail(Long paramLong) throws DepartmentException;

	public abstract ArrayList<Employee> getManagerList() throws DepartmentException;

	public abstract ArrayList<DepartmentDetail> getDepartments() throws DepartmentException;

	public abstract ArrayList<Location> getLocationList() throws DepartmentException;

	public abstract DepartmentDetail getManagerAndLocationDetail() throws DepartmentException;
}
