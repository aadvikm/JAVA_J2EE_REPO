package com.LocMgrEmp;

public class DepartmentMgr {
	private Long deptId;
	private Long mgrId;
	private String deptName;
	
	public DepartmentMgr() {
		super();
	}
	

	public DepartmentMgr(Long deptId, Long mgrId, String deptName) {
		super();
		this.deptId = deptId;
		this.mgrId = mgrId;
		this.deptName =deptName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}


	@Override
	public String toString() {
		return "DepartmentMgr [deptId=" + deptId + ", mgrId=" + mgrId + ", deptName=" + deptName + "]";
	}
	
	
	

}
