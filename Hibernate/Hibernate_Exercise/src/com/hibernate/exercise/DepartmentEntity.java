package com.hibernate.exercise;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class DepartmentEntity implements Serializable{
	
	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "departmentEntitySeq")
	@SequenceGenerator(name="departmentEntitySeq", sequenceName="DEPARTMENTS_SEQ")
	private Integer deptId;
	@Column(name="DEPARTMENT_NAME")
	private String deptName;
	@Column(name="LOCATION_ID")
	private Integer locationId;
	@Column(name="MANAGER_ID")
	private Long managerId;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="departmentId")
	//private Set<EmployeeEntity> employees;
	
	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Integer getDeptId() {
		return deptId;
	}



	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}



	public Long getManagerId() {
		return managerId;
	}



	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	/*public Set<EmployeeEntity> getEmployees() {
		return employees;
	}




	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}*/




	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", deptName=" + deptName + ", locationId=" + locationId
				+ ", managerId=" + managerId + "]";
	}




	
	


	

}
