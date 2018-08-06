package com.EmpDept;

public class Department {
	
	private Long deptId;
	
	private String deptName;
	
	private Long mgrId;

	public Department() {
		super();
	}

	
	public Department(Long deptId, String deptName, Long mgrId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.mgrId = mgrId;
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

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", mgrId=" + mgrId + "]";
	}
	

}
