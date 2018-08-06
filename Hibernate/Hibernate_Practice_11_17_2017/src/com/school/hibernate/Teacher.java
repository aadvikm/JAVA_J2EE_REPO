package com.school.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
public class Teacher implements Serializable{
	
	@Id
	@Column(name="TEACHERID")
	@SequenceGenerator(name="teacherSeq", sequenceName="TEACHER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "teacherSeq")
	private Integer teacherId;
	
	@Column(name="TEACHERNAME")
	private String teacherName;
	
	@Column(name="TDOB")
	private Date tDOB;
	
	@Column(name="SALARY")
	private BigDecimal salary;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="teacherId")
	// Set<ClassDetail> classDetail;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Date gettDOB() {
		return tDOB;
	}


	public void settDOB(Date tDOB) {
		this.tDOB = tDOB;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", tDOB=" + tDOB + ", salary="
				+ salary + "]";
	}


	/*public Set<ClassDetail> getClassDetail() {
		return classDetail;
	}


	public void setClassDetail(Set<ClassDetail> classDetail) {
		this.classDetail = classDetail;
	}*/




	
	
	
}
