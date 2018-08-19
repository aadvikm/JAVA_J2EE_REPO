package org.springpractice.domain;

public class Employee {
	private Long mgrId;

	private String mgrName;

	public Employee() {
	}

	public Employee(Long mgrId, String mgrName) {
		this.mgrId = mgrId;
		this.mgrName = mgrName;
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

	public String toString() {
		return "Employee [mgrId=" + mgrId + ", mgrName=" + mgrName + "]";
	}
}
