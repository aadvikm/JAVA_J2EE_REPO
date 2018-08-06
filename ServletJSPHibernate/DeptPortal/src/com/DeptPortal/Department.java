package com.DeptPortal;

import java.io.Serializable;

public class Department  implements Serializable{
	
private Integer deptId;
	
	private String deptName;

	private Integer locationId;
	
	private Long managerId;
	
	public Department() {
		super();
	}

	public Department(Integer deptId, String deptName, Integer locationId, Long managerId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.locationId = locationId;
		this.managerId = managerId;
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

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId + ", managerId="
				+ managerId + "]";
	}
	
	
}
