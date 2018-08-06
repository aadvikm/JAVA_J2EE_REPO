package com.DepartmentCrudJSP;


import java.io.Serializable;

import javax.persistence.Transient;

public class DepartmentEntity implements Serializable {
	
private Integer deptId;
	
	private String deptName;

	private Integer locationId;
	
	private Long managerId;
	
	@Transient
	private String managerName;
	
	@Transient
	private String streetAddress;
	
	public DepartmentEntity() {
		super();
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId
				+ ", managerId=" + managerId + ", managerName=" + managerName + ", streetAddress=" + streetAddress
				+ "]";
	}
	
	
}
