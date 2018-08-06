package com.jspDeptCrud;

public class Manager {

	private Long managerId;
	private String managerName;
	
	public Manager() {
		// TODO Auto-generated constructor stub
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

}
