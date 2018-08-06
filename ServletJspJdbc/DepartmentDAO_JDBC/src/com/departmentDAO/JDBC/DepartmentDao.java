package com.departmentDAO.JDBC;

public interface DepartmentDao {
	
	public DepartmentEntity saveDepartment(DepartmentEntity deptEntity);
	
	public DepartmentEntity fetchDepartment(int deptId);
	
	public void updateDepartment(DepartmentEntity deptEntity);
	
	public void deleteDepartment(int deptId);

}
