package com.deptcrudservlethibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


public class DepartmentEntity implements Serializable{
	
	private Integer deptId;
	
	private String deptName;

	private Integer locationId;
	
	private Long managerId;

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

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId
				+ ", managerId=" + managerId + "]";
	}




	

	
}
