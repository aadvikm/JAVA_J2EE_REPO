package com.UpdateDepartment;

public class Employee {
	
	private Long mgrId;
	private String mgrName;

	public Employee() {
		super();
	}

	public Employee(Long mgrId, String mgrName) {
		super();
		this.mgrId = mgrId;
		this.mgrName=mgrName;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}
	

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	@Override
	public String toString() {
		return "Employee [mgrId=" + mgrId + ", mgrName=" + mgrName + "]";
	}

	

}
