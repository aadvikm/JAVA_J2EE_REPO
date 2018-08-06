package com.hibernate.lesson;

import java.util.Set;

public class DepartmentEntity {
	
	private Integer deptId;
	private String deptName;
	private Integer locationId;
	private Employee managerId;
	private Set<Employee> employees;
	
	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee getManagerId() {
		return managerId;
	}

	public void setManagerId(Employee managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId
				+ ", managerId=" + managerId + ", employees=" + employees + "]";
	}

		
}
