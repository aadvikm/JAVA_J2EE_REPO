package com.UpdateDepartment;

public class Department {
	
	private Long deptId;
	private String deptName;
	
	public Department() {
		super();
	}

	public Department(Long deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
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

	@Override
	public String toString() {
		return "DeptServlet [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	

}
