package com.DepartmentCrudJSP;

public class Manager {
	
	private Long managerId;
	private String managerName;
	
	public Manager() {
		super();
	}

	public Manager(Long managerId, String managerName) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
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

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + "]";
	}
	
	
}
