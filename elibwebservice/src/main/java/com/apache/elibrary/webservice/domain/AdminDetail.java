package com.apache.elibrary.webservice.domain;

import java.util.Date;

public class AdminDetail {
	
	private Long adminId;
	private String adminUserId;
	private String name;
	private String emailId;
	private String mobileNo;
	private String password;
	private Date dateOfBirth;
	
	public AdminDetail() {
		// TODO Auto-generated constructor stub
	}

	public AdminDetail(Long adminId, String adminUserId, String name, String emailId, String mobileNo, String password,
			Date dateOfBirth) {
		super();
		this.adminId = adminId;
		this.adminUserId = adminUserId;
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "AdminDetail [adminId=" + adminId + ", adminUserId=" + adminUserId + ", name=" + name + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", password=" + password + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
