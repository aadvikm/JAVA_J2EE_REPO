package com.hibernate.lesson;

import java.math.BigDecimal;
import java.util.Date;

public class Employee{
	
	private Long employeeId;

	private BigDecimal commissionPct;

	private DepartmentEntity department;

	private String email;

	private String firstName;

	private Date hireDate;

	private String jobId;

	private String lastName;

	private Long managerId;
	
	private BigDecimal oldSal;

	private String phoneNumber;

	private BigDecimal salary;

	public Employee() {
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getOldSal() {
		return this.oldSal;
	}

	public void setOldSal(BigDecimal oldSal) {
		this.oldSal = oldSal;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", commissionPct=" + commissionPct + ", department=" + department
				+ ", email=" + email + ", firstName=" + firstName + ", hireDate=" + hireDate + ", jobId=" + jobId
				+ ", lastName=" + lastName + ", managerId=" + managerId + ", oldSal=" + oldSal + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + "]";
	}

}
