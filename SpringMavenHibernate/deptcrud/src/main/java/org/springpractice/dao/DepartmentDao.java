package org.springpractice.dao;

import java.util.List;

import org.springpractice.domain.DepartmentDetail;
import org.springpractice.domain.DepartmentEntity;
import org.springpractice.domain.Employee;
import org.springpractice.domain.Location;

public interface DepartmentDao {
	public  DepartmentEntity getDepartmentEntity(Long paramLong) throws Exception;

	public  DepartmentEntity saveDepartmentEntity(DepartmentEntity paramDepartmentEntity) throws Exception;

	public  DepartmentEntity updateDepartmentEntity(DepartmentEntity paramDepartmentEntity) throws Exception;

	public  void deleteDepartmentEntity(DepartmentEntity paramDepartmentEntity) throws Exception;

	public  DepartmentDetail getDeptDetail(Long paramLong) throws Exception;

	public  List<Employee> getManagerList() throws Exception;

	public  List<Location> getLocationList() throws Exception;

	public  List<DepartmentDetail> getDepartments() throws Exception;
}
