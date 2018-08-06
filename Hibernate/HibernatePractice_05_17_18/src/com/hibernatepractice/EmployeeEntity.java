package com.hibernatepractice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table (name ="EMPLOYEES")
@NamedQueries({
	@NamedQuery(name ="gtOnlyManagers", query ="select distinct m from EmployeeEntity e, EmployeeEntity m where e.managerId =m.employeeId"),
	@NamedQuery(name ="gtEmpDetailDeptId", query ="select e.firstName as FirstName, e.lastName as LastName, e.salary as Salary from EmployeeEntity e where e.departmentId =:departId")
})
public class EmployeeEntity implements Serializable{
	@Id
	@Column(name="EMPLOYEE_ID")
	@SequenceGenerator(name="employeeSeq", sequenceName="EMPLOYEES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "employeeSeq")
	private Long employeeId;
	
	//@ManyToOne
	//@JoinColumn(name="DEPARTMENT_ID", nullable=true)
	//private DepartmentEntity departmentId;
	
	@Column (name= "COMMISSION_PCT")
	private BigDecimal commissionPct;
	
	@Column (name ="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column (name ="EMAIL")
	private String email;
	
	@Column (name ="FIRST_NAME")
	private String firstName;
	
	@Column (name ="HIRE_DATE")
	private Date hireDate;
	
	@Column (name ="JOB_ID")
	private String jobId;
	
	@Column (name ="LAST_NAME")
	private String lastName;
	
	@Column (name ="MANAGER_ID")
	private Long managerId;
	
	@Column (name ="OLD_SAL")
	private BigDecimal oldSal;
	
	@Column (name ="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column (name ="SALARY")
	private BigDecimal salary;
	
	
	public EmployeeEntity() {
		super();
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public BigDecimal getCommissionPct() {
		return commissionPct;
	}


	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}


  public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getManagerId() {
		return managerId;
	}


	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	public BigDecimal getOldSal() {
		return oldSal;
	}


	public void setOldSal(BigDecimal oldSal) {
		this.oldSal = oldSal;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	/*public DepartmentEntity getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(DepartmentEntity departmentId) {
		this.departmentId = departmentId;
	}*/

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", commissionPct=" + commissionPct + ", departmentId="
				+ departmentId + ", email=" + email + ", firstName=" + firstName + ", hireDate=" + hireDate + ", jobId="
				+ jobId + ", lastName=" + lastName + ", managerId=" + managerId + ", oldSal=" + oldSal
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
	}
	
	
	
	

}
