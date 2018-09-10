package com.elibrary.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="STUDENT")
public class StudentEntity {
	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "studentSeqGen", sequenceName = "STUDENT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "studentSeqGen", strategy = GenerationType.SEQUENCE)
	private Long studentId;
	
	@Column(name="STUDENT_USER_ID")
	private String studentUserId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	@Column(name="MOBILE")
	private String mobileNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(Long studentId, String studentUserId, String name, String emailId, Date dateOfBirth,
			String mobileNo, String password) {
		super();
		this.studentId = studentId;
		this.studentUserId = studentUserId;
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentUserId=" + studentUserId + ", name=" + name
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}
	

}
