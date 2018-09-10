package com.elibrary.domain;

import java.util.Date;

public class StudentDetail {
	private Long studentId;
	private String studentUserId;
	private String name;
	private String emailId;
	private Date dateOfBirth;
	private String mobileNo;
	private String password;
	
	
	public StudentDetail() {
		super();
	}


	public StudentDetail(Long studentId, String studentUserId, String name, String emailId, Date dateOfBirth,
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
		return "StudentDetail [studentId=" + studentId + ", studentUserId=" + studentUserId + ", name=" + name
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}
	
	

}
