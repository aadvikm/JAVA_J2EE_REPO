package com.hibernate.lesson;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "EMPLOYEES")
/**The hibernate named query is way to use any query by some meaningful name. It is like using alias names. 
 * The Hibernate framework provides the concept of named queries so that application programmer need not to scatter queries to all the java code.
 */
@NamedQueries({
	@NamedQuery(name="getManagerAndEmployeeName" , query = "Select e.firstName, m.firstName from Employee e, Employee m where m.employeeId = e.managerId"),
	@NamedQuery(name="getAllManagers", query="Select E from Employee E where exists (Select E1 from Employee E1 where E1.managerId = E.employeeId)"),
	@NamedQuery(name="getMangerDetail", query="Select M from Employee M, Employee E where E.managerId = M.employeeId and E.employeeId = :empId")
})
public class Employee{
	
	@Id
	@Column(name="EMPLOYEE_ID")
	@SequenceGenerator(name="employeeSeq", sequenceName="EMPLOYEE_SEQ")
	private Long employeeId;

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	//@Column(name="DEPARTMENT_ID")
	//private Long departmentId;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID", nullable=true)
	private DepartmentEntity department;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="HIRE_DATE")
	private Date hireDate;

	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MANAGER_ID")
	private Long managerId;
	
	@Column(name="OLD_SAL")
	private BigDecimal oldSal;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Column(name="SALARY")
	private BigDecimal salary;

	public Employee() {
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
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

	/*public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}*/

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", commissionPct=" + commissionPct + ", department=" + department
				+ ", email=" + email + ", firstName=" + firstName + ", hireDate=" + hireDate + ", jobId=" + jobId
				+ ", lastName=" + lastName + ", managerId=" + managerId + ", oldSal=" + oldSal + ", phoneNumber="
				+ phoneNumber + ", salary=" + salary + "]";
	}
	
	

}
