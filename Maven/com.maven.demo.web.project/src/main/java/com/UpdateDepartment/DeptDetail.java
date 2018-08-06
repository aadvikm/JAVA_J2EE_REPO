package com.UpdateDepartment;

import java.util.ArrayList;

public class DeptDetail {
	
	private Long deptId;
	private String deptName;
	private Long mgrId;
	private Long locId;
	private ArrayList<Employee> mgrList;  
	private ArrayList<Location> locList;

	public DeptDetail() {
		super();
	}
	
	public DeptDetail(Long deptId, String deptName, Long mgrId, Long locId, ArrayList<Employee> mgrList,
			ArrayList<Location> locList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.mgrId = mgrId;
		this.locId = locId;
		this.mgrList = mgrList;
		this.locList = locList;
	}



	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public ArrayList<Employee> getMgrList() {
		return mgrList;
	}


	public void setMgrList(ArrayList<Employee> mgrList) {
		this.mgrList = mgrList;
	}


	public ArrayList<Location> getLocList() {
		return locList;
	}


	public void setLocList(ArrayList<Location> locList) {
		this.locList = locList;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	@Override
	public String toString() {
		return "DeptDetail [deptId=" + deptId + ", deptName=" + deptName + ", mgrId=" + mgrId + ", locId=" + locId
				+ ", mgrList=" + mgrList + ", locList=" + locList + "]";
	}


	

}
